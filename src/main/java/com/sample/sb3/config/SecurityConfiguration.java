package com.sample.sb3.config;

import org.apache.catalina.core.ApplicationFilterChain;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration  {
    @Value("${ssp.sp.id}")
    private String spId;
    @Value("${ssp.sp.id}")
    private String spUrl;
    @Value("${ssp.sp.scheme}")
    private String scheme;
    @Value("${ssp.sp.serverName}")
    private String serverName;
    @Value("${ssp.sp.includePort}")
    private String includePort;
    @Value("${server.port}")
    private String serverPort;
    @Value("${server.context-path}")
    private String contextPath;
    @Value("${ssp.idp.url}")
    private String idpUrl;
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/home").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }
    @Bean
    public SecurityFilterAutoConfiguration securityFilterAutoConfiguration() {
        return  new SecurityFilterAutoConfiguration();
    }

    @Bean
    public ApplicationFilterChain applicationFilterChain() {
        return  new ApplicationFilterChain();
    }


    @Bean
    public void configure(HttpSecurity httpSecurity) throws Exception {

    }

}
