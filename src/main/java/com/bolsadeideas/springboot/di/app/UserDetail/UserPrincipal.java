package com.bolsadeideas.springboot.di.app.UserDetail;

import java.util.Collection;
import java.util.Collections;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bolsadeideas.springboot.di.app.models.entity.Usuario;

/*PROVEE INFOMRACION PRINCIPAL DEL USUARIO LOGEADO*/
public class UserPrincipal implements UserDetails{
	
	private Usuario user;
	
	public UserPrincipal(Usuario user) {
		
		this.user=user;	
		
	}
	
	//ASIGNANDO ROLES
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Long tipouser=user.getTipousuario();
		String tipousuario="";
		
		if(tipouser==1) {
			
			tipousuario="USER";
			
		}else {
			
			tipousuario="ADMIN";
			
		}
			
		return Collections.singleton(new SimpleGrantedAuthority(tipousuario));
		
	}
	
	//OBTENGO PASSWORD DEL USUARIO VALIDADO
	public String getPassword() {
		
		return user.getPassword();
		
	}
	
	//OBTENGO NOMRBE DE USUARIO DEL USUARIO VALIDADO
	public String getUsername() {
		
		return user.getNombre_Usuario();
		
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
