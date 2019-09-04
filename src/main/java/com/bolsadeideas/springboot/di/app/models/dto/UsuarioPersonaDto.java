package com.bolsadeideas.springboot.di.app.models.dto;

public class UsuarioPersonaDto {

	private String nameUsuario;
	private String passwordUsuario;
	private String apUsuario;
	private String amUsuario;
	private String cuentaUsuario;
	private String dniUsuario;
	private String lugarUsuario;
	private String telefonoUsuario;
	
	public UsuarioPersonaDto(String nameUsuario, String passwordUsuario, String apUsuario, String amUsuario,
			String cuentaUsuario, String dniUsuario, String lugarUsuario, String telefonoUsuario) {
		this.nameUsuario = nameUsuario;
		this.passwordUsuario = passwordUsuario;
		this.apUsuario = apUsuario;
		this.amUsuario = amUsuario;
		this.cuentaUsuario = cuentaUsuario;
		this.dniUsuario = dniUsuario;
		this.lugarUsuario = lugarUsuario;
		this.telefonoUsuario = telefonoUsuario;
	}

	public String getNameUsuario() {
		return nameUsuario;
	}

	public void setNameUsuario(String nameUsuario) {
		this.nameUsuario = nameUsuario;
	}

	public String getPasswordUsuario() {
		return passwordUsuario;
	}

	public void setPasswordUsuario(String passwordUsuario) {
		this.passwordUsuario = passwordUsuario;
	}

	public String getApUsuario() {
		return apUsuario;
	}

	public void setApUsuario(String apUsuario) {
		this.apUsuario = apUsuario;
	}

	public String getAmUsuario() {
		return amUsuario;
	}

	public void setAmUsuario(String amUsuario) {
		this.amUsuario = amUsuario;
	}

	public String getCuentaUsuario() {
		return cuentaUsuario;
	}

	public void setCuentaUsuario(String cuentaUsuario) {
		this.cuentaUsuario = cuentaUsuario;
	}

	public String getDniUsuario() {
		return dniUsuario;
	}

	public void setDniUsuario(String dniUsuario) {
		this.dniUsuario = dniUsuario;
	}

	public String getLugarUsuario() {
		return lugarUsuario;
	}

	public void setLugarUsuario(String lugarUsuario) {
		this.lugarUsuario = lugarUsuario;
	}

	public String getTelefonoUsuario() {
		return telefonoUsuario;
	}

	public void setTelefonoUsuario(String telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
	}
	@Override
	
	public String toString() {
		return "UsuarioPersonaDto [Nombre =" + nameUsuario + ",Contraseña =" + passwordUsuario + ", Apellido Paterno =" + apUsuario + ", Apellido Materno ="
				+ amUsuario + ", Cuenta ="+cuentaUsuario+ ", Dni =" + dniUsuario+", Lugar Usuario ="+lugarUsuario+ ", TelefonoUsuario ="+telefonoUsuario +"]";
	}
	
}
