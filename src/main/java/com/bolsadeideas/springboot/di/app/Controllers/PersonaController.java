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

import com.bolsadeideas.springboot.di.app.models.dto.PersonaUsuarioDto;
import com.bolsadeideas.springboot.di.app.models.entity.Persona;
import com.bolsadeideas.springboot.di.app.models.service.IPersonaService;
import com.bolsadeideas.springboot.di.app.models.service.UsuarioServiceImpl;

@Controller
public class PersonaController {

	@Autowired
	private IPersonaService  personaService;
	
	@Autowired
	private UsuarioServiceImpl usuarioPersonaService;
	
	/*----------------------*/
	/*	   CREATING A NEW  	*/
	/*	   	   PERSON  		*/
	/*----------------------*/
	
	@RequestMapping(value="/form")
	public String crear() {	
		
		return "form";
		
	}
	
	@RequestMapping(value="/form",method=RequestMethod.POST)
	public String guardar(Model model ,SessionStatus status,PersonaUsuarioDto dto ) {
	

		usuarioPersonaService.InsertUserPerson( dto.getPasswordEncrypted(),dto.getUsuario(), (long) 1);
		usuarioPersonaService.InsertPersonUser(dto.getApellidoMaterno(), dto.getApellidoPaterno(), dto.getCuentaGithub(), dto.getDni(), dto.getLugarResidencia(),dto.getTelefono());
		status.setComplete();
	
		return "redirect:login";
	
	}

}