package com.example.eTaskify_ver1.configuration;

import com.example.eTaskify_ver1.model.enums.RoleEnum;
import com.example.eTaskify_ver1.service.serviceImplements.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final UserServiceImp userServiceImp;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> roles = new ArrayList<>();

        for (GrantedAuthority g : authorities) {
            roles.add(g.getAuthority());
        }
        if (roles.contains(RoleEnum.ADMIN)) {
            response.sendRedirect("/admin");
        } else if (roles.contains(RoleEnum.USER)) {
            response.sendRedirect("/user");
        }
    }
}
