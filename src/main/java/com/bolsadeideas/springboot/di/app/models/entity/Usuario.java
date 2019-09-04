package com.bolsadeideas.springboot.di.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="USUARIO")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String user;
	
	@NotEmpty
	private String contra;
	
	/*---------------------------------*/
	/*	MAKING RELATION TIPO USUARIO   */
	/*---------------------------------*/
	//carga peresoza
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn
	private TipoUsuario tipousuario;

	/*--------------------------*/
	/*	MAKING RELATION PERSONA	*/
	/*--------------------------*/
	
	/*@OneToMany(mappedBy="usuario", fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Persona> listaPersonas;
	
	public Usuario() {
		
		listaPersonas=new ArrayList<Persona>();
	
	}*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre_Usuario() {
		return user;
	}

	public void setNombre_Usuario(String username) {
		this.user  = username;
	}

	public String getPassword() {
		return contra;
	}

	public void setPassword(String password) {
		this.contra = password;
	}
	
	/*public List<Persona> getListaPersonas() {
		return listaPersonas;
	}

	public void setListaPersonas(List<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}*/
	
}