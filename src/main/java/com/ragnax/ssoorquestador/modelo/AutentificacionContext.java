package com.ragnax.ssoorquestador.modelo;

import java.io.Serializable;
import java.util.List;

import com.ragnax.ssoorquestador.servicio.clientes.modelo.AplicacionServicio;

public class AutentificacionContext implements Serializable{

	private static final long serialVersionUID = -5186392881448190533L;

	private EnterpriseContext enterpriseContext;
	private String keyAutentificacion;
	private List<AplicacionServicio> listaAplicacionServicio;


	public AutentificacionContext() {
		super();
	}

	public AutentificacionContext(EnterpriseContext enterpriseContext, String keyAutentificacion
			,List<AplicacionServicio> listaAplicacionServicio
			) {
		super();
		this.enterpriseContext = enterpriseContext;
		this.keyAutentificacion = keyAutentificacion;
		this.listaAplicacionServicio = listaAplicacionServicio;

	}

	public EnterpriseContext getEnterpriseContext() {
		return enterpriseContext;
	}

	public String getKeyAutentificacion() {
		return keyAutentificacion;
	}

	public List<AplicacionServicio> getListaAplicacionServicio() {
		return listaAplicacionServicio;
	}

	public void setEnterpriseContext(EnterpriseContext enterpriseContext) {
		this.enterpriseContext = enterpriseContext;
	}

	public void setKeyAutentificacion(String keyAutentificacion) {
		this.keyAutentificacion = keyAutentificacion;
	}

	public void setListaAplicacionServicio(List<AplicacionServicio> listaAplicacionServicio) {
		this.listaAplicacionServicio = listaAplicacionServicio;
	}

}
