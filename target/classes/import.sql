insert into tipousuarios(tipo_usuario) values("USER")
insert into tipousuarios(tipo_usuario) values("ADMIN")

insert into usuarios(password,username,tipousuario_id) values('$2a$10$vql4oLGJAk6TH1Sq.LvIeOcbEBAoHYtJOVlBpZKpDDvEUvUrx2fq2','Jesus',1)
insert into personas(apellido_materno,apellido_paterno,cuenta_github,dni,lugar_residencia,telefono,usuarios_id) values('huarcaya','alvan','Yei-Linux','77889910','callao','999888777',1)

insert into tipos_registro_asistencias(tipo_asistencia,observaciones) values('Falto','El alumno no asistio la fecha indicada')
insert into tipos_registro_asistencias(tipo_asistencia,observaciones) values('Asistio','El alumno asistio la fecha indicada')

