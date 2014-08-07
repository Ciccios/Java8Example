package com.ciccio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.stream.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;


class Personaz {

    private String name;
    private String lastname;
    private int age;

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    private Gender gender;

    Personaz(String name, String lastname, int age, Gender gender) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }
}

public class Class3 {

    public static void main(String[] args) {


        List<Integer> ints = new ArrayList<>();

        ints.add(9);
        ints.add(21);
        ints.add(4);
        ints.add(5);
        ints.add(8);
        ints.add(12);
        ints.add(90);


        Stream<Integer> stream = ints.stream();

        List<Integer> collect = stream.filter(i -> i < 10).collect(Collectors.toList());

        System.out.println(collect);


        ints.stream().map(x -> x + 1).forEach(System.out::println);


        List<Personaz> personas = new ArrayList<>();
        personas.add(new Personaz("Ciccio1", "Abbate", 32, Gender.MALE));
        personas.add(new Personaz("Ciccio1.5", "Abbate", 32, Gender.MALE));
        personas.add(new Personaz("Ciccio2", "Abbate", 2, Gender.FEMALE));
        personas.add(new Personaz("Ciccio3", "Abbate", 3, Gender.FEMALE));
        personas.add(new Personaz("Ciccio4", "Abbate", 12, Gender.FEMALE));
        personas.add(new Personaz("Ciccio5", "Abbate", 22, Gender.MALE));
        personas.add(new Personaz("Ciccio6", "Abbate", 62, Gender.MALE));
        personas.add(new Personaz("Ciccio7", "Abbate", 42, Gender.MALE));

        Map<Integer, List<Personaz>> collect1 = personas.stream().collect(groupingBy(Personaz::getAge));

        Stream<Personaz> sss = personas.stream();


        IntStream intStream = sss.mapToInt(Personaz::getAge);




        //int characteristics = sss.spliterator().characteristics();
        //System.out.println("Characteristic:" + characteristics);

        Map<Boolean, List<Personaz>> collect2 = personas.stream().collect(Collectors.partitioningBy(i -> i.getAge() < 20));

        Map<Gender, List<Personaz>> collect3 = personas.stream().collect(Collectors.groupingBy(Personaz::getGender));

        String collect4 = personas.stream().map(Personaz::getName).collect(Collectors.joining(":"));

        Integer reduce = personas.stream().map(Personaz::getAge).reduce(0, (a, b) -> a + b);

        String reduce1 = personas.stream().map(Personaz::getName).reduce("", (a, b) -> a + b);

        System.out.println("REDUCE1:" + reduce1);

        System.out.println(collect4);

        System.out.println(collect3);

        System.out.println(collect2);

        System.out.println(collect1);

    }

}
