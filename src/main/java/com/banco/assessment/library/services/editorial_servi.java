package com.banco.assessment.library.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.banco.assessment.library.model.autor;
import com.banco.assessment.library.model.editorial;
import com.banco.assessment.library.repository.editorial_rep;

@Service
public class editorial_servi implements editorial_rep {
	@Autowired
	private editorial_rep Editorial_rep;

	public List<editorial> findAllByName(String nombre) {
		// TODO Auto-generated method stub
		List<editorial> editoriales =Editorial_rep.findAll();
		List<editorial> editorial_salida =new ArrayList<>();
		int contador=0;
		for(contador=0;contador<editoriales.size();contador++) {
			//System.out.println("Esto sale en pantalla\n"+autores.get(contador).getNombre());
			if(editoriales.get(contador).getNombre().contains(nombre)) {
				editorial_salida.add(editoriales.get(contador));
			}
		}
				
		return editorial_salida;
	}
	
	public String findEditorialstring (Long id_libro){
		String editorial =" ";
		
		List<editorial> t_editoriales=Editorial_rep.findAll();
		
		
		int contador=0;
		for (contador=0;contador<t_editoriales.size();contador++) {
			if(t_editoriales.get(contador).getId()==id_libro) {
					
				editorial=editorial+" "+t_editoriales.get(contador).getNombre();
				
			}
		}
		
		return editorial;
		
	}
	
	@Override
	public List<editorial> findAll() {
		// TODO Auto-generated method stub
		return Editorial_rep.findAll();
	}

	@Override
	public List<editorial> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<editorial> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends editorial> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends editorial> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<editorial> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public editorial getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends editorial> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends editorial> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<editorial> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends editorial> S save(S entity) {
		// TODO Auto-generated method stub
		return Editorial_rep.save(entity);
	}

	@Override
	public Optional<editorial> findById(Long id) {
		// TODO Auto-generated method stub
		return Editorial_rep.findById(id);
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
		Editorial_rep.deleteById(id);
	}

	@Override
	public void delete(editorial entity) {
		// TODO Auto-generated method stub
		Editorial_rep.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends editorial> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends editorial> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends editorial> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends editorial> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends editorial> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
