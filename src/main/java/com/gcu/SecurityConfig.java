package com.gcu;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * This class sets up the security for the website using Spring Security
 * @author Chael
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter 
{
	//uses connection to database
    @Autowired
    private DataSource dataSource;
    
	/**
	 * This method sets the username and password for the allowed user.
	 * @param auth
	 */
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
            .dataSource(dataSource)
            .usersByUsernameQuery("select username, password, enabled from users WHERE username = ?")
            .authoritiesByUsernameQuery("select username, role from users where username=?");
    }
    
	@Override
	/**
	 * This method configures the security settings by setting certain links as unprotected and disabling all other urls
	 * @param http
	 */
	protected void configure(HttpSecurity http) throws Exception 
	{
		//disables the ability to access any links other than the ones listed in the unprotected list until user is logged in
		http.csrf().disable()
			.httpBasic()
				.and()
				.authorizeRequests()
				.antMatchers("/service/**").authenticated()
				.and()
			.authorizeRequests()
				.antMatchers("/", "/images/**", "/register/**").permitAll() //unprotected list
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")//sets login page as the login page for spring security
				.usernameParameter("username")
                .passwordParameter("password")
				.permitAll()
				.defaultSuccessUrl("/order/display", true) //Once successfully logged in, spring security reroutes you to the orders page
				.and()
			.logout()
				.logoutUrl("/logout")//format logout button
				.invalidateHttpSession(true)//logs user out
				.clearAuthentication(true)
				.permitAll()
				.logoutSuccessUrl("/"); //after logout takes us to the home page
	}
	

}












