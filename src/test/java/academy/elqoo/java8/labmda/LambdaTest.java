package academy.elqoo.java8.labmda;

import academy.elqoo.java8.lambda.Lambda;
import academy.elqoo.java8.lambda.TransactionLambda;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class LambdaTest {

    @Test
    public void removeStringsWithMoreThanThreeCharacters(){
        List<String> input = asList("This", "is", "java", "8");
        //input = Lambda.filter(input, s -> s.length()<3)
;       assertThat(input, contains("is", "8"));
    }

    @Test
    public void shouldBeExecutedWitingATransaction(){
        TransactionLambda lambda = new TransactionLambda();
        //Lambda.processWithinTransaction(lambda);
        assertTrue(lambda.isConsumed());
    }

    @Test
    public void shouldCreateAString(){
        String bigString = Lambda.create();
        assertTrue(bigString.length()>0);
    }

    @Test
    public void extractStringSize(){
        String myString = "This is great";
        int length = Lambda.getStringLength(myString/* get string length*/);
        assertTrue(length==13);
    }

    @Test
    public void multiply(){
        int a = 5;
        int b = 6;
        int result = Lambda.multiply(a,b);
        assertTrue(result==30);
    }

    @Test
    public void shouldSortStrings() throws Exception {
        List<String> input = Arrays.asList("C", "F", "A", "D", "B", "E");
        List<String> result = Lambda.sortStrings(input);
        assertThat(result, is(equalTo(Arrays.asList("A", "B", "C", "D", "E", "F"))));
    }


}
