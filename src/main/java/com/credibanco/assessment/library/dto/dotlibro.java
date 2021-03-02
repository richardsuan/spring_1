package com.credibanco.assessment.library.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.credibanco.assessment.library.model.editorial;
import com.credibanco.assessment.library.model.libro;
import com.credibanco.assessment.library.services.autor_servi;
import com.credibanco.assessment.library.services.editorial_servi;
import com.credibanco.assessment.library.services.libro_servi;

public class dotlibro implements Serializable {
	private Long  id;
	private String titulo;
	private String ano;
	private String genero;
	private  int paginas;
	private String  my_autor;
	private String  my_editorial;
	
public List<dotlibro> creardot(String libro_busqueda,editorial_servi Editorial_servi,libro_servi Libro_servi,autor_servi Autor_servi  ){		
		List<dotlibro> Libro =new ArrayList<>();
		List<libro> libros_semejantes =new ArrayList<>();
		
		if(libro_busqueda!=null) {
			System.out.println("if /n");
			
			libros_semejantes.addAll(Libro_servi.findAllByName(libro_busqueda.toUpperCase()));
		}else {
			System.out.println("else /n");
			libros_semejantes.addAll(Libro_servi.findAll());//esto se hace para pedir todos los editoriales
		}
		//Libro.addAll(  Libro_servi.findAllByName(Libro_2.getNombre()));
		int contador=0;
		for (contador =0;contador<libros_semejantes.size();contador++) {			
			dotlibro dot = new dotlibro();
			dot.setId(libros_semejantes.get(contador).getId()); 
			dot.setTitulo(libros_semejantes.get(contador).getTitulo().toUpperCase());
			dot.setAno(libros_semejantes.get(contador).getAno().toUpperCase());					
			dot.setGenero(libros_semejantes.get(contador).getGenero().toUpperCase());
			dot.setPaginas(libros_semejantes.get(contador).getPaginas());									
			dot.setMy_autor(Autor_servi.findAutorstring(libros_semejantes.get(contador).getId()));
			dot.setMy_editorial(Editorial_servi.findEditorialstring(libros_semejantes.get(contador).getId()));
			Libro.add(dot);
		}
		return Libro;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	public String getMy_autor() {
		return my_autor;
	}
	public void setMy_autor(String my_autor) {
		this.my_autor = my_autor;
	}
	public String getMy_editorial() {
		return my_editorial;
	}
	public void setMy_editorial(String my_editorial) {
		this.my_editorial = my_editorial;
	}
	public dotlibro(Long id, String titulo, String ano, String genero, int paginas, String my_autor,
			String my_editorial) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.ano = ano;
		this.genero = genero;
		this.paginas = paginas;
		this.my_autor = my_autor;
		this.my_editorial = my_editorial;
	}
	
	public dotlibro() {
		
	}
}
