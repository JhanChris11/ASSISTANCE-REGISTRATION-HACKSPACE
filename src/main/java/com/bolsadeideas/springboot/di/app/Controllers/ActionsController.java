package com.bolsadeideas.springboot.di.app.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.di.app.models.dto.PersonaUsuarioDto;
import com.bolsadeideas.springboot.di.app.models.service.UsuarioService;

@Controller
public class ActionsController {
	
	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping({"/editar"})
	public String editarPersonaUsuario(PersonaUsuarioDto personaUser,HttpServletRequest request,HttpSession session) {
		
		session=request.getSession();
		
		usuarioService.UpdatePersonaUsuario(personaUser.getApellidoPaterno(),personaUser.getApellidoMaterno(),personaUser.getCuentaGithub(),personaUser.getDni(),personaUser.getLugarResidencia(),personaUser.getTelefono(),personaUser.getUsuario(),(Long) session.getAttribute("id"));
		
		return "redirect:/HomeView";
		
	}
	
}
