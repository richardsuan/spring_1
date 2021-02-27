package com.credibanco.assessment.library.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.library.model.autor;
import com.credibanco.assessment.library.model.libro;
import com.credibanco.assessment.library.repository.libro_rep;

@Service
public class libro_servi implements libro_rep {
	@Autowired
	private libro_rep Libro_rep;

	@Override
	public List<libro> findAll() {
		// TODO Auto-generated method stub
		return Libro_rep.findAll();
	}

	@Override
	public List<libro> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return Libro_rep.findAll(sort);
	}
	public List<libro> findbookAutor (Long id){
		List<libro> t_libros =Libro_rep.findAll();
		List<libro> libros =new ArrayList<>();
		int contador=0;
		for (contador=0;contador<t_libros.size();contador++) {
			if(t_libros.get(contador).getId()==id) {
				libros.add(t_libros.get(contador));
			}
		}
		return libros;
	}
	
/*
 * public List<autor> findAllByName(String nombre) {
		// TODO Auto-generated method stub
		List<libro> t_libros =Libro_rep.findAll();
		List<libro> libros =new ArrayList<>();
		int contador=0;
		for(contador=0;contador<();contador++) {
			//System.out.println("Esto sale en pantalla\n"+autores.get(contador).getNombre());
			if(.get(contador).getNombre().contains(nombre)) {
				.add(.get(contador));
			}
		}
				
		return ;
	}

 */
	@Override
	public List<libro> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends libro> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends libro> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<libro> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public libro getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends libro> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends libro> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<libro> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends libro> S save(S entity) {
		// TODO Auto-generated method stub
		return Libro_rep.save(entity);
	}

	@Override
	public Optional<libro> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(libro entity) {
		// TODO Auto-generated method stub
		Libro_rep.delete(entity);
		
	}

	@Override
	public void deleteAll(Iterable<? extends libro> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends libro> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends libro> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends libro> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends libro> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

}
