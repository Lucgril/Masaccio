package it.univaq.disim.se.masaccio.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("customUserDetailsService")
    UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //.antMatchers("/", "/home").permitAll()
        		.antMatchers("/", "/home").authenticated()
                .antMatchers("/IoTRoomData/**").access("hasRole('ADMIN')")
                .antMatchers("/firstResponderCommunication/**").access("hasRole('ADMIN') or hasRole('EMPLOYEE') or hasRole('RESPONDER')")
                .and().formLogin().loginPage("/login")
                .usernameParameter("ssoId").passwordParameter("password")
                .and().csrf().disable()
                .exceptionHandling().accessDeniedPage("/Access_Denied");
    }

}
