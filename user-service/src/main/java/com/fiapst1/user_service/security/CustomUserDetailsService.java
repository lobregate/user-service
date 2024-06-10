package com.fiapst1.user_service.security;

import com.fiapst1.user_service.domain.User;
import com.fiapst1.user_service.dtos.LoginDto;
import com.fiapst1.user_service.exceptions.BadPasswordException;
import com.fiapst1.user_service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.getUserByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("\"User not found\"");
        }
        return UserPrincipal.create(user);
    }

    public void verifyUserCredentials(LoginDto login) {
        UserDetails user = loadUserByUsername(login.getEmail());
        boolean passwordIsTheSame = SecurityConfig.passwordEncoder().matches(login.getSenha(), user.getPassword());
        if (!passwordIsTheSame) {
            throw new BadPasswordException("\"Bad password\"");
        }
    }

}
