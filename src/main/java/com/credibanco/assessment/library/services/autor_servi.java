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
import com.credibanco.assessment.library.repository.autor_rep;

@Service
public class autor_servi  implements autor_rep{
	@Autowired
	private autor_rep Autor_rep;

	@Override
	public List<autor> findAll() {
		// TODO Auto-generated method stub
		return Autor_rep.findAll();
	}

	@Override
	public List<autor> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return Autor_rep.findAll(sort);
	}

	@Override
	public List<autor> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}
	

	public List<autor> findAllByName(String nombre) {
		// TODO Auto-generated method stub
		List<autor> autores =Autor_rep.findAll();
		List<autor> autor_salida =new ArrayList<>();
		int contador=0;
		for(contador=0;contador<autores.size();contador++) {
			//System.out.println("Esto sale en pantalla\n"+autores.get(contador).getNombre());
			if(autores.get(contador).getNombre().contains(nombre)) {
				autor_salida.add(autores.get(contador));
			}
		}
				
		return autor_salida;
	}

	@Override
	public <S extends autor> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends autor> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<autor> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public autor getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends autor> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends autor> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<autor> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends autor> S save(S entity) {
		// TODO Auto-generated method stub
		return Autor_rep.save(entity);
	}

	@Override
	public Optional<autor> findById(Long id) {
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
	public void delete(autor entity) {
		// TODO Auto-generated method stub
		Autor_rep.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends autor> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends autor> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends autor> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends autor> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends autor> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
