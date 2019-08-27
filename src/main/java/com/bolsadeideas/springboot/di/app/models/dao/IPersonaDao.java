package com.bolsadeideas.springboot.di.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.di.app.models.entity.Persona;

public interface IPersonaDao extends CrudRepository<Persona, Long>{

}
