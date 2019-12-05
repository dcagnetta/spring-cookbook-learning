package co.za.codeboss.bookpub.controllers;


import co.za.codeboss.bookpub.entity.Book;
import co.za.codeboss.bookpub.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * http://localhost:8080/books
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookRepository bookRepository;

    @GetMapping()
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

}
