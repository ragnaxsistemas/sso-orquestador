package com.ragnax.ssoorquestador.servicio.clientes.modelo;

public class Usuario{
 
	private Integer idUsuario;

	private String codigoUsuarioUnit;

	private Member idMember;
	
	private Perfil idPerfil;
	
//	private List<EmpresaUsuario> empresas_usuarios;
	
	public Usuario() {
		super();
	}
	
	public Usuario(Member idMember, Perfil idPerfil) {
		super();
		this.idMember = idMember;
		this.idPerfil = idPerfil;
	}

	public Usuario(Integer idUsuario) {
		super();
		this.idUsuario = idUsuario;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getCodigoUsuarioUnit() {
		return codigoUsuarioUnit;
	}

	public void setCodigoUsuarioUnit(String codigoUsuarioUnit) {
		this.codigoUsuarioUnit = codigoUsuarioUnit;
	}

	public Member getIdMember() {
		return idMember;
	}

	public void setIdMember(Member idMember) {
		this.idMember = idMember;
	}

	public Perfil getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Perfil idPerfil) {
		this.idPerfil = idPerfil;
	}

}
