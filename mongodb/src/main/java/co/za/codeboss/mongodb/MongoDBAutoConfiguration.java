package co.za.codeboss.mongodb;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories
public class MongoDBAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    MongoDBRunner mongoDBRunner() {
        return new MongoDBRunner();
    }

}
