package co.za.codeboss.bookbupstarter.dbcount;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

@Slf4j
public class DbCountRunner implements CommandLineRunner {

    private Collection<CrudRepository> repositories;

    public DbCountRunner(Collection<CrudRepository> repositories) {
        this.repositories = repositories;
    }

    @Override
    public void run(String... args) throws Exception {
        repositories.forEach(crudRepository ->
                log.info(String.format("%s has %s entries",
                        getRepositoryName(crudRepository.getClass()),
                        crudRepository.count())));
    }

    private String  getRepositoryName(Class crudRepositoryClass) {
        for (Class repositoryInterface : crudRepositoryClass.getInterfaces()) {
            if (repositoryInterface.getName().
                    startsWith("com.example.bookpub.repository")) {
                return repositoryInterface.getSimpleName();
            }
        }
        return "UnknownRepository";
    }
}
