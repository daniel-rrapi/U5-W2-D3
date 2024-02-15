package it.danielrrapi.U5W2D3.controllers;

import it.danielrrapi.U5W2D3.entities.BlogPost;
import it.danielrrapi.U5W2D3.servicies.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog-posts")
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;

    @GetMapping
    public List<BlogPost> getAllBlogPosts() {
        return this.blogPostService.getBlogPosts();
    }

    @GetMapping("/{id}")
    public BlogPost getBlogPost(@PathVariable int id) {
        return this.getBlogPost(id);
    }

    @PostMapping
    public BlogPost addBlogPost(@RequestBody BlogPost newBlogPost) {
        return this.blogPostService.saveBlogPost(newBlogPost);
    }

    @PutMapping("/{id}")
    public BlogPost updateBlogPost(@PathVariable int id ,@RequestBody BlogPost newBlogPost) {
        return this.blogPostService.findByIdAndUpdate(id, newBlogPost);
    }

    @DeleteMapping("/{id}")
    public void deleteBlogPost(@PathVariable int id) {
        this.blogPostService.findByIdAndDelete(id);
    }
}
