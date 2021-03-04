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

import com.credibanco.assessment.library.dto.doteditorial;
import com.credibanco.assessment.library.dto.dotlibro;
import com.credibanco.assessment.library.model.autor;
import com.credibanco.assessment.library.model.editorial;
import com.credibanco.assessment.library.model.libro;
import com.credibanco.assessment.library.services.autor_servi;
import com.credibanco.assessment.library.services.editorial_servi;
import com.credibanco.assessment.library.services.libro_servi;

@RestController
public class LibroRest {
	@Autowired
	private libro_servi Libro_servi;
	@Autowired
	private autor_servi Autor_servi;
	@Autowired
	private editorial_servi Editorial_servi;
	@RequestMapping("/libros/")//listar libroes
	@GetMapping	
	private ResponseEntity <List<dotlibro>> getAll_libros(){//este metodo trae a todas las libroes
		//System.out.println("hicieron get");
		dotlibro dot_libro = new dotlibro();
		return ResponseEntity.ok(dot_libro.creardot(null, Editorial_servi, Libro_servi, Autor_servi));
		//return null;
	}
	//
	@RequestMapping(value="/libro/buscar")//buscar por nombre 
	@GetMapping
	private ResponseEntity<List<dotlibro>> getoneLibro(@RequestParam("titulo")  String libro_busqueda){
		System.out.println(libro_busqueda);
		//List<autor> Autor =new ArrayList<>();
		//System.out.println(libro_busqueda.getTitulo());
		dotlibro dotlibros = new dotlibro();

		return ResponseEntity.ok(dotlibros.creardot(libro_busqueda, Editorial_servi, Libro_servi,Autor_servi));//cambiar
		//return ResponseEntity.ok(dot);
		
	}
	//
	@RequestMapping(value="/libro/buscar2/{id}")
	@DeleteMapping
	private  ResponseEntity<List<libro>> buscar2Libro(@PathVariable Long id){
		//Libro_servi.deleteById(id);
		return ResponseEntity.ok((Libro_servi.findbookAutor(id)));
	}

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
	@RequestMapping(value="/libro/eliminar/{id}")
	@DeleteMapping
	private  ResponseEntity<Boolean> eliminarLibro(@PathVariable Long id){
		Libro_servi.deleteById(id);
		return ResponseEntity.ok(!(Libro_servi.findById(id)!=null));
	}

}
