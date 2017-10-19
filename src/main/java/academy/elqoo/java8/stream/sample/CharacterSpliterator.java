package academy.elqoo.java8.stream.sample;

import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

public class CharacterSpliterator implements Spliterator<Character> {

    private final String string;
    private int currentChar = 0;
    private char seperator;


    public CharacterSpliterator(String string, char seperator) {
        this.string = string;
        this.seperator = seperator;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        action.accept(string.charAt(currentChar++));
        return currentChar < string.length();
    }

    @Override
    public Spliterator<Character> trySplit() {
        int splitPos = string.length()-currentChar;
        while(splitPos < string.length()){
	  if(string.charAt(splitPos)==seperator){
	      return new CharacterSpliterator(string.substring(0,splitPos),seperator);
	  }
	  splitPos++;
        }
        return null;
    }

    @Override
    public long estimateSize() {
        return string.length() - currentChar;
    }

    @Override
    public int characteristics() {
        return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
    }

    public static void main(String[] args) {
        Spliterator<Character> spliterator = new CharacterSpliterator("Hello this is a text Hot topic",' ');
        Stream<Character> stream = StreamSupport.stream(spliterator, true);
        stream.filter(character -> character == 'H').forEach(System.out::println);
    }
}
