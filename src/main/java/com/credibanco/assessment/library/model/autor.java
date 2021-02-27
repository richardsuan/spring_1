package com.credibanco.assessment.library.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="autor")
public class autor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long  id;
	private String nombre;
	private String  fecha_nacimiento;
	private String lugar_nacimiento;
	private String correo;
	//esto se hace para hacer las relaciones 
	@ManyToOne
	@JoinColumn(name="id_libros_escritos")
	private libro  libros_escritos;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public libro getLibros_escritos() {
		return libros_escritos;
	}
	public void setLibros_escritos(libro libros_escritos) {
		this.libros_escritos = libros_escritos;
	}
	public autor(String nombre, String fecha_nacimiento, String lugar_nacimiento, String correo,
			libro libros_escritos) {
		super();
		this.nombre = nombre;
		this.fecha_nacimiento = fecha_nacimiento;
		this.lugar_nacimiento = lugar_nacimiento;
		this.correo = correo;
		this.libros_escritos = libros_escritos;
	}
	public autor() {
		
	}
	
	
	
}
