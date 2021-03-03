package com.credibanco.assessment.library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.library.model.Pais;
import com.credibanco.assessment.library.services.PaisService;


@RestController
@RequestMapping ("/pais/")
public class PaisREST {

	
	@Autowired
	private PaisService paisService;
	
	@GetMapping
	private ResponseEntity<List<Pais>> getAllPaises (){
		return ResponseEntity.ok(paisService.findAll());
	}
	
	
}
