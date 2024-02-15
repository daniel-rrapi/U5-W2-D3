package it.danielrrapi.U5W2D3.controllers;

import it.danielrrapi.U5W2D3.entities.Author;
import it.danielrrapi.U5W2D3.servicies.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> getAllAuthors() {
        return this.authorService.getAuthors();
    }

    @GetMapping("/{id}")
    public Author findById(@PathVariable int id) {
        return this.authorService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author saveAuthor(@RequestBody Author author) {
        return this.authorService.saveAuthor(author);
    }

    @PutMapping("/{id}")
    public void findByIdAndUpdate(@PathVariable int id, @RequestBody Author author) { this.authorService.findByIdAndUpdate(id, author);}

    @DeleteMapping("/{id}")
    public void findByIdAndDelete(@PathVariable int id) { this.authorService.findByIdAndDelete(id);}

}
