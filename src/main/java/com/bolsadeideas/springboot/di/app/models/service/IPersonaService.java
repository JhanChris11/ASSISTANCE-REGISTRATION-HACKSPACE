package com.bolsadeideas.springboot.di.app.models.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.di.app.models.dto.PersonaUsuarioDto;
import com.bolsadeideas.springboot.di.app.models.entity.Persona;

public interface IPersonaService {

	@Transactional(readOnly=true)
	public List<Persona> findAll();
	
	public void save(Persona persona);
	
	public Long getIdPerson(Long id);
	
	@Transactional(readOnly=true)
	public List<PersonaUsuarioDto> findAllPersonUser();
	
}

