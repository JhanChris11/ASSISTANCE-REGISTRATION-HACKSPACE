package com.bolsadeideas.springboot.di.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name="usuarios")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;
	
	/*------------------*/
	/*	MAKING RELATION */
	/*------------------*/
	//carga peresoza
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn
	private TipoUsuario tipousuario;

	/*------------------*/
	/*	MAKING RELATION */
	/*------------------*/
	
	public Long getTipousuario() {
		return tipousuario.getId();
	}

	public void setTipousuario(TipoUsuario tipousuario) {
		this.tipousuario = tipousuario;
	}

	@OneToMany(mappedBy="usuarios",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Persona> listaPersonas;
	
	public Usuario() {
		
		listaPersonas=new ArrayList<Persona>();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre_Usuario() {
		return username;
	}

	public void setNombre_Usuario(String username) {
		this.username  = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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