package com.ragnax.ssoorquestador.servicio;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.ragnax.domain.sso.entidad.AplicacionServicio;
import com.ragnax.domain.sso.entidad.*;
import com.ragnax.domain.ssoorquestador.modelo.*;
import com.ragnax.ssoorquestador.configuration.FactoryApiProperties;
import com.ragnax.ssoorquestador.exception.SSOOrquestadorException;

@Component
@ComponentScan(basePackageClasses = { FactoryApiProperties.class})
public class SSOServicioImpl implements SSOService{

	private static final Logger objLog = LoggerFactory.getLogger(SSOServicioImpl.class);
	
//	@Autowired
//	private SSSOUtilidad sssoUtilidad;
//	private static final boolean ESTADO_SEGURIDAD_CONTEXT_ACTIVO = true;
	
//	SeguridadProperties seguridadProperties = new SeguridadProperties();
	
	//ir a la base de datos no relacional
	@Autowired
	private FactoryApiProperties factoryApiProperties;
	
	public BasicContext obtenerBasicContext(String dominioEmpresa, String rol, String usuario, String contrasenhaAplicacionWeb){
		
		String keySession = "";
//		String keySession = Encriptar1_1.generacionSHA(dominioEmpresa+rol+usuario+contrasenhaAplicacionWeb);
		
		BasicContext requestBasicContext = obtenerBasicContext(keySession);

		return requestBasicContext;
	}
	
	public BasicContext obtenerBasicContext(String keySession){

		BasicContext requestBasicContext = obtenerBasicContextxKeySession(keySession);

		return requestBasicContext;
	}

	public BasicContext almacenarBasicContext(BasicContext requestBasicContext, String dominioEmpresa, String rol, String usuario, String contrasenhaAplicacionWeb){

		String keySession = "";
		
//		String keySession = Encriptar1_1.generacionSHA(dominioEmpresa+rol+ usuario + contrasenhaAplicacionWeb);
		
		requestBasicContext = almacenarBasicContext(requestBasicContext, keySession);

		return requestBasicContext;
	}
	
	/**Almacenar en Mongo/Cassandra***/
	public BasicContext almacenarBasicContext(BasicContext requestBasicContext, String keySession){
		return null;
	}
//	public BasicContext almacenarBasicContext(BasicContext requestBasicContext, String keySession){
//		
//		BasicContext metBasicContext = obtenerBasicContextxKeySession(keySession);
//			//no existe en la lista de SessionesBasicas
//			if(metBasicContext==null){
//				requestBasicContext.setKeyBasic(keySession);
//				List<BasicContext> listaBasicContext =  obtenerCacheListaBasic();
//				listaBasicContext.add(requestBasicContext);
//				try {
//					listaBasicContext = CacheLocalServicio.generarCacheListaBasicContext(objCacheLocal, listaBasicContext);
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		
//		return requestBasicContext;
//	}
	
	public BasicContext obtenerBasicContextxKeySession(String keySession){
		// ffff453425d84364a82c776f3df4937e8329e22cea56268b3cfbb05bab96492fffff453425d84364a82c776f3df4937e8329e22cea56268b3cfbb05bab96492f
		// ffff453425d84364a82c776f3df4937e8329e22cea56268b3cfbb05bab96492f
		List<BasicContext> listaBasicContext =  obtenerCacheListaBasic();
		
		if(listaBasicContext!=null && listaBasicContext.size()>0){
			for(BasicContext req: listaBasicContext){
				if(keySession.equals(req.getKeyBasic())){
					return req;
				}
			}
		}
		
		return null;
	}
	
	private List<BasicContext> obtenerCacheListaBasic(){
		return null;
	}
//	private List<BasicContext> obtenerCacheListaBasic(){
//		List<BasicContext> listaBasicContext=new ArrayList<BasicContext>();
//		
//		try{
//			if(objCacheLocal==null){
//				objCacheLocal = CacheLocalServicio.crearRepositorioCacheLocal(); //Colocar el nombre de cache local del ws
//			}
//		
//		}catch(Exception e){
//			listaBasicContext=null;
//			objLog.error("Cae al obtener el repositorio de Cache");
//		}
//	
//		try{
//			listaBasicContext = CacheLocalServicio.obtenerCacheListaBasicContext(objCacheLocal);
//
//		}catch(Exception e){
//			listaBasicContext=null;
//		}
//		
//		return listaBasicContext;
//	}
	
