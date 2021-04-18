package ru.itis.demo.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    @Qualifier("customUserDetailsService")
    private UserDetailsService userDetailsService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/**").permitAll()
                .and()
                .formLogin() // описываем страницу входа
                .loginPage("/signIn") //наша страница входа расположена по указанному адресу
                .usernameParameter("email")// в качестве имени пользователя с этой страницы уходит email
                .defaultSuccessUrl("/profile") // после успешного входа пользователь должен перейти на указанный url
                .failureUrl("/signIn?error"); // если была ошибка, то на указанный url

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

}
