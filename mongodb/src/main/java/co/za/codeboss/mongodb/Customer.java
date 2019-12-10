package co.za.codeboss.mongodb;

import lombok.Getter;
import org.springframework.data.annotation.Id;

public class Customer {
    @Id
    public String id;

    @Getter public String firstName;
    @Getter public String lastName;

    public Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }
}
