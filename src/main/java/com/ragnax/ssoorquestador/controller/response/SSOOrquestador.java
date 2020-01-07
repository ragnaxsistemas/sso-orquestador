package com.ragnax.ssoorquestador.controller.response;

import java.io.Serializable;
import java.util.List;

import com.ragnax.ssoorquestador.modelo.AutentificacionContext;
import com.ragnax.ssoorquestador.modelo.BasicContext;
import com.ragnax.ssoorquestador.modelo.EnterpriseContext;
import com.ragnax.ssoorquestador.modelo.SeguridadContext;
import com.ragnax.ssoorquestador.modelo.TipoAccionUsuario;
import com.ragnax.ssoorquestador.modelo.UsuarioSeguridad;

public class SSOOrquestador implements Serializable{

	private static final long serialVersionUID = -4301293450469130528L;

//	private ResponseSeguridad responseSeguridad;
	private BasicContext basicContext;
	private EnterpriseContext enterpriseContext;
	private AutentificacionContext autentificacionContext;
	private SeguridadContext seguridadContext;
	
	private List<UsuarioSeguridad> listaUsuarioSeguridad;
	
	private List<TipoAccionUsuario> listaTipoAccionUsuario;
	
	private String sSessionPLataforma;
	
	public SSOOrquestador() {
		super();
	}
	
	public SSOOrquestador(BasicContext basicContext) {
		super();
		this.basicContext = basicContext;
	}
	
	public SSOOrquestador(SeguridadContext seguridadContext) {
		super();
		this.seguridadContext = seguridadContext;
	}
	
	public SSOOrquestador(EnterpriseContext enterpriseContext) {
		super();
		this.enterpriseContext = enterpriseContext;
	}
	
	public SSOOrquestador(AutentificacionContext autentificacionContext) {
		super();
		this.autentificacionContext = autentificacionContext;
	}
	
//	public ResponseSeguridad getResponseSeguridad() {
//		return responseSeguridad;
//	}
//
//	public void setResponseSeguridad(ResponseSeguridad responseSeguridad) {
//		this.responseSeguridad = responseSeguridad;
//	}

	public BasicContext getBasicContext() {
		return basicContext;
	}

	public void setBasicContext(BasicContext basicContext) {
		this.basicContext = basicContext;
	}

	public EnterpriseContext getEnterpriseContext() {
		return enterpriseContext;
	}

	public void setEnterpriseContext(EnterpriseContext enterpriseContext) {
		this.enterpriseContext = enterpriseContext;
	}

	public AutentificacionContext getAutentificacionContext() {
		return autentificacionContext;
	}

	public void setAutentificacionContext(AutentificacionContext autentificacionContext) {
		this.autentificacionContext = autentificacionContext;
	}

	public SeguridadContext getSeguridadContext() {
		return seguridadContext;
	}

	public void setSeguridadContext(SeguridadContext seguridadContext) {
		this.seguridadContext = seguridadContext;
	}

	public List<UsuarioSeguridad> getListaUsuarioSeguridad() {
		return listaUsuarioSeguridad;
	}

	public void setListaUsuarioSeguridad(List<UsuarioSeguridad> listaUsuarioSeguridad) {
		this.listaUsuarioSeguridad = listaUsuarioSeguridad;
	}

	public List<TipoAccionUsuario> getListaTipoAccionUsuario() {
		return listaTipoAccionUsuario;
	}

	public void setListaTipoAccionUsuario(List<TipoAccionUsuario> listaTipoAccionUsuario) {
		this.listaTipoAccionUsuario = listaTipoAccionUsuario;
	}

	public String getsSessionPLataforma() {
		return sSessionPLataforma;
	}

	public void setsSessionPLataforma(String sSessionPLataforma) {
		this.sSessionPLataforma = sSessionPLataforma;
	}
	
}
