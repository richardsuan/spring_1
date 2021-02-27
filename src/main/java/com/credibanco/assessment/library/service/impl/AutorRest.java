package com.credibanco.assessment.library.service.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.credibanco.assessment.library.model.autor;
import com.credibanco.assessment.library.services.autor_servi;


@RestController
public class AutorRest {
	@Autowired
	private autor_servi Autor_servi;
	@RequestMapping("/autores/")//listar autores
	@GetMapping	
	private ResponseEntity <List<autor>> getAllautores(){//este metodo trae a todos los autores que estan en la base de datos
		System.out.println("hicieron get");
		return ResponseEntity.ok(Autor_servi.findAll());
		
	}
	//
	@RequestMapping("/autor/buscar/")//buscar por nombre 
	@GetMapping
	private ResponseEntity <List<autor>> getoneAutor(@RequestBody autor Autor){
		
		return ResponseEntity.ok(Autor_servi.findAllByName(Autor.getNombre()));//cambiar
		
	}
	
	//
	@RequestMapping("/autor/agregar/")
	@PostMapping
	private ResponseEntity<autor> saveAutor(@RequestBody autor Autor){//sirve para guardarlas personas y la anotacion sirve para hacer que el body sea obligatorio
		Autor.setNombre(Autor.getNombre().toUpperCase());
		autor Autorguardado = Autor_servi.save(Autor);
		System.out.println("hicieron post");
		try {
			
			
			return  ResponseEntity.created(new URI("/autor/"+Autorguardado.getId())).body(Autorguardado);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	
}

