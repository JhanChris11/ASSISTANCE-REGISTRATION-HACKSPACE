package com.bolsadeideas.springboot.di.app.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "personas")
public class Persona implements Serializable {

	// Crear el atributo por defecto
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String apellidoPaterno;

	@NotEmpty
	private String apellidoMaterno;

	@NotEmpty
	private String dni;

	@NotEmpty
	private String cuentaGithub;

	@NotEmpty
	private String lugarResidencia;

	@NotEmpty
	private String telefono;
	
	/*------------------*/
	/*	MAKING RELATION */
	/*------------------*/
	
	@OneToMany(mappedBy="persona",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Persona_TipoRegAsis> persona_TipoRegAsis;

	/*------------------*/
	/* MAKING RELATION */
	/*------------------*/

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuarios_id")
	private Usuario usuarios;
	
	public Persona() {
		
		
	}
	
	public Persona(Long id) {
		
		this.id=id;
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCuentaGithub() {
		return cuentaGithub;
	}

	public void setCuentaGithub(String cuentaGithub) {
		this.cuentaGithub = cuentaGithub;
	}

	public String getLugarResidencia() {
		return lugarResidencia;
	}

	public void setLugarResidencia(String lugarResidencia) {
		this.lugarResidencia = lugarResidencia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}