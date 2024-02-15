package it.danielrrapi.U5W2D3.repositories;

import it.danielrrapi.U5W2D3.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorDAO extends JpaRepository<Author, Integer> {
}
