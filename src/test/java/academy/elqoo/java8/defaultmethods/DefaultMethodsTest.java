package academy.elqoo.java8.defaultmethods;

import academy.elqoo.java8.stream.CharacterToStringCollector;
import academy.elqoo.java8.stream.Stream8;
import academy.elqoo.java8.stream.User;
import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.*;

public class DefaultMethodsTest {

    @Test
    public void shouldMoveShape(){
        Shape shape = new Rectangle();
        // implement a default move method without changing the Rectangle class
        // shape.move(10,10);
        assertThat(10, equalTo(shape.getXPos()));
        assertThat(10, equalTo(shape.getYPos()));
    }

    @Test
    public void shouldMoveXposWith10(){

        Rectangle rectangle = new Rectangle();
        Triangle triangle = new Triangle();
        List<AbstractShape> shapes = asList(rectangle, triangle);
        // write a static method on shape that add 10 to each xPos of a shape
        // Shape.moveXPosWith10(shapes);
        assertThat(10, equalTo(rectangle.getXPos()));
        assertThat(10, equalTo(triangle.getXPos()));

    }

    @Test(expected = NotImplementedException.class)
    public void shouldThrowNotImplementedException(){
        // add an optional method to the shape method
        Triangle triangle = new Triangle();
        // triangle.notImplementedMethod();
    }

    @Test
    public void shouldReturnNameForTriangle(){
        Shape shape = new Triangle();
        assertThat("fill in right name here",equalTo(shape.getName()));
    }

    @Test
    public void shouldReturnNameForRectangle(){
        Shape shape = new Rectangle();
        assertThat("fill in right name here",equalTo(shape.getName()));
    }

    @Test
    public void shouldProvideName(){
        // make rectangle implement NamedObject
        NamedObject namedObject = null; // = new Rectangle()
        assertThat("fill in right name here",equalTo(namedObject.getName()));
    }


}
