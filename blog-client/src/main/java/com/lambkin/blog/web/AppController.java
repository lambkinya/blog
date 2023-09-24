package com.lambkin.blog.web;

import com.google.gson.Gson;
import com.lambkin.blog.config.OssConfig;
import com.lambkin.blog.domain.CoderEntity;
import com.lambkin.blog.model.BlogInfoVo;
import com.lambkin.blog.model.LoginInfoVo;
import com.lambkin.blog.service.IAuthService;
import com.lambkin.blog.service.query.CoderQuery;
import com.lambkin.blog.ya.YaApiResult;
import com.lambkin.blog.ya.YaBeanNoUtil;
import com.lambkin.blog.ya.YaCommonHelper;
import com.lambkin.blog.ya.YaIpUtil;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.Objects;

/**
 * <p>站点通用API</p>
 *
 * @author lambkinya
 * @since 2023-09-11 22:11:24
 */
@RestController
@RequestMapping
public class AppController {

    @Resource
    private IAuthService authServiceImpl;
    @Resource
    private CoderQuery coderQuery;
    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Resource
    private OssConfig ossConfig;


    @PostMapping("/register")
    public YaApiResult<?> register(@RequestBody LoginInfoVo infoVo) {
        CoderEntity coderEntity = new CoderEntity();
        coderEntity.setNo(YaBeanNoUtil.generateNo("YA"));
        coderEntity.setUsername(infoVo.getAccount());
        coderEntity.setPassword(bCryptPasswordEncoder.encode(infoVo.getPassword()));
        coderQuery.save(coderEntity);

        return YaApiResult.ok(coderEntity.getPassword());
    }


    @PostMapping("/upload")
    public YaApiResult<?> upload(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        if (!originalFilename.endsWith(".png")
                && !originalFilename.endsWith(".jpg")
                && !originalFilename.endsWith(".jpeg")) {
            throw new RuntimeException();
        }

        String path = YaCommonHelper.generateFilePath(Objects.requireNonNull(originalFilename));
        String url = uploadImg(file, path);
        return YaApiResult.ok(url);
    }


    @GetMapping("/visitor")
    public YaApiResult<?> visitorCheckIn(HttpServletRequest request) {
        String ipAddress = YaIpUtil.obtainClientIpAddress(request);
        return YaApiResult.ok(ipAddress);
    }


    @GetMapping("/blog-info")
    public YaApiResult<?> test() {
        return YaApiResult.ok(
                new BlogInfoVo(4, 3, 3, 26556,
                        new BlogInfoVo.SiteConfig(
                                1,"https://static.ttkwsd.top/config/7b6f25adc2b9627b8918176888bee3b5.png",
                                "https://static.ttkwsd.top/config/0bca52afdb2b9998132355d716390c9f.png",
                                "Hello World","https://www.lambkinya.com","灯下闲读，红袖添香。",
                                "后端基于SpringBoot开发，前端基于Vue3 Ts Navie UI开发，<a href=\"https://gitee.com/wu_shengdong/blog\" style=\"color: #49b1f5;\">网站源码</a>",
                                LocalDate.parse("2022-08-25"), "赣ICP备2022007910号",
                                "https://static.ttkwsd.top/config/05409c1ed50047535f28a40464f7b1ab.jpg",
                                "lambkinya","https://static.ttkwsd.top/config/d6a00d059a1e9729e763469deb4870df.jpg",
                                "","https://github.com/ttkican","https://gitee.com/wu_shengdong","https://space.bilibili.com/505715511",
                                "1824099141",0,0,1,"https://static.ttkwsd.top/config/994a286571b002e93281899cb402bd15.png",
                                "https://static.ttkwsd.top/config/f0be9dc73e230d8821179b9303a9ff49.jpg",1,"gitee,bilibili,github,qq",
                                ",gitee,github",1,"7611185981",1,"wss://ws.ttkwsd.top/websocket"
                        )
                )
        );
    }


    public String uploadImg(MultipartFile img, String path) {
        // 构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.autoRegion());
        // 指定分片上传版本
        cfg.resumableUploadAPIVersion = Configuration.ResumableUploadAPIVersion.V2;

        UploadManager uploadManager = new UploadManager(cfg);

        try {
            InputStream inputStream = img.getInputStream();

            Auth auth = Auth.create(ossConfig.getAccessKey(), ossConfig.getSecretKey());
            String upToken = auth.uploadToken(ossConfig.getBucket());

            try {
                Response response = uploadManager.put(inputStream,path,upToken,null, null);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);

                return ossConfig.getDomainName() + path;
            } catch (QiniuException ex) {
                ex.printStackTrace();
                if (ex.response != null) {
                    System.err.println(ex.response);

                    try {
                        String body = ex.response.toString();
                        System.err.println(body);
                    } catch (Exception ignored) {
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
