package academy.elqoo.java8.stream;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;

    private Integer age;

    private boolean male;

    public User(Integer age) {
        this.age = age;
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, boolean male) {
        this.name = name;
        this.male = male;
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User(String name, Integer age, boolean male) {
        this.name = name;
        this.age = age;
        this.male = male;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public boolean isMale() {
        return male;
    }

    public static List<User> getUsersWithAge(Integer ... ages){
        List<User> users = new ArrayList<>();
        for (Integer age : ages) {
	  users.add(new User(age));
        }
        return users;
    }

}
