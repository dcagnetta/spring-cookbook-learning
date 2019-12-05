package co.za.codeboss.bookpub.repository;

import co.za.codeboss.bookpub.entity.Author;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * http://localhost:8080/authors
*/
//@RepositoryRestResource(collectionResourceRel = "writers", path = "writers")
@RepositoryRestResource
public interface IAuthorRepository extends PagingAndSortingRepository<Author, Long> {
}
