package com.ragnax.ssoorquestador.servicio.utilidades;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ragnax.domain.sso.entidad.*;
import com.ragnax.domain.ssoorquestador.modelo.*;





public class SSOOrquestadorMapper {

	public static BasicContext mapToBasicContext(Empresa empresaModel, Rol rol, EmpresaUsuario empresaUsuarioModel, 
			GrupoUsuarioModel grupoUsuarioModel){

		BasicContext basicContext = new BasicContext();

		if(empresaModel!=null){

			if(empresaModel.getIdEmpresa()!=null){
				basicContext.setIdEmpresa(empresaModel.getIdEmpresa());
			}
			basicContext.setRolUnicoIdentificadorEmpresa(empresaModel.getRolUnicoIdentificadorEmpresa()); //rut - ruc - dni
			basicContext.setNombreEmpresa(empresaModel.getNombreEmpresa()); //nombre fantasia
			basicContext.setNombreEmpresaLowerCase(empresaModel.getNombreEmpresaLowerCase());
			basicContext.setDominioEmpresa(empresaModel.getDominioEmpresa());
			basicContext.setRazonSocialEmpresa(empresaModel.getRazonSocialEmpresa()); //nombre legal empresa
			basicContext.setRazonSocialEmpresaLowerCase(empresaModel.getRazonSocialEmpresaLowerCase());
			basicContext.setGiroEmpresa(empresaModel.getGiroEmpresa()); // accion que hace empresa
			basicContext.setDireccionOrigen(empresaModel.getDireccionOrigen());  // ubicacion legal empresa
			basicContext.setCodigoPais(empresaModel.getCodigoPaisPortal());
			//		
			if(empresaModel.getIdRegion()!=null){
				basicContext.setIdRegion(empresaModel.getIdRegion());
			}
			if(empresaModel.getIdComuna()!=null){
				basicContext.setIdComuna(empresaModel.getIdComuna());
			}

			basicContext.setCiudadOrigen(empresaModel.getCiudadOrigen());

		}

		if(empresaUsuarioModel!=null){
			if(empresaUsuarioModel.getIdEmpresaUsuario()!=null){
				basicContext.setIdEmpresaUsuario(empresaUsuarioModel.getIdEmpresaUsuario());
			}
			
			if(empresaUsuarioModel.getIdRol()!=null){
				basicContext.setRolContexto(rol.getNombreRol());
			}
		}

		if(grupoUsuarioModel!=null){
			if(grupoUsuarioModel.getUsuario()!=null && grupoUsuarioModel.getUsuario().getIdUsuario()!=null){
				basicContext.setCodigoUsuario(grupoUsuarioModel.getUsuario().getCodigoUsuarioUnit());
			}

			if(grupoUsuarioModel.getMember()!=null){
				basicContext.setNombreMember(grupoUsuarioModel.getMember().getNombreMember());
				basicContext.setApellidoPaternoMember(grupoUsuarioModel.getMember().getApellidoPaternoMember());
				basicContext.setApellidoMaternoMember(grupoUsuarioModel.getMember().getApellidoMaternoMember());
				basicContext.setTelefonoContactoMember(grupoUsuarioModel.getMember().getTelefonoContactoMember());
				basicContext.setFechaNacimientoMember(grupoUsuarioModel.getMember().getFechaNacimientoMember());
				basicContext.setGeneroMember(grupoUsuarioModel.getMember().getIdGenero()+"");
				basicContext.setFirmaMember(grupoUsuarioModel.getMember().getFirmaMember());
				basicContext.setCreacionMember(grupoUsuarioModel.getMember().getCreacionMember());
				
			}
			
			if(grupoUsuarioModel.getListaIdentificador()!=null && grupoUsuarioModel.getListaIdentificador().size()>0){
				List<Identificador> listaIdentificador = new ArrayList<Identificador>();
				Identificador identificacion = new Identificador();
				for(Identificador identificadorModel:grupoUsuarioModel.getListaIdentificador()){
					identificacion = new Identificador(identificadorModel.getNombreIdentificador(), identificadorModel.getValueIdentificador(), identificadorModel.getCodigoPaisPortal(), null);
					if(identificadorModel.getNombreIdentificador().equalsIgnoreCase("RUT")){
//						identificacion.setValueIdentificador(UtilidadesSSSO.generarPatronRUT(identificacion.getValueIdentificador()));
						identificacion.setValueIdentificador(identificacion.getValueIdentificador());
					}
					listaIdentificador.add(identificacion);
				}
				basicContext.setListaIdentificacion(listaIdentificador);
			}
			
			if(grupoUsuarioModel.getPerfil()!=null){
				basicContext.setUsernamePerfil(grupoUsuarioModel.getPerfil().getUsernamePerfil()); //Nombre del Usuario el del eventual login
				basicContext.setNombrePerfilLowerCase(grupoUsuarioModel.getPerfil().getNombrePerfilLowerCase()); //Nombre del Perfil a ver en la pagina del perfil
				basicContext.setMailPerfil(grupoUsuarioModel.getPerfil().getEmailPerfil());
				basicContext.setPasswordPregunta(grupoUsuarioModel.getPerfil().getPasswordPregunta());
				
				basicContext.setUltimaAccionUsuario(grupoUsuarioModel.getPerfil().getUltimaAccionUsuario());
				basicContext.setUltimaConexionPerfil(grupoUsuarioModel.getPerfil().getUltimaConexionPerfil()); //ultimo momento en el cual el usuario hizo log-In en el servicio
				basicContext.setEstadoPerfilLastBloqueado(grupoUsuarioModel.getPerfil().getEstadoPerfilLastBloqueado());

				if(grupoUsuarioModel.getPerfil().getAnonimo()!=null){
					basicContext.setAnonimo(grupoUsuarioModel.getPerfil().getAnonimo());
				}
			}

			if(grupoUsuarioModel.getConfiguracionEmpresaUsuario()!=null){
				basicContext.setPasswordEmpresaUsuarioContrasenhaFormat(grupoUsuarioModel.getConfiguracionEmpresaUsuario().getPasswordEmpresaUsuarioContrasenhaFormat());

				if(grupoUsuarioModel.getConfiguracionEmpresaUsuario()!=null && grupoUsuarioModel.getConfiguracionEmpresaUsuario().getPasswordEmpresaUsuarioContrasenhaSalto()!=null){
					basicContext.setPasswordEmpresaUsuarioContrasenhaSalto(grupoUsuarioModel.getConfiguracionEmpresaUsuario().getPasswordEmpresaUsuarioContrasenhaSalto());
				}
			}
		}
		basicContext.setKeyBasic("");

		return basicContext;
	}

