package com.ragnax.ssoorquestador.modelo;

import java.io.Serializable;

public class EnterpriseContext implements Serializable {
	
	private static final long serialVersionUID = -4531786488344876910L;

	private BasicContext basicContext; 
	private int idAplicacionEmpresa;
	private int idAplicacion;
	private int idAplicacionRol;
	private int idEmpresaUsuarioAplicacionEmpresa;
	private String keyEnterprise;
	
	public EnterpriseContext() {
		super();
	}
	
	public EnterpriseContext(BasicContext basicContext) {
		super();
		this.basicContext = basicContext;
	}

	public BasicContext getBasicContext() {
		return basicContext;
	}

	public int getIdAplicacionEmpresa() {
		return idAplicacionEmpresa;
	}

	public int getIdAplicacion() {
		return idAplicacion;
	}

	public int getIdAplicacionRol() {
		return idAplicacionRol;
	}

	public int getIdEmpresaUsuarioAplicacionEmpresa() {
		return idEmpresaUsuarioAplicacionEmpresa;
	}

	public String getKeyEnterprise() {
		return keyEnterprise;
	}

	public void setBasicContext(BasicContext basicContext) {
		this.basicContext = basicContext;
	}

	public void setIdAplicacionEmpresa(int idAplicacionEmpresa) {
		this.idAplicacionEmpresa = idAplicacionEmpresa;
	}

	public void setIdAplicacion(int idAplicacion) {
		this.idAplicacion = idAplicacion;
	}

	public void setIdAplicacionRol(int idAplicacionRol) {
		this.idAplicacionRol = idAplicacionRol;
	}

	public void setIdEmpresaUsuarioAplicacionEmpresa(int idEmpresaUsuarioAplicacionEmpresa) {
		this.idEmpresaUsuarioAplicacionEmpresa = idEmpresaUsuarioAplicacionEmpresa;
	}

	public void setKeyEnterprise(String keyEnterprise) {
		this.keyEnterprise = keyEnterprise;
	}
	
}
