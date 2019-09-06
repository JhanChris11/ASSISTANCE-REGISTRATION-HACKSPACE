package com.bolsadeideas.springboot.di.app.Controllers;

import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bolsadeideas.springboot.di.app.models.entity.Persona;
import com.bolsadeideas.springboot.di.app.models.service.IPersonaService;

@Controller
public class PersonaController {

	@Autowired
	private IPersonaService  personaService;
	
	/*----------------------*/
	/*	   CREATING A NEW  	*/
	/*	   	   PERSON  		*/
	/*----------------------*/
	
	
	@RequestMapping(value="/form")
	public String crear() {	
		
		return "form";
		
	}
	
	@RequestMapping(value="/form",method=RequestMethod.POST)
	public String guardar(SessionStatus status,Persona persona) {
	
		personaService.save(persona);
		status.setComplete();
		
		System.out.println("Se guardo "+ persona.getApellidoMaterno());
		
		return "redirect:login";
	
	}

}