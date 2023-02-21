package com.projetoSpring.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoSpring.demo.entity.BookEntity;
import com.projetoSpring.demo.entity.dto.BookDTO;
import com.projetoSpring.demo.repository.BookRepositoy;

@Service
public class BookService {

	@Autowired
	private BookRepositoy bookRepository;
	
	public List<BookEntity> findAll(){
	 return bookRepository.findAll();
	}
	
	public BookEntity findById(Long id) {
		Optional<BookEntity> entity = bookRepository.findById(id);
		
		if(entity.isPresent()) {
			return entity.get();
		}
		
		throw new RuntimeException();
	}
	
	public BookEntity save(BookDTO dto) {
		
		BookEntity entity = new BookEntity();
		entity.setName(dto.getName());
		entity.setYear(dto.getYear());
		entity.setEdition(dto.getEdition());
		entity.setAuthor(dto.getAuthor());
		
		return bookRepository.save(entity);
	}

	public BookEntity update(BookEntity entity, BookDTO dto) {
		
		entity.setName(dto.getName());
		entity.setYear(dto.getYear());
		entity.setEdition(dto.getEdition());
		entity.setAuthor(dto.getAuthor());
		
		return bookRepository.save(entity);
		
	}

	public void delete(Long id) {
		bookRepository.deleteById(id);
		}

	

}