	public AutentificacionContext obtenerAuthenticationContext(String keyAuthentication){
		
		List<AutentificacionContext> listaAuthenticationContext =  obtenerCacheListaAuthenticationContext();
		
		if(listaAuthenticationContext!=null && listaAuthenticationContext.size()>0){
			for(AutentificacionContext req: listaAuthenticationContext){
				if(keyAuthentication.equals(req.getKeyAutentificacion())){
					return req;
				}
			}
		}
		
		return null;
	}
	
	public AutentificacionContext almacenarAuthenticationContext(AutentificacionContext authenticacionContext){
		//Hacer La Clave exclusivamente con las variables del AuthenticationContext.

		String concatIdAplicacionServicioModel = "";
		if(authenticacionContext.getListaAplicacionServicio()!=null){
			for(AplicacionServicio asm: authenticacionContext.getListaAplicacionServicio()){
				concatIdAplicacionServicioModel = concatIdAplicacionServicioModel+"-"+asm.getIdAplicacion(); 
			}
		}

		String keyAutentificacion = "";
//		String keyAutentificacion = Encriptar1_1.generacionSHA(authenticacionContext.getEnterpriseContext().getKeyEnterprise()+concatIdAplicacionServicioModel);
		
		authenticacionContext.setKeyAutentificacion(keyAutentificacion);
		
		authenticacionContext = almacenarAuthenticationContext(authenticacionContext, authenticacionContext.getKeyAutentificacion());

		return authenticacionContext;
	}
	
	public AutentificacionContext almacenarAuthenticationContext(AutentificacionContext contextoAutenticacion, String keyAuthenticacion){
		return null;
	}
//	public AutentificacionContext almacenarAuthenticationContext(AutentificacionContext contextoAutenticacion, String keyAuthenticacion){
//		
//		
//		AutentificacionContext metAuthenticationContext = obtenerAuthenticationContext(keyAuthenticacion);
//			//no existe en la lista de SessionesEnterpriseas
//			if(metAuthenticationContext==null){
//				contextoAutenticacion.setKeyAutentificacion(keyAuthenticacion);
//				List<AutentificacionContext> listaAuthenticationContext =  obtenerCacheListaAuthenticationContext();
//				listaAuthenticationContext.add(contextoAutenticacion);
//				try {
//					listaAuthenticationContext = CacheLocalServicio.generarCacheListaAuthenticationContext(objCacheLocal, listaAuthenticationContext);
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		
//		return contextoAutenticacion;
//	}
	
	private List<AutentificacionContext> obtenerCacheListaAuthenticationContext(){
		return null;
	}
//	private List<AutentificacionContext> obtenerCacheListaAuthenticationContext(){
//		List<AutentificacionContext> listaAuthenticationContext=new ArrayList<AutentificacionContext>();
//		
//		try{
//			if(objCacheLocal==null){
//				objCacheLocal = CacheLocalServicio.crearRepositorioCacheLocal(); //Colocar el nombre de cache local del ws
//			}
//		
//		}catch(Exception e){
//			listaAuthenticationContext=null;
//			objLog.error("Cae al obtener el repositorio de Cache");
//		}
//	
//		try{
//			listaAuthenticationContext = CacheLocalServicio.obtenerCacheListaAuthenticationContext(objCacheLocal);
//
//		}catch(Exception e){
//			listaAuthenticationContext=null;
//		}
//		
//		return listaAuthenticationContext;
//	}
	
	public EnterpriseContext obtenerEnterpriseContext(String aplicacion, String keySession){

		String keyEnterprise = "";
		
//		String keyEnterprise = Encriptar1_1.generacionSHA(aplicacion+keySession);
		
		EnterpriseContext requestEnterpriseContext = obtenerEnterpriseContextxKey(keyEnterprise);

		return requestEnterpriseContext;
	}

	public EnterpriseContext almacenarEnterpriseContext(EnterpriseContext requestEnterpriseContext, String aplicacion, String keySession){

		String keyEnterprise = "";
		
//		String keyEnterprise = Encriptar1_1.generacionSHA(aplicacion+keySession);
		
		requestEnterpriseContext = almacenarEnterpriseContext(requestEnterpriseContext, keyEnterprise);

		return requestEnterpriseContext;
	}
	
