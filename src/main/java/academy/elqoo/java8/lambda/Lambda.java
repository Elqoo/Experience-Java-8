package academy.elqoo.java8.lambda;


import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lambda {

    public static List<String> filter(List<String> strings, Predicate<String> condition){
        return strings.stream().filter(condition).collect(Collectors.toList());
    }

    public static void processWithinTransaction(/*Runnable runnable*/){
        Transaction transaction = new Transaction();
        transaction.start();
        transaction.stop();
    }

    public static String create(/* add functional interface to create something */){
        return null;
    }

    public static Integer getStringLength(String s /*place a function here*/){
        return null;
    }

    public static int multiply(int a, int b /* add a functional interface here */){
        return 0;
    }

    public static List<String> sortStrings(List<String> strings /* sorting can be done using a comparator */){
         return null;
    }

}
