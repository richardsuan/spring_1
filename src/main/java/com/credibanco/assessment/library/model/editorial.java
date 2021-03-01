package com.credibanco.assessment.library.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="Editorial")
public class editorial {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long  id;
	private String nombre;
	private String direccion_correspondencia;
	private String telefono;
	private String correo;
	private int maximo_libros;
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
	public editorial(String nombre, String direccion_correspondencia, String telefono, String correo,
			int maximo_libros) {
		super();
		this.nombre = nombre;
		this.direccion_correspondencia = direccion_correspondencia;
		this.telefono = telefono;
		this.correo = correo;
		this.maximo_libros = maximo_libros;
	}
	public editorial() {
		
	}
	//esto se hace para hacer las relaciones 
	/*
	@ManyToOne
	@JoinColumn(name="id_libros_editados")
	private libro  libros_editados;*/
	
	

	
	
	
	
	
}
