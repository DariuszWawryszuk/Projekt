package com.Darek.Programik.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
public class SecutityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;


    @Override
    public void configure(HttpSecurity security) throws Exception {

        //http.headers().frameOptions().disable();

        security.authorizeRequests()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/books").hasAnyAuthority("USER","ADMIN")
                .antMatchers("/basket").hasAnyAuthority("USER")
                .antMatchers("/newbookinbasket").hasAnyAuthority("USER")
                .antMatchers("/book").hasAnyAuthority("USER")
                .antMatchers("/newbook").hasAnyAuthority("ADMIN")
                .antMatchers("/delete").hasAnyAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().defaultSuccessUrl("/books");

    }

    @Autowired
    public void securityUsers(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT username,password,enabled FROM USERS WHERE username = ?")
                .authoritiesByUsernameQuery("SELECT username,role FROM ROLE WHERE username = ?");
    }

    
}
