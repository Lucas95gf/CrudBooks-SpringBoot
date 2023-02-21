package com.projetoSpring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoSpring.demo.entity.BookEntity;

@Repository
public interface BookRepositoy extends JpaRepository<BookEntity, Long> {

}