	public static EnterpriseContext mapToEnterpriseContext(BasicContext basicContext,
			AplicacionEmpresa aplicacionEmpresaModel, AplicacionRol aplicacionRolModel, EmpresaUsuarioAplicacionEmpresa euaeModel){

		EnterpriseContext enterpriseContext = new EnterpriseContext(basicContext);
		if(aplicacionEmpresaModel!=null){
			if(aplicacionEmpresaModel.getIdAplicacionEmpresa()!=null){
				enterpriseContext.setIdAplicacionEmpresa(aplicacionEmpresaModel.getIdAplicacionEmpresa());
			}

			if(aplicacionEmpresaModel.getIdAplicacion()!=null){
				enterpriseContext.setIdAplicacion(aplicacionEmpresaModel.getIdAplicacion().getIdAplicacion());
			}
		}

		if(aplicacionRolModel!=null){
			if(aplicacionRolModel.getIdAplicacionRol()!=null){
				enterpriseContext.setIdAplicacionRol(aplicacionRolModel.getIdAplicacionRol());
			}
		}

		if(euaeModel!=null){
			if(euaeModel.getIdEmpresaUsuarioAplicacionEmpresa()!=null){
				enterpriseContext.setIdEmpresaUsuarioAplicacionEmpresa(euaeModel.getIdEmpresaUsuarioAplicacionEmpresa());
			}
		}

		return enterpriseContext;
	}

