package com.ragnax.ssoorquestador.servicio.clientes.modelo;

import java.sql.Timestamp;

public class Member{
 
	private Integer idMember;
	
	private String nombreMember;//Nombre de la Persona
	
	private String apellidoPaternoMember; //Apellido de la Persona
	
	private String apellidoMaternoMember; //Apellido de la Persona
	
	private String telefonoContactoMember;
	
	private String fechaNacimientoMember;
	
	private String firmaMember;
	
	private Timestamp creacionMember;
	
	private Genero idGenero;
	
//	private List<Identificador> identificador_member;
	
//	private List<Usuario> usuarios_member;
	
	public Member() {
		super();
	}
	
	public Member(String nombreMember, String apellidoPaternoMember,
			String apellidoMaternoMember, String telefonoContactoMember, String fechaNacimientoMember,
			String firmaMember, Genero idGenero) {
		super();
		this.nombreMember = nombreMember;
		this.apellidoPaternoMember = apellidoPaternoMember;
		this.apellidoMaternoMember = apellidoMaternoMember;
		this.telefonoContactoMember = telefonoContactoMember;
		this.fechaNacimientoMember = fechaNacimientoMember;
		this.firmaMember = firmaMember;
		this.idGenero = idGenero;
	}



	public Integer getIdMember() {
		return idMember;
	}

	public void setIdMember(Integer idMember) {
		this.idMember = idMember;
	}

	public String getNombreMember() {
		return nombreMember;
	}

	public void setNombreMember(String nombreMember) {
		this.nombreMember = nombreMember;
	}

	public String getApellidoPaternoMember() {
		return apellidoPaternoMember;
	}

	public void setApellidoPaternoMember(String apellidoPaternoMember) {
		this.apellidoPaternoMember = apellidoPaternoMember;
	}

	public String getApellidoMaternoMember() {
		return apellidoMaternoMember;
	}

	public void setApellidoMaternoMember(String apellidoMaternoMember) {
		this.apellidoMaternoMember = apellidoMaternoMember;
	}

	public String getTelefonoContactoMember() {
		return telefonoContactoMember;
	}

	public void setTelefonoContactoMember(String telefonoContactoMember) {
		this.telefonoContactoMember = telefonoContactoMember;
	}

	public String getFechaNacimientoMember() {
		return fechaNacimientoMember;
	}

	public void setFechaNacimientoMember(String fechaNacimientoMember) {
		this.fechaNacimientoMember = fechaNacimientoMember;
	}

	public String getFirmaMember() {
		return firmaMember;
	}

	public void setFirmaMember(String firmaMember) {
		this.firmaMember = firmaMember;
	}

	public Timestamp getCreacionMember() {
		return creacionMember;
	}

	public void setCreacionMember(Timestamp creacionMember) {
		this.creacionMember = creacionMember;
	}

	public Genero getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(Genero idGenero) {
		this.idGenero = idGenero;
	}
	
}
