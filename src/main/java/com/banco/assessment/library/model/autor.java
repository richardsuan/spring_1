package com.banco.assessment.library.model;


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

/**
 * @author richa
 *
 */
@Entity
@Table (name="Autor")
public class autor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long  id;
	private Long  d_identidad;
	private String nombre;
	private String  fecha_nacimiento;
	private String lugar_nacimiento;
	private String correo;
	private String pais;
	
	
	//esto se hace para hacer las relaciones 
	
  
    

	
	public autor() {
			
	}





	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public Long getD_identidad() {
		return d_identidad;
	}





	public void setD_identidad(Long d_identidad) {
		this.d_identidad = d_identidad;
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





	public String getPais() {
		return pais;
	}





	public void setPais(String pais) {
		this.pais = pais;
	}















	public autor(Long d_identidad, String nombre, String fecha_nacimiento, String lugar_nacimiento, String correo,
			String pais) {
		super();
		this.d_identidad = d_identidad;
		this.nombre = nombre;
		this.fecha_nacimiento = fecha_nacimiento;
		this.lugar_nacimiento = lugar_nacimiento;
		this.correo = correo;
		this.pais = pais;
		
	}
	
	
	
	
	
}
