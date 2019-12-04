package co.za.codeboss.bookpub.repository;

import co.za.codeboss.bookpub.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IBookRepository extends CrudRepository<Book, Long> {
}
