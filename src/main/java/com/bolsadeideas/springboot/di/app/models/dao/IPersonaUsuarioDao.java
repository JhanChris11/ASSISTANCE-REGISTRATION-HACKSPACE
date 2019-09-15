package com.bolsadeideas.springboot.di.app.models.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bolsadeideas.springboot.di.app.models.dto.PersonaUsuarioDto;
import com.bolsadeideas.springboot.di.app.models.entity.Persona;

public interface IPersonaUsuarioDao extends JpaRepository<Persona,Long>{
	/* CONSULTAS PARA LUEGO LLAMARLO USUARIOSERVICE -1 */

	@Query("SELECT new com.bolsadeideas.springboot.di.app.models.dto.PersonaUsuarioDto(u.username,p.apellidoPaterno,p.apellidoMaterno,p.dni,p.cuentaGithub,p.lugarResidencia,p.telefono) FROM Persona p INNER JOIN p.usuarios u WHERE u.id= ?1")
	PersonaUsuarioDto findUserByStatus(Long status);
	
	@Transactional 
	@Modifying 
	@Query(value="UPDATE personas p INNER JOIN usuarios u ON p.usuarios_id=u.id SET p.apellido_paterno=?1,p.apellido_materno=?2,p.cuenta_github=?3,p.dni=?4,p.lugar_residencia=?5,p.telefono=?6,u.username=?7 WHERE p.usuarios_id=?8", nativeQuery = true)
	void updatePersonUser(String ApellidoPaterno,String ApellidoMaterno,String CuentaGithub,String dni,String lugarResidencia,String telefono,String usuario,Long idUsuario);
	
	/*-------------------------------------*/
	/*      CONSULTAS NATIVAS PARA         */
	/* INSERTAR EL REGISTRO DE UN PERSONA  */
	/*-------------------------------------*/
	
	@Transactional 
	@Modifying 
	@Query(value="INSERT into usuarios (password,username,tipousuario_id) values (?1,?2,?3)", nativeQuery = true) 
	void insertUserPerson(String password, String username, Long tipousuario_id);
	
	@Transactional 
	@Modifying 
	@Query(value="INSERT into personas (apellido_paterno,apellido_materno , cuenta_github,dni,lugar_residencia,telefono,usuarios_id) select ?1,?2,?3,?4,?5,?6,max(id) from usuarios", nativeQuery = true)
	void insertPersonUser(String ApellidoPaterno,String ApellidoMaterno,String CuentaGithub,String dni,String lugarResidencia,String telefono);
}
