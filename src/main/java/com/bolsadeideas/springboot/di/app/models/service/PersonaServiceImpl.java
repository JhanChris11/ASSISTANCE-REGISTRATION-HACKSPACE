package com.bolsadeideas.springboot.di.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bolsadeideas.springboot.di.app.models.dao.IPersonaDao;
import com.bolsadeideas.springboot.di.app.models.entity.Persona;
@Component("Mi primer servicio")
public class PersonaServiceImpl implements IPersonaService {
	@Autowired
	private IPersonaDao personaDao;

	@Override
	public List<Persona> findAll() {
	
		return (List<Persona>) personaDao.findAll();
	}

	@Override
	public void save(Persona persona) {
		// TODO Auto-generated method stub
		personaDao.save(persona);
		
	}

	@Override
	public String Operacion() {
	
		return "hola";
	}
	

		
	}
	
