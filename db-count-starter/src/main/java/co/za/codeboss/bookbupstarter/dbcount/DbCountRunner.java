package co.za.codeboss.bookbupstarter.dbcount;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Slf4j
public class DbCountRunner implements CommandLineRunner {

    private List<CrudRepository> repositories;

    public DbCountRunner(List<CrudRepository> repositories) {
        Collections.reverse(repositories);
        this.repositories = repositories;
    }

    @Override
    public void run(String... args) throws Exception {
        repositories.forEach(crudRepository -> {

            log.info("Deleting repository: {}", crudRepository.getClass().getName());
            crudRepository.deleteAll();

            log.info(String.format("%s has %s entries",
                    getRepositoryName(crudRepository.getClass()),
                    crudRepository.count()));
        });

    }

    private String getRepositoryName(Class crudRepositoryClass) {
        for (Class repositoryInterface : crudRepositoryClass.getInterfaces()) {
            if (repositoryInterface.getName().
                    startsWith("co.za.codeboss.bookpub.repository")) {
                return repositoryInterface.getSimpleName();
            }
        }
        return "UnknownRepository";
    }
}
