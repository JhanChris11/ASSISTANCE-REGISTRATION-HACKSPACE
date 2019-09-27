package com.bolsadeideas.springboot.di.app.Controllers;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.di.app.models.service.IPersonaService;
import java.util.Map;

@Controller
public class ViewPagesAdminController {
	
	@Autowired
	private IPersonaService personaService;
	
	/*----------------------*/
	/*	   SHOW DASHBOARD  	*/
	/*----------------------*/
	
	@RequestMapping({"/principal"})
	public String principal(Model model) {
		
		System.out.println("Bien ahi!");
		
		return "admin/principal-admin";
		
	}
	
	/*----------------------*/
	/*	   SHOW CRUDUSERS  	*/
	/*----------------------*/
	
	@RequestMapping({"/listado"})
	public String listado(Model model,Map<String,Object> modelObject,HttpServletRequest request,HttpSession session) {
		
		session=request.getSession();
		
		System.out.println(session.getAttribute("id"));
		
		modelObject.put("personasUsuarios",personaService.findAllPersonUser());
		
		return "admin/listado";
		
	}
	
	/*----------------------------------*/
	/*	   SHOW REGISTER ASSISTENCE  	*/
	/*----------------------------------*/
	
	@RequestMapping({"/calendario"})
	public String calendario(Model model) {
		return "admin/calendario";
	}

}
