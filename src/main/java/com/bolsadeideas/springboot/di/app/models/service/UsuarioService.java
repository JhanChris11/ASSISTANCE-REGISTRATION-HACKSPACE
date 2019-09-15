package com.bolsadeideas.springboot.di.app.models.service;

import java.util.List;

import com.bolsadeideas.springboot.di.app.models.dto.PersonaUsuarioDto;
import com.bolsadeideas.springboot.di.app.models.entity.Usuario;

public interface UsuarioService {

	public List<Usuario> findAll();

	public void save(Usuario usuario);

	public PersonaUsuarioDto getUser(Long id);
	/* METODOS CON LOS PARAMETROS DE LAS CONSULTAS NATIVAS -2 */

	public void UpdatePersonaUsuario(String ApellidoPaterno, String ApellidoMaterno, String CuentaGithub, String dni,
			String lugarResidencia, String telefono, String usuario, Long idUsuario);

	public void InsertUserPerson(String password, String username, Long tipousuario_id);

	public void InsertPersonUser(String ApellidoPaterno, String ApellidoMaterno, String CuentaGithub, String dni,
			String lugarResidencia, String telefono);

}
