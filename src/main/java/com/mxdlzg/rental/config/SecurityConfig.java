package com.mxdlzg.rental.config;

import com.mxdlzg.rental.dao.service.UserService;
import com.mxdlzg.rental.domain.auth.JWTAccessDeniedHandler;
import com.mxdlzg.rental.domain.auth.JWTAuthenticationEntryPoint;
import com.mxdlzg.rental.domain.auth.JWTAuthenticationFilter;
import com.mxdlzg.rental.domain.auth.JWTAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    @Qualifier("userService")
    private UserService userService;
    @Autowired
    private JWTAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @Autowired
    private JWTAccessDeniedHandler jwtAccessDeniedHandler;

    private final String ADMIN = "ADMIN";
    private final String USER = "USER";

    //加密
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ExceptionTranslationFilter exceptionTranslationFilter = new ExceptionTranslationFilter(new JWTAuthenticationEntryPoint());

        http.csrf().disable()
                .authorizeRequests()
//                .antMatchers("/tasks").authenticated()
                .antMatchers("/api/analysis/**").hasRole(ADMIN)
                .antMatchers("/api/pay/checkout").hasRole(ADMIN)
                .antMatchers("/api/pay/payment").hasRole(USER)
                .antMatchers("/api/order/takeCar").hasRole(ADMIN)
                .antMatchers("/api/order/orderDetail").hasAnyRole(USER,ADMIN)
                .antMatchers("/api/order/**").hasAnyRole(USER)
                .antMatchers("/api/assets/queryCouponsList").hasRole(USER)
                .antMatchers("/api/assets/**").hasAnyRole(ADMIN)
                .anyRequest().permitAll()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                //.addFilterBefore(new ExceptionTranslationFilter(new JWTAuthenticationEntryPoint()),JWTAuthenticationFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                    .accessDeniedHandler(jwtAccessDeniedHandler);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
}
