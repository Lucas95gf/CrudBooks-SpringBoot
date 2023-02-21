package com.projetoSpring.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.projetoSpring.demo.entity.BookEntity;
import com.projetoSpring.demo.entity.dto.BookDTO;
import com.projetoSpring.demo.service.BookService;

@RestController
@RequestMapping("api/books")
public class BookController {

	
	@Autowired
	private BookService bookService;
	
	@GetMapping
	public List<BookEntity> findAll(){
		return bookService.findAll();
	}
	
	@GetMapping("/{id}")
	public BookEntity findById(@PathVariable Long id) {
		return bookService.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public BookEntity save(@RequestBody BookDTO dto) {
		return bookService.save(dto);
	}
	
	@PutMapping("/{id}")
	public BookEntity updateBook(@RequestBody BookDTO dto, @PathVariable Long id) {
		BookEntity bookEntity = bookService.findById(id);
		return bookService.update(bookEntity, dto);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		bookService.delete(id);
	}

}
