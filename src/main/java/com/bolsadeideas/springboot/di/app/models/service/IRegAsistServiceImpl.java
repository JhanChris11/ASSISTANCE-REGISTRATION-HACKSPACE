package com.bolsadeideas.springboot.di.app.models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bolsadeideas.springboot.di.app.models.dao.IRegistroAsistenciaDao;

@Component("Mi tercer servicio")
public class IRegAsistServiceImpl implements IRegAsistService{
	
	@Autowired
	public IRegistroAsistenciaDao regAsis;

	@Override
	public void InsertarAsistencia(Long idPersona,Long idRegAsistencia) {
		
		regAsis.InsertRegistroAsistencia(idPersona, idRegAsistencia);
		
	}

}
