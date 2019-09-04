package com.bolsadeideas.springboot.di.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bolsadeideas.springboot.di.app.models.dao.IUsuarioDao;

import com.bolsadeideas.springboot.di.app.models.entity.Usuario;

public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private IUsuarioDao usuarioDao;

	public List<Usuario> findAll() {

		return (List<Usuario>) usuarioDao.findAll();

	}

	public void save(Usuario usuario) {

		usuarioDao.save(usuario);

	}
}
