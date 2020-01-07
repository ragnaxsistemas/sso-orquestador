package com.ragnax.ssoorquestador.servicio.clientes.modelo;

import java.lang.String;
import java.sql.Timestamp;

public class Aplicacion{

	private Integer idAplicacion;

	private String nombreAplicacion; //Nombre del componente Mostrar no es el nombre en la Uri.
	
	private String nombreAplicacionLowerCase; //Nombre del componente Mostrar no es el nombre en la Uri.

	private String uriRuta; //codigo unico como el dominio
	
	private String codigoAplicacion; //codigo unico
	
	private String descripcionAplicacion; //nombre a comprobar

	private Timestamp fechaCreacionAplicacion;

//	private List<AplicacionEmpresa> aplicaciones_empresas;
//	
//	private List<AplicacionRol> aplicaciones_roles;
//	
//	private List<AplicacionServicio> aplicaciones_servicios;
	
	public Aplicacion() {
		super();
	}
	
	public Aplicacion(Object idAplicacion) {
		super();
		this.idAplicacion = (idAplicacion instanceof Integer) ? (Integer) idAplicacion : 0;
	}
	
	public Aplicacion(String nombreAplicacion, String uriRuta, String codigoAplicacion, String descripcionAplicacion) {
		super();
		this.nombreAplicacion = nombreAplicacion;
		this.uriRuta = uriRuta;
		this.codigoAplicacion = codigoAplicacion;
		this.descripcionAplicacion = descripcionAplicacion;
	}

	public Integer getIdAplicacion() {
		return idAplicacion;
	}

	public void setIdAplicacion(Integer idAplicacion) {
		this.idAplicacion = idAplicacion;
	}

	public String getNombreAplicacion() {
		return nombreAplicacion;
	}

	public void setNombreAplicacion(String nombreAplicacion) {
		this.nombreAplicacion = nombreAplicacion;
	}

	public String getNombreAplicacionLowerCase() {
		return nombreAplicacionLowerCase;
	}

	public void setNombreAplicacionLowerCase(String nombreAplicacionLowerCase) {
		this.nombreAplicacionLowerCase = nombreAplicacionLowerCase;
	}

	public String getUriRuta() {
		return uriRuta;
	}

	public void setUriRuta(String uriRuta) {
		this.uriRuta = uriRuta;
	}

	public String getCodigoAplicacion() {
		return codigoAplicacion;
	}

	public void setCodigoAplicacion(String codigoAplicacion) {
		this.codigoAplicacion = codigoAplicacion;
	}

	public String getDescripcionAplicacion() {
		return descripcionAplicacion;
	}

	public void setDescripcionAplicacion(String descripcionAplicacion) {
		this.descripcionAplicacion = descripcionAplicacion;
	}

	public Timestamp getFechaCreacionAplicacion() {
		return fechaCreacionAplicacion;
	}

	public void setFechaCreacionAplicacion(Timestamp fechaCreacionAplicacion) {
		this.fechaCreacionAplicacion = fechaCreacionAplicacion;
	}
	
}
