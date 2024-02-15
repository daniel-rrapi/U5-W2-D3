package it.danielrrapi.U5W2D3.servicies;

import it.danielrrapi.U5W2D3.entities.Author;
import it.danielrrapi.U5W2D3.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class AuthorService {
    private List<Author> authors = new ArrayList<>();

    public List<Author> getAuthors() {
        return authors;
    }
    public Author saveAuthor(Author newUser) {
        Random random = new Random();
        newUser.setId(random.nextInt(1, 1000000));
        this.authors.add(newUser);
        return newUser;
    }
    public Author findById(int id) {
        Author found = null;
        for (Author author : this.authors) {
            if (author.getId() == id) {
                found = author;
            }
        }
        if (found == null) {
            throw  new NotFoundException(id);
        } else  return found;
    }
    public void findByIdAndUpdate(int id, Author updateUser) {
        Iterator<Author> iterator = this.authors.iterator();
        while (iterator.hasNext()) {
            Author current = iterator.next();
            if (current.getId() == id) {
                current.setNome(updateUser.getNome());
                current.setCognome(updateUser.getCognome());
                current.setEmail(updateUser.getEmail());
                current.setDataDiNascita(updateUser.getDataDiNascita());
            }
        }
    }
    public void findByIdAndDelete(int id) {
        Iterator<Author> iterator = this.authors.iterator();
        while (iterator.hasNext()) {
            Author current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
            }
        }
    }
}
