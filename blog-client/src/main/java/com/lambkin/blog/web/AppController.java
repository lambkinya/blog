package com.lambkin.blog.web;

import com.lambkin.blog.domain.CoderEntity;
import com.lambkin.blog.model.BlogInfoVo;
import com.lambkin.blog.model.CoderInfoVo;
import com.lambkin.blog.model.LoginInfoVo;
import com.lambkin.blog.service.IAuthService;
import com.lambkin.blog.service.query.CoderQuery;
import com.lambkin.blog.ya.YaApiResult;
import com.lambkin.blog.ya.YaBeanCopyUtil;
import com.lambkin.blog.ya.YaBeanNoUtil;
import com.lambkin.blog.ya.YaJwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

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


//    @GetMapping("/login")
//    public YaApiResult<?> login(@RequestBody LoginInfoVo info) {
//        authServiceImpl.login(info.getAccount(), info.getPassword());
//        return YaApiResult.okResult("login is successful...");
//    }



    @GetMapping("/info")
    public YaApiResult<?> queryLoginInfo(HttpServletRequest request) {
        String apiToken = request.getHeader("Authorization");
        String token = apiToken.trim().substring("Beaner".length());

        Claims claims = null;
        try {
            claims = YaJwtUtil.parse(token);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String coderNo = claims.getSubject();
        CoderEntity coder = coderQuery.queryByCoderNo(coderNo);

        return YaApiResult.okResult(YaBeanCopyUtil.copyBean(coder, CoderInfoVo.class));
    }

    @PostMapping("/register")
    public YaApiResult<?> register(@RequestBody LoginInfoVo infoVo) {
        CoderEntity coderEntity = new CoderEntity();
        coderEntity.setNo(YaBeanNoUtil.generateNo("YA"));
        coderEntity.setAccount(infoVo.getAccount());
        coderEntity.setPassword(bCryptPasswordEncoder.encode(infoVo.getPassword()));
        coderEntity.setNickname(infoVo.getAccount());
        coderQuery.save(coderEntity);

        return YaApiResult.okResult(coderEntity.getPassword());
    }


    @GetMapping("/blog-info")
    public YaApiResult<?> test() {
        return YaApiResult.okResult(
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
}
