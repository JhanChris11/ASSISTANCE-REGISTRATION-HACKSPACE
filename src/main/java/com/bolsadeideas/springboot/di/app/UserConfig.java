package com.bolsadeideas.springboot.di.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@Order(1)
public class UserConfig extends WebSecurityConfigurerAdapter{
		
		//METODO DE CONFIGURACION PARA QUE CUALQUIER SOLICITUD A LA APLICACION SEA AUTENTICADA
		protected void configure(HttpSecurity http) throws Exception {
	
			http.csrf().disable()
			  	.authorizeRequests()
			  	.antMatchers("/resources/static/**","/css/**","/js/**","/img/**","/form").permitAll()
			  	.antMatchers(HttpMethod.GET,"/resources/templates/user/**").hasAuthority("USER")
			  	.antMatchers("/login","/form").hasAuthority("USER")
	      		.anyRequest().authenticated()//AUTHENTICATED LLAMA AL METODO AuthenticationProvider QUE HARA TODO EL PROCESO 
	      		//DE VALIDACION DEL USUARIO AL DAR CLICK EN EL BUTTON DE LA PAGINA SUBMIT
	      		.and()
			    .formLogin().loginPage("/login").permitAll()
			    .defaultSuccessUrl("/login", true)
			    .and()
			    .logout()
			    .invalidateHttpSession(true)
	            .clearAuthentication(true)
	            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	            .logoutSuccessUrl("/login") 
			    .permitAll();
		
		}
		
		@Autowired
		private UserDetailsService userDetailsService;
			
		//ULTIMO PASO EN EL PROCESO DE AUTENTICACION.METODO PARA LA AUTENTICACION DEL USUARIO AL DAR CLICK EN LOGIN	
		@Bean
		public AuthenticationProvider authProvider() {
				
				
				System.out.println(userDetailsService);
				
				/*interfaz de autenticación centrada en el acceso a los datos que se encuentran almacenados dentro de una base de datos*/
				DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
				
				/*Responsable de tomar un objeto de solicitud de autenticación y decidir si es o no válida*/
				
				/*ACA COLOCAMOS LOS DATOS OBTENIDOS DEL OBJETO USER PRINCIPAL QUE SE GUARDARON CUANDO SE VALIDO CORRECTAMENTE 
				 * EL USUARIO*/
				provider.setUserDetailsService(userDetailsService);
			
				//provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
				
				/*COLOCAMOS QUE LA PASSWORD SE ENCRIPTARA*/
				provider.setPasswordEncoder(encoder());
				
				/*RETORNA EL OBJETO VALIDADO SEA NULL O NO*/
				System.out.println(provider);
				return provider;
				
		}
			
		@Bean
		public PasswordEncoder encoder() {
			
			System.out.println("VALIDANDO PASSWORD");
				
		    return new BCryptPasswordEncoder();
		        
		} 
		
}
	
	

