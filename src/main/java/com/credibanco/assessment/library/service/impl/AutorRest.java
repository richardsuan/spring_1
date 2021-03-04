package com.credibanco.assessment.library.service.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.library.dto.dotautor;
import com.credibanco.assessment.library.model.autor;
import com.credibanco.assessment.library.model.libro;
import com.credibanco.assessment.library.services.autor_servi;
import com.credibanco.assessment.library.services.libro_servi;


@RestController
public class AutorRest {
	@Autowired
	private autor_servi Autor_servi;
	@Autowired
	private libro_servi Libro_servi;
	@RequestMapping("/autores/")//listar autores
	@GetMapping	
	private ResponseEntity <List<dotautor>> getAllautores(){//este metodo trae a todos los autores que estan en la base de datos
		System.out.println("hicieron get");
		dotautor autor_salida = new dotautor();
		return ResponseEntity.ok(autor_salida.creardot(null,null,Autor_servi,Libro_servi));//cambiar
		
	}
	
	@RequestMapping(value="/autor/buscar")//buscar por nombre 
	@GetMapping
	private ResponseEntity<List<dotautor>> getoneAutor(@RequestParam("nombre")  String Autor_busqueda,@RequestParam("valor")  String valor){
		//List<autor> Autor =new ArrayList<>();
		System.out.println("hicieron get en /autor/buscar/ \n");
		System.out.println(valor);
		dotautor autor_salida = new dotautor();

		return ResponseEntity.ok(autor_salida.creardot(Autor_busqueda,valor,Autor_servi,Libro_servi));//cambiar
		//return ResponseEntity.ok(dot);
		
	}
	
	//
	@RequestMapping(value="/autor/eliminar/{id}")
	@DeleteMapping
	private  ResponseEntity<Boolean> eliminarAutor(@PathVariable Long id){
		Autor_servi.deleteById(id);
		return ResponseEntity.ok(!(Autor_servi.findById(id)!=null));
	}

	@RequestMapping("/autor/agregar/")
	@PostMapping
	private ResponseEntity<autor> saveAutor(@RequestBody autor Autor){//sirve para guardarlas personas y la anotacion sirve para hacer que el body sea obligatorio
		
		try {
			Autor.setNombre(Autor.getNombre().toUpperCase());
			autor Autorguardado = Autor_servi.save(Autor);
			
			
			return  ResponseEntity.created(new URI("/autor/agregar/"+Autorguardado.getId())).body(Autorguardado);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	//
	
	
	
}

