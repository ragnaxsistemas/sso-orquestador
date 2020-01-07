package com.ragnax.ssoorquestador.servicio.clientes.modelo;

public class Identificador{
 

	private Integer idIdentificador;

	private String nombreIdentificador;
	
	private String valueIdentificador;

	private String codigoPaisPortal;

	private Member idMember;
	
	public Identificador() {
		super();
	}
	
	public Identificador(String nombreIdentificador, String valueIdentificador, String codigoPaisPortal,
			Member idMember) {
		super();
		this.nombreIdentificador = nombreIdentificador;
		this.valueIdentificador = valueIdentificador;
		this.codigoPaisPortal = codigoPaisPortal;
		this.idMember = idMember;
	}

	public Integer getIdIdentificador() {
		return idIdentificador;
	}

	public void setIdIdentificador(Integer idIdentificador) {
		this.idIdentificador = idIdentificador;
	}

	public String getNombreIdentificador() {
		return nombreIdentificador;
	}

	public void setNombreIdentificador(String nombreIdentificador) {
		this.nombreIdentificador = nombreIdentificador;
	}

	public String getValueIdentificador() {
		return valueIdentificador;
	}

	public void setValueIdentificador(String valueIdentificador) {
		this.valueIdentificador = valueIdentificador;
	}

	public String getCodigoPaisPortal() {
		return codigoPaisPortal;
	}

	public void setCodigoPaisPortal(String codigoPaisPortal) {
		this.codigoPaisPortal = codigoPaisPortal;
	}

	public Member getIdMember() {
		return idMember;
	}

	public void setIdMember(Member idMember) {
		this.idMember = idMember;
	}
	
}
