package com.ragnax.ssoorquestador.servicio.clientes.modelo;

import java.sql.Timestamp;

public class SeguridadSessionPlataforma{

	private Integer idSeguridadSessionPlataforma;

	private String keySeguridadSessionPlataforma;

	private String value64SeguridadSessionPlataforma;

	private Integer estadoSeguridadSessionPlataforma;

	private Timestamp fechaCreacionSeguridadSessionPlataforma;

	private Timestamp fechaExpiracionSeguridadSessionPlataforma;

	public SeguridadSessionPlataforma() {
		super();
	}

	public Integer getIdSeguridadSessionPlataforma() {
		return idSeguridadSessionPlataforma;
	}

	public void setIdSeguridadSessionPlataforma(Integer idSeguridadSessionPlataforma) {
		this.idSeguridadSessionPlataforma = idSeguridadSessionPlataforma;
	}

	public String getKeySeguridadSessionPlataforma() {
		return keySeguridadSessionPlataforma;
	}

	public void setKeySeguridadSessionPlataforma(String keySeguridadSessionPlataforma) {
		this.keySeguridadSessionPlataforma = keySeguridadSessionPlataforma;
	}

	public String getValue64SeguridadSessionPlataforma() {
		return value64SeguridadSessionPlataforma;
	}

	public void setValue64SeguridadSessionPlataforma(String value64SeguridadSessionPlataforma) {
		this.value64SeguridadSessionPlataforma = value64SeguridadSessionPlataforma;
	}

	public Integer getEstadoSeguridadSessionPlataforma() {
		return estadoSeguridadSessionPlataforma;
	}

	public void setEstadoSeguridadSessionPlataforma(Integer estadoSeguridadSessionPlataforma) {
		this.estadoSeguridadSessionPlataforma = estadoSeguridadSessionPlataforma;
	}

	public Timestamp getFechaCreacionSeguridadSessionPlataforma() {
		return fechaCreacionSeguridadSessionPlataforma;
	}

	public void setFechaCreacionSeguridadSessionPlataforma(Timestamp fechaCreacionSeguridadSessionPlataforma) {
		this.fechaCreacionSeguridadSessionPlataforma = fechaCreacionSeguridadSessionPlataforma;
	}

	public Timestamp getFechaExpiracionSeguridadSessionPlataforma() {
		return fechaExpiracionSeguridadSessionPlataforma;
	}

	public void setFechaExpiracionSeguridadSessionPlataforma(Timestamp fechaExpiracionSeguridadSessionPlataforma) {
		this.fechaExpiracionSeguridadSessionPlataforma = fechaExpiracionSeguridadSessionPlataforma;
	}

	

	
}

