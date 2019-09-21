package com.bolsadeideas.springboot.di.app.models.service;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bolsadeideas.springboot.di.app.models.dao.IRegistroAsistenciaDao;
import com.bolsadeideas.springboot.di.app.models.entity.Persona_TipoRegAsis;

@Component("Mi tercer servicio")
public class IRegAsistServiceImpl implements IRegAsistService{
	
	@Autowired
	public IRegistroAsistenciaDao regAsis;

	@Override
	public void InsertarAsistencia(Long idPersona,Long idRegAsistencia) {
		
		regAsis.InsertRegistroAsistencia(idPersona,idRegAsistencia);
		
	}

	@Override
	public String GetDateRegister(LocalDate date,Long idPersona) {
		
		Persona_TipoRegAsis persreg=new Persona_TipoRegAsis();
		String fecha="";
		
		try {
			
			persreg=regAsis.GetDate(date,idPersona);
			
			fecha=persreg.getCreatedOn().toString().substring(0,10);
			
		}catch(Exception e) {
			
			fecha="No registrado";
			
		}
		
		return fecha;
		
	}

}
