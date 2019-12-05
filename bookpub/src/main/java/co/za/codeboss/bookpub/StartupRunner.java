package co.za.codeboss.bookpub;

import co.za.codeboss.bookpub.entity.Author;
import co.za.codeboss.bookpub.entity.Book;
import co.za.codeboss.bookpub.repository.IAuthorRepository;
import co.za.codeboss.bookpub.repository.IBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

/**
 * Command-line runners are a useful functionality to execute the various types of code
 * that only have to be run once, after startup
 */
@Slf4j
public class StartupRunner implements CommandLineRunner {

    @Autowired
    private IBookRepository _bookRepository;
    @Autowired
    private IAuthorRepository _authorRepository;


    @Override
    public void run(String... args) throws Exception {
        log.info(">>> Welcome to the Book Catalog System! <<<");

        _authorRepository.deleteAll();
        _bookRepository.deleteAll();

        Author author = new Author("Dillan", "Cagnetta");
        author = _authorRepository.save(author);
        Book book = new Book("978-1-78528-415-1", "Spring Boot Recipes", author);
        _bookRepository.save(book);
    }

}
