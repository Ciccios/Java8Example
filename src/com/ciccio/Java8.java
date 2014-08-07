package com.ciccio;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Person {

    private String name;
    private int age;

    Person(int age) {
        this.age = age;
    }

    Person(String name) {
        this.name = name;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class Java8 {

    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();

        persons.add(new Person("Francesco", 32));
        persons.add(new Person("Imma", 34));
        persons.add(new Person("Mary", 55));

        persons.add(new Person("A", 55));
        persons.add(new Person("b", 66));
        persons.add(new Person("c", 23));
        persons.add(new Person("d", 44));
        persons.add(new Person("e", 12));

        persons.add(new Person("A", 55));
        persons.add(new Person("b", 66));
        persons.add(new Person("c", 23));
        persons.add(new Person("d", 44));
        persons.add(new Person("e", 12));


        long start1 = System.nanoTime();
        persons.stream().mapToInt(Person::getAge).average().getAsDouble();
        long stop1 = System.nanoTime();

        System.out.println("TIME: " + (stop1 - start1));


        long start2 = System.nanoTime();
        persons.stream().collect(Collectors.groupingBy(Person::getAge));
        long end2 = System.nanoTime();

        System.out.println("TIME: " + (end2 - start2));

        long start3 = System.nanoTime();
        persons.parallelStream().collect(Collectors.groupingBy(Person::getAge));
        long end3 = System.nanoTime();

        System.out.println("TIME: " + (end3 - start3));


    }



}
