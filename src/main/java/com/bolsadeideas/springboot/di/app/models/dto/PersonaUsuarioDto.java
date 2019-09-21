package com.bolsadeideas.springboot.di.app.models.dto;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PersonaUsuarioDto {

	public String Usuario;
	
	public String ApellidoPaterno;
	
	public String ApellidoMaterno;
	
	public String dni;
	
	public String cuentaGithub;
	
	public String lugarResidencia;
	
	public String telefono;
	
	public String password;
	
	public PersonaUsuarioDto(){
		
	}
	public PersonaUsuarioDto(String Usuario,String ApellidoPaterno,String ApellidoMaterno,String dni,String cuentaGithub,String lugarResidencia,String telefono , String password){
		
		this.Usuario=Usuario;
		this.ApellidoPaterno=ApellidoPaterno;
		this.ApellidoMaterno=ApellidoMaterno;
		this.dni=dni;
		this.cuentaGithub=cuentaGithub;
		this.lugarResidencia=lugarResidencia;
		this.telefono=telefono;
		this.password=password;
		
	}

	public PersonaUsuarioDto(String Usuario,String ApellidoPaterno,String ApellidoMaterno,String dni,String cuentaGithub,String lugarResidencia,String telefono){
		
		this.Usuario=Usuario;
		this.ApellidoPaterno=ApellidoPaterno;
		this.ApellidoMaterno=ApellidoMaterno;
		this.dni=dni;
		this.cuentaGithub=cuentaGithub;
		this.lugarResidencia=lugarResidencia;
		this.telefono=telefono;
		
	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public String getApellidoPaterno() {
		return ApellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		ApellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return ApellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		ApellidoMaterno = apellidoMaterno;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCuentaGithub() {
		return cuentaGithub;
	}

	public void setCuentaGithub(String cuentaGithub) {
		this.cuentaGithub = cuentaGithub;
	}

	public String getLugarResidencia() {
		return lugarResidencia;
	}

	public void setLugarResidencia(String lugarResidencia) {
		this.lugarResidencia = lugarResidencia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPasswordEncrypted() {
		
		BCryptPasswordEncoder encryptePassword=new BCryptPasswordEncoder();
		
		return encryptePassword.encode(getPassword());
		
	}

}
