package com.lambkin.blog.config;

import com.alibaba.fastjson.JSON;
import com.lambkin.blog.filter.AuthenticationTokenFilter;
import com.lambkin.blog.filter.LoginFilter;
import com.lambkin.blog.ya.YaApiCodeEnum;
import com.lambkin.blog.ya.YaApiResult;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import java.io.IOException;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-12 14:36:33
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {


    /**
     * 获取AuthenticationManager（认证管理器），登录时认证使用
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    /**
     * 密码解析器
     * @return org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, LoginFilter loginFilter, AuthenticationTokenFilter authenticationTokenFilter) throws Exception {

        /*
          anonymous 允许匿名用户访问,不允许已登入用户访问
          permitAll 不管登入,不登入 都能访问
          authenticated 登录之后才能访问
          invalidateHttpSession 登出后,是否要清空当前session
         */
        http
                .authorizeHttpRequests(
                        authorizeHttpRequests -> authorizeHttpRequests
//                                .requestMatchers("/blog-info").authenticated()
//                                .requestMatchers("/logout").authenticated()
                                .anyRequest().permitAll()

        );


        // 使用自定义的登录过滤器
        http.addFilterAt(loginFilter,UsernamePasswordAuthenticationFilter.class);

        // 添加 token 验证过滤器
        http.addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        // 未认证异常响应
        http.exceptionHandling(exceptionHandling ->
                exceptionHandling.authenticationEntryPoint((request, response, authException) -> {
                    response.setContentType("text/html;charset=UTF-8");
                    response.getWriter().write(JSON.toJSONString(
                            YaApiResult.error(YaApiCodeEnum.NEED_LOGIN)
                    ));
                })
        );

        http
                .logout(logout ->
                        logout.invalidateHttpSession(true)
                                .deleteCookies("JSESSIONID")
                                .logoutSuccessHandler(new LogoutSuccessHandler() {
                                    @Override
                                    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                                        response.setContentType("application/json;charset=UTF-8");
                                        response.setStatus(HttpStatus.OK.value());
                                        response.getWriter().write(JSON.toJSONString(YaApiResult.okResult("logout - ok")));
                                    }
                                })
                );

        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults());

        return http.build();
    }


}
