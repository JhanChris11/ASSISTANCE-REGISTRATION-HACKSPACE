package com.bolsadeideas.springboot.di.app.Controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.bolsadeideas.springboot.di.app.UserDetail.UserPrincipal;
import com.bolsadeideas.springboot.di.app.UserDetailService.MyUserDetailsService;
import com.bolsadeideas.springboot.di.app.models.dto.PersonaUsuarioDto;
import com.bolsadeideas.springboot.di.app.models.service.UsuarioService;

@Controller
public class ViewPagesController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	/*----------------------*/
	/*	   SHOW HOMEVIEW  	*/
	/*----------------------*/

	@RequestMapping({"/HomeView"})
	public String HomeView(Model model,HttpServletRequest request,HttpSession session) {
		
		PersonaUsuarioDto persUser;
		
		session = request.getSession();
		
		Long id=(Long) session.getAttribute("id");
		
		persUser=usuarioService.getUser(id);
		
		model.addAttribute("usuario",persUser.getUsuario());
		model.addAttribute("apellidos",persUser.getApellidoPaterno()+" "+persUser.getApellidoMaterno());
		model.addAttribute("dni",persUser.getDni());
		
		return "Home";
		
	}
	
	/*----------------------*/
	/*	   SHOW HOMEEDIT  	*/
	/*----------------------*/
	
	@RequestMapping({"/HomeEdit"})
	public String HomeEdit(Map<String,Object> modelObject,HttpServletRequest request,HttpSession session) {
		
		PersonaUsuarioDto persUser;
		
		session = request.getSession();
		
		Long id=(Long) session.getAttribute("id");
		
		persUser=usuarioService.getUser(id);
		
		modelObject.put("personaUser",persUser);
		
		return "Home2";
		
	}
	
}
