package academy.elqoo.java8.optional;

import org.junit.Test;

import java.io.OptionalDataException;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class OptionalTest {

    @Test
    public void shouldCreateEmptyOptional(){
        Optional<String> optional = Optional.empty(); // create empty optional
        assertThat(optional.isPresent(),equalTo(false));
    }

    @Test
    public void shouldReturnBookName(){
        Optional<Book> book = Optional8.getBook();
        String bookName = book.map(Book::getName).orElse(""); // book. ....
        assertThat(bookName,equalTo("Experience Java 8"));
    }

    @Test
    public void shouldReturnBookAuthor(){
        Optional<Book> book = Optional8.getBookWithAuthor();
        String authorName = book.flatMap(Book::getAuthor).orElse(""); // book. ....
        assertThat(authorName,equalTo("Stijn De Mulder"));
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldThrowNoElementException(){
        Optional<Book> book = Optional.empty();
        book.get().getAuthor();
    }

    @Test(expected = MyCustomException.class)
    public void shouldThrowOptionalEmptyException() throws MyCustomException {
        Optional<Book> book = Optional8.getBook();
        book.get().getAuthor().orElseThrow(() -> new MyCustomException());
    }

}
