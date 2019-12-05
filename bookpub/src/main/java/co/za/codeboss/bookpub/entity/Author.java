package co.za.codeboss.bookpub.entity;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@RequiredArgsConstructor // This adds a constructor for all fields that are either @NonNull or final.
public class Author {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull private String firstName;
    @NonNull private String lastName;
    @OneToMany(mappedBy = "author")
    private List<Book> books;
}
