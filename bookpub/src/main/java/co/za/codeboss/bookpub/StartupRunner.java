package co.za.codeboss.bookpub;

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
    private IBookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        log.info("\t >>>> Hello from CommandLineRunner, {}", getClass());
        log.info("Number of books: " + bookRepository.count());
    }

}
