package com.ragnax.ssoorquestador.servicio;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.ragnax.ssoorquestador.configuration.FactoryApiProperties;
import com.ragnax.ssoorquestador.controller.response.SSOOrquestador;
import com.ragnax.ssoorquestador.exception.SSOOrquestadorException;
import com.ragnax.ssoorquestador.modelo.*;
import com.ragnax.ssoorquestador.servicio.clientes.SSOClienteRest;
import com.ragnax.ssoorquestador.servicio.clientes.modelo.*;
import com.ragnax.ssoorquestador.servicio.utilidades.SSOOrquestadorMapper;


@Service
@ComponentScan(basePackageClasses = { FactoryApiProperties.class})
public class SSOOrquestadorServiceImpl implements SSOOrquestadorService {

	private static final Logger objLog = LoggerFactory.getLogger(SSOOrquestadorServiceImpl.class);
	
	@Autowired
	private FactoryApiProperties factoryApiProperties;
	
	@Autowired
	private SSOService ssoService;
	
	@Autowired
	private SSOClienteRest ssoClienteRest;
	
//	@Autowired
//	private ZapalaClienteRest zapalaClienteRest;
	

	public SSOOrquestador obtenerBasicContext(String usuarioContext, String passwordUsuario, ConsultaSeguridad consultaSeguridad) throws SSOOrquestadorException {

		//		BasicContext basicContext = null;
		SSOOrquestador seguridadAplicaciones = null;

		GrupoUsuarioModel grupoUsuario = new GrupoUsuarioModel();

		Empresa empresa = ssoClienteRest.buscarEmpresaxDominio(new Empresa(consultaSeguridad.getDominioEmpresa()));

		if(empresa!=null && empresa.getIdEmpresa()!=null){
			//boolean veridicar = ssoClienteRest.verificarMaquinaEmpresa(consultaSeguridad, empresa).get;
			boolean veridicar = true;

			if(veridicar){
				/* dominioEmpresa - rol - usuarioContrasenhaAplicacionWeb */
				BasicContext basicContext = ssoService.obtenerBasicContext(consultaSeguridad.getDominioEmpresa(), 
						consultaSeguridad.getRolContexto(), usuarioContext, passwordUsuario);

				if(basicContext==null){

					Rol rol = ssoClienteRest.buscarRolxNombre(new Rol(consultaSeguridad.getRolContexto()));

					grupoUsuario = ssoService.
							buscarPerfilxUsernamexPasswordContrasenhaxEstadoUsuarioPerfil(new Perfil(usuarioContext, passwordUsuario), empresa);

					if(grupoUsuario!=null && grupoUsuario.getUsuario()!=null && grupoUsuario.getUsuario().getIdUsuario()!=null &&
							grupoUsuario.getMember()!=null && grupoUsuario.getMember().getIdMember()!=null &&
							grupoUsuario.getPerfil()!=null && grupoUsuario.getPerfil().getIdPerfil()!=null ){

						EmpresaUsuario empresaUsuario = ssoClienteRest.buscarEmpresaUsuarioxEmpresaxUsuarioxRol
								(new EmpresaUsuario(empresa , grupoUsuario.getUsuario(), rol));

						if(empresaUsuario!=null && empresaUsuario.getIdEmpresaUsuario()!=null){

							basicContext = SSOOrquestadorMapper.mapToBasicContext(empresa, rol, empresaUsuario, grupoUsuario);

							if(basicContext!=null){

								basicContext = ssoService.almacenarBasicContext(
										basicContext, consultaSeguridad.getDominioEmpresa(), consultaSeguridad.getRolContexto(), usuarioContext, passwordUsuario);
								objLog.info("Nuevo Contexto de Session de Empresa: "+basicContext.getKeyBasic());

								seguridadAplicaciones = new SSOOrquestador(basicContext);
							}
						}
					}
				}
			}
		}

		return seguridadAplicaciones;
	}

