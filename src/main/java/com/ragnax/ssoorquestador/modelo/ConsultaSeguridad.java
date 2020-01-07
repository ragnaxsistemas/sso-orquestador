package com.ragnax.ssoorquestador.modelo;

import java.io.Serializable;

public class ConsultaSeguridad implements Serializable{

	private static final long serialVersionUID = 4492524734886492566L;
	
	private String remoteAddr;
	
	private String remoteHost;
	
	private String dataRequest;
	
	private String nombreAplicacionSeguridad;
	
	private String nombreAplicacion; 
	
	private String nombreAplicacionProducto;
	
	private String nombreAplicacionProductoServicio;
	
	private String metodoHttp;
	
	private String dominioEmpresa;
	
	private String rolContexto;
	
	private String keySeguridad;
	//Por el momento que se define un api de session
	private int ttlSession;
	
	private String nombreUsuario;
	
	private String contrasenhaUsuarioEmpresa;

	public ConsultaSeguridad() {
		super();
	}
	
	public ConsultaSeguridad(String dataRequest, String ipConsulta) {
		super();
		this.dataRequest = dataRequest;
	}
	
	public ConsultaSeguridad(String remoteAddr, String remoteHost, String dataRequest, String nombreAplicacionSeguridad,
			String nombreAplicacion, String nombreAplicacionProducto, String nombreAplicacionProductoServicio,
			String metodoHttp) {
		super();
		this.remoteAddr = remoteAddr;
		this.remoteHost = remoteHost;
		this.dataRequest = dataRequest;
		this.nombreAplicacionSeguridad = nombreAplicacionSeguridad;
		this.nombreAplicacion = nombreAplicacion;
		this.nombreAplicacionProducto = nombreAplicacionProducto;
		this.nombreAplicacionProductoServicio = nombreAplicacionProductoServicio;
		this.metodoHttp = metodoHttp;
	}

	public ConsultaSeguridad(String remoteAddr, String remoteHost, String dataRequest, String nombreAplicacionSeguridad,
			String nombreAplicacion, String nombreAplicacionProducto, String nombreAplicacionProductoServicio,
			String metodoHttp, String dominioEmpresa, String rolContexto, String keySeguridad, int ttlSession,
			String nombreUsuario, String contrasenhaUsuarioEmpresa) {
		this.remoteAddr = remoteAddr;
		this.remoteHost = remoteHost;
		this.dataRequest = dataRequest;
		this.nombreAplicacionSeguridad = nombreAplicacionSeguridad;
		this.nombreAplicacion = nombreAplicacion;
		this.nombreAplicacionProducto = nombreAplicacionProducto;
		this.nombreAplicacionProductoServicio = nombreAplicacionProductoServicio;
		this.metodoHttp = metodoHttp;
		this.dominioEmpresa = dominioEmpresa;
		this.rolContexto = rolContexto;
		this.keySeguridad = keySeguridad;
		this.ttlSession = ttlSession;
		this.nombreUsuario = nombreUsuario;
		this.contrasenhaUsuarioEmpresa = contrasenhaUsuarioEmpresa;
	}

	public String getRemoteAddr() {
		return remoteAddr;
	}

	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}

	public String getRemoteHost() {
		return remoteHost;
	}

	public void setRemoteHost(String remoteHost) {
		this.remoteHost = remoteHost;
	}

	public String getDataRequest() {
		return dataRequest;
	}

	public void setDataRequest(String dataRequest) {
		this.dataRequest = dataRequest;
	}

	public String getNombreAplicacionSeguridad() {
		return nombreAplicacionSeguridad;
	}

	public void setNombreAplicacionSeguridad(String nombreAplicacionSeguridad) {
		this.nombreAplicacionSeguridad = nombreAplicacionSeguridad;
	}

	public String getNombreAplicacion() {
		return nombreAplicacion;
	}

	public void setNombreAplicacion(String nombreAplicacion) {
		this.nombreAplicacion = nombreAplicacion;
	}

	public String getNombreAplicacionProducto() {
		return nombreAplicacionProducto;
	}

	public void setNombreAplicacionProducto(String nombreAplicacionProducto) {
		this.nombreAplicacionProducto = nombreAplicacionProducto;
	}

	public String getNombreAplicacionProductoServicio() {
		return nombreAplicacionProductoServicio;
	}

	public void setNombreAplicacionProductoServicio(String nombreAplicacionProductoServicio) {
		this.nombreAplicacionProductoServicio = nombreAplicacionProductoServicio;
	}

	public String getMetodoHttp() {
		return metodoHttp;
	}

	public void setMetodoHttp(String metodoHttp) {
		this.metodoHttp = metodoHttp;
	}

	public String getDominioEmpresa() {
		return dominioEmpresa;
	}

	public void setDominioEmpresa(String dominioEmpresa) {
		this.dominioEmpresa = dominioEmpresa;
	}

	public String getRolContexto() {
		return rolContexto;
	}

	public void setRolContexto(String rolContexto) {
		this.rolContexto = rolContexto;
	}

	public String getKeySeguridad() {
		return keySeguridad;
	}

	public void setKeySeguridad(String keySeguridad) {
		this.keySeguridad = keySeguridad;
	}

	public int getTtlSession() {
		return ttlSession;
	}

	public void setTtlSession(int ttlSession) {
		this.ttlSession = ttlSession;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasenhaUsuarioEmpresa() {
		return contrasenhaUsuarioEmpresa;
	}

	public void setContrasenhaUsuarioEmpresa(String contrasenhaUsuarioEmpresa) {
		this.contrasenhaUsuarioEmpresa = contrasenhaUsuarioEmpresa;
	}
	
}
