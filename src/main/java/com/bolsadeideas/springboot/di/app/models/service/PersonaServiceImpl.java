package com.bolsadeideas.springboot.di.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bolsadeideas.springboot.di.app.models.dao.IPersonaDao;
import com.bolsadeideas.springboot.di.app.models.dao.IPersonaUsuarioDao;
import com.bolsadeideas.springboot.di.app.models.dto.PersonaUsuarioDto;
import com.bolsadeideas.springboot.di.app.models.entity.Persona;

@Component("Mi primer servicio")
public class PersonaServiceImpl implements IPersonaService {
	
	@Autowired
	private IPersonaDao personaDao;
	
	@Autowired
	private IPersonaUsuarioDao personaUsuarioDao;


	public List<Persona> findAll() {
	
		return (List<Persona>) personaDao.findAll();
		
	}

	public void save(Persona persona) {
		
		personaDao.save(persona);
		
	}

	@Override
	public Long getIdPerson(Long id) {
		
		Persona persona=new Persona();
		
		persona=personaDao.findAllActiveUsers(id);
		
		return persona.getId();
		
	}

	public List<PersonaUsuarioDto> findAllPersonUser() {	
		
		return (List<PersonaUsuarioDto>) personaUsuarioDao.findAllPersonUser();
		
	}

}
	
