package com.ragnax.ssoorquestador.servicio.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.ragnax.ssoorquestador.servicio.clientes.modelo.*;

@FeignClient(name = "ragnax-seguridad" , url = "localhost:8082")
public interface SSOClienteRest {
	
	@PostMapping("/generar-tiempo-duracion") /****buscarRolxNombre****/
	public Rol buscarRolxNombre(Rol objRol);
	
	@PostMapping("/generar-tiempo-duracion") /****buscarEmpresaxDominio****/
	public Empresa buscarEmpresaxDominio(Empresa objEmpresa);
	
	@PostMapping("/generar-tiempo-duracion") /****buscarEmpresaUsuarioxEmpresaxUsuarioxRol****/
	public EmpresaUsuario buscarEmpresaUsuarioxEmpresaxUsuarioxRol(EmpresaUsuario objEmpresaUsuario);
	
	@PostMapping("/generar-tiempo-duracion") /****buscarEmpresaUsuarioxEmpresaxUsuarioxRol****/
	public Aplicacion buscarAplicacionxUriRuta(Aplicacion objAplicacion);
	
	@PostMapping("/generar-tiempo-duracion") /****buscarEmpresa****/
	public Empresa buscarEmpresa(Empresa objEmpresa);
	
	@PostMapping("/generar-tiempo-duracion") /****buscarAplicacionEmpresaxAplicacionxEmpresa****/
	public AplicacionEmpresa buscarAplicacionEmpresaxAplicacionxEmpresa(AplicacionEmpresa objAplicacionEmpresa);
	
	@PostMapping("/generar-tiempo-duracion") /****buscarAplicacionRolxAplicacionxRol****/
	public AplicacionRol buscarAplicacionRolxAplicacionxRol(AplicacionRol objAplicacionRol);
	
	@PostMapping("/generar-tiempo-duracion") /****buscarEmpresaUsuarioAplicacionEmpresaxEUxAE****/
	public EmpresaUsuarioAplicacionEmpresa buscarEmpresaUsuarioAplicacionEmpresaxEUxAE(EmpresaUsuarioAplicacionEmpresa objEmpresaUsuarioAplicacionEmpresa);
	
	@PostMapping("/generar-tiempo-duracion") /****buscarAplicacion****/
	public Aplicacion buscarAplicacion(Aplicacion objAplicacion);
	
	@PostMapping("/generar-tiempo-duracion") /****listarAplicacionServicioxAplicacion****/
	public List<AplicacionServicio> listarAplicacionServicioxAplicacion(AplicacionServicio objAplicacionServicio);
	
	@PostMapping("/generar-tiempo-duracion") /****buscarEmpresaUsuarioAplicacionEmpresa****/
	public EmpresaUsuarioAplicacionEmpresa buscarEmpresaUsuarioAplicacionEmpresa(EmpresaUsuarioAplicacionEmpresa objEmpresaUsuarioAplicacionEmpresa);
	
	@PostMapping("/generar-tiempo-duracion") /****buscarAplicacionServicioxAplicacionxUriRutaxMetodoHttp****/
	public AplicacionServicio buscarAplicacionServicioxAplicacionxUriRutaxMetodoHttp(AplicacionServicio objAplicacionServicio);
	
	@PostMapping("/generar-tiempo-duracion") /****buscarConfiguracionEmpresaUsuarioxEmpresa****/
	public ConfiguracionEmpresaUsuario buscarConfiguracionEmpresaUsuarioxEmpresa(ConfiguracionEmpresaUsuario objConfiguracionEmpresaUsuario);
	
	@PostMapping("/generar-tiempo-duracion") /****buscarGeneroxNombre****/
	public Genero buscarGeneroxNombre(Genero objGenero);
	
	@PostMapping("/generar-tiempo-duracion") /****crearMember****/
	public Member crearMember(Member objMember);
	
	@PostMapping("/generar-tiempo-duracion") /****crearIdentificador****/
	public Identificador crearIdentificador(Identificador objIdentificador);
	
	@PostMapping("/generar-tiempo-duracion") /****crearPerfil****/
	public Perfil crearPerfil(Perfil objPerfil);
	
	@PostMapping("/generar-tiempo-duracion") /****generarCodigoUsuario****/
	public Usuario generarCodigoUsuario(Usuario objUsuario);
	
	@PostMapping("/generar-tiempo-duracion") /****crearUsuario****/
	public Usuario crearUsuario(Usuario objUsuario);
	
	@PostMapping("/generar-tiempo-duracion") /****crearEmpresaUsuario****/
	public EmpresaUsuario crearEmpresaUsuario(EmpresaUsuario objEmpresaUsuario);
	
	@PostMapping("/generar-tiempo-duracion") /****crearEmpresaUsuarioAplicacionEmpresa****/
	public EmpresaUsuarioAplicacionEmpresa crearEmpresaUsuarioAplicacionEmpresa(EmpresaUsuarioAplicacionEmpresa objEmpresaUsuarioAplicacionEmpresa);
	
	@PostMapping("/generar-tiempo-duracion") /****buscarUsuarioxCodigo****/
	public Usuario buscarUsuarioxCodigo(Usuario objUsuario);
	
	@PostMapping("/generar-tiempo-duracion") /****buscarPerfilxEmail****/
	public Perfil buscarPerfilxEmail(Perfil objPerfil);
	
	@PostMapping("/generar-tiempo-duracion") /****buscarIdentificadorxValuexPais****/
	public Identificador buscarIdentificadorxValuexPais(Identificador objIdentificador);
	
	@PostMapping("/generar-tiempo-duracion") /****buscarMember****/
	public Member buscarMember(Member objMember);
	
	@PostMapping("/generar-tiempo-duracion") /****buscarPerfilxUsername****/
	public Perfil buscarPerfilxUsername(Perfil objPerfil);
	
	@PostMapping("/generar-tiempo-duracion") /****buscarEmpresaUsuario****/
	public EmpresaUsuario buscarEmpresaUsuario(EmpresaUsuario objEmpresaUsuario);
	
	@PostMapping("/generar-tiempo-duracion") /****listarEmpresaUsuarioxEmpresaxRol****/
	public List<EmpresaUsuario> listarEmpresaUsuarioxEmpresaxRol(EmpresaUsuario objEmpresaUsuario);
	
	/***
	
	
	
	
	
	
	
	
	
	***/
	

}
