package com.ragnax.ssoorquestador.servicio.clientes.modelo;

public class TipoAccionPerfil{
 
	private Integer idTipoAccionPerfil;

	private String nombreTipoAccionPerfil;

	private String descripcionTipoAccionPerfil;

//	private List<AccionPerfil> acciones_perfiles_perfiles;
	
	public TipoAccionPerfil() {
		super();
	}

	public TipoAccionPerfil(String nombreTipoAccionPerfil, String descripcionTipoAccionPerfil) {
		super();
		this.nombreTipoAccionPerfil = nombreTipoAccionPerfil;
		this.descripcionTipoAccionPerfil = descripcionTipoAccionPerfil;
	}

	public Integer getIdTipoAccionPerfil() {
		return idTipoAccionPerfil;
	}


	public void setIdTipoAccionPerfil(Integer idTipoAccionPerfil) {
		this.idTipoAccionPerfil = idTipoAccionPerfil;
	}


	public String getNombreTipoAccionPerfil() {
		return nombreTipoAccionPerfil;
	}


	public void setNombreTipoAccionPerfil(String nombreTipoAccionPerfil) {
		this.nombreTipoAccionPerfil = nombreTipoAccionPerfil;
	}


	public String getDescripcionTipoAccionPerfil() {
		return descripcionTipoAccionPerfil;
	}


	public void setDescripcionTipoAccionPerfil(String descripcionTipoAccionPerfil) {
		this.descripcionTipoAccionPerfil = descripcionTipoAccionPerfil;
	}
	
}
