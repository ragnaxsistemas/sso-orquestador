package com.ragnax.ssoorquestador.servicio.clientes.modelo;

import java.lang.String;
import java.sql.Timestamp;

public class FotoPerfil{
 
	private Integer idFotoPerfil;

	private Timestamp uploadFotoPerfil;

	private Timestamp changeFotoPerfil;

	private String repositorioFotoPerfil;

	private String keyFotoPerfil;

	private Perfil idPerfil;
	
	//Un Perfil "member" puede tener muchos usuarios.(compartir sessiones - gerentes) 
	//pero un usuario jcornej solo puede estar en un Perfil 
	public FotoPerfil() {
		super();
	}

	public FotoPerfil(String repositorioFotoPerfil, String keyFotoPerfil, Perfil idPerfil) {
		super();
		this.repositorioFotoPerfil = repositorioFotoPerfil;
		this.keyFotoPerfil = keyFotoPerfil;
		this.idPerfil = idPerfil;
	}

	public Integer getIdFotoPerfil() {
		return idFotoPerfil;
	}

	public void setIdFotoPerfil(Integer idFotoPerfil) {
		this.idFotoPerfil = idFotoPerfil;
	}

	public Timestamp getUploadFotoPerfil() {
		return uploadFotoPerfil;
	}

	public void setUploadFotoPerfil(Timestamp uploadFotoPerfil) {
		this.uploadFotoPerfil = uploadFotoPerfil;
	}

	public Timestamp getChangeFotoPerfil() {
		return changeFotoPerfil;
	}

	public void setChangeFotoPerfil(Timestamp changeFotoPerfil) {
		this.changeFotoPerfil = changeFotoPerfil;
	}

	public String getRepositorioFotoPerfil() {
		return repositorioFotoPerfil;
	}

	public void setRepositorioFotoPerfil(String repositorioFotoPerfil) {
		this.repositorioFotoPerfil = repositorioFotoPerfil;
	}

	public String getKeyFotoPerfil() {
		return keyFotoPerfil;
	}

	public void setKeyFotoPerfil(String keyFotoPerfil) {
		this.keyFotoPerfil = keyFotoPerfil;
	}

	public Perfil getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Perfil idPerfil) {
		this.idPerfil = idPerfil;
	}
	
}
