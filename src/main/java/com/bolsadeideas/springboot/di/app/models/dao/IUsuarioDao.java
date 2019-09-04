package com.bolsadeideas.springboot.di.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bolsadeideas.springboot.di.app.models.entity.Persona;
import com.bolsadeideas.springboot.di.app.models.entity.Usuario;
import com.bolsadeideas.springboot.di.app.models.dto.UsuarioPersonaDto;

public interface IUsuarioDao extends JpaRepository<Usuario, Long>{

//	@Query("SELECT new ")
//	
//	@Query("SELECT new com.jeejava.dto.DeptEmpDto(d.name, e.name, e.email, e.address) "
//			+ "FROM Department d LEFT JOIN d.employees e")
//	List<DeptEmpDto> fetchEmpDeptDataLeftJoin();
//
//	@Query("SELECT new com.jeejava.dto.DeptEmpDto(d.name, e.name, e.email, e.address) "
//			+ "FROM Department d RIGHT JOIN d.employees e")
//	List<DeptEmpDto> fetchEmpDeptDataRightJoin();	
	
//	public Usuario findByUsername(String username);
	

//insert into clientes (id,nombre,apellido,email,create_at) values (1,'Chris','Calderon','jccmunac.97@gmail.com','2019-08-14');
//@Query("INSERT new com.bolsadeideas.springboot.di.app.models.dto.UsuarioPersonaDto into (u.username,u.password,p.apellido_paterno,p.apellido_materno,p.cuenta_github,p.dni,p.lugar_residencia,p.telefono)" + "FROM usuarios u INNER JOIN personas p ON u.id=p.usuarios_id")
//	List<UsuarioPersonaDto>UsuarioPersonaJoin();

	
	
}