	//usuarioContext nombre de la Aplicacion.
	public SSOOrquestador obtenerEnterpriseContext(String usuarioContext, String passwordUsuario) throws SSOOrquestadorException {
		//	public EnterpriseContext obtenerEnterpriseContext(String usuarioContext, String passwordUsuario, ConsultaSeguridad consultaSeguridad) throws Exception {

		SSOOrquestador seguridadAplicaciones = null;

			EnterpriseContext enterpriseContext = ssoService.obtenerEnterpriseContext(usuarioContext, passwordUsuario);

			if(enterpriseContext==null){

				BasicContext basicContext = ssoService.obtenerBasicContext(passwordUsuario);

				if(basicContext!=null){

					Aplicacion aplicacion = ssoClienteRest.buscarAplicacionxUriRuta(new Aplicacion("/"+usuarioContext));
					
					Empresa empresa = ssoClienteRest.buscarEmpresa(new Empresa(basicContext.getIdEmpresa()));

					if(aplicacion.getIdAplicacion()!=null && aplicacion.getIdAplicacion()>0){

						AplicacionEmpresa aplicacionEmpresa = ssoClienteRest.buscarAplicacionEmpresaxAplicacionxEmpresa
								(new AplicacionEmpresa(aplicacion,  empresa));
						
						Rol rol = new Rol();
						rol.setNombreRol(basicContext.getRolContexto());
						rol = ssoClienteRest.buscarRolxNombre(rol);
						
						AplicacionRol aplicacionRol = ssoClienteRest.buscarAplicacionRolxAplicacionxRol
								(new AplicacionRol(aplicacion,  rol));
						
						EmpresaUsuario empresaUsuario = ssoClienteRest.buscarEmpresaUsuarioxEmpresaxUsuarioxRol(new EmpresaUsuario(empresa, null, rol));

						if(aplicacionRol.getIdRol().getIdRol().intValue()>0){
							EmpresaUsuarioAplicacionEmpresa euae = ssoClienteRest.buscarEmpresaUsuarioAplicacionEmpresaxEUxAE
									(new EmpresaUsuarioAplicacionEmpresa(empresaUsuario,  aplicacionEmpresa));

							enterpriseContext = SSOOrquestadorMapper.mapToEnterpriseContext(basicContext, 
									aplicacionEmpresa, aplicacionRol, euae);

							if(enterpriseContext!=null){

								enterpriseContext = ssoService.almacenarEnterpriseContext(enterpriseContext, usuarioContext, passwordUsuario);
								
								seguridadAplicaciones = new SSOOrquestador(enterpriseContext);
								
							}
						}
					}
				}
			}
		
		return seguridadAplicaciones;
	}
	//Generalmente debiese ser la aplicacion quien llama a este metodo, para validar a las aplicaciones y servicios que tiene acceso.
	//se Almacena. y siempre se consulta para la aplicacion.
	//para la autentificacion el usuario es el keyEnterprise
	//el password es el keyAutentificacion
	public SSOOrquestador obtenerAutentificacionContext(String usuario, String keyEnterprise, ConsultaSeguridad consultaSeguridad) throws SSOOrquestadorException {

		SSOOrquestador seguridadAplicaciones = null; 

			//jsakassakjh pasarlos alos parametros del metodo.
			//uriRutaAplicacionServicio:  httpServlet.getURI() / httpServlet.getContextPath()
			//metodoHttp httpServlet.getMethod());  //GET / POST
			//httpServletRequest.getRemoteHost();
			AutentificacionContext autentificacionContext= (consultaSeguridad.getKeySeguridad()!=null && !"".equals(consultaSeguridad.getKeySeguridad())) ? 
					autentificacionContext = ssoService.obtenerAuthenticationContext(consultaSeguridad.getKeySeguridad()) : null;

					if(autentificacionContext==null){

						EnterpriseContext enterpriseContext = ssoService.obtenerEnterpriseContextxKey(keyEnterprise);

						if(enterpriseContext!=null && enterpriseContext.getIdAplicacionRol() >0){
							//Buscar la Authenticacion, ya almacenada.

							List<SeguridadAplicacionAcceso> listaSeguridadAplicacionAcceso = null;

							Aplicacion aplicacion = ssoClienteRest.buscarAplicacion(new Aplicacion(enterpriseContext.getIdAplicacion()));

							List<AplicacionServicio> listaAplicacionServicio = ssoClienteRest.listarAplicacionServicioxAplicacion(
									new AplicacionServicio(aplicacion));

							if(listaAplicacionServicio==null){
								listaAplicacionServicio = new ArrayList<AplicacionServicio>();
							}

							if(listaAplicacionServicio!=null){
								//Mandar esta Lista para formar la Key
								autentificacionContext = new AutentificacionContext(enterpriseContext, null ,listaAplicacionServicio ); 

								if(autentificacionContext!=null){

									autentificacionContext = ssoService.almacenarAuthenticationContext(autentificacionContext);

									EmpresaUsuarioAplicacionEmpresa objEUAE  = new EmpresaUsuarioAplicacionEmpresa(); 
									objEUAE = ssoClienteRest.buscarEmpresaUsuarioAplicacionEmpresa(objEUAE);

									autentificacionContext.getEnterpriseContext().getIdEmpresaUsuarioAplicacionEmpresa();

									//								if(listaAplicacionServicio.size()>0){
									listaSeguridadAplicacionAcceso = null;
									//											ssoClienteRest.listarSeguridadAplicacionAccesoxEUAExListaAplicacionServicio(objSeguridadAplicacionAcceso)(
									//											new SeguridadAplicacionAcceso(new EmpresaUsuarioAplicacionEmpresa()), autentificacionContext.getEnterpriseContext().getIdAplicacion());
									//								}
									if(listaSeguridadAplicacionAcceso==null){
										listaSeguridadAplicacionAcceso = new ArrayList<SeguridadAplicacionAcceso>();
									}

									if(listaSeguridadAplicacionAcceso!=null){

										SeguridadContext seguridadContext = SSOOrquestadorMapper.mapToSeguridadContext(autentificacionContext, listaSeguridadAplicacionAcceso);

										if(seguridadContext!=null){
											//Aqui Guardadito
											seguridadContext = ssoService.almacenarSeguridadContext(seguridadContext);

											seguridadAplicaciones = new SSOOrquestador(seguridadContext);

										}
									}
								}
							}
						}
					}
		
		//Hasta Aqui...
		return seguridadAplicaciones;
	}

