package com.dsr.jschool.configuration;

import com.dsr.jschool.security.JwtFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtFilter jwtFilter;

    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(STATELESS)
                .and()
                .authorizeRequests()
//                .antMatchers(GET, "/api/v1/devices").hasRole("USER")
//                .antMatchers(POST, "/api/v1/devices/*/transfer").hasRole("USER")
//                .antMatchers(GET, "/api/v1/devices/*").hasRole("USER")
//                .antMatchers(POST,"/api/v1/devices").hasRole("ADMIN")
//                .antMatchers(DELETE,"/api/v1/devices/*").hasRole("ADMIN")
//                .antMatchers(PUT,"/api/v1/devices/*").hasRole("ADMIN")
                .antMatchers("/api/v1/devices/*").anonymous()
                .antMatchers("/security/*").anonymous()
                .and().addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
