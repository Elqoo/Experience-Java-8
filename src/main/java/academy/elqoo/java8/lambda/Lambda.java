package academy.elqoo.java8.lambda;


import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Lambda {

    public static List<String> filter(List<String> strings, Predicate<String> condition){
        return strings.stream().filter(condition).collect(Collectors.toList());
    }

    public static void processWithinTransaction(Runnable runnable){
        Transaction transaction = new Transaction();
        transaction.start();
        runnable.run();
        transaction.stop();
    }

    public static String create(Supplier<String> supplier){
        return supplier.get();
    }

    public static Integer getStringLength(String s, Function<String, Integer> function){
        return function.apply(s);
    }

    public static int multiply(int a, int b , BinaryOperator<Integer> operation){
        return operation.apply(a, b);
    }

    public static List<String> sortStrings(List<String> strings, Comparator<String> comparator){
         strings.sort(comparator);
         return strings;
    }

}
