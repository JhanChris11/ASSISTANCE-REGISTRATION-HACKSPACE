package com.bolsadeideas.springboot.di.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bolsadeideas.springboot.di.app.models.entity.Persona_TipoRegAsis;

public interface IRegistroAsistenciaDao extends JpaRepository<Persona_TipoRegAsis,Long>{

	@Transactional
	@Modifying
	@Query(value="insert into rel_persona_tiporegasis(fecha,personas_id,tipos_registro_asistencias_id) values(sysdate(),(select id from personas where usuarios_id=?1),?2)",nativeQuery=true)
	void InsertRegistroAsistencia(Long idPersona,Long idRegAsistencia);
	
}
