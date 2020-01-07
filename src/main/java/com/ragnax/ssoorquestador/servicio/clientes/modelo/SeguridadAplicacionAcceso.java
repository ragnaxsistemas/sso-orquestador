package com.ragnax.ssoorquestador.servicio.clientes.modelo;

public class SeguridadAplicacionAcceso{


	private Integer idSeguridadAplicacionAcceso;

	private EmpresaUsuarioAplicacionEmpresa idEmpresaUsuarioAplicacionEmpresa;

	private AplicacionServicio idAplicacionServicio;

	private Boolean estadoSeguridadAplicacionAcceso;

	public SeguridadAplicacionAcceso() {
		super();
	}
	
	public SeguridadAplicacionAcceso(EmpresaUsuarioAplicacionEmpresa idEmpresaUsuarioAplicacionEmpresa,
			AplicacionServicio idAplicacionServicio) {
		super();
		this.idEmpresaUsuarioAplicacionEmpresa = idEmpresaUsuarioAplicacionEmpresa;
		this.idAplicacionServicio = idAplicacionServicio;
	}
	
	public SeguridadAplicacionAcceso(EmpresaUsuarioAplicacionEmpresa idEmpresaUsuarioAplicacionEmpresa,
			AplicacionServicio idAplicacionServicio, Boolean estadoSeguridadAplicacionAcceso) {
		super();
		this.idEmpresaUsuarioAplicacionEmpresa = idEmpresaUsuarioAplicacionEmpresa;
		this.idAplicacionServicio = idAplicacionServicio;
		this.estadoSeguridadAplicacionAcceso = estadoSeguridadAplicacionAcceso;
	}

	public Integer getIdSeguridadAplicacionAcceso() {
		return idSeguridadAplicacionAcceso;
	}

	public void setIdSeguridadAplicacionAcceso(Integer idSeguridadAplicacionAcceso) {
		this.idSeguridadAplicacionAcceso = idSeguridadAplicacionAcceso;
	}

	public EmpresaUsuarioAplicacionEmpresa getIdEmpresaUsuarioAplicacionEmpresa() {
		return idEmpresaUsuarioAplicacionEmpresa;
	}

	public void setIdEmpresaUsuarioAplicacionEmpresa(EmpresaUsuarioAplicacionEmpresa idEmpresaUsuarioAplicacionEmpresa) {
		this.idEmpresaUsuarioAplicacionEmpresa = idEmpresaUsuarioAplicacionEmpresa;
	}

	public AplicacionServicio getIdAplicacionServicio() {
		return idAplicacionServicio;
	}

	public void setIdAplicacionServicio(AplicacionServicio idAplicacionServicio) {
		this.idAplicacionServicio = idAplicacionServicio;
	}

	public Boolean getEstadoSeguridadAplicacionAcceso() {
		return estadoSeguridadAplicacionAcceso;
	}

	public void setEstadoSeguridadAplicacionAcceso(Boolean estadoSeguridadAplicacionAcceso) {
		this.estadoSeguridadAplicacionAcceso = estadoSeguridadAplicacionAcceso;
	}
	
}
