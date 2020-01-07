package com.ragnax.ssoorquestador.servicio.clientes.modelo;

import java.lang.String;

public class Maquina{
 
	private Integer idMaquina;

	private String direccionIpMaquina;
	
	private String nombreIpMaquina; //nombre fantasia
	
//	private List<MaquinaEmpresa> maquinas_empresas;
	
	public Maquina() {
		super();
	}

	public Integer getIdMaquina() {
		return idMaquina;
	}

	public void setIdMaquina(Integer idMaquina) {
		this.idMaquina = idMaquina;
	}

	public String getDireccionIpMaquina() {
		return direccionIpMaquina;
	}

	public void setDireccionIpMaquina(String direccionIpMaquina) {
		this.direccionIpMaquina = direccionIpMaquina;
	}

	public String getNombreIpMaquina() {
		return nombreIpMaquina;
	}

	public void setNombreIpMaquina(String nombreIpMaquina) {
		this.nombreIpMaquina = nombreIpMaquina;
	}

}
