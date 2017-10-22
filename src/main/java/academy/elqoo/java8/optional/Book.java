package academy.elqoo.java8.optional;

import java.util.Optional;

public class Book {

    private String name;

    private String author;

    public Book(String name) {
        this.name = name;
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getAuthor(){
        return Optional.ofNullable(author);
    }
}
