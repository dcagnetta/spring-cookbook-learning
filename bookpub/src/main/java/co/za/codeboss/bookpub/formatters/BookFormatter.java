package co.za.codeboss.bookpub.formatters;

import co.za.codeboss.bookpub.entity.Book;
import co.za.codeboss.bookpub.repository.IBookRepository;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class BookFormatter implements Formatter<Book> {
    private IBookRepository repository;

    public BookFormatter(IBookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book parse(String bookIdentifier, Locale locale) throws ParseException {
        Book book = repository.findBookByIsbn(bookIdentifier);
        return book != null
                ? book
                : repository.findById(Long.valueOf(bookIdentifier)).get();
    }

    @Override
    public String print(Book book, Locale locale) {
        return book.getIsbn();
    }
}
