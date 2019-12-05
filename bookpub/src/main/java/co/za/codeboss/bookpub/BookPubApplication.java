package co.za.codeboss.bookpub;

import co.za.codeboss.bookpub.repository.IBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.*;

@Slf4j
@SpringBootApplication
@EnableScheduling
public class BookPubApplication {
    /**
     * Configures IoC
     */
    @Bean
    StartupRunner scheduleRunner() {
        return new StartupRunner();
    }

    @Autowired
    private IBookRepository bookRepository;

    public static void main(String[] args) {
        log.info("Simple log statement with inputs {}, {} and {}", 1, 2, 3);
        SpringApplication.run(BookPubApplication.class, args);
    }

    /*@Scheduled annotation can be placed only on methods without arguments*/
    @Scheduled(initialDelay = 1000, fixedRate = 10000)
    public void run() {
        log.info("Number of books: " + bookRepository.count());
    }
}
