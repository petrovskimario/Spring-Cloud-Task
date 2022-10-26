package com.iwlabs.spring.cloud.task.repository;

import com.iwlabs.spring.cloud.task.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
}
