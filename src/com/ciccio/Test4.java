package com.ciccio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Ciccio on 12/07/2014.
 */
public class Test4 {

    private ByteArrayOutputStream stream;
    private Character delimiter;

    public Test4(ByteArrayOutputStream stream) {
        this.stream = stream;
    }

    public Test4() {

        stream = new ByteArrayOutputStream(1024);
    }

    public void add(String element) {
        try {
            stream.write(element.getBytes());
            stream.write((int)'\t');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Test4 test4 = new Test4();
        test4.add("Ciccio1");
        test4.add("Ciccio2");
        test4.add("Ciccio3");
        test4.add("Ciccio4");
        test4.add("Ciccio5");

        ArrayList<String> strings = new ArrayList<>();
        strings.add("ciccio");
    }


}
