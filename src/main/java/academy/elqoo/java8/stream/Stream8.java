package academy.elqoo.java8.stream;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream8 {

    public static List<Integer> returnSquareRoot(List<Integer> numbers) {
        return numbers.stream().map(number -> (int) Math.sqrt(number)).collect(Collectors.toList());
        //throw new NotImplementedException();
    }

    public static List<Integer> getAgeFromUsers(List<User> users) {
        //return users.stream().filter (user -> user.getAge() >= 18 && user.getAge() <= 20 ).map(user -> user.getAge()).collect(Collectors.toList());
        //return users.stream().filter(user -> user.getAge() == 18 || user.getAge() == 20).map(User::getAge).collect(Collectors.toList());
        Predicate<User> condition = user -> (user.getAge() == 18 || user.getAge() == 20);
        return users.stream().filter(condition).map(User::getAge).collect(Collectors.toList());
    }

    public static List<Integer> getDistinctAges(List<User> users) {
        //return users.stream().map(User::getAge).distinct().collect(Collectors.toList());
        return users.stream().filter(distinctByKey(User::getAge)).mapToInt(e->e.getAge()).boxed().collect(Collectors.toList());
    }

    /**
     *
     * @param keyExtractor
     * @param <T>
     * @return
     */
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    public static List<User> getLimitedUserList(List<User> users, int limit) {
        return users.stream().limit(limit).collect(Collectors.toList());
        //throw new NotImplementedException();
    }

    public static Integer countUsersOlderThen25(List<User> users) {
        return (int) users.stream().filter(user -> user.getAge() > 25).count();
    }

    public static List<String> mapToUpperCase(List<String> strings) {
        //return strings.stream().map(str -> str.toUpperCase()).collect(Collectors.toList());
        //return strings.parallelStream().map(String::toUpperCase).collect(Collectors.toList());
        return strings.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    public static Integer sum(List<Integer> integers) {

        //return integers.stream().mapToInt(integer -> integer).sum();
       // return integers.stream().mapToInt(i -> i.intValue()).sum();
        //return integers.stream().mapToInt(Integer::intValue).sum();
        //return integers.stream().collect(Collectors.summingInt(Integer::intValue));
       /* LongAdder a = new LongAdder();
        integers.parallelStream().forEach(a::add);
        return a.intValue();*/
      // return integers.stream().reduce(0,Integer::sum);
        /*integers.stream()
                .reduce(0, (a,b) -> a+b);*/
       return IntStream.of(integers.stream().mapToInt(Integer::intValue).toArray()).sum();
    }

    public static List<Integer> skip(List<Integer> integers, Integer toSkip) {
        return integers.stream().skip(toSkip).collect(Collectors.toList());
    }

    public static List<String> getFirstNames(List<String> names) {
        return names.stream().map(str -> str.split(" ")[0]).collect(Collectors.toList());
    }

    public static List<String> getDistinctLetters(List<String> names) {
        return names.stream().map(str -> str.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
    }


    public static String separateNamesByComma(List<User> users) {
       return  users.stream().map(User::getName).collect(Collectors.joining(", "));
    }

    public static double getAverageAge(List<User> users) {
        return  users.stream().mapToDouble(User::getAge).average().getAsDouble();
    }

    public static Integer getMaxAge(List<User> users) {
        return users.stream().mapToInt(user -> user.getAge()).max().getAsInt();
    }

    public static Integer getMinAge(List<User> users) {
        return users.stream().mapToInt(User::getAge).min().getAsInt();
    }

    public static Map<Boolean, List<User>> partionUsersByGender(List<User> users) {
        //return users.stream().collect(Collectors.groupingBy(User::isMale));
        return users.stream().collect(Collectors.partitioningBy(User::isMale));
    }

    public static Map<Integer, List<User>> groupByAge(List<User> users) {
        //return users.stream().collect(Collectors.groupingBy(user -> user.getAge()));
        return users.stream().collect(Collectors.groupingBy(User::getAge));
    }

    public static Map<Boolean, Map<Integer, List<User>>> groupByGenderAndAge(List<User> users) {
        return users.stream().collect(Collectors.partitioningBy(User::isMale, Collectors.groupingBy(User::getAge)));
    }

    public static Map<Boolean, Long> countGender(List<User> users) {

        return users.stream().collect(Collectors.groupingBy(User::isMale,Collectors.counting()));

    }

    public static boolean anyMatch(List<User> users, int age) {
        return users.stream().anyMatch(user ->  user.getAge() == age );
    }

    public static boolean noneMatch(List<User> users, int age) {
       return users.stream().noneMatch(user -> user.getAge()==age);

    }

    public static Optional<User> findAny(List<User> users, String name) {
       // return users.stream().filter(user -> user.getName()==name).findAny();
        return users.stream().filter(user -> user.getName().matches(name)).findAny();
    }

    public static List<User> sortByAge(List<User> users) {
        return users.stream().sorted(Comparator.comparingInt(User::getAge)).collect(Collectors.toList());
    }

    public static Stream<Integer> getBoxedStream(IntStream stream) {
        return stream.boxed();

    }

    public static List<Integer> generateFirst10PrimeNumbers() {
       return IntStream.rangeClosed(2,40).filter(Stream8::isPrime).limit(10).boxed().collect(Collectors.toList());
    }

    public static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
    }

    public static List<Integer> generate10RandomNumbers() {
        return new Random().ints(0,100).limit(10).boxed().collect(Collectors.toList());
    }

    public static User findOldest(List<User> users) {
        return users.stream().sorted(Comparator.comparingInt(User::getAge).reversed()).findFirst().get();
    }

    public static int sumAge(List<User> users) {

        return users.stream().mapToInt(User::getAge).sum();
    }

    public static IntSummaryStatistics ageSummaryStatistics(List<User> users) {
        return users.stream().mapToInt(User::getAge).summaryStatistics();
    }


    public static List<Integer> MergingStreamsResultStreamBoth(Stream<Integer> stream1 , Stream<Integer> stream2) {
        return  Stream.concat(stream1, stream2).collect(Collectors.toList());
    }


    public static List<Integer> Merged4Streams_ResultContainsAllElements(Stream<Integer> stream1,Stream<Integer> stream2,Stream<Integer> stream3,Stream<Integer> stream4) {
        return  Stream.of(
                stream1, stream2, stream3, stream4)
                .flatMap(i -> i).collect(Collectors.toList());
    }
}
