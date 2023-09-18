package com.example.cs203g1t3.security;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.http.HttpMethod.POST;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    private final UserDetailsService userDetailsService;

    public SecurityConfig(@Qualifier("userService") UserDetailsService userDetailsService){
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public BCryptPasswordEncoder encoder() {
        // auto-generate a random salt internally
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder());

        return authProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and() //  "and()"" method allows us to continue configuring the parent
                .authorizeRequests()
                .requestMatchers(HttpMethod.GET, "/register", "/login").permitAll()
                .requestMatchers(POST,"/register").permitAll()
                //Can add more permits here
                .and()
                .authenticationProvider(authenticationProvider()) //specifies the authentication provider for HttpSecurity
                .csrf().disable() // CSRF protection is needed only for browser based attacks
                .formLogin().disable()
                .headers().disable(); // Disable the security headers, as we do not return HTML in our service
        return http.build();
    }
}
