package com.ragnax.ssoorquestador.servicio.clientes.modelo;

public class AplicacionServicio{

	private Integer idAplicacionServicio;
	
	private Aplicacion idAplicacion;

	private String uriRutaAplicacion;
	
	private String uriRutaAplicacionProducto;
	
	private String uriRutaAplicacionProductoServicio;
	
	private String parametroRutaAplicacionProductoServicio;
	
	private String metodoHttp;
	
	private Boolean estadoAplicacionServicio;
	
//	private List<SeguridadAplicacionAcceso> seguridades_aplicaciones_accesos;

	public AplicacionServicio() {
		super();
	}
	
	public AplicacionServicio(Aplicacion idAplicacion) {
		super();
		this.idAplicacion = idAplicacion;
	}
	
	public AplicacionServicio(Aplicacion idAplicacion, String uriRutaAplicacion, String uriRutaAplicacionProducto,
			String uriRutaAplicacionProductoServicio, String parametroRutaAplicacionProductoServicio,
			String metodoHttp) {
		super();
		this.idAplicacion = idAplicacion;
		this.uriRutaAplicacion = uriRutaAplicacion;
		this.uriRutaAplicacionProducto = uriRutaAplicacionProducto;
		this.uriRutaAplicacionProductoServicio = uriRutaAplicacionProductoServicio;
		this.parametroRutaAplicacionProductoServicio = parametroRutaAplicacionProductoServicio;
		this.metodoHttp = metodoHttp;
	}

	public Integer getIdAplicacionServicio() {
		return idAplicacionServicio;
	}

	public void setIdAplicacionServicio(Integer idAplicacionServicio) {
		this.idAplicacionServicio = idAplicacionServicio;
	}

	public Aplicacion getIdAplicacion() {
		return idAplicacion;
	}

	public void setIdAplicacion(Aplicacion idAplicacion) {
		this.idAplicacion = idAplicacion;
	}

	public String getUriRutaAplicacion() {
		return uriRutaAplicacion;
	}

	public void setUriRutaAplicacion(String uriRutaAplicacion) {
		this.uriRutaAplicacion = uriRutaAplicacion;
	}

	public String getUriRutaAplicacionProducto() {
		return uriRutaAplicacionProducto;
	}

	public void setUriRutaAplicacionProducto(String uriRutaAplicacionProducto) {
		this.uriRutaAplicacionProducto = uriRutaAplicacionProducto;
	}

	public String getUriRutaAplicacionProductoServicio() {
		return uriRutaAplicacionProductoServicio;
	}

	public void setUriRutaAplicacionProductoServicio(String uriRutaAplicacionProductoServicio) {
		this.uriRutaAplicacionProductoServicio = uriRutaAplicacionProductoServicio;
	}

	public String getParametroRutaAplicacionProductoServicio() {
		return parametroRutaAplicacionProductoServicio;
	}

	public void setParametroRutaAplicacionProductoServicio(String parametroRutaAplicacionProductoServicio) {
		this.parametroRutaAplicacionProductoServicio = parametroRutaAplicacionProductoServicio;
	}

	public String getMetodoHttp() {
		return metodoHttp;
	}

	public void setMetodoHttp(String metodoHttp) {
		this.metodoHttp = metodoHttp;
	}

	public Boolean getEstadoAplicacionServicio() {
		return estadoAplicacionServicio;
	}

	public void setEstadoAplicacionServicio(Boolean estadoAplicacionServicio) {
		this.estadoAplicacionServicio = estadoAplicacionServicio;
	}
}