	//Una vez trabajando con los metodo validados... key de Authentificacion de servicios -  tipo metodo
	public SSOOrquestador obtenerSeguridadContext(String nombreAplicacion, String producto, String metodo, String metodoHttp, String keyAuthenticacion) throws SSOOrquestadorException{
		System.out.println("metodo:" +metodo +" producto:"+producto + " aplicacion:"+nombreAplicacion + " metodoHttp:"+metodoHttp+" keyAuthenticacion:"+keyAuthenticacion);

		AutentificacionContext autentificacionContext = (keyAuthenticacion!=null && !"".equals(keyAuthenticacion)) ? 
				ssoService.obtenerAuthenticationContext(keyAuthenticacion) : null;

				if(autentificacionContext!=null && autentificacionContext.getListaAplicacionServicio()!=null){
					for(AplicacionServicio aplicacionServicioEnterprise : autentificacionContext.getListaAplicacionServicio()){
						if(aplicacionServicioEnterprise.getUriRutaAplicacion()!=null && aplicacionServicioEnterprise.getUriRutaAplicacionProducto()!=null 
								&& aplicacionServicioEnterprise.getUriRutaAplicacionProductoServicio()!=null && aplicacionServicioEnterprise.getUriRutaAplicacionProducto()!=null &&
										aplicacionServicioEnterprise.getUriRutaAplicacion().equals(nombreAplicacion) && aplicacionServicioEnterprise.getUriRutaAplicacionProducto().equals(producto) &&
										aplicacionServicioEnterprise.getUriRutaAplicacionProductoServicio().equals(metodo) && aplicacionServicioEnterprise.getMetodoHttp().equals(metodoHttp)){
							AplicacionServicio aplicacionServicio = new AplicacionServicio();

							
							Aplicacion aplicacion = ssoClienteRest.buscarAplicacion(new Aplicacion(aplicacionServicioEnterprise.getIdAplicacion()));
							
							aplicacionServicio = new AplicacionServicio(aplicacion, aplicacionServicioEnterprise.getUriRutaAplicacion(), aplicacionServicioEnterprise.getUriRutaAplicacionProducto(),
									aplicacionServicioEnterprise.getUriRutaAplicacionProductoServicio(), null,
									aplicacionServicioEnterprise.getMetodoHttp());

							
								aplicacionServicio = ssoClienteRest.buscarAplicacionServicioxAplicacionxUriRutaxMetodoHttp(aplicacionServicio);
								 
								SeguridadContext seguridadContext = ssoService.obtenerSeguridadContextXAutentificacionContext(autentificacionContext);

								if(seguridadContext!=null){

									for(SeguridadAplicacionAcceso saaDTO : seguridadContext.getListaSeguridadAplicacionAcceso()){
										if(saaDTO.getIdAplicacionServicio().getIdAplicacionServicio() == aplicacionServicio.getIdAplicacionServicio()){
											return new  SSOOrquestador(seguridadContext);
											
										}
									}
								}
							
						}
					}
				}
				return null;	
	}



	//se Almacena. y siempre se consulta para el Usuario.
	public SSOOrquestador obtenerLoginUsuario(String usuarioLogin, String passwordUsuario, ConsultaSeguridad consultaSeguridad) throws SSOOrquestadorException {
		//		UsuarioContext usuarioContext = null;
		SSOOrquestador seguridadAplicaciones = null;  

		GrupoUsuarioModel grupoUsuario = new GrupoUsuarioModel();

			//uriRutaAplicacionServicio:  httpServlet.getURI() / httpServlet.getContextPath()
			//httpServlet.getMethod() Requerido
			// - //GET / - / POST

			//Buscar la Authenticacion, ya almacenada.
			BasicContext basicContext = ssoService.obtenerBasicContext(consultaSeguridad.getDominioEmpresa(), consultaSeguridad.getRolContexto(), usuarioLogin,
					passwordUsuario);

			if(basicContext==null){
				EnterpriseContext enterpriseContext = ssoService.obtenerEnterpriseContextxKey(consultaSeguridad.getKeySeguridad());

				if(enterpriseContext!=null && enterpriseContext.getIdAplicacionRol() > 0){
					Rol rol = ssoClienteRest.buscarRolxNombre(new Rol(consultaSeguridad.getRolContexto()));

					Empresa empresa = ssoClienteRest.buscarEmpresaxDominio(new Empresa(consultaSeguridad.getDominioEmpresa()));

					grupoUsuario = ssoService.
							buscarPerfilxUsernamexPasswordContrasenhaxEstadoUsuarioPerfil(new Perfil()
//									usuarioLogin, passwordUsuario, passwordUsuario, ESTADO_CONTEXT_ACTIVO)
									, empresa) ;

					if(grupoUsuario!=null && grupoUsuario.getUsuario()!=null && grupoUsuario.getUsuario().getIdUsuario()!=null &&
							grupoUsuario.getMember()!=null && grupoUsuario.getMember().getIdMember()!=null &&
							grupoUsuario.getPerfil()!=null && grupoUsuario.getPerfil().getIdPerfil()!=null ){

						EmpresaUsuario empresaUsuario = ssoClienteRest.buscarEmpresaUsuarioxEmpresaxUsuarioxRol
								(new EmpresaUsuario(empresa, grupoUsuario.getUsuario(), 
										rol));

						if(empresaUsuario!=null){

							basicContext = SSOOrquestadorMapper.mapToBasicContext(empresa, rol, empresaUsuario, grupoUsuario);

							if(basicContext!=null){

								basicContext = ssoService.almacenarBasicContext(
										basicContext, consultaSeguridad.getDominioEmpresa(), consultaSeguridad.getRolContexto(), usuarioLogin, passwordUsuario);

								objLog.info("Nuevo Contexto de Session de Usuario: "+basicContext.getKeyBasic());
								
								seguridadAplicaciones = new SSOOrquestador(basicContext);
								
							}
						}
					}
				}
			}
		
		return seguridadAplicaciones;
	}
	
