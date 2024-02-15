package it.danielrrapi.U5W2D3.servicies;

import it.danielrrapi.U5W2D3.entities.BlogPost;
import it.danielrrapi.U5W2D3.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BlogPostService {
    private List<BlogPost> blogPosts = new ArrayList<>();

    public List<BlogPost> getBlogPosts() {
        return blogPosts;
    }

    public BlogPost saveBlogPost(BlogPost newBlogPost) {
        this.blogPosts.add(newBlogPost);
        return newBlogPost;
    }

    public BlogPost findById(int id) {
        BlogPost found = null;
        for(BlogPost blogPost : this.blogPosts) {
            if(blogPost.getId() == id) {
                found = blogPost;
            }
        }
        if(found != null) {
            return found;
        } else throw new NotFoundException(id);
    }

    public BlogPost findByIdAndUpdate(int id, BlogPost newBlogPost) {
        Iterator<BlogPost> iterator = this.blogPosts.iterator();
        while (iterator.hasNext()) {
            BlogPost current = iterator.next();
            if(current.getId() == id) {
                current.setTitolo(newBlogPost.getTitolo());
                current.setContenuto(newBlogPost.getContenuto());
                current.setCategoria(newBlogPost.getCategoria());
                current.setCover(newBlogPost.getCover());
                current.setTempoDiLettura(newBlogPost.getTempoDiLettura());
            }
        }
        return newBlogPost;
    }

    public void findByIdAndDelete(int id) {
        Iterator<BlogPost> iterator = this.blogPosts.iterator();
        while (iterator.hasNext()) {
            BlogPost current = iterator.next();
            if(current.getId() == id) {
                iterator.remove();
            }
        }
    }
}
