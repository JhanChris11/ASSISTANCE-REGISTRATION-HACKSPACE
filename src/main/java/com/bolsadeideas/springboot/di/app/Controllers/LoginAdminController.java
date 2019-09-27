package com.bolsadeideas.springboot.di.app.Controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsadeideas.springboot.di.app.models.dto.PersonaUsuarioDto;

@Controller 
public class LoginAdminController {
	
	/*----------------------*/
	/*		SHOW INDEX  	*/
	/*		 OR LOGIN  		*/
	/*----------------------*/
	
	@RequestMapping({"/admin"})
	public String loginAdmin(Map <String,Object> model,Model model2,HttpServletRequest request,HttpSession session,PersonaUsuarioDto personaDto) {
		
		model.put("personausuariodto",personaDto);
		
		System.out.println("Redireccionando del admin");
		
		System.out.println(request.getRemoteUser()+"del admin");
		
		if(request.getRemoteUser()!=null) {
			
			System.out.println("Redireccionando");
			
			return "redirect:/principal";
			
		}
		
		return "admin/login-admin";
		
	}
	
	/*----------------------*/
	/*	   	   LOGOUT 		*/
	/*----------------------*/
	
	@RequestMapping({"/logoutAdmin"})
	public String logoutAdmin(SessionStatus status) {
		
		status.setComplete();
		
		return "admin/login-admin";	
		
	}

}
