package com.te.cardemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.te.cardemo.filter.JwtFilter;
import com.te.cardemo.util.JwtUtil;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService detailsService;
	
	@Autowired
	private JwtFilter jwtRequestFilter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(detailsService);
	}
	

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable().authorizeRequests().antMatchers("/admin/signupAuthentication").permitAll()
	
		.antMatchers("/admin/loginAuthentication").permitAll()
		.antMatchers("/user/car/info").permitAll().antMatchers("/user/car/search").permitAll()
		.antMatchers("/admin/car/info").hasRole("ADMIN").antMatchers("/admin/car/info/").hasRole("ADMIN")
		.antMatchers("/superAdmin/car/info").hasRole("SUPERADMIN")
		.anyRequest().authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		http.cors();
		

	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
		
	}
}
