package epicode.u5d7hw.controllers;

import epicode.u5d7hw.entities.Author;
import epicode.u5d7hw.entities.Blogpost;
import epicode.u5d7hw.payloads.BlogpostPayload;
import epicode.u5d7hw.services.AuthorsService;
import epicode.u5d7hw.services.BlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs") // Definisce l'URL di base per tutti i metodi in questa classe
public class BlogsController {
    @Autowired
    BlogsService blogsService;

    @Autowired
    AuthorsService authorsService;

    // 1. - POST http://localhost:3001/blogs (+ req.body)
    @PostMapping("") // Utilizza solo @PostMapping, poiché l'URL di base è già definito
    @ResponseStatus(HttpStatus.CREATED)
    public Blogpost saveBlog(@RequestBody BlogpostPayload payload) {
        // Cerca l'autore utilizzando l'id ricevuto nel payload
        Author author = authorsService.findById(payload.getAuthorId());

        // Crea un nuovo Blogpost e assegna i valori del payload
        Blogpost blogpost = new Blogpost();
        blogpost.setTitle(payload.getTitle());
        blogpost.setContent(payload.getContent());
        blogpost.setReadingTime(payload.getReadingTime());
        blogpost.setAuthor(author); // Assegna l'autore trovato

        // Salva e restituisce il blog post
        return blogsService.save(blogpost);
    }

    // 2. - GET http://localhost:3001/blogs
    @GetMapping("")
    public List<Blogpost> getBlogs() {
        return blogsService.getBlogs();
    }

    // 3. - GET http://localhost:3001/blogs/{id}
    @GetMapping("/{blogId}")
    public Blogpost findById(@PathVariable int blogId) {
        return blogsService.findById(blogId);
    }

    // 4. - PUT http://localhost:3001/blogs/{id} (+ req.body)
    @PutMapping("/{blogId}")
    public Blogpost findAndUpdate(@PathVariable int blogId, @RequestBody Blogpost body) {
        return blogsService.findByIdAndUpdate(blogId, body);
    }

    // 5. - DELETE http://localhost:3001/blogs/{id}
    @DeleteMapping("/{blogId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
    public void findAndDelete(@PathVariable int blogId) {
        blogsService.findByIdAndDelete(blogId);
    }
}