	public static AutentificacionContext mapToAuthenticacionContext(EnterpriseContext enterpriseContext, 
			List<AplicacionServicio> listaAplicacionServicioModel){

		AutentificacionContext autentificacionContext = new AutentificacionContext();

		autentificacionContext.setEnterpriseContext(enterpriseContext);
		
		autentificacionContext.setKeyAutentificacion("");
		
		autentificacionContext.setListaAplicacionServicio(listaAplicacionServicioModel);
		
		return autentificacionContext;
	}
	
//	public static List<AplicacionServicio> mapListAplicacionServicioDTOtoListAplicacionServicioModel(List<AplicacionServicioEnterprise> listaAplicacionServicio){
//
//		List<AplicacionServicio> listaAplicacionServicioModel = new ArrayList<AplicacionServicio>();
//		
//		AplicacionServicio aplicacionServicioModel = null;
//		
//		for(AplicacionServicioEnterprise asDTO: listaAplicacionServicio){
//			aplicacionServicioModel = new AplicacionServicio(new Aplicacion(asDTO.getIdAplicacion()), asDTO.getUriRutaAplicacion(), asDTO.getUriRutaAplicacionProducto(),
//					asDTO.getUriRutaAplicacionProductoServicio(), asDTO.getParametroRutaAplicacionProductoServicio(), asDTO.getMetodoHttp(), asDTO.getEstadoAplicacionServicio());
//			listaAplicacionServicioModel.add(aplicacionServicioModel);
//		}
//		
//		
//		return listaAplicacionServicioModel;
//	}
	
	
	
	
	public static SeguridadContext mapToSeguridadContext(AutentificacionContext autentificacionContext, 
			List<SeguridadAplicacionAcceso> listaSeguridadAplicacionAccesoModel){

		SeguridadContext seguridadContext = new SeguridadContext();
		
		if(autentificacionContext!=null){
			seguridadContext.setAutentificacionContext(autentificacionContext);
			seguridadContext.setKeySeguridad("");
			
			List<SeguridadAplicacionAcceso> listaSeguridadAplicacionAcceso = new ArrayList<SeguridadAplicacionAcceso>();
			SeguridadAplicacionAcceso seguridadAplicacionAccesoDTO = null;
			
			for(SeguridadAplicacionAcceso saa:listaSeguridadAplicacionAccesoModel){
				seguridadAplicacionAccesoDTO = new SeguridadAplicacionAcceso(
						saa.getIdEmpresaUsuarioAplicacionEmpresa(), 
						saa.getIdAplicacionServicio(),
						saa.getEstadoSeguridadAplicacionAcceso());
				listaSeguridadAplicacionAcceso.add(seguridadAplicacionAccesoDTO);
			}
			
			seguridadContext.setListaSeguridadAplicacionAcceso(listaSeguridadAplicacionAcceso);
			return seguridadContext;
		}
		
		return null;
	}
	
	
	public static List<UsuarioSeguridad> listUsuarioToListUsuario(List<GrupoUsuarioModel> listaGrupoUsuarioModel, 
			AutentificacionContext autentificacionContext, Rol rolModel){

		List<UsuarioSeguridad> listaUsuarioSeguridad=new ArrayList<UsuarioSeguridad>();

		if(listaGrupoUsuarioModel==null || listaGrupoUsuarioModel.size()==0){
			return new ArrayList<UsuarioSeguridad>();
		}
		else{
			listaUsuarioSeguridad=new ArrayList<UsuarioSeguridad>();
			
			UsuarioSeguridad usuarioSeguridad=new UsuarioSeguridad();
			
			for(GrupoUsuarioModel gruUsuMod: listaGrupoUsuarioModel){
				usuarioSeguridad=new UsuarioSeguridad();
				
				usuarioSeguridad = mapToUsuarioSeguridad(gruUsuMod,  autentificacionContext, rolModel );

				listaUsuarioSeguridad.add(usuarioSeguridad);
			}
		}

		return listaUsuarioSeguridad;
	}
	
