package com.hazloakki.gateway.security;

//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
////@Configuration
////@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    http.authorizeRequests().antMatchers("/static/**").permitAll()
//      .anyRequest().fullyAuthenticated()
//      .and().httpBasic()
//      .and().csrf().disable();
//  }
//
// // @Autowired
//  void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//    UserDetailsManagerConfigurer authentication =
//      auth.inMemoryAuthentication();
//
//    authentication.withUser("admin").password("secreto").roles("ADMIN", "ACTUATOR");
//    authentication.withUser("user").password("secreto").roles("OPERATOR");
//  }
//}