package com.example.eTaskify_ver1.configuration;

import com.example.eTaskify_ver1.model.enums.RoleEnum;
import com.example.eTaskify_ver1.service.serviceImplements.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration implements WebMvcConfigurer {

    private final UserServiceImp userServiceImp;
    private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userServiceImp);
        auth.setPasswordEncoder(bCryptPasswordEncoder());

        return auth;
    }

    public void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity)throws Exception{
        httpSecurity.authorizeHttpRequests()
                .antMatchers(
                        "/registration**",
                        "/js/**",
                        "/css/**"
                ).permitAll()
                .antMatchers("/admin/**").hasRole(RoleEnum.ADMIN.name())
                .antMatchers("/task/**").hasAnyRole(RoleEnum.USER.name(),RoleEnum.ADMIN.name())
                .antMatchers("/index").permitAll()
                .and()
                .formLogin()
                .successHandler(customAuthenticationSuccessHandler)
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true);
        httpSecurity.csrf().disable();
        return httpSecurity.build();
    }

}
