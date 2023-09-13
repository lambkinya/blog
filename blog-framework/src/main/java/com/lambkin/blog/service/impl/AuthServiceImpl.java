package com.lambkin.blog.service.impl;

import com.lambkin.blog.service.IAuthService;
import jakarta.annotation.Resource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-12 14:34:05
 */
@Service
public class AuthServiceImpl implements IAuthService {

    @Resource
    private AuthenticationManager authenticationManager;

    @Override
    public void login(String account, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(account, password);
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //判断是否认证通过
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或密码错误");
        }
    }

}
