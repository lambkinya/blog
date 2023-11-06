package com.lambkin.blog.service.impl;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lambkin.blog.cache.AppCache;
import com.lambkin.blog.constant.AccessConsts;
import com.lambkin.blog.constant.CacheConsts;
import com.lambkin.blog.constant.SystemConfigConsts;
import com.lambkin.blog.constant.TableNoConsts;
import com.lambkin.blog.enums.UserTypeEnum;
import com.lambkin.blog.mapper.CoderMapper;
import com.lambkin.blog.model.dto.coder.CoderSignupRequest;
import com.lambkin.blog.model.entity.CoderEntity;
import com.lambkin.blog.model.vo.CoderVO;
import com.lambkin.blog.service.ICoderService;
import com.lambkin.blog.ya.AppErrorCode;
import com.lambkin.blog.ya.ThrowUtils;
import com.lambkin.blog.ya.YaBeanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * Coder 服务实现类
 *
 * @author lambkinya
 * @since 2023-10-30 11:28:55
 */
@Service
public class CoderServiceImpl extends ServiceImpl<CoderMapper, CoderEntity> implements ICoderService {


    @Override
    public CoderVO signup(CoderSignupRequest param) {

        // 校验信息 账号格式、手机号或邮箱、验证码
        String regex = "\\d{11}";
        ThrowUtils.throwIf(param.getUsername().matches(regex), AppErrorCode.PARAMS_ERROR, "用户名不能为11为数字...");

        // 校验 验证码
        Integer codeCache = (Integer) AppCache.get(CacheConsts.CODER_SIGNUP_MAIL_CODE + param.getEmail());
        ThrowUtils.throwIf(codeCache == null || codeCache != Integer.parseInt(param.getCode()), AppErrorCode.PARAMS_ERROR, "验证码错误或该验证码已失效...");
        AppCache.remove(CacheConsts.CODER_SIGNUP_MAIL_CODE + param.getEmail());


        // 解析前端加密过的密码
        param.setPassword(SecureUtil.aes(SystemConfigConsts.CRYPTOJS_KEY.getBytes(StandardCharsets.UTF_8)).decryptStr(param.getPassword(), CharsetUtil.CHARSET_UTF_8));

        // 用户名 是否重复
        int accountCount = Math.toIntExact(lambdaQuery().eq(CoderEntity::getUsername, param.getUsername()).count());
        ThrowUtils.throwIf(accountCount != 0, AppErrorCode.ACCOUNT_HAS_EXIST);
        // 邮箱 是否已被绑定
        int emailCount = Math.toIntExact(lambdaQuery().eq(CoderEntity::getEmail, param.getEmail()).count());
        ThrowUtils.throwIf(emailCount != 0, AppErrorCode.EMAIL_HAS_EXIST);

        // 保存用户
        CoderEntity coder = new CoderEntity(YaBeanUtils.generateNo(TableNoConsts.CODER_NO));
        coder.setUsername(param.getUsername());
        coder.setEmail(param.getEmail());
        coder.setPassword(DigestUtils.md5DigestAsHex(param.getPassword().getBytes()));
        this.save(coder);

        coder = lambdaQuery().eq(CoderEntity::getId, coder.getId()).one();

        String coderToken = AccessConsts.USER_ACCESS_TOKEN + IdUtil.simpleUUID();
        // 可以根据 用户 token 获取用户信息
        AppCache.put(coderToken, coder, AccessConsts.TOKEN_EXPIRE);
        // 可以根据 用户 no 获取 用户 token
        AppCache.put(CacheConsts.USER_TOKEN + coder.getNo(), coderToken, AccessConsts.TOKEN_EXPIRE);

        // 脱敏用户数据 返回前端
        CoderVO result = new CoderVO();
        BeanUtils.copyProperties(coder, result);

        //FIXME 初始化用户朋友圈、群聊和站长的好友关系
//        WeiYan weiYan = new WeiYan();
//        weiYan.setUserId(one.getId());
//        weiYan.setContent("到此一游");
//        weiYan.setType(CacheConsts.WEIYAN_TYPE_FRIEND);
//        weiYan.setIsPublic(Boolean.TRUE);
//        weiYanService.save(weiYan);
//
//        ImChatGroupUser imChatGroupUser = new ImChatGroupUser();
//        imChatGroupUser.setGroupId(ImConfigConst.DEFAULT_GROUP_ID);
//        imChatGroupUser.setUserId(one.getId());
//        imChatGroupUser.setUserStatus(ImConfigConst.GROUP_USER_STATUS_PASS);
//        imChatGroupUserMapper.insert(imChatGroupUser);
//
//        ImChatUserFriend imChatUser = new ImChatUserFriend();
//        imChatUser.setUserId(one.getId());
//        imChatUser.setFriendId(PoetryUtil.getAdminUser().getId());
//        imChatUser.setRemark("站长");
//        imChatUser.setFriendStatus(ImConfigConst.FRIEND_STATUS_PASS);
//        imChatUserFriendMapper.insert(imChatUser);
//
//        ImChatUserFriend imChatFriend = new ImChatUserFriend();
//        imChatFriend.setUserId(PoetryUtil.getAdminUser().getId());
//        imChatFriend.setFriendId(one.getId());
//        imChatFriend.setFriendStatus(ImConfigConst.FRIEND_STATUS_PASS);
//        imChatUserFriendMapper.insert(imChatFriend);

        return result;
    }