	public UsuarioSeguridad crearNuevoUsuarioSeguridad(UsuarioSeguridad usuarioSeguridad) throws SSOOrquestadorException {
		//Rol de Administrador y Aplicacion en el BasicContext podran crear al nuevo Usuario 

		Usuario usuario = new Usuario();
		
		List<String> listaEnterpriseUserAsociation = new ArrayList<String>();

		
			/*Obtenemos la authenticacion de la empresa que va a agregar a un nuevo usuario*/
			AutentificacionContext authenticacionContext = ssoService.obtenerAuthenticationContext(usuarioSeguridad.getKeyAutentificacion());
			//si no está authenticado para la lista de servicios.. no guardar
			if(authenticacionContext!=null && authenticacionContext.getEnterpriseContext() !=null && authenticacionContext.getEnterpriseContext().getBasicContext() !=null){

				Rol rol = ssoClienteRest.buscarRolxNombre(new Rol(usuarioSeguridad.getNombreRol()));

				if(rol!=null && rol.getIdRol() !=null && rol.getIdRol() >0 ){

					Empresa empresa = ssoClienteRest.buscarEmpresa(new Empresa(usuarioSeguridad.getIdEmpresa()));

					if(empresa!=null && empresa.getIdEmpresa() !=null && empresa.getIdEmpresa() >0){

						ConfiguracionEmpresaUsuario configuracionEmpresaUsuario = ssoClienteRest.
								buscarConfiguracionEmpresaUsuarioxEmpresa(new ConfiguracionEmpresaUsuario(empresa, 
										Boolean.parseBoolean(factoryApiProperties.getConfigdata().getEstadoActivoConsulta())));

						if(configuracionEmpresaUsuario!=null && configuracionEmpresaUsuario.getIdConfiguracionEmpresaUsuario()>0){
							//usuario no existe es posible almacenarlos en la base de Datos
							String cripPass = "";

							if(configuracionEmpresaUsuario.getPasswordEmpresaUsuarioContrasenhaFormat().equals("MD5")){
//								cripPass = Encriptar1_1.getMD5(usuarioSeguridad.getPasswordContrasenha());
							}
							else if(configuracionEmpresaUsuario.getPasswordEmpresaUsuarioContrasenhaFormat().equals("SHA-256")){
//								cripPass = Encriptar1_1.generacionSHA(usuarioSeguridad.getPasswordContrasenha());
							}
							
							Genero genero = ssoClienteRest.buscarGeneroxNombre(new Genero(usuarioSeguridad.getGeneroMember()));
							
							Perfil perfil = new Perfil(usuarioSeguridad.getUsernamePerfil(), 
									usuarioSeguridad.getNombrePerfilLowerCase().toLowerCase(), usuarioSeguridad.getMailUsuario(), usuarioSeguridad.getPasswordContrasenha(), 
									cripPass, usuarioSeguridad.getPasswordPregunta(), usuarioSeguridad.getPasswordRespuesta(), 
									usuarioSeguridad.getAnonimo());


							if(genero!=null && genero.getIdGenero()!=null && genero.getIdGenero()>0){
								//								Member member = new Member(null, usuarioSeguridad.getRutMember(), usuarioSeguridad.getNombreMember(), usuarioSeguridad.getApellidoPaterno(), usuarioSeguridad.getApellidoMaterno(),
								//										usuarioSeguridad.getTelefonoContactoMember(), usuarioSeguridad.getFechaNacimientoMember(), genero.getIdGenero(), usuarioSeguridad.getGeneroMember(),
								//										usuarioSeguridad.getFirmaMember(), DateMapper.DateUtilToDateSantiago(new Date()));
								Member member = new Member( usuarioSeguridad.getNombreMember(), usuarioSeguridad.getApellidoPaterno(),
										usuarioSeguridad.getApellidoMaterno(), usuarioSeguridad.getTelefonoContactoMember(), usuarioSeguridad.getFechaNacimientoMember(),
										usuarioSeguridad.getFirmaMember(), genero);

								member = ssoClienteRest.crearMember(member);

								if(member!=null && member.getIdMember()!=null && member.getIdMember()>0){
									
									Identificador identificador = new Identificador(usuarioSeguridad.getTipoIdentificador(), usuarioSeguridad.getRutMember(),
											authenticacionContext.getEnterpriseContext().getBasicContext().getCodigoPais(), member) ;

									identificador = ssoClienteRest.crearIdentificador(identificador);

									if(identificador!=null && identificador.getIdIdentificador()!=null && identificador.getIdIdentificador()>0){
										perfil = ssoClienteRest.crearPerfil(perfil);

										if(perfil!=null && perfil.getIdPerfil()!=null && perfil.getIdPerfil()>0 &&
												member!=null && member.getIdMember()!=null && member.getIdMember()>0){
											
											usuario = ssoClienteRest.generarCodigoUsuario(new Usuario(member, perfil));
											
											usuario = ssoClienteRest.crearUsuario(usuario);

											if(usuario!=null && usuario.getIdUsuario()!=null && usuario.getIdUsuario()>0){
												/******TODO */
												List<Aplicacion> listaAplicacion = null;
//														ssoClienteRest.listarAplicacionxNombreAplicacionxEstado(
//														usuarioSeguridad.getConcatAplicacion(), ESTADO_CONTEXT_ACTIVO); 

												EmpresaUsuario empresaUsuario = ssoClienteRest.crearEmpresaUsuario
														(new EmpresaUsuario(empresa, usuario,rol));

												for(Aplicacion appMod: listaAplicacion){
													//Este Tiene Que estar Creado
													AplicacionEmpresa aplicacionEmpresa = ssoClienteRest.buscarAplicacionEmpresaxAplicacionxEmpresa
															(new AplicacionEmpresa(appMod, empresa));

													if(empresaUsuario!=null && empresaUsuario.getIdEmpresaUsuario()!=null && empresaUsuario.getIdEmpresaUsuario()>0){
														EmpresaUsuarioAplicacionEmpresa empresaUsuarioAplicacionEmpresa = ssoClienteRest.crearEmpresaUsuarioAplicacionEmpresa
																(new EmpresaUsuarioAplicacionEmpresa(empresaUsuario, aplicacionEmpresa));

														listaEnterpriseUserAsociation.add(empresaUsuarioAplicacionEmpresa.getIdEmpresaUsuarioAplicacionEmpresa()+"");
														//												usuarioSeguridad.setsEnterpriseUserAsociation(empresaUsuarioAplicacionEmpresa.getIdEmpresaUsuarioAplicacionEmpresa()+"");
													}else{
														//Fin desde aqui
													}
												}//Fin del for
											}else{
												//Fin desde aqui
											}
										}else{
											//Fin desde aqui
										}
									}else{
										//Fin desde aqui
									}
								}else{
									//Fin desde aqui
								}
							}else{
								//Fin desde aqui
							}
						}
					}
				}
			}else{
				//Fin desde aqui
			}
		
		//		return requestBasicContext;
		if(usuario!=null && usuario.getIdUsuario()!=null && usuario.getIdUsuario()>0){
			if(listaEnterpriseUserAsociation!=null && listaEnterpriseUserAsociation.size()>0){
				usuarioSeguridad.setIdUsuario(usuario.getIdUsuario());
				usuarioSeguridad.setListaEnterpriseUserAsociation(listaEnterpriseUserAsociation);
			}
		}

		return usuarioSeguridad;
	}


