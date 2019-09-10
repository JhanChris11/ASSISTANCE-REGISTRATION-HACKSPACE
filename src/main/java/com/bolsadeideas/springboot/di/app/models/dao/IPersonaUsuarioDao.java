package com.bolsadeideas.springboot.di.app.models.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bolsadeideas.springboot.di.app.models.dto.PersonaUsuarioDto;
import com.bolsadeideas.springboot.di.app.models.entity.Persona;

public interface IPersonaUsuarioDao extends JpaRepository<Persona,Long>{

	@Query("SELECT new com.bolsadeideas.springboot.di.app.models.dto.PersonaUsuarioDto(u.username,p.apellidoPaterno,p.apellidoMaterno,p.dni,p.cuentaGithub,p.lugarResidencia,p.telefono) FROM Persona p INNER JOIN p.usuarios u WHERE u.id= ?1")
	PersonaUsuarioDto findUserByStatus(Long status);
	
	@Transactional 
	@Modifying 
	@Query(value="UPDATE personas p INNER JOIN usuarios u ON p.usuarios_id=u.id SET p.apellido_paterno=?1,p.apellido_materno=?2,p.cuenta_github=?3,p.dni=?4,p.lugar_residencia=?5,p.telefono=?6,u.username=?7 WHERE p.usuarios_id=?8", nativeQuery = true)
	void updatePersonUser(String ApellidoPaterno,String ApellidoMaterno,String CuentaGithub,String dni,String lugarResidencia,String telefono,String usuario,Long idUsuario);
	
}
