package com.ragnax.ssoorquestador.servicio.clientes.modelo;

public class Rol{
 
	private Integer idRol;

	private String nombreRol; //Nombre a Mostrar

	private String nombreRolLowerCase; //nombre a comprobar

	private String descripcionRol;
	
	private Boolean estadoRol;
	
//	private List<AplicacionRol> aplicaciones_roles;
	
//	private List<EmpresaUsuario> empresas_usuarios;
	
	public Rol() {
		super();
	}
	
	public Rol(String nombreRol) {
		super();
		this.nombreRol = nombreRol;
	}

	public Integer getIdRol() {
		return idRol;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public String getNombreRolLowerCase() {
		return nombreRolLowerCase;
	}

	public String getDescripcionRol() {
		return descripcionRol;
	}

	public Boolean getEstadoRol() {
		return estadoRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public void setNombreRolLowerCase(String nombreRolLowerCase) {
		this.nombreRolLowerCase = nombreRolLowerCase;
	}

	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
	}

	public void setEstadoRol(Boolean estadoRol) {
		this.estadoRol = estadoRol;
	}

}
