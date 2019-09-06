package com.bolsadeideas.springboot.di.app.Controllers;

import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bolsadeideas.springboot.di.app.models.entity.Persona;

@Controller
public class LoginController {

	/*----------------------*/
	/*		SHOW INDEX  	*/
	/*		 OR LOGIN  		*/
	/*----------------------*/
	
	@RequestMapping({"/login"})
	public String login(Map <String,Object> model,HttpServletRequest request,HttpSession session) {
		
		Persona persona=new Persona();
		
		model.put("persona",persona);
		
		System.out.println("Al entrar imprimo "+request.getRemoteUser());
		
		if(request.getRemoteUser()!=null) {
			
			System.out.println("Redireccionando");
			
			return "redirect:/HomeView";
			
		}
		
		return "login";
		
	}
	
	/*----------------------*/
	/*	   	   LOGOUT 		*/
	/*----------------------*/
	
	@RequestMapping({"/logout"})
	public String logout(Model model) {
		
		return "login";
		
	}
	
}
