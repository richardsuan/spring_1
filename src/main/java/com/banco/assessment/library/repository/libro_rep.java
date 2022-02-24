package com.banco.assessment.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.assessment.library.model.libro;

public interface libro_rep extends JpaRepository<libro, Long> {
	
}
