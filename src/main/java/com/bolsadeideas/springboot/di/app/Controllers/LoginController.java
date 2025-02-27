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
public class LoginController {
	
	/*----------------------*/
	/*		SHOW INDEX  	*/
	/*		 OR LOGIN  		*/
	/*----------------------*/
	
	@RequestMapping({"/login","/"})
	public String login(Map <String,Object> model,Model model2,HttpServletRequest request,HttpSession session ,PersonaUsuarioDto personaDto) {
		
		
		model.put("personausuariodto",personaDto);
		
		System.out.println("Redireccionando del login User");
		
		System.out.println(request.getRemoteUser()+ "de User");
		
		if(request.getRemoteUser()!=null) {
			
			System.out.println("Redireccionando");
			
			return "redirect:/HomeView";
			
		}
		
		return "user/login";
		
	}
	
	/*----------------------*/
	/*	   	   LOGOUT 		*/
	/*----------------------*/
	
	@RequestMapping({"/logout"})
	public String logout(Model model,SessionStatus status) {
		
		status.setComplete();
		
		return "user/login";
		
	}
	
}
