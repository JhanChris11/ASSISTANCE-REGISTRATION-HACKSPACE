package com.bolsadeideas.springboot.di.app.UserDetailService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bolsadeideas.springboot.di.app.UserDetail.UserPrincipal;
import com.bolsadeideas.springboot.di.app.models.dao.IUserDao;
import com.bolsadeideas.springboot.di.app.models.entity.Usuario;

/*	CLASE PARA IMPLEMENTAR	*/
/* 	  USERDETAILSSERVICE	*/
/*	 GESTIONANDO NUESTRO	*/
/*	 SERVICIO DE USUARIO	*/

//USER DETAILS SERVICE
//Esta interfaz describe un objeto que realiza un acceso a datos con un único método loadUserByUsername 

@Service
@SessionAttributes("usuario")
public class MyUserDetailsService implements UserDetailsService{
	
	private String nombre;
	private Long role;
	
	/*INYECTANDO AL OBJETO REPO*/
	@Autowired
	private IUserDao repo;
	
	@Autowired 
	 private HttpSession session;
	
	//devuelve la información de un usuario a partir de su nombre de usuario.
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//ACCESO AL DAO ESPECIFICO PARA USUARIOS Y OBTENGO EL USUARIO QUE HE VALIDADO
		Usuario user=repo.findByUsername(username);
		
		if(user==null) {
			
			throw new UsernameNotFoundException("User 404");
			
		}
		
		nombre=user.getPassword();
		role=user.getTipousuario();
		
		UserPrincipal usuario= new UserPrincipal(user);
		usuario.GetDatesSession(session);
		
		return usuario;
		
	}

}
