package com.lambkin.blog.filter;

import com.lambkin.blog.model.domain.CoderEntity;
import com.lambkin.blog.model.User;
import com.lambkin.blog.service.ICoderService;
import com.lambkin.blog.ya.YaJwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-13 19:48:22
 */
@Component
public class AuthenticationTokenFilter extends OncePerRequestFilter {

    @Resource
    private ICoderService coderServiceImpl;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("authentication");
        if (!StringUtils.hasText(token)) {
            //说明该接口不需要登录  直接放行
            filterChain.doFilter(request, response);
            return;
        }

        Claims claims = null;
        try {
            claims = YaJwtUtil.parse(token);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String coderNo = claims.getSubject();
        CoderEntity coderEntity = coderServiceImpl.queryByNo(coderNo);

        User user = new User();
        user.setId(coderNo);
        user.setUsername(coderEntity.getUsername());
        user.setPassword(coderEntity.getPassword());

        //存入SecurityContextHolder
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user,null,null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        filterChain.doFilter(request, response);
    }

}
