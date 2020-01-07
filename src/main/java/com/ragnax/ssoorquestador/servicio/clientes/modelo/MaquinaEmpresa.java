package com.ragnax.ssoorquestador.servicio.clientes.modelo;

public class MaquinaEmpresa{
 
	private Integer idMaquinaEmpresa;
	
	private Empresa idEmpresa;
	
	private Maquina idMaquina;
	
	public MaquinaEmpresa() {
		super();
	}
	
	public MaquinaEmpresa(Empresa idEmpresa, Maquina idMaquina) {
		super();
		this.idEmpresa = idEmpresa;
		this.idMaquina = idMaquina;
	}

	public Integer getIdMaquinaEmpresa() {
		return idMaquinaEmpresa;
	}

	public void setIdMaquinaEmpresa(Integer idMaquinaEmpresa) {
		this.idMaquinaEmpresa = idMaquinaEmpresa;
	}

	public Empresa getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Empresa idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Maquina getIdMaquina() {
		return idMaquina;
	}

	public void setIdMaquina(Maquina idMaquina) {
		this.idMaquina = idMaquina;
	}
	
}
