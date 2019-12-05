package co.za.codeboss.bookpub;

import co.za.codeboss.bookpub.entity.Author;
import co.za.codeboss.bookpub.entity.Book;
import co.za.codeboss.bookpub.properties.CustomProperties;
import co.za.codeboss.bookpub.repository.IAuthorRepository;
import co.za.codeboss.bookpub.repository.IBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;

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
    @Autowired
    private CustomProperties _customProperties;


    @Override
    public void run(String... args) throws Exception {
        log.info(String.format(">>> %s to the Book Catalog System! <<<", _customProperties.getWelcomeMessage()));

        _authorRepository.deleteAll();
        _bookRepository.deleteAll();

        Author author = new Author("Dillan", "Cagnetta");
        author = _authorRepository.save(author);
        Book book = new Book("978-1-78528-415-1", "Spring Boot Recipes", author);
        _bookRepository.save(book);
    }

    /*@Scheduled annotation can be placed only on methods without arguments*/
    @Scheduled(initialDelay = 1000, fixedRate = 10000)
    public void run() {
        log.info("Number of books: " + _bookRepository.count());
    }

}
