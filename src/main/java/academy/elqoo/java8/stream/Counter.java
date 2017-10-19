package academy.elqoo.java8.stream;

import java.util.stream.LongStream;

public class Counter {

    public long counter = 0;

    public void add(long value) {
        counter += value;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            Counter counter = new Counter();
            LongStream.rangeClosed(0, 100).parallel().forEach(counter::add);
            System.out.println(counter.counter);
        }

    }

}



