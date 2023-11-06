package com.lambkin.blog.service.impl;

import com.lambkin.blog.cache.AppCache;
import com.lambkin.blog.cache.AppCacheUtils;
import com.lambkin.blog.constant.CacheConsts;
import com.lambkin.blog.constant.SystemConfigConsts;
import com.lambkin.blog.model.entity.CoderEntity;
import com.lambkin.blog.service.IBlogService;
import com.lambkin.blog.util.MailHelper;
import com.lambkin.blog.ya.AppErrorCode;
import com.lambkin.blog.ya.BusinessException;
import com.lambkin.blog.ya.ThrowUtils;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 博客功能服务 实现类
 *
 * @author lambkinya
 * @since 2023-10-31 13:58:28
 */
@Slf4j
@Component
public class BlogServiceImpl implements IBlogService {

    @Resource
    private MailHelper mailHelper;

    @Value("${user.code.format}")
    private String codeFormat;


    @Override
    public void getCode(Integer type) {
        CoderEntity coder = AppCacheUtils.getCurrentUser();
        int code = generateCode();
        if (type == 1) {
            ThrowUtils.throwIf(!StringUtils.hasText(coder.getPhone()), AppErrorCode.PHONE_NOT_BINDING);
            log.info(coder.getId() + "---" + coder.getUsername() + "---" + "手机验证码---" + code);
        } else if (type == 2) {
            sendMail(code, coder.getEmail());
        }
    }

    @Override
    public void codeTo(Integer type, String target) {
        int code = generateCode();

        sendMail(code, target);
    }


    private String getCodeMail(int i) {
        return String.format(mailHelper.getMailText(), "LAMBKIN", String.format(MailHelper.imMail, "TUOR"), "TUOR", String.format(codeFormat, i), "", "LAMBKIN");
    }

    private int generateCode() {
        return new Random().nextInt(900000) + 100000;
    }

    private void sendMail(int code, String email) {
        // 构建 收信人列表
        List<String> mail = new ArrayList<>();
        mail.add(email);

        // 生成 验证码
        String text = getCodeMail(code);

        // 从缓存获取 当前邮件 今日已发送的验证码 的次数
        AtomicInteger count = (AtomicInteger) AppCache.get(CacheConsts.CODE_MAIL + mail.get(0));
        // 判断是否超过 每日可发送的指定次数【3】 防止恶意调用
        if (count == null || count.get() < SystemConfigConsts.CODE_MAIL_COUNT) {
            mailHelper.sendMailMessage(mail, "您有一封来自 LAMBKIN 的回执！", text);
            // 将 验证码放入缓存
            AppCache.put(CacheConsts.CODER_SIGNUP_MAIL_CODE + email, code, 300);
            // 记录 当前邮箱 今日发送验证码 的次数
            if (count == null) {
                AppCache.put(CacheConsts.CODE_MAIL + mail.get(0), new AtomicInteger(1), CacheConsts.CODE_EXPIRE);
                System.out.println(new AtomicInteger(1));
            } else {
                count.incrementAndGet();
                System.out.println(count.incrementAndGet());
            }
        } else {
            throw new BusinessException(AppErrorCode.CLIENT_ERROR, "验证码次数为零, 请明日再试...");
        }
    }

}
