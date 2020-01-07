package com.ragnax.ssoorquestador.servicio.clientes.modelo;

public class AplicacionEmpresa{

	private Integer idAplicacionEmpresa;

	private Aplicacion idAplicacion;
	
	private Empresa idEmpresa;
	
	
	private Boolean estadoAplicacionEmpresa;
	
//	private List<EmpresaUsuarioAplicacionEmpresa> empresas_usuarios_aplicaciones_empresas;
	
	public AplicacionEmpresa() {
		super();
	}
	
	public AplicacionEmpresa(Aplicacion idAplicacion, Empresa idEmpresa) {
		super();
		this.idAplicacion = idAplicacion;
		this.idEmpresa = idEmpresa;
	}

	public Integer getIdAplicacionEmpresa() {
		return idAplicacionEmpresa;
	}

	public void setIdAplicacionEmpresa(Integer idAplicacionEmpresa) {
		this.idAplicacionEmpresa = idAplicacionEmpresa;
	}

	public Aplicacion getIdAplicacion() {
		return idAplicacion;
	}

	public void setIdAplicacion(Aplicacion idAplicacion) {
		this.idAplicacion = idAplicacion;
	}

	public Empresa getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Empresa idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Boolean getEstadoAplicacionEmpresa() {
		return estadoAplicacionEmpresa;
	}

	public void setEstadoAplicacionEmpresa(Boolean estadoAplicacionEmpresa) {
		this.estadoAplicacionEmpresa = estadoAplicacionEmpresa;
	}

	
}
