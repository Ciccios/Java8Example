package com.ciccio;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Ciccio on 26/07/2014.
 */

public class CiccioSpliterator implements Spliterator<Integer> {

    @Override
    public boolean tryAdvance(Consumer<? super Integer> action) {
        return false;
    }

    @Override
    public Spliterator<Integer> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return 0;
    }

    @Override
    public int characteristics() {
        return 0;
    }

    interface ciccio {

        default void cicciotest() {
            System.out.println(4);
        }

    }

    static class a implements ciccio {

    }


    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 2, 3, 4);

        List<String> collect = integers.stream().map(Object::toString).collect(Collectors.toList());
        System.out.println("sssssss:"+collect);


        String reduce = integers.stream().map(Object::toString).reduce("", String::concat);
        System.out.println(reduce);




//        int[] ints = {1, 2, 3, 4};
//        OfInt spliterator = Spliterators.spliterator(ints, Spliterator.ORDERED);
//
//        OfInt half1 = spliterator.trySplit();
//
//        spliterator.forEachRemaining((IntConsumer)System.out::println);
//        half1.forEachRemaining((IntConsumer)System.out::println);
//
//
//        IntStream intStream = IntStream.of(3, 4, 5, 6);
//        double asDouble = intStream.map(i -> i + 1)
//                .average().getAsDouble();
//
//
//        System.out.println(intStream.average().getAsDouble());


        List<Integer> ins = new ArrayList<>();

        ins.add(2);
        ins.add(3);
        ins.add(4);
        ins.add(5);

        Stream<Integer> of = Stream.of(1, 2, 3, 4);
        Stream<Integer> stream = ins.stream();

        IntStream of1 = IntStream.of(1, 2, 3, 4, 5);

        Spliterator<Integer> split = stream.spliterator();
        stream.map(integer -> integer + 1);

        stream.filter(i -> i >9);

        Predicate<Integer> predicate = (integer -> integer < 4);

        Predicate<Integer> predicate1 = integer -> integer > 20;

        Predicate<Integer> total = predicate.and(predicate1);

        Predicate<Integer> p =  i -> i > 8;


        Consumer<Integer> myConsumer = System.out::println;


        Runnable r = () -> {

            int i = 3;
            for (int j = 0; j < 100; j++) {
                System.out.println(j);
            }

        };

        new Thread(() -> {
            for (int j = 0; j < 100; j++) {
                System.out.println(j);
            }

        }).start();

        Callable<Integer> c = () -> 3;

        Callable<Integer> callable = () -> 5;

        Executors.newSingleThreadExecutor().submit(()-> 6);




    }
}
