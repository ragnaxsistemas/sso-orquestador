//package com.ragnax.ssoorquestador.modelo;
//
//import java.io.Serializable;
//import java.sql.Timestamp;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class UsuarioSeguridad implements Serializable{
//	
//	private static final long serialVersionUID = -3909501105485905555L;
//	
//	private int idUsuario;
//	private String remoteAddr;
//	private String remoteHost;
//	private String passwordContrasenha;
//	private String passwordPregunta;
//	private String passwordRespuesta;
//	
//	private int idEmpresa;
//	private String nombreRol;
//	private String tipoIdentificador;
//	private String rutMember;
//	private Map<String, String> mapaIdentificador = new HashMap<String, String>();
//	private String nombreMember;//Nombre de la Persona
//	private String apellidoPaterno; //Apellido de la Persona
//	private String apellidoMaterno; //Apellido de la Persona
//	private String mailUsuario; //mail usuario
//	private String telefonoContactoMember;
//	private String fechaNacimientoMember;
//	private String generoMember;
//	private String firmaMember;
//	private Timestamp creacionMember;
//	private String usernamePerfil; //Nombre del Usuario el del eventual login
//	private String nombrePerfilLowerCase; //Nombre del Perfil a ver en la pagina del perfil
//	private String concatAplicacion;
//	
//	private Timestamp ultimaAccionUsuario;
//	private String tipoAccionUsuario;
//	private Timestamp ultimaConexionPerfil; //ultimo momento en el cual el usuario hizo log-In en el servicio
//	private Timestamp estadoPerfilLastBloqueado; 
//	private int anonimo;
//	
//	private String sEnterpriseUser; //idEmpresausuario
//	private String sEnterpriseUserAsociation; //idEmpresausuario
////	private String sEnterpriseUserAplication; //idEmpresaUsuarioAplicacionEmpresa
//	private List<String> listaEnterpriseUserAsociation;
//	private String keyAutentificacion;
//	
//	
//	public UsuarioSeguridad(String usernamePerfil) {
//		super();
//		this.usernamePerfil = usernamePerfil;
//	}
//	
//	public UsuarioSeguridad() {
//		super();
//	}
//
//	public int getIdUsuario() {
//		return idUsuario;
//	}
//
//	public String getRemoteAddr() {
//		return remoteAddr;
//	}
//
//	public String getRemoteHost() {
//		return remoteHost;
//	}
//
//	public String getPasswordContrasenha() {
//		return passwordContrasenha;
//	}
//
//	public String getPasswordPregunta() {
//		return passwordPregunta;
//	}
//
//	public String getPasswordRespuesta() {
//		return passwordRespuesta;
//	}
//
//	public int getIdEmpresa() {
//		return idEmpresa;
//	}
//
//	public String getNombreRol() {
//		return nombreRol;
//	}
//
//	public String getRutMember() {
//		return rutMember;
//	}
//
//	public String getNombreMember() {
//		return nombreMember;
//	}
//
//	public String getApellidoPaterno() {
//		return apellidoPaterno;
//	}
//
//	public String getApellidoMaterno() {
//		return apellidoMaterno;
//	}
//
//	public String getMailUsuario() {
//		return mailUsuario;
//	}
//
//	public String getTelefonoContactoMember() {
//		return telefonoContactoMember;
//	}
//
//	public String getFechaNacimientoMember() {
//		return fechaNacimientoMember;
//	}
//
//	public String getGeneroMember() {
//		return generoMember;
//	}
//
//	public String getFirmaMember() {
//		return firmaMember;
//	}
//
//	public Timestamp getCreacionMember() {
//		return creacionMember;
//	}
//
//	public String getUsernamePerfil() {
//		return usernamePerfil;
//	}
//
//	public String getNombrePerfilLowerCase() {
//		return nombrePerfilLowerCase;
//	}
//
//	public String getConcatAplicacion() {
//		return concatAplicacion;
//	}
//
//	public Timestamp getUltimaAccionUsuario() {
//		return ultimaAccionUsuario;
//	}
//
//	public String getTipoAccionUsuario() {
//		return tipoAccionUsuario;
//	}
//
//	public Timestamp getUltimaConexionPerfil() {
//		return ultimaConexionPerfil;
//	}
//
//	public Timestamp getEstadoPerfilLastBloqueado() {
//		return estadoPerfilLastBloqueado;
//	}
//
//	public int getAnonimo() {
//		return anonimo;
//	}
//
//	public String getsEnterpriseUser() {
//		return sEnterpriseUser;
//	}
//
//	public String getsEnterpriseUserAsociation() {
//		return sEnterpriseUserAsociation;
//	}
//
//	public List<String> getListaEnterpriseUserAsociation() {
//		return listaEnterpriseUserAsociation;
//	}
//
//	public String getKeyAutentificacion() {
//		return keyAutentificacion;
//	}
//
//	public void setIdUsuario(int idUsuario) {
//		this.idUsuario = idUsuario;
//	}
//
//	public void setRemoteAddr(String remoteAddr) {
//		this.remoteAddr = remoteAddr;
//	}
//
//	public void setRemoteHost(String remoteHost) {
//		this.remoteHost = remoteHost;
//	}
//
//	public void setPasswordContrasenha(String passwordContrasenha) {
//		this.passwordContrasenha = passwordContrasenha;
//	}
//
//	public void setPasswordPregunta(String passwordPregunta) {
//		this.passwordPregunta = passwordPregunta;
//	}
//
//	public void setPasswordRespuesta(String passwordRespuesta) {
//		this.passwordRespuesta = passwordRespuesta;
//	}
//
//	public void setIdEmpresa(int idEmpresa) {
//		this.idEmpresa = idEmpresa;
//	}
//
//	public void setNombreRol(String nombreRol) {
//		this.nombreRol = nombreRol;
//	}
//
////	public void setRutMember(String rutMember) {
////		this.rutMember = rutMember;
////	}
//
//	public void setNombreMember(String nombreMember) {
//		this.nombreMember = nombreMember;
//	}
//
//	public void setApellidoPaterno(String apellidoPaterno) {
//		this.apellidoPaterno = apellidoPaterno;
//	}
//
//	public void setApellidoMaterno(String apellidoMaterno) {
//		this.apellidoMaterno = apellidoMaterno;
//	}
//
//	public void setMailUsuario(String mailUsuario) {
//		this.mailUsuario = mailUsuario;
//	}
//
//	public void setTelefonoContactoMember(String telefonoContactoMember) {
//		this.telefonoContactoMember = telefonoContactoMember;
//	}
//
//	public void setFechaNacimientoMember(String fechaNacimientoMember) {
//		this.fechaNacimientoMember = fechaNacimientoMember;
//	}
//
//	public void setGeneroMember(String generoMember) {
//		this.generoMember = generoMember;
//	}
//
//	public void setFirmaMember(String firmaMember) {
//		this.firmaMember = firmaMember;
//	}
//
//	public void setCreacionMember(Timestamp creacionMember) {
//		this.creacionMember = creacionMember;
//	}
//
//	public void setUsernamePerfil(String usernamePerfil) {
//		this.usernamePerfil = usernamePerfil;
//	}
//
//	public void setNombrePerfilLowerCase(String nombrePerfilLowerCase) {
//		this.nombrePerfilLowerCase = nombrePerfilLowerCase;
//	}
//
//	public void setConcatAplicacion(String concatAplicacion) {
//		this.concatAplicacion = concatAplicacion;
//	}
//
//	public void setUltimaAccionUsuario(Timestamp ultimaAccionUsuario) {
//		this.ultimaAccionUsuario = ultimaAccionUsuario;
//	}
//
//	public void setTipoAccionUsuario(String tipoAccionUsuario) {
//		this.tipoAccionUsuario = tipoAccionUsuario;
//	}
//
//	public void setUltimaConexionPerfil(Timestamp ultimaConexionPerfil) {
//		this.ultimaConexionPerfil = ultimaConexionPerfil;
//	}
//
//	public void setEstadoPerfilLastBloqueado(Timestamp estadoPerfilLastBloqueado) {
//		this.estadoPerfilLastBloqueado = estadoPerfilLastBloqueado;
//	}
//
//	public void setAnonimo(int anonimo) {
//		this.anonimo = anonimo;
//	}
//
//	public void setsEnterpriseUser(String sEnterpriseUser) {
//		this.sEnterpriseUser = sEnterpriseUser;
//	}
//
//	public void setsEnterpriseUserAsociation(String sEnterpriseUserAsociation) {
//		this.sEnterpriseUserAsociation = sEnterpriseUserAsociation;
//	}
//
//	public void setListaEnterpriseUserAsociation(List<String> listaEnterpriseUserAsociation) {
//		this.listaEnterpriseUserAsociation = listaEnterpriseUserAsociation;
//	}
//
//	public void setKeyAutentificacion(String keyAutentificacion) {
//		this.keyAutentificacion = keyAutentificacion;
//	}
//
//	public String getTipoIdentificador() {
//		return tipoIdentificador;
//	}
//
//	public void setTipoIdentificador(String tipoIdentificador) {
//		this.tipoIdentificador = tipoIdentificador;
//	}
//
//	public void setRutMember(String rutMember) {
//		this.rutMember = rutMember;
//	}
//
//	public Map<String, String> getMapaIdentificador() {
//		return mapaIdentificador;
//	}
//
//	public void setMapaIdentificador(Map<String, String> mapaIdentificador) {
//		this.mapaIdentificador = mapaIdentificador;
//	}
//
//}
