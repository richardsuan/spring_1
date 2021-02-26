package com.credibanco.assessment.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="libro")
public class libro {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String titulo;
	private String ano;
	private String genero;
	private  int paginas;
	
	//esto se hace para hacer las relaciones 
	@ManyToOne
	@JoinColumn(name ="editorial_id")
	private editorial  editorial_this;
	@ManyToOne
	@JoinColumn(name ="autor_id")
	private autor  autor_this;
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public editorial getEditorial_this() {
		return editorial_this;
	}
	public void setEditorial_this(editorial editorial_this) {
		this.editorial_this = editorial_this;
	}
	public autor getAutor_this() {
		return autor_this;
	}
	public void setAutor_this(autor autor_this) {
		this.autor_this = autor_this;
	}
	public libro(String titulo, String ano, String genero, int paginas, editorial editorial_this, autor autor_this) {
		super();
		this.titulo = titulo;
		this.ano = ano;
		this.genero = genero;
		this.paginas = paginas;
		this.editorial_this = editorial_this;
		this.autor_this = autor_this;
	}
	
	
	
}
