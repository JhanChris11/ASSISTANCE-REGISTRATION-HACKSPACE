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
	
	@GetMapping({"/","","/index"})
	public String index(Model model) {
		//model.addAttribute("objeto", personaService.Operacion());
		return "index";
	}
	@RequestMapping(value="/form")
	public String crear(Map <String,Object> model) {
		Persona persona = new Persona();
		
		model.put("persona",persona);
		model.put("titulo","Registrar");
		
		
		return "form";
	}
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Persona persona, BindingResult result, Model model, RedirectAttributes flash,
			SessionStatus status) {
	
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Registrar");
			return "form";
		}
		personaService.save(persona);
		status.setComplete();
		
	return "form";
}
}
