package com.bolsadeideas.springboot.di.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
<<<<<<< HEAD
import javax.persistence.Column;
=======
>>>>>>> 0fc2e35791462e3300b8eaf69d2117eebbe35def
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
<<<<<<< HEAD
@Table(name="USUARIO")
=======
@Table(name="usuarios")
>>>>>>> 0fc2e35791462e3300b8eaf69d2117eebbe35def
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
<<<<<<< HEAD
	
	@NotEmpty
	private String user;
	
	@NotEmpty
	private String contra;
	
	/*---------------------------------*/
	/*	MAKING RELATION TIPO USUARIO   */
	/*---------------------------------*/
=======
	
	
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;
	
	/*------------------*/
	/*	MAKING RELATION */
	/*------------------*/
>>>>>>> 0fc2e35791462e3300b8eaf69d2117eebbe35def
	//carga peresoza
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn
	private TipoUsuario tipousuario;

<<<<<<< HEAD
	/*--------------------------*/
	/*	MAKING RELATION PERSONA	*/
	/*--------------------------*/
	
	/*@OneToMany(mappedBy="usuario", fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Persona> listaPersonas;
	
	public Usuario() {
		
		listaPersonas=new ArrayList<Persona>();
	
	}*/
=======
	/*------------------*/
	/*	MAKING RELATION */
	/*------------------*/
	
	
	//@OneToMany(mappedBy="usuarios",orphanRemoval=false, fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@OneToMany(mappedBy="usuarios",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Persona> listaPersonas;
	
	public Usuario() {
	listaPersonas=new ArrayList<Persona>();
	}
>>>>>>> 0fc2e35791462e3300b8eaf69d2117eebbe35def

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre_Usuario() {
<<<<<<< HEAD
		return user;
	}

	public void setNombre_Usuario(String username) {
		this.user  = username;
=======
		return username;
	}

	public void setNombre_Usuario(String username) {
		this.username  = username;
>>>>>>> 0fc2e35791462e3300b8eaf69d2117eebbe35def
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

<<<<<<< HEAD
	public void setListaPersonas(List<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}*/
	
}
=======
	public List<Persona> getListaPersonas() {
		return listaPersonas;
	}

	public void setListaPersonas(List<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}

	public void addPersona(Persona listaPersona) {
		listaPersonas.add(listaPersona);
	}

}
>>>>>>> 0fc2e35791462e3300b8eaf69d2117eebbe35def
