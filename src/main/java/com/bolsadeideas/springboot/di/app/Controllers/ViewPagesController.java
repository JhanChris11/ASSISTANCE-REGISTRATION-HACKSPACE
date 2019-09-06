package com.bolsadeideas.springboot.di.app.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Controller
public class ViewPagesController {

	private String usuario="";
	
	/*----------------------*/
	/*	   SHOW HOMEVIEW  	*/
	/*----------------------*/
	
	@RequestMapping({"/HomeView"})
	public String HomeView(Model model,HttpServletRequest request,HttpSession sesion) {
		
		usuario=request.getRemoteUser();
		
		model.addAttribute("usuario",usuario);
		
		return "Home";
		
	}
	
	/*----------------------*/
	/*	   SHOW HOMEEDIT  	*/
	/*----------------------*/
	
	@RequestMapping({"/HomeEdit"})
	public String HomeEdit() {
		
		return "Home2";
		
	}
	
}
