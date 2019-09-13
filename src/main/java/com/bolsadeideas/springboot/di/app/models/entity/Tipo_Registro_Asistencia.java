package com.bolsadeideas.springboot.di.app.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="tipos_registro_asistencias")
public class Tipo_Registro_Asistencia implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	
	@NotEmpty
	public String TipoAsistencia;

	@NotEmpty
	public String Observaciones;
	
	/*------------------*/
	/*	MAKING RELATION */
	/*------------------*/
	
	@OneToMany(mappedBy="tipoRegAsistencia",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Persona_TipoRegAsis> persona_TipoRegAsis;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoAsistencia(){
		return TipoAsistencia;
	}

	public void setTipoAsistencia(String tipoAsistencia) {
		TipoAsistencia = tipoAsistencia;
	}

	public String getObservaciones() {
		return Observaciones;
	}

	public void setObservaciones(String observaciones) {
		Observaciones = observaciones;
	}

}