    @Override
    public CoderVO signIn(String account, String password, Boolean isAdmin) {
        //  解析前端加密过的用户密码
        password = SecureUtil.aes(SystemConfigConsts.CRYPTOJS_KEY.getBytes(StandardCharsets.UTF_8)).decryptStr(password, CharsetUtil.CHARSET_UTF_8);

        // 从数据库查询当前登录账号 是否存在
        CoderEntity coderEntity = lambdaQuery()
                .and(
                        queryWrapper -> queryWrapper.eq(CoderEntity::getUsername, account).or().eq(CoderEntity::getEmail, account).or().eq(CoderEntity::getPhone, account)
                ).eq(CoderEntity::getPassword, DigestUtils.md5DigestAsHex(password.getBytes())).one();


        ThrowUtils.throwIf(coderEntity == null, AppErrorCode.PARAMS_ERROR, "账号/密码错误，请重新输入...");
        ThrowUtils.throwIf(!coderEntity.getStatus(), AppErrorCode.ACCOUNT_BANNED);


        String adminToken = "";
        String userToken = "";

        if (isAdmin) {
            boolean accountIsAdmin = coderEntity.getType() != UserTypeEnum.ADMIN.getCode() && coderEntity.getType() != UserTypeEnum.CODER.getCode();
            ThrowUtils.throwIf(accountIsAdmin, AppErrorCode.PERMISSION_DENIED, "请使用管理员账号登录...");

            if (AppCache.get(CacheConsts.ADMIN_TOKEN + coderEntity.getNo()) != null) {
                adminToken = (String) AppCache.get(CacheConsts.ADMIN_TOKEN + coderEntity.getNo());
            }
        } else {
            if (AppCache.get(CacheConsts.USER_TOKEN + coderEntity.getId()) != null) {
                userToken = (String) AppCache.get(CacheConsts.USER_TOKEN + coderEntity.getId());
            }
        }


        if (isAdmin && !StringUtils.hasText(adminToken)) {
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            adminToken = AccessConsts.ADMIN_ACCESS_TOKEN + uuid;
            AppCache.put(adminToken, coderEntity, AccessConsts.TOKEN_EXPIRE);
            AppCache.put(CacheConsts.ADMIN_TOKEN + coderEntity.getId(), adminToken, AccessConsts.TOKEN_EXPIRE);
        } else if (!isAdmin && !StringUtils.hasText(userToken)) {
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            userToken = AccessConsts.USER_ACCESS_TOKEN + uuid;
            AppCache.put(userToken, coderEntity, AccessConsts.TOKEN_EXPIRE);
            AppCache.put(CacheConsts.USER_TOKEN + coderEntity.getId(), userToken, AccessConsts.TOKEN_EXPIRE);
        }


        CoderVO coder = new CoderVO();
        BeanUtils.copyProperties(coderEntity, coder);
        if (isAdmin && coderEntity.getType() == UserTypeEnum.ADMIN.getCode()) {
            coder.setIsBoss(true);
        }

        if (isAdmin) {
            coder.setAccessToken(adminToken);
        } else {
            coder.setAccessToken(userToken);
        }
        return coder;
    }


    private void aesEncrypt(String context) {
        // 使用密钥构建 AES
        AES aes = SecureUtil.aes(SystemConfigConsts.CRYPTOJS_KEY.getBytes(StandardCharsets.UTF_8));

        // 加密为16进制表示 f2106f5c351f372b7f977022b65ba4df
        String encryptHex = aes.encryptHex(context);
        System.out.println(encryptHex);
        // 解密为字符串
        String decryptStr = SecureUtil.aes(SystemConfigConsts.CRYPTOJS_KEY.getBytes(StandardCharsets.UTF_8)).decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);
        System.out.println(decryptStr);
    }

}
