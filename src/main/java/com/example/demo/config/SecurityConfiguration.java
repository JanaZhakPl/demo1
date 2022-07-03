package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {
  // В этом блоке регулируем поведение приложения при авторизации и аутентификации пользователя.
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .antMatchers(HttpMethod.GET, "/", "/home", "/registration")
        .permitAll() // Разрешаем доступ без аутентификации
        .antMatchers(HttpMethod.POST, "/registration")
        .permitAll() // Разрешаем доступ без аутентификации
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .defaultSuccessUrl("/home") // При удачном логине перенаправляем на главную страницу
        .permitAll()
        .and()
        .logout()
        .logoutUrl("/logout")
        .logoutSuccessUrl("/home") // Аналогично при удачном логауте перенаправляем на главную страницу
        .permitAll()
        .and()
        .csrf().disable()
        .httpBasic(); // Отключаем CSRF защиту, так как мы не используем её в приложении.
    return http.build();
  }

  // Храним пароли в зашифрованном виде Bcrypt https://bcrypt-generator.com/ - обрати внимание!!!
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
