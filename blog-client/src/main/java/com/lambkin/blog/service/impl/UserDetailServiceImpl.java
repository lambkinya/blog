package com.lambkin.blog.service.impl;

import com.lambkin.blog.domain.CoderEntity;
import com.lambkin.blog.model.User;
import com.lambkin.blog.service.ICoderService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-13 11:11:03
 */
@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    private ICoderService coderServiceImpl;


    /**
     * 根据用户名查询用户的认证授权信息
     * @param username 用户名
     * @return org.springframework.security.core.userdetails.UserDetails
     * @throws UsernameNotFoundException 异常
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final CoderEntity coder = coderServiceImpl.queryByAccount(username);
        if (coder == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        User user = new User();
        user.setUsername(coder.getAccount());
        user.setPassword(coder.getPassword());
        user.setId(coder.getNo());
        return user;
    }
}
