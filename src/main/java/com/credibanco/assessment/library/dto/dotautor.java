package com.credibanco.assessment.library.dto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.credibanco.assessment.library.services.autor_servi;
import com.credibanco.assessment.library.services.libro_servi;
import com.credibanco.assessment.library.model.autor;

public class dotautor implements Serializable{
	
	private Long  id;
	private Long  d_identidad;
	private String nombre;
	private String  fecha_nacimiento;
	private String lugar_nacimiento;
	private String pais;
	private String correo;
	private String  libros_escritos;
	
	public List<dotautor> creardot(String autor_busqueda,String valor,autor_servi Autor_servi,libro_servi Libro_servi  ) {
		System.out.print("dot");
		List<dotautor> Autor =new ArrayList<>();
		List<autor> Autores_semejantes =new ArrayList<>();
		if(autor_busqueda!=null) {
			
			Autores_semejantes.addAll(Autor_servi.findAllByName(autor_busqueda.toUpperCase()));
		}else {
			Autores_semejantes.addAll(Autor_servi.findAll());//esto se hace para pedir todos los autores
		}
		//Autor.addAll(  Autor_servi.findAllByName(Autor_2.getNombre()));
		int contador=0;
		for (contador =0;contador<Autores_semejantes.size();contador++) {
			//System.out.print(" \n FOR /n");
			dotautor dot = new dotautor();
			dot.setId(Autores_semejantes.get(contador).getId());
			dot.setD_identidad(Autores_semejantes.get(contador).getD_identidad());
			dot.setNombre(Autores_semejantes.get(contador).getNombre().toUpperCase());
			dot.setCorreo(Autores_semejantes.get(contador).getCorreo().toLowerCase());
			dot.setLugar_nacimiento(Autores_semejantes.get(contador).getLugar_nacimiento().toUpperCase());
			dot.setPais(Autores_semejantes.get(contador).getPais().toUpperCase());
			dot.setFecha_nacimiento(Autores_semejantes.get(contador).getFecha_nacimiento());
			
			dot.setLibros_escritos(Libro_servi.findbookAutorstring(Autores_semejantes.get(contador).getId()));
			Autor.add(dot);
			
		}
		return Autor;
	}
	public dotautor() {//constructor vacio
		
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
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
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
