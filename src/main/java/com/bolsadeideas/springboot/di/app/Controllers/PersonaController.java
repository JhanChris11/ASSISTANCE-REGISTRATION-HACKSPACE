package com.bolsadeideas.springboot.di.app.Controllers;

import java.util.Map;

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
@SessionAttributes("persona")
public class PersonaController {

	@Autowired
	private IPersonaService  personaService;
	
	/*----------------------*/
	/*		SHOW INDEX  	*/
	/*----------------------*/

	@GetMapping({"/","","/index"})
	public String index(Map <String,Object> model) {
		
		Persona persona = new Persona();
		
		model.put("persona",persona);
		model.put("titulo","Registrar");
		
		return "index";
		
	}

	@RequestMapping(value="/signIn")
	public String signIn(Map <String,Object> model) {
		
		
		Persona persona=new Persona();
		
		model.put("persona",persona);
		
		return "signIn";
		
	}
	
	@RequestMapping(value="/signIn",method=RequestMethod.POST)
	public String validateSignIn(@Valid Persona persona, BindingResult result, Model model, RedirectAttributes flash,SessionStatus status) {
		
		status.setComplete();
		
		return "Home";
		
	}
	
	/*----------------------*/
	/*	   SHOW HOMEVIEW  	*/
	/*----------------------*/
	
	@RequestMapping(value="/HomeView")
	public String HomeView() {
		
		return "Home";
		
	}
	
	/*----------------------*/
	/*	   SHOW HOMEEDIT  	*/
	/*----------------------*/
	
	@RequestMapping(value="/HomeEdit")
	public String HomeEdit() {
		
		return "Home2";
		
	}
	
	/*----------------------*/
	/*	   CREATING A NEW  	*/
	/*	   	   PERSON  		*/
	/*----------------------*/
	
	@RequestMapping(value="/form")
	public String guardar(@Valid Persona persona, BindingResult result, Model model, RedirectAttributes flash,
			SessionStatus status) {
	
		personaService.save(persona);
		
		status.setComplete();
		
		return "index";
	
	}
		
}
