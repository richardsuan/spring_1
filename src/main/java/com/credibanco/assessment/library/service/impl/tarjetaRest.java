package com.credibanco.assessment.library.service.impl;

import java.net.URI;
import java.util.List;

import com.credibanco.assessment.library.model.tarjeta;
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

import com.credibanco.assessment.library.dto.dotTarjeta;
import com.credibanco.assessment.library.services.user_servi;
import com.credibanco.assessment.library.services.tarjeta_servi;

@RestController
public class tarjetaRest {
	@Autowired
	private tarjeta_servi Libro_servi;
	@Autowired
	private user_servi Autor_servi;
	@RequestMapping("/libros/")//listar libroes
	@GetMapping	
	private ResponseEntity <List<dotTarjeta>> getAll_libros(){//este metodo trae a todas las libroes
		//System.out.println("hicieron get");
		dotTarjeta dot_libro = new dotTarjeta();
		return ResponseEntity.ok(dot_libro.creardot(null, Libro_servi, Autor_servi));
		//return null;
	}
	//
	@RequestMapping(value="/libro/buscar")//buscar por nombre 
	@GetMapping
	private ResponseEntity<List<dotTarjeta>> getoneLibro(@RequestParam("titulo")  String libro_busqueda){
		System.out.println(libro_busqueda);
		//List<autor> Autor =new ArrayList<>();
		//System.out.println(libro_busqueda.getTitulo());
		dotTarjeta dotlibros = new dotTarjeta();

		return ResponseEntity.ok(dotlibros.creardot(libro_busqueda, Libro_servi,Autor_servi));//cambiar
		//return ResponseEntity.ok(dot);
		
	}
	//
	@RequestMapping(value="/libro/buscar2/{id}")
	@DeleteMapping
	private  ResponseEntity<List<tarjeta>> buscar2Libro(@PathVariable Long id){
		//Libro_servi.deleteById(id);
		return ResponseEntity.ok((Libro_servi.findbookAutor(id)));
	}

	//
	@RequestMapping("/libro/agregar/")
	@PostMapping
	private ResponseEntity<tarjeta> saveLibro(@RequestBody tarjeta tarjeta){//sirve para guardar las libroes
		
		try {
			tarjeta.setTitulo(tarjeta.getTitulo().toUpperCase());
			//Libro.setAutor_this(Libro.getAutor_this().getId());
			tarjeta Autorguardado = Libro_servi.save(tarjeta);
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
