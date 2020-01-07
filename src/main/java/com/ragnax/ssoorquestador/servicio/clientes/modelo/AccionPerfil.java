package com.ragnax.ssoorquestador.servicio.clientes.modelo;

import java.lang.String;
import java.sql.Timestamp;

public class AccionPerfil{
 
	private Integer idAccionPerfil;
	
	private Timestamp ultimaAccionPerfil;
	
	private Perfil idPerfil;
	
	private TipoAccionPerfil idTipoAccionPerfil;
	
	private String keyAccionPerfil;
	
	//Un Perfil "member" puede tener muchos usuarios.(compartir sessiones - gerentes) 
	//pero un usuario jcornej solo puede estar en un Perfil 
	public AccionPerfil() {
		super();
	}
	
	public AccionPerfil(Object idAccionPerfil) {
		super();
		this.idAccionPerfil = (idAccionPerfil instanceof Integer) ? (Integer) idAccionPerfil : 0;
	}
	
	public AccionPerfil(Perfil idPerfil, TipoAccionPerfil idTipoAccionPerfil, String keyAccionPerfil) {
		super();
		this.idPerfil = idPerfil;
		this.idTipoAccionPerfil = idTipoAccionPerfil;
		this.keyAccionPerfil = keyAccionPerfil;
	}

	public Integer getIdAccionPerfil() {
		return idAccionPerfil;
	}

	public void setIdAccionPerfil(Integer idAccionPerfil) {
		this.idAccionPerfil = idAccionPerfil;
	}

	public Timestamp getUltimaAccionPerfil() {
		return ultimaAccionPerfil;
	}

	public void setUltimaAccionPerfil(Timestamp ultimaAccionPerfil) {
		this.ultimaAccionPerfil = ultimaAccionPerfil;
	}

	public Perfil getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Perfil idPerfil) {
		this.idPerfil = idPerfil;
	}

	public TipoAccionPerfil getIdTipoAccionPerfil() {
		return idTipoAccionPerfil;
	}

	public void setIdTipoAccionPerfil(TipoAccionPerfil idTipoAccionPerfil) {
		this.idTipoAccionPerfil = idTipoAccionPerfil;
	}

	public String getKeyAccionPerfil() {
		return keyAccionPerfil;
	}

	public void setKeyAccionPerfil(String keyAccionPerfil) {
		this.keyAccionPerfil = keyAccionPerfil;
	}
}
