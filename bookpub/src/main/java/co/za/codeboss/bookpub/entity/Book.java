package co.za.codeboss.bookpub.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull private String isbn;
    @NonNull private String title;
    @NonNull private String description;
    @ManyToOne
    private Author author;

    public Book(String isbn, String title, Author author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }
}
