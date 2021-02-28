package com.credibanco.assessment.library.service.impl;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.library.model.autor;
import com.credibanco.assessment.library.model.libro;
import com.credibanco.assessment.library.services.autor_servi;
import com.credibanco.assessment.library.services.libro_servi;

@RestController
public class LibroRest {
	@Autowired
	private libro_servi Libro_servi;
	@Autowired
	private autor_servi Autor_servi;
	@RequestMapping("/libros/")//listar libroes
	@GetMapping	
	private ResponseEntity <List<libro>> getAll_libros(){//este metodo trae a todas las libroes
		//System.out.println("hicieron get");
		return ResponseEntity.ok(Libro_servi.findAll());
		
	}
	//
	
	//
	@RequestMapping("/libro/agregar/")
	@PostMapping
	private ResponseEntity<libro> saveLibro(@RequestBody libro Libro){//sirve para guardar las libroes
		
		try {
			Libro.setTitulo(Libro.getTitulo().toUpperCase());
			//Libro.setAutor_this(Libro.getAutor_this().getId());
			libro Autorguardado = Libro_servi.save(Libro);
			System.out.println("hicieron post");
			
			return  ResponseEntity.created(new URI("/libro/agregar/"+Autorguardado.getId())).body(Autorguardado);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
}
