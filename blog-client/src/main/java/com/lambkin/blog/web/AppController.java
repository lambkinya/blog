package com.lambkin.blog.web;

import com.lambkin.blog.cache.AppCache;
import com.lambkin.blog.constant.CodeConstant;
import com.lambkin.blog.mail.MailUtil;
import com.lambkin.blog.ya.ApiResponse;
import com.lambkin.blog.ya.AppErrorCode;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * other request
 *
 * @author lambkinya
 * @since 2023-10-13 11:32:24
 */
@Slf4j
@RestController
@RequestMapping("/app")
public class AppController {

    @Resource
    private MailUtil mailUtil;


    @GetMapping("/code-mail")
    public ApiResponse<?> sendMail(@RequestParam String to) {
        int code = new Random().nextInt(900000) + 100000;

        log.info(to + "---" + "邮箱验证码---" + code);

        List<String> mail = new ArrayList<>();
        mail.add(to);
        String text = getCodeMail(code);

        AtomicInteger count = (AtomicInteger) AppCache.get(CodeConstant.CODE_MAIL + mail.get(0));
        if (count == null || count.get() < CodeConstant.CODE_MAIL_COUNT) {
            mailUtil.sendMailMessage(mail, "您有一封来自 Lambkin 的回执！", text);
            if (count == null) {
                AppCache.put(CodeConstant.CODE_MAIL + mail.get(0), new AtomicInteger(1), CodeConstant.CODE_EXPIRE);
            } else {
                count.incrementAndGet();
            }
        } else {
            return ApiResponse.error(AppErrorCode.SYSTEM_ERROR, "验证码发送次数过多，请明天再试！");
        }

        AppCache.put(CodeConstant.SIGNUP_MAIL_CODE + to, code);
        return ApiResponse.ok();
    }


    private String getCodeMail(int i) {
        return String.format(mailUtil.getMailText(),
                "Lambkin",
                String.format(MailUtil.imMail, "tuor"),
                "tuor",
                String.format("【lambkinya.com】%s为本次验证的验证码，请在5分钟内完成验证。为保证账号安全，请勿泄漏此验证码。", i),
                "",
                "Lambkin");
    }
}
