package academy.elqoo.java8.optional;

import java.util.Optional;

public class Optional8 {

    public static Optional<Book> getBook(){
        return Optional.of(new Book("Experience Java 8"));
    }

    public static Optional<Book> getBookWithAutohor(){
        return Optional.of(new Book("Stijn De Mulder"));
    }

}