	public UsuarioSeguridad actualizarNuevoUsuarioSeguridad(UsuarioSeguridad usuarioSeguridad) throws SSOOrquestadorException {
		
		return null;
	}

	public boolean recuperarContrasenhaUsuarioSeguridad(UsuarioSeguridad usuarioSeguridad) throws SSOOrquestadorException {
		//Rol de Administrador y Aplicacion en el BasicContext podran crear al nuevo Usuario 

		/*Obtenemos la authenticacion de la empresa que va a agregar a un nuevo usuario*/
		AutentificacionContext authenticacionContext = ssoService.obtenerAuthenticationContext(usuarioSeguridad.getKeyAutentificacion());
		//si no está authenticado para la lista de servicios.. no guardar
		if(authenticacionContext!=null && authenticacionContext.getEnterpriseContext() !=null && authenticacionContext.getEnterpriseContext().getBasicContext() !=null){
			//TODO pasar la logica del envio de correo al servicio.
			Rol rol = ssoClienteRest.buscarRolxNombre(new Rol(usuarioSeguridad.getNombreRol()));

			if(rol!=null && rol.getIdRol() !=null && rol.getIdRol() >0 ){
				return validarExistenciaCorreoElectronico(usuarioSeguridad);
			}
		}


		return false;
	}
	
