package com.bolsadeideas.springboot.di.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	/*--------------------------------------------*/
	/*METHOD TO BE ABLE TO REGISTER AND CONFIGURE */
	/*--------------------------------------------*/
	//bean para crear un componente , creo la instancia , la retornamos y lo guardamos en el contenedor (bean)
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();	
	}
	
	@Override
	
	protected void configure(HttpSecurity http) throws Exception {

		// TODO Auto-generated method stub
		http.authorizeRequests().antMatchers("/css/**","/js/**").permitAll()
	//.antMatchers("/ver/**").hasAnyRole("USER")
	//	.antMatchers("/form/**").hasAnyRole("ADMIN")
	//	.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/index").permitAll();
		/*
		.failureUrl("/login?error=true")
		.usernameParameter("username")
		.passwordParameter("password")
		.permitAll()
		.and()
		.logout().permitAll();
	*/
	}

	@Autowired //Para inyectar este componente
	public void configurerGlobal (AuthenticationManagerBuilder builder ) throws Exception {
	
		PasswordEncoder encoder = passwordEncoder();
		//Expresion Lambda
	/*
		UserBuilder user = User.builder().passwordEncoder(password1 -> {
			return encoder.encode(password1);
		});
		
		UserBuilder user = User.build()..passwordEncoder(password ->encoder.encode(password));
		
	*/
		
		/*
			Caracteristica de Java 8 , se llama de manera estatica , 
			la expresion :: obtiene el argumento de la opcion lambda y se pasa al metodo de forma implicita	*/
		
		//Retornar el password encriptado con BCrypt
		UserBuilder users = User.builder().passwordEncoder(encoder::encode);
		//Al tener user Builder configurado podemos crear estos usuarios en memoria ; el password de manera automatica se encripta
		
		builder.inMemoryAuthentication()
		.withUser(users.username("Admin").password("12345").roles("ADMIN","USERS"))
		.withUser(users.username("carlos").password("12345").roles("USER"));
		
	}
	
}
