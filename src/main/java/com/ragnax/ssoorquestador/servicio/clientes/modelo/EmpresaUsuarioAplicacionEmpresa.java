package com.ragnax.ssoorquestador.servicio.clientes.modelo;

public class EmpresaUsuarioAplicacionEmpresa {
 
	private Integer idEmpresaUsuarioAplicacionEmpresa;
	
	private EmpresaUsuario idEmpresaUsuario;
	
	private AplicacionEmpresa idAplicacionEmpresa;
	
	private Boolean estadoEmpresaUsuarioAplicacionEmpresa;
	
//	private List<SeguridadAplicacionAcceso> seguridades_aplicaciones_accesos;
	
	public EmpresaUsuarioAplicacionEmpresa() {
		super();
	}
	
	public EmpresaUsuarioAplicacionEmpresa(EmpresaUsuario idEmpresaUsuario) {
		super();
		this.idEmpresaUsuario = idEmpresaUsuario;
	}
	
	public EmpresaUsuarioAplicacionEmpresa(EmpresaUsuario idEmpresaUsuario, AplicacionEmpresa idAplicacionEmpresa) {
		super();
		this.idEmpresaUsuario = idEmpresaUsuario;
		this.idAplicacionEmpresa = idAplicacionEmpresa;
	}

	public Integer getIdEmpresaUsuarioAplicacionEmpresa() {
		return idEmpresaUsuarioAplicacionEmpresa;
	}

	public void setIdEmpresaUsuarioAplicacionEmpresa(Integer idEmpresaUsuarioAplicacionEmpresa) {
		this.idEmpresaUsuarioAplicacionEmpresa = idEmpresaUsuarioAplicacionEmpresa;
	}

	public EmpresaUsuario getIdEmpresaUsuario() {
		return idEmpresaUsuario;
	}

	public void setIdEmpresaUsuario(EmpresaUsuario idEmpresaUsuario) {
		this.idEmpresaUsuario = idEmpresaUsuario;
	}

	public AplicacionEmpresa getIdAplicacionEmpresa() {
		return idAplicacionEmpresa;
	}

	public void setIdAplicacionEmpresa(AplicacionEmpresa idAplicacionEmpresa) {
		this.idAplicacionEmpresa = idAplicacionEmpresa;
	}

	public Boolean getEstadoEmpresaUsuarioAplicacionEmpresa() {
		return estadoEmpresaUsuarioAplicacionEmpresa;
	}

	public void setEstadoEmpresaUsuarioAplicacionEmpresa(Boolean estadoEmpresaUsuarioAplicacionEmpresa) {
		this.estadoEmpresaUsuarioAplicacionEmpresa = estadoEmpresaUsuarioAplicacionEmpresa;
	}
	
}
