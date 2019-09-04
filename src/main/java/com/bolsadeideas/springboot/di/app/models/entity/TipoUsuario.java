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

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;



@Entity
@Table(name="tipousuarios")
public class TipoUsuario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String tipo_usuario;
	
	/*------------------*/
	/*	MAKING RELATION */
	/*------------------*/
	
	@OneToMany(mappedBy="tipousuario",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Usuario> listaUsuarios;
	
	public TipoUsuario() {
		
	listaUsuarios=new ArrayList<Usuario>();
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo_usuario() {
		return tipo_usuario;
	}

	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	/*Guarda una por una*/
//	public void addUsuario (Usuario listaUsuario) {
//		listaUsuarios.add(listaUsuario);
//	}
	

}