	public EnterpriseContext almacenarEnterpriseContext(EnterpriseContext requestEnterpriseContext, String keyEnterprise){
		return null;
	}
//	public EnterpriseContext almacenarEnterpriseContext(EnterpriseContext requestEnterpriseContext, String keyEnterprise){
//		
//		
//		EnterpriseContext metEnterpriseContext = obtenerEnterpriseContextxKey(keyEnterprise);
//			//no existe en la lista de SessionesEnterpriseas
//			if(metEnterpriseContext==null){
//				requestEnterpriseContext.setKeyEnterprise(keyEnterprise);
//				List<EnterpriseContext> listaEnterpriseContext =  obtenerCacheListaEnterprise();
//				listaEnterpriseContext.add(requestEnterpriseContext);
//				try {
//					listaEnterpriseContext = CacheLocalServicio.generarCacheListaEnterpriseContext(objCacheLocal, listaEnterpriseContext);
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		
//		return requestEnterpriseContext;
//	}
	
	public EnterpriseContext obtenerEnterpriseContextxKey(String keyEnterprise){
		
		List<EnterpriseContext> listaEnterpriseContext =  obtenerCacheListaEnterprise();
		
		if(listaEnterpriseContext!=null && listaEnterpriseContext.size()>0){
			for(EnterpriseContext req: listaEnterpriseContext){
				if(keyEnterprise.equals(req.getKeyEnterprise())){
					return req;
				}
			}
		}
		
		return null;
	}
	
	private List<EnterpriseContext> obtenerCacheListaEnterprise(){
		return null;
	}
//	private List<EnterpriseContext> obtenerCacheListaEnterprise(){
//		List<EnterpriseContext> listaEnterpriseContext=new ArrayList<EnterpriseContext>();
//		
//		try{
//			if(objCacheLocal==null){
//				objCacheLocal = CacheLocalServicio.crearRepositorioCacheLocal(); //Colocar el nombre de cache local del ws
//			}
//		
//		}catch(Exception e){
//			listaEnterpriseContext=null;
//			objLog.error("Cae al obtener el repositorio de Cache");
//		}
//	
//		try{
//			listaEnterpriseContext = CacheLocalServicio.obtenerCacheListaEnterpriseContext(objCacheLocal);
//
//		}catch(Exception e){
//			listaEnterpriseContext=null;
//		}
//		
//		return listaEnterpriseContext;
//	}
	
	public SeguridadContext obtenerSeguridadContextXAutentificacionContext(AutentificacionContext autentificacionContext){

		String concatIdSeguridadAplicacionAccesoModel = "";

		concatIdSeguridadAplicacionAccesoModel = autentificacionContext.getKeyAutentificacion()+" "+autentificacionContext.getEnterpriseContext().getIdEmpresaUsuarioAplicacionEmpresa()+" "+ factoryApiProperties.getConfigdata().getEstadoActivoConsulta()+" "+ autentificacionContext.getEnterpriseContext().getIdAplicacion();

		String keySeguridad = "";
//		String keySeguridad = Encriptar1_1.generacionSHA(autentificacionContext.getKeyAutentificacion()+concatIdSeguridadAplicacionAccesoModel);

		return obtenerSeguridadContext(keySeguridad);
	}
	
	public SeguridadContext obtenerSeguridadContext(String keySeguridad){
		
		List<SeguridadContext> listaSeguridadContext =  obtenerCacheListaSeguridadContext();
		
		if(listaSeguridadContext!=null && listaSeguridadContext.size()>0){
			for(SeguridadContext segCtx: listaSeguridadContext){
				if(segCtx.getKeySeguridad().equals(keySeguridad)){
					return segCtx;
				}
			}
		}
		
		return null;
	}
	
	
	
