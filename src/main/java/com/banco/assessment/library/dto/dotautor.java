package com.banco.assessment.library.dto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.banco.assessment.library.model.autor;
import com.banco.assessment.library.services.autor_servi;

public class dotautor implements Serializable{
	
	private Long  id;
	private Long  d_identidad;
	private String nombre;
	private String  fecha_nacimiento;
	private String lugar_nacimiento;
	private String pais;
	private String correo;
	
	
	public List<dotautor> creardot(String valor_busqueda,String tipo,autor_servi Autor_servi  ) {
		//System.out.print("dot "+autor_busqueda+"\n");
		List<dotautor> Autor =new ArrayList<>();
		List<autor> Autores_semejantes =new ArrayList<>();
		if(valor_busqueda!=null) {
			System.out.print("dot if \n"+valor_busqueda);
			Autores_semejantes.addAll(Autor_servi.findPerson(valor_busqueda.toUpperCase(),tipo));
			System.out.print(Autores_semejantes.isEmpty());
			if(Autores_semejantes.isEmpty()) {
				return null;
			}
		}else {
			Autores_semejantes.addAll(Autor_servi.findAll());//esto se hace para pedir todos los autores
		}
		
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
	public dotautor(String nombre, String fecha_nacimiento, String lugar_nacimiento, String correo) {
		super();
		this.nombre = nombre;
		this.fecha_nacimiento = fecha_nacimiento;
		this.lugar_nacimiento = lugar_nacimiento;
		this.correo = correo;
		
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

	

	
	
	
}
