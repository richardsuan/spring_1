package com.credibanco.assessment.library.dto;
import java.io.Serializable;

import com.credibanco.assessment.library.model.libro;
public class dotautor implements Serializable{
	
	
	private String nombre;
	private String  fecha_nacimiento;
	private String lugar_nacimiento;
	private String correo;

	private String  libros_escritos;
	
	public dotautor() {//constructor vacio
		
	}

	public dotautor(String nombre, String fecha_nacimiento, String lugar_nacimiento, String correo,
			String libros_escritos) {
		super();
		this.nombre = nombre;
		this.fecha_nacimiento = fecha_nacimiento;
		this.lugar_nacimiento = lugar_nacimiento;
		this.correo = correo;
		this.libros_escritos = libros_escritos;
	}

	//aqui se crean los get y set 
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getLugar_nacimiento() {
		return lugar_nacimiento;
	}

	public void setLugar_nacimiento(String lugar_nacimiento) {
		this.lugar_nacimiento = lugar_nacimiento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getLibros_escritos() {
		return libros_escritos;
	}

	public void setLibros_escritos(String libros_escritos) {
		this.libros_escritos = libros_escritos;
	}
	
	
}
