package com.credibanco.assessment.library.dto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.credibanco.assessment.library.model.editorial;
import com.credibanco.assessment.library.services.editorial_servi;
import com.credibanco.assessment.library.services.libro_servi;
public class doteditorial implements Serializable {
	private Long  id;
	private String nombre;
	private String direccion_correspondencia;
	private String telefono;
	private String correo;
	private int maximo_libros;
	private int libros_editados_int;
	private String libros_editados;
	//
	public List<doteditorial> creardot(String editorial_busqueda,boolean opcion  ,editorial_servi Editorial_servi,libro_servi Libro_servi  ) {
		
		List<doteditorial> Editorial =new ArrayList<>();
		List<editorial> Editoriales_semejantes =new ArrayList<>();
		if(editorial_busqueda!=null) {
			
			Editoriales_semejantes.addAll(Editorial_servi.findAllByName(editorial_busqueda.toUpperCase()));
		}else {
			Editoriales_semejantes.addAll(Editorial_servi.findAll());//esto se hace para pedir todos los editoriales
		}
		//Editorial.addAll(  Editorial_servi.findAllByName(Editorial_2.getNombre()));
		int contador=0;
		for (contador =0;contador<Editoriales_semejantes.size();contador++) {
			//System.out.print(" \n FOR /n");
			if(opcion==false || Editoriales_semejantes.get(contador).getMaximo_libros()==-1) {
				doteditorial dot = new doteditorial();
				dot.setId(Editoriales_semejantes.get(contador).getId()); 
				dot.setNombre(Editoriales_semejantes.get(contador).getNombre().toUpperCase());
				dot.setCorreo(Editoriales_semejantes.get(contador).getCorreo().toLowerCase());					
				dot.setDireccion_correspondencia(Editoriales_semejantes.get(contador).getDireccion_correspondencia().toLowerCase());
				dot.setTelefono(Editoriales_semejantes.get(contador).getTelefono());						
				dot.setMaximo_libros(Editoriales_semejantes.get(contador).getMaximo_libros());			
				dot.setLibros_editados_int(Libro_servi.findbookeditorialint(Editoriales_semejantes.get(contador).getId()));
				dot.setLibros_editados(Libro_servi.findbookeditorialstring(Editoriales_semejantes.get(contador).getId()));
				Editorial.add(dot);
			}else {
				if(Editoriales_semejantes.get(contador).getMaximo_libros()-Libro_servi.findbookeditorialint(Editoriales_semejantes.get(contador).getId())>0) {
					doteditorial dot = new doteditorial();
					dot.setId(Editoriales_semejantes.get(contador).getId()); 
					dot.setNombre(Editoriales_semejantes.get(contador).getNombre().toUpperCase());
					dot.setCorreo(Editoriales_semejantes.get(contador).getCorreo().toLowerCase());					
					dot.setDireccion_correspondencia(Editoriales_semejantes.get(contador).getDireccion_correspondencia().toLowerCase());
					dot.setTelefono(Editoriales_semejantes.get(contador).getTelefono());						
					dot.setMaximo_libros(Editoriales_semejantes.get(contador).getMaximo_libros());			
					dot.setLibros_editados_int(Libro_servi.findbookeditorialint(Editoriales_semejantes.get(contador).getId()));
					dot.setLibros_editados(Libro_servi.findbookeditorialstring(Editoriales_semejantes.get(contador).getId()));
					Editorial.add(dot);
				}
			}
		}
		return Editorial;
	}
	//
	public doteditorial() {
		
	}
	
	public doteditorial(Long id, String nombre, String direccion_correspondencia, String telefono, String correo,
			int maximo_libros, int libros_editados_int, String libros_editados) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion_correspondencia = direccion_correspondencia;
		this.telefono = telefono;
		this.correo = correo;
		this.maximo_libros = maximo_libros;
		this.libros_editados_int = libros_editados_int;
		this.libros_editados = libros_editados;
	}
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
	public int getLibros_editados_int() {
		return libros_editados_int;
	}
	public void setLibros_editados_int(int libros_editados_int) {
		this.libros_editados_int = libros_editados_int;
	}
	public String getLibros_editados() {
		return libros_editados;
	}
	public void setLibros_editados(String libros_editados) {
		this.libros_editados = libros_editados;
	}
	
	
	

}
