package academy.elqoo.java8.stream;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Collects Characters from a string to a String
 */
public class CharacterToStringCollector implements Collector<Character, StringBuilder, String> {
    @Override
    public Supplier<StringBuilder> supplier() {
        return ()-> new StringBuilder();
    }

    @Override
    public BiConsumer<StringBuilder, Character> accumulator() {
        return (stringBuilder, character) -> stringBuilder.append(character);
    }

    @Override
    public BinaryOperator<StringBuilder> combiner() {
        return (stringBuilder, stringBuilder2) -> stringBuilder.append(stringBuilder2);
    }
    @Override
    public Function<StringBuilder, String> finisher() {
        return (stringBuilder ) -> stringBuilder.toString();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.CONCURRENT);
    }
}
