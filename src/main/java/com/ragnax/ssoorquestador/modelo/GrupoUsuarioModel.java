package com.ragnax.ssoorquestador.modelo;

import java.io.Serializable;
import java.util.List;

import com.ragnax.ssoorquestador.servicio.clientes.modelo.ConfiguracionEmpresaUsuario;
import com.ragnax.ssoorquestador.servicio.clientes.modelo.Identificador;
import com.ragnax.ssoorquestador.servicio.clientes.modelo.Member;
import com.ragnax.ssoorquestador.servicio.clientes.modelo.Perfil;
import com.ragnax.ssoorquestador.servicio.clientes.modelo.Usuario;

public class GrupoUsuarioModel implements Serializable{
	
	private static final long serialVersionUID = -1465013234801191835L;
	private Usuario usuario;
	private Member member;
	private List<Identificador> listaIdentificador;
	private Perfil perfil;
	private ConfiguracionEmpresaUsuario configuracionEmpresaUsuario;
	
	public GrupoUsuarioModel() {
		super();
	}

	public GrupoUsuarioModel(Usuario usuario, Member member, Perfil perfil) {
		super();
		this.usuario = usuario;
		this.member = member;
		this.perfil = perfil;
	}
	
	public GrupoUsuarioModel(Usuario usuario, Member member, Perfil perfil, ConfiguracionEmpresaUsuario configuracionEmpresaUsuario) {
		super();
		this.usuario = usuario;
		this.member = member;
		this.perfil = perfil;
		this.configuracionEmpresaUsuario = configuracionEmpresaUsuario;
	}
	
	public GrupoUsuarioModel(Usuario usuario, Member member, Perfil perfil, 
			ConfiguracionEmpresaUsuario configuracionEmpresaUsuario, List<Identificador> listaIdentificador) {
		super();
		this.usuario = usuario;
		this.member = member;
		this.perfil = perfil;
		this.listaIdentificador = listaIdentificador;
		this.configuracionEmpresaUsuario = configuracionEmpresaUsuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Member getMember() {
		return member;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public ConfiguracionEmpresaUsuario getConfiguracionEmpresaUsuario() {
		return configuracionEmpresaUsuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public void setConfiguracionEmpresaUsuario(ConfiguracionEmpresaUsuario configuracionEmpresaUsuario) {
		this.configuracionEmpresaUsuario = configuracionEmpresaUsuario;
	}

	public List<Identificador> getListaIdentificador() {
		return listaIdentificador;
	}

	public void setListaIdentificador(List<Identificador> listaIdentificador) {
		this.listaIdentificador = listaIdentificador;
	}
	
}
