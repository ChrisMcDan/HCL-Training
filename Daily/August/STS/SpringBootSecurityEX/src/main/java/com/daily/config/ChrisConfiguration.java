/*August 10, 2022*/

package com.daily.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class ChrisConfiguration extends WebSecurityConfigurerAdapter
{
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication()
		.withUser("Sam")
		.password("1234")
		.roles("USER")
		.and()
		.withUser("Saran")
		.password("1234")
		.roles("ADMIN");
	}
	
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests()
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/user").hasAnyRole("USER", "ADMIN")	//Allows access to 'user' page for 'USER' and 'ADMIN'. '.hasRole(String)'
		.antMatchers("/").permitAll()
		.and().formLogin();
	}
	
	@Bean
	public PasswordEncoder getPwdEnCoder()
	{
		return NoOpPasswordEncoder.getInstance();	//BCryptPasswordEncoder
	}
}