package com.ragnax.ssoorquestador.servicio.clientes.modelo;

public class Empresa{
 

	private Integer idEmpresa;

	private String rolUnicoIdentificadorEmpresa; //rut - ruc - dni

	private String nombreEmpresa; //nombre fantasia

	private String nombreEmpresaLowerCase;

	private String dominioEmpresa;

	private String razonSocialEmpresa; //nombre legal empresa

	private String razonSocialEmpresaLowerCase;

	private String giroEmpresa; // accion que hace empresa

	private String direccionOrigen;  // ubicacion legal empresa

	private String codigoPaisPortal;

	private Integer idRegion;

	private Integer idComuna;

	private String ciudadOrigen;

	private Boolean estadoEmpresa; 

//	private List<EmpresaUsuario> empresas_usuarios;
	
//	private List<EmpresaUsuario> aplicaciones_empresas;
	
//	private List<ConfiguracionEmpresaUsuario> configuraciones_aplicaciones_usuarios;
	
//	private List<MaquinaEmpresa> maquinas_empresas;
	
	public Empresa() {
		super();
	}
	
	public Empresa(Integer idEmpresa) {
		super();
		this.idEmpresa = idEmpresa;
	}
	
	public Empresa(String dominioEmpresa) {
		super();
		this.dominioEmpresa = dominioEmpresa;
	}
	
	public Empresa(String rolUnicoIdentificadorEmpresa, String nombreEmpresa, 
			String dominioEmpresa, String razonSocialEmpresa, String giroEmpresa,
			String direccionOrigen, String codigoPaisPortal, Integer idRegion, Integer idComuna, String ciudadOrigen) {
		super();
		this.rolUnicoIdentificadorEmpresa = rolUnicoIdentificadorEmpresa;
		this.nombreEmpresa = nombreEmpresa;
		this.dominioEmpresa = dominioEmpresa;
		this.razonSocialEmpresa = razonSocialEmpresa;
		this.giroEmpresa = giroEmpresa;
		this.direccionOrigen = direccionOrigen;
		this.codigoPaisPortal = codigoPaisPortal;
		this.idRegion = idRegion;
		this.idComuna = idComuna;
		this.ciudadOrigen = ciudadOrigen;
	}

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getRolUnicoIdentificadorEmpresa() {
		return rolUnicoIdentificadorEmpresa;
	}

	public void setRolUnicoIdentificadorEmpresa(String rolUnicoIdentificadorEmpresa) {
		this.rolUnicoIdentificadorEmpresa = rolUnicoIdentificadorEmpresa;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getNombreEmpresaLowerCase() {
		return nombreEmpresaLowerCase;
	}

	public void setNombreEmpresaLowerCase(String nombreEmpresaLowerCase) {
		this.nombreEmpresaLowerCase = nombreEmpresaLowerCase;
	}

	public String getDominioEmpresa() {
		return dominioEmpresa;
	}

	public void setDominioEmpresa(String dominioEmpresa) {
		this.dominioEmpresa = dominioEmpresa;
	}

	public String getRazonSocialEmpresa() {
		return razonSocialEmpresa;
	}

	public void setRazonSocialEmpresa(String razonSocialEmpresa) {
		this.razonSocialEmpresa = razonSocialEmpresa;
	}

	public String getRazonSocialEmpresaLowerCase() {
		return razonSocialEmpresaLowerCase;
	}

	public void setRazonSocialEmpresaLowerCase(String razonSocialEmpresaLowerCase) {
		this.razonSocialEmpresaLowerCase = razonSocialEmpresaLowerCase;
	}

	public String getGiroEmpresa() {
		return giroEmpresa;
	}

	public void setGiroEmpresa(String giroEmpresa) {
		this.giroEmpresa = giroEmpresa;
	}

	public String getDireccionOrigen() {
		return direccionOrigen;
	}

	public void setDireccionOrigen(String direccionOrigen) {
		this.direccionOrigen = direccionOrigen;
	}
	
	public String getCodigoPaisPortal() {
		return codigoPaisPortal;
	}

	public void setCodigoPaisPortal(String codigoPaisPortal) {
		this.codigoPaisPortal = codigoPaisPortal;
	}

	public Integer getIdRegion() {
		return idRegion;
	}

	public void setIdRegion(Integer idRegion) {
		this.idRegion = idRegion;
	}

	public Integer getIdComuna() {
		return idComuna;
	}

	public void setIdComuna(Integer idComuna) {
		this.idComuna = idComuna;
	}

	public String getCiudadOrigen() {
		return ciudadOrigen;
	}

	public void setCiudadOrigen(String ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}

	public Boolean getEstadoEmpresa() {
		return estadoEmpresa;
	}

	public void setEstadoEmpresa(Boolean estadoEmpresa) {
		this.estadoEmpresa = estadoEmpresa;
	}
}