	public boolean cambiarContrasenhaUsuarioSeguridad(UsuarioSeguridad usuarioSeguridad) throws SSOOrquestadorException {
		//Rol de Administrador y Aplicacion en el BasicContext podran crear al nuevo Usuario 

		/*Obtenemos la authenticacion de la empresa que va a agregar a un nuevo usuario*/
		AutentificacionContext authenticacionContext = ssoService.obtenerAuthenticationContext(usuarioSeguridad.getKeyAutentificacion());
		//si no está authenticado para la lista de servicios.. no guardar
		if(authenticacionContext!=null && authenticacionContext.getEnterpriseContext() !=null && authenticacionContext.getEnterpriseContext().getBasicContext() !=null){
			//TODO pasar la logica del envio de correo al servicio.
			Rol rol = ssoClienteRest.buscarRolxNombre(new Rol(usuarioSeguridad.getNombreRol()));

			if(rol!=null && rol.getIdRol() !=null && rol.getIdRol() >0 ){
				return validarExistenciaCorreoElectronico(usuarioSeguridad);
			}
		}

		return false;
	}

	public UsuarioSeguridad obtenerUsuarioSeguridadByIdUsuarioByEmailPerfil(UsuarioSeguridad usuarioSeguridad) throws SSOOrquestadorException {

		Empresa empresa = ssoClienteRest.buscarEmpresa(new Empresa(usuarioSeguridad.getIdEmpresa()));

		if(empresa!=null && empresa.getIdEmpresa()!=null){

			Usuario usuario = ssoClienteRest.buscarUsuarioxCodigo(new Usuario(usuarioSeguridad.getIdUsuario()));

			if(usuario!=null && usuario.getIdUsuario()!=null){

				Perfil perfil = new Perfil();

				perfil.setEmailPerfil(usuarioSeguridad.getMailUsuario());
				//retorna el perfil con contraseña
				perfil = ssoClienteRest.buscarPerfilxEmail(perfil);

				if(perfil!=null){
					usuarioSeguridad.setPasswordContrasenha(perfil.getPasswordContrasenha());
				}

			}else{

			}
		}

		return usuarioSeguridad;
	}

