package com.bolsadeideas.springboot.di.app.models.service;

import java.time.LocalDate;
import java.util.Date;

public interface IRegAsistService {
	
	public void InsertarAsistencia(Long idPersona,Long idRegAsistencia);
	
	public String GetDateRegister(LocalDate date,Long idPersona);

}
