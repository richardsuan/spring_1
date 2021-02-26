package com.credibanco.assessment.library.dto;
import java.io.Serializable;

import com.credibanco.assessment.library.model.libro;
public class dotautor implements Serializable{
	
	
	private String nombre;
	private String  fecha_nacimiento;
	private String lugar_nacimiento;
	private String correo;
	//esto se hace para hacer las relaciones 
	private String  libros_escritos;
	
}
