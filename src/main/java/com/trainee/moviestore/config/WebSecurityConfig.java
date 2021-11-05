package com.trainee.moviestore.config;

import com.trainee.moviestore.config.security.MvsUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private MvsUserDetailService mvsUserDetailService;

    private static final String[] AUTH_WHITELIST = {
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/"
    };

    public WebSecurityConfig(MvsUserDetailService mvsUserDetailService) {
        this.mvsUserDetailService = mvsUserDetailService;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(AUTH_WHITELIST).permitAll()
                .antMatchers(HttpMethod.GET, "/movies/**").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.GET, "/users/**").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(this.mvsUserDetailService);

        return daoAuthenticationProvider;
    }


//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        return new InMemoryUserDetailsManager(
//                User.builder()
//                        .username("user")
//                        .password(passwordEncoder().encode("user"))
//                        .roles("USER")
//                        .build(),
//                User.builder()
//                        .username("admin")
//                        .password(passwordEncoder().encode("admin"))
//                        .roles("ADMIN")
//                        .build()
//        );
//
//    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

}
