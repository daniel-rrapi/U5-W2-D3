package it.danielrrapi.U5W2D3.servicies;

import it.danielrrapi.U5W2D3.entities.BlogPost;
import it.danielrrapi.U5W2D3.exceptions.NotFoundException;
import it.danielrrapi.U5W2D3.repositories.BlogPostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BlogPostService {
    @Autowired
    private BlogPostDAO blogPostDAO;

    public Page<BlogPost> getBlogPosts(int pageNumber, int size, String orderBy) {
        if(size > 100) size = 100;
        Pageable pageable = PageRequest.of(pageNumber, size, Sort.by(orderBy));
        return blogPostDAO.findAll(pageable);
    }

    public BlogPost saveBlogPost(BlogPost newBlogPost) {
       return blogPostDAO.save(newBlogPost);
    }

    public BlogPost findById(int id) {
        return blogPostDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public BlogPost findByIdAndUpdate(int id, BlogPost newBlogPost) {
        BlogPost found = this.findById(id);
        found.setTitolo(newBlogPost.getTitolo());
        found.setContenuto(newBlogPost.getContenuto());
        found.setCategoria(newBlogPost.getCategoria());
        found.setCover(newBlogPost.getCover());
        found.setTempoDiLettura(newBlogPost.getTempoDiLettura());
        return found;
    }
        public void findByIdAndDelete ( int id){
BlogPost found = this.findById(id);
blogPostDAO.delete(found);
        }
    }