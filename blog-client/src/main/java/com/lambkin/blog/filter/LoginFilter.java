package com.lambkin.blog.filter;

import cn.hutool.json.JSONUtil;
import com.lambkin.blog.model.LoginInfoVo;
import com.lambkin.blog.support.AuthenticationHandler;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

import static com.lambkin.blog.support.AuthenticationHandler.APPLICATION_JSON_CHARSET_UTF_8;

/**
 * <p>登录过滤器</p>
 *
 * @author lambkinya
 * @since 2023-09-13 09:32:27
 */
@Component
public class LoginFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!HttpMethod.POST.name().equalsIgnoreCase(request.getMethod())) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }

        StringBuilder json = new StringBuilder();
        try {
            BufferedReader reader = request.getReader();

            String line = null;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        LoginInfoVo loginInfoVo = JSONUtil.parse(json).toBean(LoginInfoVo.class);

        UsernamePasswordAuthenticationToken authenticationToken = UsernamePasswordAuthenticationToken.unauthenticated(loginInfoVo.getAccount(), loginInfoVo.getPassword());
        setDetails(request, authenticationToken);
        return this.getAuthenticationManager().authenticate(authenticationToken);
    }




    public LoginFilter(AuthenticationManager authenticationManager, AuthenticationHandler authenticationHandler) throws Exception {
        super(authenticationManager);
        setAuthenticationFailureHandler(authenticationHandler);
        setAuthenticationSuccessHandler(authenticationHandler);
        //登录使用的路径
        setFilterProcessesUrl("/login");
    }

}
