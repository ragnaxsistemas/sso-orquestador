package com.ragnax.ssoorquestador.servicio.clientes.modelo;

public class EmpresaUsuario {

	private Integer idEmpresaUsuario;

	private Empresa idEmpresa;
	
	private Usuario idUsuario;

	private Rol idRol;

	private Boolean estadoEmpresaUsuario;
	
//	private List<EmpresaUsuarioAplicacionEmpresa> empresas_usuarios_aplicaciones_empresas;

	public EmpresaUsuario() {
		super();
	}
	
	public EmpresaUsuario(Empresa idEmpresa, Usuario idUsuario, Rol idRol) {
		super();
		this.idEmpresa = idEmpresa;
		this.idUsuario = idUsuario;
		this.idRol = idRol;
	}

	public Integer getIdEmpresaUsuario() {
		return idEmpresaUsuario;
	}

	public void setIdEmpresaUsuario(Integer idEmpresaUsuario) {
		this.idEmpresaUsuario = idEmpresaUsuario;
	}

	public Empresa getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Empresa idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Rol getIdRol() {
		return idRol;
	}

	public void setIdRol(Rol idRol) {
		this.idRol = idRol;
	}

	public Boolean getEstadoEmpresaUsuario() {
		return estadoEmpresaUsuario;
	}

	public void setEstadoEmpresaUsuario(Boolean estadoEmpresaUsuario) {
		this.estadoEmpresaUsuario = estadoEmpresaUsuario;
	}
}
