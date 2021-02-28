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
import com.credibanco.assessment.library.model.editorial;
import com.credibanco.assessment.library.services.editorial_servi;

@RestController
public class EditorialRest {

  	@Autowired
	private editorial_servi Editorial_servi;
  	
	@RequestMapping("/editoriales/")//listar editoriales
	@GetMapping	
	private ResponseEntity <List<editorial>> getAlleditoriales(){//este metodo trae a todas las editoriales
		//System.out.println("hicieron get");
		return ResponseEntity.ok(Editorial_servi.findAll());
		
	}
	
	@RequestMapping("/editorial/agregar/")
	@PostMapping
	private ResponseEntity<editorial> saveEditorial(@RequestBody editorial Editorial){//sirve para guardar las editoriales
		
		try {
			Editorial.setNombre(Editorial.getNombre().toUpperCase());
			editorial Autorguardado = Editorial_servi.save(Editorial);
			System.out.println("hicieron post");
			
			return  ResponseEntity.created(new URI("/editorial/agregar/"+Autorguardado.getId())).body(Autorguardado);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}

}
