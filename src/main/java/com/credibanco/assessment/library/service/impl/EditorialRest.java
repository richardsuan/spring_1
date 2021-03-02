package com.credibanco.assessment.library.service.impl;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.library.dto.dotautor;
import com.credibanco.assessment.library.dto.doteditorial;
import com.credibanco.assessment.library.model.autor;
import com.credibanco.assessment.library.model.editorial;
import com.credibanco.assessment.library.services.editorial_servi;
import com.credibanco.assessment.library.services.libro_servi;

@RestController
public class EditorialRest {

  	@Autowired
	private editorial_servi Editorial_servi;
  	@Autowired
	private libro_servi Libro_servi;
	@RequestMapping("/editoriales/")//listar editoriales
	@GetMapping	
	private ResponseEntity <List<doteditorial>> getAlleditoriales(){//este metodo trae a todas las editoriales
		//System.out.println("hicieron get");
		doteditorial dot_editoriales = new doteditorial();
		return ResponseEntity.ok(dot_editoriales.creardot(null, Editorial_servi,Libro_servi ));
		
	}
	
	
	@RequestMapping("/editorial/buscar")//buscar por nombre 
	@GetMapping
	private ResponseEntity<List<doteditorial>> getoneEditorial(@RequestParam("nombre")  String Editorial_busqueda){
		//List<autor> Autor =new ArrayList<>();
		
		doteditorial dot_editoriales = new doteditorial();

		return ResponseEntity.ok(dot_editoriales.creardot(Editorial_busqueda, Editorial_servi, Libro_servi));//cambiar
		//return ResponseEntity.ok(dot);
		
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
	@RequestMapping(value="/editorial/eliminar/{id}")
	@DeleteMapping
	private  ResponseEntity<Boolean> eliminarEditorial(@PathVariable Long id){
		Editorial_servi.deleteById(id);
		return ResponseEntity.ok(!(Editorial_servi.findById(id)!=null));
	}

}
