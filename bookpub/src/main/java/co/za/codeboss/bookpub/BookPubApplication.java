package co.za.codeboss.bookpub;

import co.za.codeboss.bookbupstarter.dbcount.EnableDbCounting;
import co.za.codeboss.bookpub.repository.IBookRepository;
import co.za.codeboss.bookpub.properties.CustomProperties;
import co.za.codeboss.mongodb.EnableMongoDB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.*;

@Slf4j
@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties(CustomProperties.class)
@EnableDbCounting
@EnableMongoDB
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
