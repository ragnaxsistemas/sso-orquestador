package com.ragnax.ssoorquestador.servicio.clientes.modelo;

import java.sql.Timestamp;

public class Perfil{
 

	private Integer idPerfil;

	private String usernamePerfil; //Nombre del Usuario el del eventual login

	private String nombrePerfilLowerCase; //Nombre del Perfil a ver en la pagina del perfil
	
	private String passwordContrasenhaNormal;
	
	private String passwordContrasenha;
	
	private String emailPerfil; //mail usuario
	
	private String passwordPregunta;
	
	private String passwordRespuesta;
	
	private Boolean estadoUsuarioPerfil;
	
	private Timestamp ultimaAccionUsuario;
	
	private Timestamp ultimaConexionPerfil; //ultimo momento en el cual el usuario hizo log-In en el servicio

	private Timestamp passwordUltimaActualizacion;
	
	private Timestamp estadoPerfilLastBloqueado; 
	
	private Integer anonimo;
	
	//Un Perfil "member" puede tener muchos usuarios.(compartir sessiones - gerentes) 
	//pero un usuario jcornej solo puede estar en un Perfil 
	//@OneToMany(fetch = FetchType.EAGER, mappedBy="idPerfil")
//	private List<Usuario> usuarios_perfiles;
	
//	private List<AccionPerfil> acciones_perfiles_perfiles;
	
//	private List<FotoPerfil> fotos_perfiles;
	
	public Perfil() {
		super();
	}

	public Perfil(String usernamePerfil, String nombrePerfilLowerCase, String passwordContrasenhaNormal,
			String passwordContrasenha, String emailPerfil, String passwordPregunta, String passwordRespuesta,
			Integer anonimo) {
		super();
		this.usernamePerfil = usernamePerfil;
		this.nombrePerfilLowerCase = nombrePerfilLowerCase;
		this.passwordContrasenhaNormal = passwordContrasenhaNormal;
		this.passwordContrasenha = passwordContrasenha;
		this.emailPerfil = emailPerfil;
		this.passwordPregunta = passwordPregunta;
		this.passwordRespuesta = passwordRespuesta;
		this.anonimo = anonimo;
	}
	
	public Perfil(String usernamePerfil, String passwordContrasenhaNormal) {
		super();
		this.usernamePerfil = usernamePerfil;
		this.passwordContrasenhaNormal = passwordContrasenhaNormal;
	}

	public Integer getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getUsernamePerfil() {
		return usernamePerfil;
	}

	public void setUsernamePerfil(String usernamePerfil) {
		this.usernamePerfil = usernamePerfil;
	}

	public String getNombrePerfilLowerCase() {
		return nombrePerfilLowerCase;
	}

	public void setNombrePerfilLowerCase(String nombrePerfilLowerCase) {
		this.nombrePerfilLowerCase = nombrePerfilLowerCase;
	}

	public String getPasswordContrasenhaNormal() {
		return passwordContrasenhaNormal;
	}

	public void setPasswordContrasenhaNormal(String passwordContrasenhaNormal) {
		this.passwordContrasenhaNormal = passwordContrasenhaNormal;
	}

	public String getPasswordContrasenha() {
		return passwordContrasenha;
	}

	public void setPasswordContrasenha(String passwordContrasenha) {
		this.passwordContrasenha = passwordContrasenha;
	}

	public String getEmailPerfil() {
		return emailPerfil;
	}

	public void setEmailPerfil(String emailPerfil) {
		this.emailPerfil = emailPerfil;
	}

	public String getPasswordPregunta() {
		return passwordPregunta;
	}

	public void setPasswordPregunta(String passwordPregunta) {
		this.passwordPregunta = passwordPregunta;
	}

	public String getPasswordRespuesta() {
		return passwordRespuesta;
	}

	public void setPasswordRespuesta(String passwordRespuesta) {
		this.passwordRespuesta = passwordRespuesta;
	}

	public Boolean getEstadoUsuarioPerfil() {
		return estadoUsuarioPerfil;
	}

	public void setEstadoUsuarioPerfil(Boolean estadoUsuarioPerfil) {
		this.estadoUsuarioPerfil = estadoUsuarioPerfil;
	}

	public Timestamp getUltimaAccionUsuario() {
		return ultimaAccionUsuario;
	}

	public void setUltimaAccionUsuario(Timestamp ultimaAccionUsuario) {
		this.ultimaAccionUsuario = ultimaAccionUsuario;
	}

	public Timestamp getUltimaConexionPerfil() {
		return ultimaConexionPerfil;
	}

	public void setUltimaConexionPerfil(Timestamp ultimaConexionPerfil) {
		this.ultimaConexionPerfil = ultimaConexionPerfil;
	}

	public Timestamp getPasswordUltimaActualizacion() {
		return passwordUltimaActualizacion;
	}

	public void setPasswordUltimaActualizacion(Timestamp passwordUltimaActualizacion) {
		this.passwordUltimaActualizacion = passwordUltimaActualizacion;
	}

	public Timestamp getEstadoPerfilLastBloqueado() {
		return estadoPerfilLastBloqueado;
	}

	public void setEstadoPerfilLastBloqueado(Timestamp estadoPerfilLastBloqueado) {
		this.estadoPerfilLastBloqueado = estadoPerfilLastBloqueado;
	}

	public Integer getAnonimo() {
		return anonimo;
	}

	public void setAnonimo(Integer anonimo) {
		this.anonimo = anonimo;
	}
}
