package com.ragnax.ssoorquestador.servicio.clientes.modelo;

public class ConfiguracionEmpresaUsuario{
 
	private Integer idConfiguracionEmpresaUsuario;
	
	private String passwordEmpresaUsuarioContrasenhaFormat;
	
	private Boolean passwordEmpresaUsuarioContrasenhaSalto;
	
	private Empresa idEmpresa;
	
	private Boolean estadoConfiguracionEmpresaUsuario;
	
	public ConfiguracionEmpresaUsuario() {
		super();
	}
	
	public ConfiguracionEmpresaUsuario(Empresa idEmpresa, Boolean estadoConfiguracionEmpresaUsuario) {
		super();
		this.idEmpresa = idEmpresa;
		this.estadoConfiguracionEmpresaUsuario = estadoConfiguracionEmpresaUsuario; 
	}
	
	public ConfiguracionEmpresaUsuario(String passwordEmpresaUsuarioContrasenhaFormat,
			Boolean passwordEmpresaUsuarioContrasenhaSalto, Empresa idEmpresa) {
		super();
		this.passwordEmpresaUsuarioContrasenhaFormat = passwordEmpresaUsuarioContrasenhaFormat;
		this.passwordEmpresaUsuarioContrasenhaSalto = passwordEmpresaUsuarioContrasenhaSalto;
		this.idEmpresa = idEmpresa;
	}



	public Integer getIdConfiguracionEmpresaUsuario() {
		return idConfiguracionEmpresaUsuario;
	}

	public void setIdConfiguracionEmpresaUsuario(Integer idConfiguracionEmpresaUsuario) {
		this.idConfiguracionEmpresaUsuario = idConfiguracionEmpresaUsuario;
	}

	public String getPasswordEmpresaUsuarioContrasenhaFormat() {
		return passwordEmpresaUsuarioContrasenhaFormat;
	}

	public void setPasswordEmpresaUsuarioContrasenhaFormat(String passwordEmpresaUsuarioContrasenhaFormat) {
		this.passwordEmpresaUsuarioContrasenhaFormat = passwordEmpresaUsuarioContrasenhaFormat;
	}

	public Boolean getPasswordEmpresaUsuarioContrasenhaSalto() {
		return passwordEmpresaUsuarioContrasenhaSalto;
	}

	public void setPasswordEmpresaUsuarioContrasenhaSalto(Boolean passwordEmpresaUsuarioContrasenhaSalto) {
		this.passwordEmpresaUsuarioContrasenhaSalto = passwordEmpresaUsuarioContrasenhaSalto;
	}

	public Empresa getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Empresa idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Boolean getEstadoConfiguracionEmpresaUsuario() {
		return estadoConfiguracionEmpresaUsuario;
	}

	public void setEstadoConfiguracionEmpresaUsuario(Boolean estadoConfiguracionEmpresaUsuario) {
		this.estadoConfiguracionEmpresaUsuario = estadoConfiguracionEmpresaUsuario;
	}
	
}
