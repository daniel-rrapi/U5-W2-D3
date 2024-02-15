package it.danielrrapi.U5W2D3.repositories;

import it.danielrrapi.U5W2D3.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostDAO extends JpaRepository<BlogPost, Integer> {
}
