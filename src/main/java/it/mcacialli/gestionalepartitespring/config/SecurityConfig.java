package it.mcacialli.gestionalepartitespring.config;

import it.mcacialli.gestionalepartitespring.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    CustomUserDetailService customUserDetailService;

  /*
   @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
   */

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()

                .antMatchers("/torneo/**").hasAnyAuthority("ADMIN")
                .antMatchers("/registrazioneTorneo/**").hasAnyAuthority("ADMIN")
                .antMatchers("/registrazioneTorneo").hasAnyAuthority("ADMIN")
                .antMatchers("/utente/**").hasAnyAuthority("ADMIN")
                .antMatchers("/utente").hasAnyAuthority("ADMIN")
                .antMatchers("/campo").hasAnyAuthority("ADMIN")
                .antMatchers("/match").hasAnyAuthority("ADMIN")
                .antMatchers("/team").hasAnyAuthority("ADMIN")
                .antMatchers("/classifica").hasAnyAuthority("UTENTE")
                .and().formLogin()
                .and().csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailService)
                .passwordEncoder(bCryptPasswordEncoder());
    }
}
