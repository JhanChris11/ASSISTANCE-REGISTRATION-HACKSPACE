package com.bolsadeideas.springboot.di.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@Order(1)
public class AdminConfig extends WebSecurityConfigurerAdapter{
		
		//METODO DE CONFIGURACION PARA QUE CUALQUIER SOLICITUD A LA APLICACION SEA AUTENTICADA
		protected void configure(HttpSecurity http) throws Exception {
	
			http.csrf().disable()
			  	.authorizeRequests()
			  	.antMatchers("/resources/static/**","/app-assets/**","/css/**","/js/**","/img/**").permitAll()
			  	.antMatchers(HttpMethod.GET,"/resources/templates/admin/**").hasAuthority("ADMIN")
			  	.antMatchers("/admin").hasAuthority("ADMIN")
	      		.anyRequest().authenticated()//AUTHENTICATED LLAMA AL METODO AuthenticationProvider QUE HARA TODO EL PROCESO 
	      		//DE VALIDACION DEL USUARIO AL DAR CLICK EN EL BUTTON DE LA PAGINA SUBMIT
	      		.and()
			    .formLogin().loginPage("/admin").permitAll()
			    .defaultSuccessUrl("/admin", true)
			    .and()
			    .logout()
			    .invalidateHttpSession(true)
	            .clearAuthentication(true)
	            .logoutRequestMatcher(new AntPathRequestMatcher("/logoutAdmin"))
	            .logoutSuccessUrl("/admin") 
			    .permitAll();
		
		}
		
}