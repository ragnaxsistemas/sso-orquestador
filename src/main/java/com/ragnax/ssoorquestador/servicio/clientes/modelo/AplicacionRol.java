package com.ragnax.ssoorquestador.servicio.clientes.modelo;

public class AplicacionRol{

	private Integer idAplicacionRol;

	private Aplicacion idAplicacion;

	private Rol idRol;
	
	private Boolean estadoAplicacionRol;
	
	public AplicacionRol() {
		super();
	}
	
	public AplicacionRol(Aplicacion idAplicacion, Rol idRol) {
		super();
		this.idAplicacion = idAplicacion;
		this.idRol = idRol;
	}

	public Integer getIdAplicacionRol() {
		return idAplicacionRol;
	}

	public void setIdAplicacionRol(Integer idAplicacionRol) {
		this.idAplicacionRol = idAplicacionRol;
	}

	public Aplicacion getIdAplicacion() {
		return idAplicacion;
	}

	public void setIdAplicacion(Aplicacion idAplicacion) {
		this.idAplicacion = idAplicacion;
	}

	public Rol getIdRol() {
		return idRol;
	}

	public void setIdRol(Rol idRol) {
		this.idRol = idRol;
	}

	public Boolean getEstadoAplicacionRol() {
		return estadoAplicacionRol;
	}

	public void setEstadoAplicacionRol(Boolean estadoAplicacionRol) {
		this.estadoAplicacionRol = estadoAplicacionRol;
	}
	
}
