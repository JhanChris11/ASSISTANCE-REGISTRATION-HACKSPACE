package com.bolsadeideas.springboot.di.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;

@Configuration
@EnableWebSecurity

/*WebSecurityConfigurerAdapter:PROPORCIONAR SEGURIDAD*/

public class AppSecurityConfig extends WebSecurityConfigurerAdapter{
	
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
		return provider;
		
	}
	
	@Bean
    public PasswordEncoder encoder() {
		
        return new BCryptPasswordEncoder();
        
    }
	
	//METODO DE CONFIGURACION PARA QUE CUALQUIER SOLICITUD A LA APLICACION SEA AUTENTICADA
	protected void configure(HttpSecurity http) throws Exception {
		
		//security.ignoring().antMatchers("/css/**","/js/**","/img/**");

		http.csrf().disable()
		  	.authorizeRequests()
		  	//.antMatchers("/HomeEdit/**").hasAuthority("USER")
		  	.antMatchers(HttpMethod.GET,"/resources/**","/resources/static/**","/css/**","/js/**","/img/**","/login").permitAll()
      		.anyRequest().authenticated()//AUTHENTICATED LLAMA AL METODO AuthenticationProvider QUE HARA TODO EL PROCESO 
      		//DE VALIDACION DEL USUARIO AL DAR CLICK EN EL BUTTON DE LA PAGINA SUBMIT
      		.and()
		    .formLogin().loginPage("/login").permitAll()
		    .and()
		    .formLogin().loginPage("/form").permitAll()
		    .defaultSuccessUrl("/login", true)
		    .and()
		    .logout()
		    .invalidateHttpSession(true)
            .clearAuthentication(true)
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/login") 
		    .permitAll();
	
	              
	}
	
}
