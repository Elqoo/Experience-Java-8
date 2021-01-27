package academy.elqoo.java8.lambda;


import java.util.Comparator;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class Lambda {

    public static List<String> filter(List<String> strings, Predicate<String> condition){
        return strings.stream().filter(condition).collect(Collectors.toList());
    }

    public static void processWithinTransaction(Runnable runnable){
        Transaction transaction = new Transaction();
        transaction.start(runnable);
        transaction.stop(runnable);
    }

    public static String create(Supplier s/* add functional interface to create something */){
        return s.get().toString();
    }

    public static Integer getStringLength(String s, Function<String,Integer> f /*place a function here*/){
        return f.apply(s);
    }

    public static int multiply(int a, int b, BiFunction<Integer, Integer,Integer> multiple /* add a functional interface here */){
        return multiple.apply(a,b);
    }

    public static List<String> sortStrings(List<String>  strings, Comparator comparator/* sorting can be done using a comparator */){
         return (List<String>) strings.stream().sorted(comparator).collect(Collectors.toList());
    }

}
