package com.bolsadeideas.springboot.di.app.models.dao;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.di.app.models.entity.Persona;

public interface IPersonaDao extends JpaRepository<Persona, Long>{

	
}
