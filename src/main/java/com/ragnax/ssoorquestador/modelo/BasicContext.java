//package com.ragnax.ssoorquestador.modelo;
//
//import java.io.Serializable;
//import java.sql.Timestamp;
//import java.util.List;
//
//import com.ragnax.ssoorquestador.servicio.clientes.modelo.Identificador;
//
//public class BasicContext implements Serializable{
//	
//	private static final long serialVersionUID = 5156174671203035887L;
//	
//	private int idEmpresa;
//	private String rolUnicoIdentificadorEmpresa; //rut - ruc - dni
//	private String nombreEmpresa; //nombre fantasia
//	private String nombreEmpresaLowerCase;
//	private String dominioEmpresa;
//	private String razonSocialEmpresa; //nombre legal empresa
//	private String razonSocialEmpresaLowerCase;
//	private String giroEmpresa; // accion que hace empresa
//	private String direccionOrigen;  // ubicacion legal empresa
//	private String codigoPais;
//	private int idRegion;
//	private int idComuna;
//	private String ciudadOrigen;
//
//	private String passwordEmpresaUsuarioContrasenhaFormat;
//	private boolean passwordEmpresaUsuarioContrasenhaSalto;
// 
//	private int idEmpresaUsuario;
//	private String rolContexto;
//	private String codigoUsuario;
//	
////	private String rutMember;
////	private String nombreIdentificador;
////	private String valueIdentificador;
////	private Integer paisIdentificador;
//	
//	private String nombreMember;//Nombre de la Persona
//	private String apellidoPaternoMember; //Apellido de la Persona
//	private String apellidoMaternoMember;
//	private List<Identificador> listaIdentificacion;
//	
//	private String telefonoContactoMember;
//	private String fechaNacimientoMember; //dd-mm-yyyy
//	private String generoMember; //Nombre del Genero
//	private String firmaMember;
//	private Timestamp creacionMember;
//	private String usernamePerfil; //Nombre del Usuario el del eventual login
//	private String nombrePerfilLowerCase; //Nombre del Perfil a ver en la pagina del perfil
//	private String mailPerfil; //mail usuario
//	private String passwordPregunta;
//	private Timestamp ultimaAccionUsuario;
//	private Timestamp ultimaConexionPerfil; //ultimo momento en el cual el usuario hizo log-In en el servicio
//	private Timestamp estadoPerfilLastBloqueado; 
//	private int anonimo;
//	
//	private String keyBasic;
//	
//	public BasicContext() {
//		super();
//	}
//
//	public int getIdEmpresa() {
//		return idEmpresa;
//	}
//
//	public void setIdEmpresa(int idEmpresa) {
//		this.idEmpresa = idEmpresa;
//	}
//
//	public String getRolUnicoIdentificadorEmpresa() {
//		return rolUnicoIdentificadorEmpresa;
//	}
//
//	public void setRolUnicoIdentificadorEmpresa(String rolUnicoIdentificadorEmpresa) {
//		this.rolUnicoIdentificadorEmpresa = rolUnicoIdentificadorEmpresa;
//	}
//
//	public String getNombreEmpresa() {
//		return nombreEmpresa;
//	}
//
//	public void setNombreEmpresa(String nombreEmpresa) {
//		this.nombreEmpresa = nombreEmpresa;
//	}
//
//	public String getNombreEmpresaLowerCase() {
//		return nombreEmpresaLowerCase;
//	}
//
//	public void setNombreEmpresaLowerCase(String nombreEmpresaLowerCase) {
//		this.nombreEmpresaLowerCase = nombreEmpresaLowerCase;
//	}
//
//	public String getDominioEmpresa() {
//		return dominioEmpresa;
//	}
//
//	public void setDominioEmpresa(String dominioEmpresa) {
//		this.dominioEmpresa = dominioEmpresa;
//	}
//
//	public String getRazonSocialEmpresa() {
//		return razonSocialEmpresa;
//	}
//
//	public void setRazonSocialEmpresa(String razonSocialEmpresa) {
//		this.razonSocialEmpresa = razonSocialEmpresa;
//	}
//
//	public String getRazonSocialEmpresaLowerCase() {
//		return razonSocialEmpresaLowerCase;
//	}
//
//	public void setRazonSocialEmpresaLowerCase(String razonSocialEmpresaLowerCase) {
//		this.razonSocialEmpresaLowerCase = razonSocialEmpresaLowerCase;
//	}
//
//	public String getGiroEmpresa() {
//		return giroEmpresa;
//	}
//
//	public void setGiroEmpresa(String giroEmpresa) {
//		this.giroEmpresa = giroEmpresa;
//	}
//
//	public String getDireccionOrigen() {
//		return direccionOrigen;
//	}
//
//	public void setDireccionOrigen(String direccionOrigen) {
//		this.direccionOrigen = direccionOrigen;
//	}
//
//	public String getCodigoPais() {
//		return codigoPais;
//	}
//
//	public void setCodigoPais(String codigoPais) {
//		this.codigoPais = codigoPais;
//	}
//
//	public int getIdRegion() {
//		return idRegion;
//	}
//
//	public void setIdRegion(int idRegion) {
//		this.idRegion = idRegion;
//	}
//
//	public int getIdComuna() {
//		return idComuna;
//	}
//
//	public void setIdComuna(int idComuna) {
//		this.idComuna = idComuna;
//	}
//
//	public String getCiudadOrigen() {
//		return ciudadOrigen;
//	}
//
//	public void setCiudadOrigen(String ciudadOrigen) {
//		this.ciudadOrigen = ciudadOrigen;
//	}
//
//	public String getPasswordEmpresaUsuarioContrasenhaFormat() {
//		return passwordEmpresaUsuarioContrasenhaFormat;
//	}
//
//	public void setPasswordEmpresaUsuarioContrasenhaFormat(String passwordEmpresaUsuarioContrasenhaFormat) {
//		this.passwordEmpresaUsuarioContrasenhaFormat = passwordEmpresaUsuarioContrasenhaFormat;
//	}
//
//	public boolean isPasswordEmpresaUsuarioContrasenhaSalto() {
//		return passwordEmpresaUsuarioContrasenhaSalto;
//	}
//
//	public void setPasswordEmpresaUsuarioContrasenhaSalto(boolean passwordEmpresaUsuarioContrasenhaSalto) {
//		this.passwordEmpresaUsuarioContrasenhaSalto = passwordEmpresaUsuarioContrasenhaSalto;
//	}
//
//	public int getIdEmpresaUsuario() {
//		return idEmpresaUsuario;
//	}
//
//	public void setIdEmpresaUsuario(int idEmpresaUsuario) {
//		this.idEmpresaUsuario = idEmpresaUsuario;
//	}
//
//	public String getRolContexto() {
//		return rolContexto;
//	}
//
//	public void setRolContexto(String rolContexto) {
//		this.rolContexto = rolContexto;
//	}
//
//	public String getCodigoUsuario() {
//		return codigoUsuario;
//	}
//
//	public void setCodigoUsuario(String codigoUsuario) {
//		this.codigoUsuario = codigoUsuario;
//	}
//
//	public String getNombreMember() {
//		return nombreMember;
//	}
//
//	public void setNombreMember(String nombreMember) {
//		this.nombreMember = nombreMember;
//	}
//
//	public String getApellidoPaternoMember() {
//		return apellidoPaternoMember;
//	}
//
//	public void setApellidoPaternoMember(String apellidoPaternoMember) {
//		this.apellidoPaternoMember = apellidoPaternoMember;
//	}
//
//	public String getApellidoMaternoMember() {
//		return apellidoMaternoMember;
//	}
//
//	public void setApellidoMaternoMember(String apellidoMaternoMember) {
//		this.apellidoMaternoMember = apellidoMaternoMember;
//	}
//
//	public List<Identificador> getListaIdentificacion() {
//		return listaIdentificacion;
//	}
//
//	public void setListaIdentificacion(List<Identificador> listaIdentificacion) {
//		this.listaIdentificacion = listaIdentificacion;
//	}
//
//	public String getTelefonoContactoMember() {
//		return telefonoContactoMember;
//	}
//
//	public void setTelefonoContactoMember(String telefonoContactoMember) {
//		this.telefonoContactoMember = telefonoContactoMember;
//	}
//
//	public String getFechaNacimientoMember() {
//		return fechaNacimientoMember;
//	}
//
//	public void setFechaNacimientoMember(String fechaNacimientoMember) {
//		this.fechaNacimientoMember = fechaNacimientoMember;
//	}
//
//	public String getGeneroMember() {
//		return generoMember;
//	}
//
//	public void setGeneroMember(String generoMember) {
//		this.generoMember = generoMember;
//	}
//
//	public String getFirmaMember() {
//		return firmaMember;
//	}
//
//	public void setFirmaMember(String firmaMember) {
//		this.firmaMember = firmaMember;
//	}
//
//	public Timestamp getCreacionMember() {
//		return creacionMember;
//	}
//
//	public void setCreacionMember(Timestamp creacionMember) {
//		this.creacionMember = creacionMember;
//	}
//
//	public String getUsernamePerfil() {
//		return usernamePerfil;
//	}
//
//	public void setUsernamePerfil(String usernamePerfil) {
//		this.usernamePerfil = usernamePerfil;
//	}
//
//	public String getNombrePerfilLowerCase() {
//		return nombrePerfilLowerCase;
//	}
//
//	public void setNombrePerfilLowerCase(String nombrePerfilLowerCase) {
//		this.nombrePerfilLowerCase = nombrePerfilLowerCase;
//	}
//
//	public String getMailPerfil() {
//		return mailPerfil;
//	}
//
//	public void setMailPerfil(String mailPerfil) {
//		this.mailPerfil = mailPerfil;
//	}
//
//	public String getPasswordPregunta() {
//		return passwordPregunta;
//	}
//
//	public void setPasswordPregunta(String passwordPregunta) {
//		this.passwordPregunta = passwordPregunta;
//	}
//
//	public Timestamp getUltimaAccionUsuario() {
//		return ultimaAccionUsuario;
//	}
//
//	public void setUltimaAccionUsuario(Timestamp ultimaAccionUsuario) {
//		this.ultimaAccionUsuario = ultimaAccionUsuario;
//	}
//
//	public Timestamp getUltimaConexionPerfil() {
//		return ultimaConexionPerfil;
//	}
//
//	public void setUltimaConexionPerfil(Timestamp ultimaConexionPerfil) {
//		this.ultimaConexionPerfil = ultimaConexionPerfil;
//	}
//
//	public Timestamp getEstadoPerfilLastBloqueado() {
//		return estadoPerfilLastBloqueado;
//	}
//
//	public void setEstadoPerfilLastBloqueado(Timestamp estadoPerfilLastBloqueado) {
//		this.estadoPerfilLastBloqueado = estadoPerfilLastBloqueado;
//	}
//
//	public int getAnonimo() {
//		return anonimo;
//	}
//
//	public void setAnonimo(int anonimo) {
//		this.anonimo = anonimo;
//	}
//
//	public String getKeyBasic() {
//		return keyBasic;
//	}
//
//	public void setKeyBasic(String keyBasic) {
//		this.keyBasic = keyBasic;
//	}
//
//	
//}
