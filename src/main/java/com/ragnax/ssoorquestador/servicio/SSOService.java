package com.ragnax.ssoorquestador.servicio;

import java.util.Date;
import java.util.List;

import com.ragnax.domain.sso.entidad.*;
import com.ragnax.domain.ssoorquestador.modelo.*;
import com.ragnax.ssoorquestador.exception.SSOOrquestadorException;


public interface SSOService {
	
//	public BasicContext mapToBasicContext(Empresa empresaModel, Rol rol, EmpresaUsuario empresaUsuarioModel, 
//			GrupoUsuarioModel grupoUsuarioModel);
//	
//	public EnterpriseContext mapToEnterpriseContext(BasicContext basicContext,
//			AplicacionEmpresa aplicacionEmpresaModel, AplicacionRol aplicacionRolModel, EmpresaUsuarioAplicacionEmpresa euaeModel);
//	
//	public AutentificacionContext mapToAuthenticacionContext(EnterpriseContext enterpriseContext, 
//			List<AplicacionServicio> listaAplicacionServicioModel);
//	
//	public SeguridadContext mapToSeguridadContext(AutentificacionContext autentificacionContext, 
//			List<SeguridadAplicacionAcceso> listaSeguridadAplicacionAccesoModel);
//	
//	public List<UsuarioSeguridad> listUsuarioToListUsuario(List<GrupoUsuarioModel> listaGrupoUsuarioModel, 
//			AutentificacionContext autentificacionContext, Rol rolModel);
//	
//	public UsuarioSeguridad mapToUsuarioSeguridad(GrupoUsuarioModel grupoUsuarioModel, AutentificacionContext autentificacionContext, Rol rolModel);
	/*******************************************************************/
	/*******************************************************************/
	/*******************************************************************/
	public BasicContext obtenerBasicContext(String dominioEmpresa, String rol, String usuario, String contrasenhaAplicacionWeb);
	
	public BasicContext obtenerBasicContext(String keySession);
	
	public BasicContext almacenarBasicContext(BasicContext requestBasicContext, String dominioEmpresa, String rol, String usuario, String contrasenhaAplicacionWeb);
	
	public BasicContext almacenarBasicContext(BasicContext requestBasicContext, String keySession);
	
	public BasicContext obtenerBasicContextxKeySession(String keySession);
	
	public AutentificacionContext obtenerAuthenticationContext(String keyAuthentication);
	
	public AutentificacionContext almacenarAuthenticationContext(AutentificacionContext authenticacionContext);
	
	public AutentificacionContext almacenarAuthenticationContext(AutentificacionContext contextoAutenticacion, String keyAuthenticacion);
	
	public EnterpriseContext obtenerEnterpriseContext(String aplicacion, String keySession);
	
	public EnterpriseContext almacenarEnterpriseContext(EnterpriseContext requestEnterpriseContext, String aplicacion, String keySession);
	
	public EnterpriseContext almacenarEnterpriseContext(EnterpriseContext requestEnterpriseContext, String keyEnterprise);
	
	public EnterpriseContext obtenerEnterpriseContextxKey(String keyEnterprise);
	
	public SeguridadContext obtenerSeguridadContextXAutentificacionContext(AutentificacionContext autentificacionContext);
	
	public SeguridadContext obtenerSeguridadContext(String keySeguridad);
	
	public SeguridadContext almacenarSeguridadContext(SeguridadContext seguridadContext);
	
	public SeguridadContext almacenarSeguridadContext(SeguridadContext seguridadContext, String keySeguridad);
	
	public Boolean verificarMaquinaEmpresa(ConsultaSeguridad consultaSeguridad, Empresa empresa);
	
	public List<GrupoUsuarioModel> listarUsuarioPerfilMemberxEmpresaxRol(Usuario usuario, Empresa empresa, Rol rol) throws SSOOrquestadorException;
	
	public List<GrupoUsuarioModel> listarUsuarioPerfilMemberxUsuarioxFechaCreacion(List<EmpresaUsuario> listaEmpresaUsuario, Date fechaAnterior, Date fechaPosterior) throws SSOOrquestadorException;
	
	public GrupoUsuarioModel buscarPerfilxUsernamexPasswordContrasenhaxEstadoUsuarioPerfil(Perfil perfil, Empresa empresa) throws SSOOrquestadorException;
	
	public GrupoUsuarioModel buscarPerfilxUsernamexPasswordContrasenha(Perfil perfil, Empresa empresa) throws SSOOrquestadorException;
							 
//	public List<Aplicacion> obtenerCacheListaAplicacion();
//	public List<TipoAccionPerfil> obtenerCacheListaTipoAccionPerfil();
//	public List<Genero> obtenerListaGenero();
//	
//	
//	public Genero obtenerGenero(Genero genero) throws SeguridadClienteException;
//	public Rol obtenerRol(Rol rol) throws SeguridadClienteException;
//	public Empresa obtenerEmpresaId(Empresa empresa) throws SeguridadClienteException;
//	public Empresa obtenerEmpresaDominio(Empresa empresa) throws SeguridadClienteException;
//	public Aplicacion obtenerAplicacionxUriRuta(Aplicacion aplicacion) throws SeguridadClienteException;
//	public Aplicacion obtenerAplicacionxId(Aplicacion aplicacion)  throws SeguridadClienteException;
//	public TipoAccionPerfil obtenerTipoAccionPerfil(TipoAccionPerfil tipoAccionPerfil) throws SeguridadClienteException;
//	
//	public SeguridadSessionPlataforma generarSeguridadSessionPlataforma(SeguridadSessionPlataforma seguridadSessionPlataforma)  throws SeguridadClienteException;
//	
//	public SeguridadSessionPlataforma obtenerSeguridadSessionPlataforma(String key) throws SeguridadClienteException;
//	
//	public EmpresaUsuario buscarEmpresaUsuarioxEmpresaxUsuarioxRol(EmpresaUsuario objEmpresaUsuarioModel) throws SeguridadClienteException;
//	
//	public AplicacionEmpresa buscarAplicacionEmpresaxAplicacionxEmpresaxEstado(AplicacionEmpresa objAplicacionEmpresa) throws SeguridadClienteException;
//	
//	public EmpresaUsuarioAplicacionEmpresa buscarEmpresaUsuarioAplicacionEmpresaxEUAE(EmpresaUsuarioAplicacionEmpresa objEmpresaUsuarioAplicacionEmpresa) throws SeguridadClienteException;
//	
//	public List<AplicacionServicio>	listarAplicacionServicioxIdAplicacionxEstadoAplicacion(AplicacionEmpresa objAplicacionEmpresa) throws SeguridadClienteException;
//	
//	public List<SeguridadAplicacionAcceso> listarSeguridadAplicacionAccesoxEUAExListaAplicacionServicioxEstado(SeguridadAplicacionAcceso objSeguridadAplicacionAcceso) throws SeguridadClienteException;
//	
//	public AplicacionServicio buscarAplicacionServicioxIdAplicacionxUriRutaxMetodoHttpxEstadoAplicacionServicio(AplicacionServicio objAplicacionServicio) throws SeguridadClienteException;
	
	
}
