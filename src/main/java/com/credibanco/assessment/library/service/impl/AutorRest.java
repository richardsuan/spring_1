package com.credibanco.assessment.library.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.credibanco.assessment.library.model.autor;
import com.credibanco.assessment.library.services.autor_servi;


@RestController
@RequestMapping("/autor/")
public class AutorRest {
	@Autowired
	private autor_servi Autor_servi;
	@GetMapping
	private ResponseEntity <List<autor>> getAllautores(){
		return ResponseEntity.ok(Autor_servi.findAll());
	}
}
