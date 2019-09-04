package com.bolsadeideas.springboot.di.app.models.service;


import com.bolsadeideas.springboot.di.app.models.entity.Usuario;

public interface UsuarioService {

//	@Autowired
//	//private IUsuarioDao  usuariodao;
//	
//	@Autowired
//	public List<UsuarioPersonaDto> UsuarioPersonaJoin(){
//		return usuariodao.UsuarioPersonaJoin();
//	}
	
	public void save(Usuario usuario);
}
