package com.bolsadeideas.springboot.di.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.di.app.models.dao.IPersonaUsuarioDao;
import com.bolsadeideas.springboot.di.app.models.dao.IUserDao;
import com.bolsadeideas.springboot.di.app.models.dto.PersonaUsuarioDto;
import com.bolsadeideas.springboot.di.app.models.entity.Usuario;

@Component("Mi segundo servicio")
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private IUserDao usuarioDao;
	
	@Autowired
	private IPersonaUsuarioDao personaUsuarioDao;

	public List<Usuario> findAll() {

		return (List<Usuario>) usuarioDao.findAll();

	}

	public void save(Usuario usuario) {

		usuarioDao.save(usuario);

	}

	@Override
	public PersonaUsuarioDto getUser(Long id) {
		
		PersonaUsuarioDto perUser;
			
		perUser=personaUsuarioDao.findUserByStatus(id);
			
		return perUser;
		
	}
	
	@Override
	public void UpdatePersonaUsuario(String ApellidoPaterno,String ApellidoMaterno,String CuentaGithub,String dni,String lugarResidencia,String telefono,String usuario,Long idUsuario){
		
		personaUsuarioDao.updatePersonUser(ApellidoPaterno,ApellidoMaterno,CuentaGithub,dni,lugarResidencia,telefono,usuario,idUsuario);
		
	}
	
}