	public SeguridadContext almacenarSeguridadContext(SeguridadContext seguridadContext){
		//Hacer La Clave exclusivamente con las variables del ContextoAutenticacion.
		String concatIdSeguridadAplicacionAccesoModel = "";
		
		//key + IdEmpresaUsuarioAplicacionEmpresa + estado + idAplicacion
		concatIdSeguridadAplicacionAccesoModel = seguridadContext.getAutentificacionContext().getKeyAutentificacion()+" "+seguridadContext.getAutentificacionContext().getEnterpriseContext().getIdEmpresaUsuarioAplicacionEmpresa()+" "+ factoryApiProperties.getConfigdata().getEstadoActivoConsulta()+" "+ seguridadContext.getAutentificacionContext().getEnterpriseContext().getIdAplicacion();
//		Pasarlos a Auth..?
//		if(seguridadContext.getListaSeguridadAplicacionAcceso()!=null){
//			for(SeguridadAplicacionAccesoDTO sam: seguridadContext.getListaSeguridadAplicacionAcceso()){
//				concatIdSeguridadAplicacionAccesoModel = concatIdSeguridadAplicacionAccesoModel+"-"+sam.getIdAplicacionServicio(); 
//			}
//		}
		
		String keySeguridad = "";
		
//		String keySeguridad = Encriptar1_1.generacionSHA(seguridadContext.getAutentificacionContext().getKeyAutentificacion()+concatIdSeguridadAplicacionAccesoModel);
		
		seguridadContext.setKeySeguridad(keySeguridad);

		seguridadContext = almacenarSeguridadContext(seguridadContext, seguridadContext.getKeySeguridad());

		return seguridadContext;
	}
	
	public SeguridadContext almacenarSeguridadContext(SeguridadContext seguridadContext, String keySeguridad){
		return null;
	}
//	public SeguridadContext almacenarSeguridadContext(SeguridadContext seguridadContext, String keySeguridad){
//		
//		
//		SeguridadContext metSeguridadContext = obtenerSeguridadContext(keySeguridad);
//			//no existe en la lista de SessionesEnterpriseas
//			if(metSeguridadContext==null){
//				seguridadContext.setKeySeguridad(keySeguridad);
//				List<SeguridadContext> listaContextoAutenticacion =  obtenerCacheListaSeguridadContext();
//				listaContextoAutenticacion.add(seguridadContext);
//				try {
//					listaContextoAutenticacion = CacheLocalServicio.generarCacheListaSeguridadContext(objCacheLocal, listaContextoAutenticacion);
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		
//		return seguridadContext;
//	}
	
	private List<SeguridadContext> obtenerCacheListaSeguridadContext(){
		return null;
	}

//	private List<SeguridadContext> obtenerCacheListaSeguridadContext(){
//		List<SeguridadContext> listaSeguridadContext=new ArrayList<SeguridadContext>();
//		
//		try{
//			if(objCacheLocal==null){
//				objCacheLocal = CacheLocalServicio.crearRepositorioCacheLocal(); //Colocar el nombre de cache local del ws
//			}
//		
//		}catch(Exception e){
//			listaSeguridadContext=null;
//			objLog.error("Cae al obtener el repositorio de Cache");
//		}
//	
//		try{
//			listaSeguridadContext = CacheLocalServicio.obtenerCacheListaSeguridadContext(objCacheLocal);
//
//		}catch(Exception e){
//			listaSeguridadContext=null;
//		}
//		
//		return listaSeguridadContext;
//	}
	
	@Override
	public Boolean verificarMaquinaEmpresa(ConsultaSeguridad consultaSeguridad, Empresa empresa) {
		// TODO Traer los Valores Formateados
		return null;
	}

	@Override
	public List<GrupoUsuarioModel> listarUsuarioPerfilMemberxEmpresaxRol(Usuario usuario, Empresa empresa, Rol rol)
			throws SSOOrquestadorException {
		// TODO Traer los Valores Formateados
		return null;
	}

	@Override
	public List<GrupoUsuarioModel> listarUsuarioPerfilMemberxUsuarioxFechaCreacion(
			List<EmpresaUsuario> listaEmpresaUsuario, Date fechaAnterior, Date fechaPosterior)
			throws SSOOrquestadorException {
		// TODO Traer los Valores Formateados
		return null;
	}

	@Override
	public GrupoUsuarioModel buscarPerfilxUsernamexPasswordContrasenhaxEstadoUsuarioPerfil(Perfil perfil,
			Empresa empresa) throws SSOOrquestadorException {
		// TODO Traer los Valores Formateados
		return null;
	}

	@Override
	public GrupoUsuarioModel buscarPerfilxUsernamexPasswordContrasenha(Perfil perfil, Empresa empresa)
			throws SSOOrquestadorException {
		// TODO Traer los Valores Formateados
		return null;
	}
	
	
	
}

