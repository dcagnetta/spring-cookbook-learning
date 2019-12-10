package co.za.codeboss.bookbupstarter.dbcount;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

@Configuration
public class DbCountAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public DbCountRunner dbCountRunner(List<CrudRepository> repositories) {
        return new DbCountRunner(repositories);
    }

}
