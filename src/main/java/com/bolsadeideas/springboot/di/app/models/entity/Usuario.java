package com.bolsadeideas.springboot.di.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUsuario;
	
	@NotEmpty
	private String nombre_Usuario;
	
	@NotEmpty
	private String password;
	
	/*------------------*/
	/*	MAKING RELATION */
	/*------------------*/
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn
	private TipoUsuario tipousuario;

	public Long getId() {
		return idUsuario;
	}

	public void setId(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre_Usuario() {
		return nombre_Usuario;
	}

	public void setNombre_Usuario(String nombre_Usuario) {
		this.nombre_Usuario = nombre_Usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
