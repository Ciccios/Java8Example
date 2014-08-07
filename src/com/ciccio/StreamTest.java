package com.ciccio;

import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 * Created by Ciccio on 02/08/2014.
 */
public class StreamTest {

    public static void main(String[] args) {


        IntStream ints1 = new Random().ints(1000000000);
        IntStream ints2 = new Random().ints(1000000000);

        IntStream parallel = ints1.parallel();

        long start = System.currentTimeMillis();
        DoubleStream doubleStream1 = ints2.mapToDouble(t -> t + 1.5);
        System.out.println(doubleStream1.count());

        long total = System.currentTimeMillis() - start;
        System.out.println("Total serial: " + total + " ms");


        long startp = System.currentTimeMillis();
        DoubleStream doubleStream = parallel.mapToDouble(t -> t + 1.5);
        System.out.println(doubleStream.count());

        long totalp = System.currentTimeMillis() - startp;
        System.out.println("Total parallel: " + totalp + " ms");



    }


}
