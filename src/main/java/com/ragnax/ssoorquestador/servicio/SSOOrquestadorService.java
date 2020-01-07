package com.ragnax.ssoorquestador.servicio;

import com.ragnax.ssoorquestador.controller.response.SSOOrquestador;
import com.ragnax.ssoorquestador.exception.SSOOrquestadorException;
import com.ragnax.ssoorquestador.modelo.ConsultaSeguridad;

public interface SSOOrquestadorService {
	
	public SSOOrquestador obtenerBasicContext(String usuarioContext, String passwordUsuario, ConsultaSeguridad consultaSeguridad) throws SSOOrquestadorException;
	
	public SSOOrquestador obtenerEnterpriseContext(String usuarioContext, String passwordUsuario) throws SSOOrquestadorException;
		
	public SSOOrquestador obtenerAutentificacionContext(String usuarioContext, String passwordUsuario, ConsultaSeguridad consultaSeguridad) throws SSOOrquestadorException;
	
	public SSOOrquestador obtenerLoginUsuario(String usuarioContext, String passwordUsuario, ConsultaSeguridad consultaSeguridad) throws SSOOrquestadorException;
	
	public SSOOrquestador obtenerSeguridadContext(String metodo, String producto, String aplicacion, String metodoHttp, String keyAuthenticacion) throws SSOOrquestadorException;
	

}
