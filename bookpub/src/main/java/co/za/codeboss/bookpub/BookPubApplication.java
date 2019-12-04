package co.za.codeboss.bookpub;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class BookPubApplication {

    /**
     * Configures IoC
     */
    @Bean
    StartupRunner scheduleRunner() {
        return new StartupRunner();
    }

    public static void main(String[] args) {
        log.info("Simple log statement with inputs {}, {} and {}", 1, 2, 3);
        SpringApplication.run(BookPubApplication.class, args);
    }
}