	public static UsuarioSeguridad mapToUsuarioSeguridad(GrupoUsuarioModel grupoUsuarioModel, AutentificacionContext autentificacionContext, Rol rolModel){

		UsuarioSeguridad usuarioSeguridad=new UsuarioSeguridad();
		
		if(grupoUsuarioModel==null){
			return new UsuarioSeguridad();
		}
		else{
			usuarioSeguridad.setIdUsuario(grupoUsuarioModel.getUsuario().getIdUsuario());
			usuarioSeguridad.setPasswordContrasenha("");
			usuarioSeguridad.setPasswordRespuesta("");
			usuarioSeguridad.setPasswordPregunta(grupoUsuarioModel.getPerfil().getPasswordPregunta());
			
			
			usuarioSeguridad.setIdEmpresa(autentificacionContext.getEnterpriseContext().getBasicContext().getIdEmpresa());
			usuarioSeguridad.setNombreRol(rolModel.getNombreRolLowerCase());
			
			Map<String, String> mapaIdentificador = new HashMap<String, String>();
		
			for(Identificador im:grupoUsuarioModel.getListaIdentificador()){
				mapaIdentificador.put(im.getNombreIdentificador().toUpperCase(), im.getValueIdentificador());
			}
			usuarioSeguridad.setMapaIdentificador(mapaIdentificador);
			
//			usuarioSeguridad.setRutMember(grupoUsuarioModel.getMember().getRutMember());
			usuarioSeguridad.setNombreMember(grupoUsuarioModel.getMember().getNombreMember());
			usuarioSeguridad.setApellidoPaterno(grupoUsuarioModel.getMember().getApellidoPaternoMember());
			usuarioSeguridad.setApellidoMaterno(grupoUsuarioModel.getMember().getApellidoMaternoMember());
			usuarioSeguridad.setMailUsuario(grupoUsuarioModel.getPerfil().getEmailPerfil());
			usuarioSeguridad.setTelefonoContactoMember(grupoUsuarioModel.getMember().getTelefonoContactoMember());
			usuarioSeguridad.setFechaNacimientoMember(grupoUsuarioModel.getMember().getFechaNacimientoMember());
			usuarioSeguridad.setGeneroMember(grupoUsuarioModel.getMember().getIdGenero()+"");
			usuarioSeguridad.setFirmaMember(grupoUsuarioModel.getMember().getFirmaMember());
			usuarioSeguridad.setCreacionMember(grupoUsuarioModel.getMember().getCreacionMember());
			usuarioSeguridad.setUsernamePerfil(grupoUsuarioModel.getPerfil().getUsernamePerfil());
			usuarioSeguridad.setNombrePerfilLowerCase(grupoUsuarioModel.getPerfil().getNombrePerfilLowerCase());
						
			usuarioSeguridad.setUltimaAccionUsuario(grupoUsuarioModel.getPerfil().getUltimaAccionUsuario());
			usuarioSeguridad.setUltimaConexionPerfil(grupoUsuarioModel.getPerfil().getUltimaConexionPerfil());
			usuarioSeguridad.setEstadoPerfilLastBloqueado(grupoUsuarioModel.getPerfil().getEstadoPerfilLastBloqueado()); 
			usuarioSeguridad.setAnonimo(grupoUsuarioModel.getPerfil().getAnonimo());
			
		}

		return usuarioSeguridad;
	}
	




}