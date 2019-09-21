package com.bolsadeideas.springboot.di.app.Controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.di.app.models.dto.PersonaUsuarioDto;
import com.bolsadeideas.springboot.di.app.models.service.IPersonaService;
import com.bolsadeideas.springboot.di.app.models.service.IRegAsistService;
import com.bolsadeideas.springboot.di.app.models.service.UsuarioService;

@Controller
public class ActionsController {
	
	@Autowired
	private IPersonaService personaService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private IRegAsistService regAsisService;

	@RequestMapping({"/editar"})
	public String editarPersonaUsuario(PersonaUsuarioDto personaUser,HttpServletRequest request,HttpSession session) {
		
		session=request.getSession();
		
		System.out.println(personaUser.getApellidoMaterno());
		
		usuarioService.UpdatePersonaUsuario(personaUser.getApellidoPaterno(),personaUser.getApellidoMaterno(),personaUser.getCuentaGithub(),personaUser.getDni(),personaUser.getLugarResidencia(),personaUser.getTelefono(),personaUser.getUsuario(),(Long) session.getAttribute("id"));
		
		return "redirect:/HomeView";
		
	}
	
	@RequestMapping({"/registrar"})
	public String registrarPersonaUsuario(HttpServletRequest request,HttpSession session) throws ParseException{
		
		session=request.getSession();
		
		/*----------------------*/
		/*	   GET ID PERSONA   */
		/*----------------------*/
		
		Long idPersona=personaService.getIdPerson((Long)(session.getAttribute("id")));
		
		
		regAsisService.InsertarAsistencia(idPersona,Long.parseLong("1"));

		
		return "redirect:/HomeView";
		
	}
	
}
