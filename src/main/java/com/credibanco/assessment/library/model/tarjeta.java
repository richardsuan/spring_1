package com.credibanco.assessment.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Libro")
public class tarjeta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long  id;
	private String titulo;
	private String ano;
	private String genero;
	private  int paginas;
	private Long  my_autor;
	//esto se hace para hacer las relaciones 	
	
/*
    @ManyToOne()
    @JoinColumn(name = "autor_id")
    private autor my_autor;
	

    @ManyToOne()
    @JoinColumn(name = "editorial_id")
    private editorial my_editorial;
  */  
	public tarjeta() {
		
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

	public Long getMy_autor() {
		return my_autor;
	}

	public void setMy_autor(Long my_autor) {
		this.my_autor = my_autor;
	}
	public tarjeta(String titulo, String ano, String genero, int paginas, Long my_autor, Long my_editorial) {
		super();
		this.titulo = titulo;
		this.ano = ano;
		this.genero = genero;
		this.paginas = paginas;
		this.my_autor = my_autor;
	}
}
