package com.bolsadeideas.springboot.di.app.models.entity;

import java.io.Serializable;
import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Embeddable
@Table(name="rel_persona_tiporegasis")
public class Persona_TipoRegAsis implements Serializable{
	
	// Crear el atributo por defecto
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Fecha")
	@CreationTimestamp
    private LocalDateTime createdOn;
	
	/*------------------*/
	/* MAKING RELATION */
	/*------------------*/

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="personas_id")
	private Persona persona;
	
	/*------------------*/
	/* MAKING RELATION */
	/*------------------*/

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tipos_registro_asistencias_id")
	private Tipo_Registro_Asistencia tipoRegAsistencia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@PrePersist
    public void prePersist() {
        createdOn = LocalDateTime.now();
    }
 
}
