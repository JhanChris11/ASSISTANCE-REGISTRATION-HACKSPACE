package com.bolsadeideas.springboot.di.app.Controllers;

import java.security.Principal;
import java.util.Map;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bolsadeideas.springboot.di.app.models.entity.Persona;

@Controller
public class LoginController {
/*
	@GetMapping("/index")
	public String index(Map <String,Object> model , Principal principal , RedirectAttributes flash  ) {
		//Objeto principal contiene al usuario logeado
	Persona persona = new Persona();
		
		model.put("persona",persona);
		model.put("titulo","Registrar");

		
		return "index";
	}
	*/
}
