package com.bolsadeideas.springboot.di.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.di.app.models.entity.Usuario;

/*----------------------*/
/*	 DAO QUE GESTIONA	*/ 
/* LAS LLAMADAS A LA BD */ 
/* 		 DEL USER		*/
/*----------------------*/

public interface IUserDao extends JpaRepository<Usuario, Long>{

	Usuario findByUsername(String username);
	
}
