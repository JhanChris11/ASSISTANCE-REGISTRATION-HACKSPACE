package com.bolsadeideas.springboot.di.app.Controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.bolsadeideas.springboot.di.app.UserDetail.UserPrincipal;
import com.bolsadeideas.springboot.di.app.UserDetailService.MyUserDetailsService;
import com.bolsadeideas.springboot.di.app.models.dto.PersonaUsuarioDto;
import com.bolsadeideas.springboot.di.app.models.service.IPersonaService;
import com.bolsadeideas.springboot.di.app.models.service.IRegAsistService;
import com.bolsadeideas.springboot.di.app.models.service.UsuarioService;

@Controller
public class ViewPagesController {
	
	@Autowired
	private IPersonaService personaService;
	
	@Autowired
	private IRegAsistService regAsisService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	/*----------------------*/
	/*	   SHOW HOMEVIEW  	*/
	/*----------------------*/

	@RequestMapping({"/HomeView"})
	public String HomeView(Model model,HttpServletRequest request,HttpSession session) {
		
		/*----------------------*/
		/*	   SETTING DATES    */
		/*----------------------*/
		
		session=request.getSession();
		
		PersonaUsuarioDto persUser;
		
		Long id=(Long) session.getAttribute("id");
		
		persUser=usuarioService.getUser(id);
		
		/*----------------------*/
		/*	     GET  DATE      */
		/*----------------------*/
		
		DateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
		
		Date date=new Date();
		
		LocalDate date1 = LocalDate.parse(dateformat.format(date));
		
		/*----------------------*/
		/*	   GET ID PERSONA   */
		/*----------------------*/
		
		Long idPersona=personaService.getIdPerson(id);
		
		if(regAsisService.GetDateRegister(date1,idPersona)!="No registrado") {
			
			System.out.println("Ya marcaste asistencia!!! ");
			
			model.addAttribute("valor","registrado");
			
		}else {
			
			model.addAttribute("valor","noregistrado");
			
		}
		
		model.addAttribute("usuario",persUser.getUsuario());
		model.addAttribute("apellidos",persUser.getApellidoPaterno()+" "+persUser.getApellidoMaterno());
		model.addAttribute("dni",persUser.getDni());
		model.addAttribute("nombres",persUser.getUsuario()+" "+persUser.getApellidoPaterno());
		
		return "user/Home";
		
	}
	
	/*----------------------*/
	/*	   SHOW HOMEEDIT  	*/
	/*----------------------*/
	
	@RequestMapping({"/HomeEdit"})
	public String HomeEdit(Map<String,Object> modelObject,Model model,HttpServletRequest request,HttpSession session) {
		
		PersonaUsuarioDto persUser;
		
		session = request.getSession();
		
		Long id=(Long) session.getAttribute("id");
		
		persUser=usuarioService.getUser(id);
		
		modelObject.put("personaUser",persUser);
		model.addAttribute("nombres",persUser.getUsuario()+" "+persUser.getApellidoPaterno());
		
		return "user/Home2";
		
	}
	
}
