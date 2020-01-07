package com.ragnax.ssoorquestador.servicio.clientes.modelo;

public class Genero{
 
	private Integer idGenero;
	
	private String nombreGenero;
	
	private String descripcionGenero;
	
	private Boolean estadoGenero;
	
//	private List<Member> members_generos;
	
	public Genero() {
		super();
	}
	
	public Genero(String nombreGenero) {
		super();
		this.nombreGenero = nombreGenero;
	}
	
	public Genero(String nombreGenero, String descripcionGenero) {
		super();
		this.nombreGenero = nombreGenero;
		this.descripcionGenero = descripcionGenero;
	}

	public Integer getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(Integer idGenero) {
		this.idGenero = idGenero;
	}

	public String getNombreGenero() {
		return nombreGenero;
	}

	public void setNombreGenero(String nombreGenero) {
		this.nombreGenero = nombreGenero;
	}

	public String getDescripcionGenero() {
		return descripcionGenero;
	}

	public void setDescripcionGenero(String descripcionGenero) {
		this.descripcionGenero = descripcionGenero;
	}

	public Boolean getEstadoGenero() {
		return estadoGenero;
	}

	public void setEstadoGenero(Boolean estadoGenero) {
		this.estadoGenero = estadoGenero;
	}
}