	public boolean validarExistenciaRut(UsuarioSeguridad usuarioSeguridad) throws SSOOrquestadorException{
		//		UsuarioSeguridad retUsuarioSeguridad = new UsuarioSeguridad();
		//		retUsuarioSeguridad.setRutMember("false");

		AutentificacionContext authenticacionContext = ssoService.obtenerAuthenticationContext(usuarioSeguridad.getKeyAutentificacion());
		
		if(authenticacionContext!=null && authenticacionContext.getEnterpriseContext() !=null && authenticacionContext.getEnterpriseContext().getBasicContext() !=null){

			Empresa empresa = ssoClienteRest.buscarEmpresa(new Empresa(usuarioSeguridad.getIdEmpresa()));

			Identificador identificador = new Identificador();

			identificador.setValueIdentificador(usuarioSeguridad.getRutMember());

			identificador.setCodigoPaisPortal(empresa.getCodigoPaisPortal());

			identificador = ssoClienteRest.buscarIdentificadorxValuexPais(identificador);

			if(identificador!=null && identificador.getIdIdentificador()!=null && identificador.getIdIdentificador()>0){
				//				identificador.setValueIdentificador(ValidacionPatrones.generarPatronRUT(identificador.getValueIdentificador()));

				Member member = new Member();

				member.setIdMember(identificador.getIdIdentificador());

				member = ssoClienteRest.buscarMember(member);

				if(member!=null && member.getIdMember()!=null && member.getIdMember()>0){
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}

		//si no está authenticado para la lista de servicios.. no guardar
		return false;
	}

	public boolean validarExistenciaCorreoElectronico(UsuarioSeguridad usuarioSeguridad) throws SSOOrquestadorException{
		UsuarioSeguridad retUsuarioSeguridad = new UsuarioSeguridad();

		AutentificacionContext authenticacionContext = ssoService.obtenerAuthenticationContext(usuarioSeguridad.getKeyAutentificacion());
		//si no está authenticado para la lista de servicios.. no guardar
		if(authenticacionContext!=null && authenticacionContext.getEnterpriseContext() !=null && authenticacionContext.getEnterpriseContext().getBasicContext() !=null){

			Perfil perfil = new Perfil();

			perfil.setEmailPerfil(usuarioSeguridad.getMailUsuario());
			//retorna el perfil con contraseña
			perfil = ssoClienteRest.buscarPerfilxEmail(perfil);

			if(perfil!=null && perfil.getIdPerfil()!=null && perfil.getIdPerfil()>0){
				return true;
			}else{
				//No Existe el Correo
				return false;

			}
		}
		retUsuarioSeguridad.setMailUsuario("false");

		return false;
	}

	public boolean validarExistenciaUsernameLogin(UsuarioSeguridad usuarioSeguridad) throws SSOOrquestadorException{
		UsuarioSeguridad retUsuarioSeguridad = new UsuarioSeguridad();
		retUsuarioSeguridad.setUsernamePerfil("false");

		AutentificacionContext authenticacionContext = ssoService.obtenerAuthenticationContext(usuarioSeguridad.getKeyAutentificacion());
		//si no está authenticado para la lista de servicios.. no guardar
		if(authenticacionContext!=null && authenticacionContext.getEnterpriseContext() !=null && authenticacionContext.getEnterpriseContext().getBasicContext() !=null){

			Perfil perfil = new Perfil();

			perfil.setUsernamePerfil(usuarioSeguridad.getUsernamePerfil());

			perfil = null;
//					ssoClienteRest.buscarPerfilxOnlyUsernamePerfil(perfil);

			if(perfil!=null && perfil.getIdPerfil()!=null && perfil.getIdPerfil()>0){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}

	public boolean validarExistenciaNombrePerfil(UsuarioSeguridad usuarioSeguridad) throws SSOOrquestadorException{
		UsuarioSeguridad retUsuarioSeguridad = new UsuarioSeguridad();
		retUsuarioSeguridad.setNombrePerfilLowerCase("false");

		AutentificacionContext authenticacionContext = ssoService.obtenerAuthenticationContext(usuarioSeguridad.getKeyAutentificacion());
		//si no está authenticado para la lista de servicios.. no guardar
		if(authenticacionContext!=null && authenticacionContext.getEnterpriseContext() !=null && authenticacionContext.getEnterpriseContext().getBasicContext() !=null){

			Perfil perfil = new Perfil();

			perfil.setNombrePerfilLowerCase(usuarioSeguridad.getNombrePerfilLowerCase());

			perfil = null; 
//			ssoClienteRest.buscarPerfilxOnlyNombreUsuarioPerfil(perfil);

			if(perfil!=null && perfil.getIdPerfil()!=null && perfil.getIdPerfil()>0){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}


	public boolean validarExistenciaPasswordRespuesta(UsuarioSeguridad usuarioSeguridad) throws SSOOrquestadorException{
		UsuarioSeguridad retUsuarioSeguridad = new UsuarioSeguridad();
		retUsuarioSeguridad.setNombrePerfilLowerCase("false");

		AutentificacionContext authenticacionContext = ssoService.obtenerAuthenticationContext(usuarioSeguridad.getKeyAutentificacion());
		//si no está authenticado para la lista de servicios.. no guardar
		if(authenticacionContext!=null && authenticacionContext.getEnterpriseContext() !=null && authenticacionContext.getEnterpriseContext().getBasicContext() !=null){

			Perfil perfil = new Perfil();

			perfil.setUsernamePerfil(usuarioSeguridad.getUsernamePerfil());

			perfil = null; 
//				factorySeguridadNegocio.getPerfilNegocio().buscarPerfilxOnlyNombreUsuarioPerfil(perfil);

			if(perfil!=null && perfil.getIdPerfil()!=null && perfil.getIdPerfil()>0){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}

	public boolean registrarAccionPerfilUsuario(UsuarioSeguridad usuarioSeguridad) throws SSOOrquestadorException{
		UsuarioSeguridad retUsuarioSeguridad = new UsuarioSeguridad();


		retUsuarioSeguridad.setNombrePerfilLowerCase("false");

		AutentificacionContext authenticacionContext = ssoService.obtenerAuthenticationContext(usuarioSeguridad.getKeyAutentificacion());
		//si no está authenticado para la lista de servicios.. no guardar
		if(authenticacionContext!=null && authenticacionContext.getEnterpriseContext() !=null && authenticacionContext.getEnterpriseContext().getBasicContext() !=null){

			Perfil perfil = new Perfil();

			perfil.setUsernamePerfil(usuarioSeguridad.getUsernamePerfil());

			perfil = ssoClienteRest.buscarPerfilxUsername(perfil);

			if(perfil!=null && perfil.getIdPerfil()!=null && perfil.getIdPerfil()>0){

				List<TipoAccionPerfil> listaTipoAccionPerfil = new ArrayList<TipoAccionPerfil>();

				listaTipoAccionPerfil = null; 
				//						ssoClienteRest.listarTipoAccionPerfil();
				TipoAccionPerfil tipoAccionPerfil = null;

				for(TipoAccionPerfil tapm: listaTipoAccionPerfil){
					if(tapm.getNombreTipoAccionPerfil().equals(usuarioSeguridad.getTipoAccionUsuario())){
						tipoAccionPerfil = tapm;
					}
				}

				if(tipoAccionPerfil!=null){
					AccionPerfil accionPerfil = null; 
					//							ssoClienteRest.
					//							buscarAccionPerfilxPerfilxTipoAccionxKeyAccion(new AccionPerfil(DateMapper.DateUtilToDateSantiago(new Date()), perfil.getIdPerfil(), tipoAccionPerfil.getIdTipoAccionPerfil(),
					//							tipoAccionPerfil.getNombreTipoAccionPerfil()));

					if(accionPerfil==null || accionPerfil.getIdAccionPerfil()==null|| accionPerfil.getIdAccionPerfil()>0){
						accionPerfil = null; 
						//								ssoClienteRest.crearAccionPerfil(new AccionPerfil(DateMapper.DateUtilToDateSantiago(new Date()), perfil.getIdPerfil(), tipoAccionPerfil.getIdTipoAccionPerfil(),
						//								tipoAccionPerfil.getNombreTipoAccionPerfil()));

						if(accionPerfil.getIdAccionPerfil()!=null && accionPerfil.getIdAccionPerfil()>0){
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	public List<UsuarioSeguridad> listarUsuarioSeguridadxEmpresaxRolxFechaCreacion(ConsultaSeguridad consultaSeguridad) throws SSOOrquestadorException {

		List<UsuarioSeguridad> listaUsuarioSeguridad = null;

		AutentificacionContext authenticacionContext = ssoService.obtenerAuthenticationContext(consultaSeguridad.getKeySeguridad());
		//si no está authenticado para la lista de servicios.. no guardar
		if(authenticacionContext!=null && authenticacionContext.getEnterpriseContext() !=null && authenticacionContext.getEnterpriseContext().getBasicContext() !=null){
			try{

				if(consultaSeguridad.getRolContexto()!=null && !"".equals(consultaSeguridad.getRolContexto())){
					Rol rol = ssoClienteRest.buscarRolxNombre(new Rol(consultaSeguridad.getRolContexto()));

					//					if(rol!=null && rol.getIdRol() !=null && rol.getIdRol() >0 ){

					Empresa empresa = ssoClienteRest.buscarEmpresa(new Empresa(authenticacionContext.getEnterpriseContext().getBasicContext().getIdEmpresa()));

					EmpresaUsuario objEmpresaUsuario = ssoClienteRest.buscarEmpresaUsuario(new EmpresaUsuario(empresa, new Usuario(), rol));


					List<EmpresaUsuario> listaEmpresaUsuario = ssoClienteRest.listarEmpresaUsuarioxEmpresaxRol(objEmpresaUsuario);

//					RagnaxSSSO seguridadAplicaciones = (RagnaxSSSO) UtilidadesSeguridad.convertirJsonToObject(consultaSeguridad.getDataRequest(), RagnaxSSSO.class);

					//						listaUsuarioSeguridad = seguridadAplicaciones.getListaUsuarioSeguridad();
					//						List<GrupoUsuario> listaGrupoUsuario = null;
					List<GrupoUsuarioModel> listaGrupoUsuario = ssoService.
							listarUsuarioPerfilMemberxUsuarioxFechaCreacion(listaEmpresaUsuario, null, null);
					//										AppDate.convertirStrFormatYYYY_MM_DDTHH_MM_SSToDate(listaUsuarioSeguridad.get(0).getCreacionMember()) , 
					//										AppDate.convertirStrFormatYYYY_MM_DDTHH_MM_SSToDate(listaUsuarioSeguridad.get(1).getCreacionMember()));

					listaUsuarioSeguridad = SSOOrquestadorMapper.listUsuarioToListUsuario(listaGrupoUsuario,  authenticacionContext, rol);

					//					}


				}

			}catch(Exception e){

			}
		}

		return listaUsuarioSeguridad;
	}

	public List<UsuarioSeguridad> listarAccionPerfil(ConsultaSeguridad consultaSeguridad) throws SSOOrquestadorException {

		List<UsuarioSeguridad> listaUsuarioSeguridad = null;

		//		AutentificacionContext authenticacionContext = ssoService.obtenerAuthenticationContext(consultaSeguridad.getKeySeguridad());
		//		//si no está authenticado para la lista de servicios.. no guardar
		//		if(authenticacionContext!=null && authenticacionContext.getEnterpriseContext() !=null && authenticacionContext.getEnterpriseContext().getBasicContext() !=null){
		//			try{
		//
		//				Rol rol = ssoClienteRest.obtenerRol(new Rol(consultaSeguridad.getRolContexto()));
		//
		//				if(rol!=null && rol.getIdRol() !=null && rol.getIdRol() >0 ){
		//
		//					EmpresaUsuario empresaUsuario = new EmpresaUsuario(authenticacionContext.getEnterpriseContext().getBasicContext().getIdEmpresa(), Integer.parseInt(consultaSeguridad.getUsuario()),
		//							rol.getIdRol(),  ESTADO_CONTEXT_ACTIVO);
		//					
		//					empresaUsuario = factorySeguridadNegocio.getEmpresaUsuarioNegocio().buscarEmpresaUsuarioxEmpresaxUsuarioxRol(empresaUsuario);
		//
		//					if(empresaUsuario!=null && (empresaUsuario.getIdUsuario()!=null && empresaUsuario.getIdUsuario()>0)){
		//						
		//					}
		//
		//					
		////					listaUsuarioSeguridad = ssoService.listUsuarioToListUsuarioEntity(listaGrupoUsuario,  authenticacionContext, rol);
		//
		//					
		//				}	
		//
		//			}catch(Exception e){
		//
		//			}
		//		}

		return listaUsuarioSeguridad;
	}
	
	
	
}
