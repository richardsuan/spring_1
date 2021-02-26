package com.credibanco.assessment.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="editorial")
public class editorial {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	private String direccion_correspondencia;
	private String telefono;
	private String correo;
	private int maximo_libros;
	//esto se hace para hacer las relaciones 
	private libro  libros_editados;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion_correspondencia() {
		return direccion_correspondencia;
	}
	public void setDireccion_correspondencia(String direccion_correspondencia) {
		this.direccion_correspondencia = direccion_correspondencia;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public int getMaximo_libros() {
		return maximo_libros;
	}
	public void setMaximo_libros(int maximo_libros) {
		this.maximo_libros = maximo_libros;
	}
	public libro getLibros_editados() {
		return libros_editados;
	}
	public void setLibros_editados(libro libros_editados) {
		this.libros_editados = libros_editados;
	}
	public editorial(String nombre, String direccion_correspondencia, String telefono, String correo, int maximo_libros,
			libro libros_editados) {
		super();
		this.nombre = nombre;
		this.direccion_correspondencia = direccion_correspondencia;
		this.telefono = telefono;
		this.correo = correo;
		this.maximo_libros = maximo_libros;
		this.libros_editados = libros_editados;
	}
	
	
	
}
