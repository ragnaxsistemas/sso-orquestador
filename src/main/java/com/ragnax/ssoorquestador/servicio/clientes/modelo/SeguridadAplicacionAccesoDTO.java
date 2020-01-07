package com.ragnax.ssoorquestador.servicio.clientes.modelo;

import java.io.Serializable;

public class SeguridadAplicacionAccesoDTO  implements Serializable{

	private static final long serialVersionUID = -305187828392226198L;
	
	private int idEmpresaUsuarioAplicacionServicio;
	private int idAplicacionServicio;
	private int estadoSeguridadAplicacionAcceso;

	public SeguridadAplicacionAccesoDTO() {
		super();
	}
	
	public SeguridadAplicacionAccesoDTO(int idEmpresaUsuarioAplicacionServicio, int estadoSeguridadAplicacionAcceso) {
		super();
		this.idEmpresaUsuarioAplicacionServicio = idEmpresaUsuarioAplicacionServicio;
		this.estadoSeguridadAplicacionAcceso = estadoSeguridadAplicacionAcceso;
	}
	
	public SeguridadAplicacionAccesoDTO(int idEmpresaUsuarioAplicacionServicio, int idAplicacionServicio,
			int estadoSeguridadAplicacionAcceso) {
		super();
		this.idEmpresaUsuarioAplicacionServicio = idEmpresaUsuarioAplicacionServicio;
		this.idAplicacionServicio = idAplicacionServicio;
		this.estadoSeguridadAplicacionAcceso = estadoSeguridadAplicacionAcceso;
	}

	public int getIdEmpresaUsuarioAplicacionServicio() {
		return idEmpresaUsuarioAplicacionServicio;
	}

	public int getIdAplicacionServicio() {
		return idAplicacionServicio;
	}

	public int getEstadoSeguridadAplicacionAcceso() {
		return estadoSeguridadAplicacionAcceso;
	}

	public void setIdEmpresaUsuarioAplicacionServicio(int idEmpresaUsuarioAplicacionServicio) {
		this.idEmpresaUsuarioAplicacionServicio = idEmpresaUsuarioAplicacionServicio;
	}

	public void setIdAplicacionServicio(int idAplicacionServicio) {
		this.idAplicacionServicio = idAplicacionServicio;
	}

	public void setEstadoSeguridadAplicacionAcceso(int estadoSeguridadAplicacionAcceso) {
		this.estadoSeguridadAplicacionAcceso = estadoSeguridadAplicacionAcceso;
	}

	
	
}
