package com.ciccio;

import java.util.function.Function;

/**
 * Created by Ciccio on 29/05/2014.
 */

class Persona {
    String name;
    String lastname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void func(Function<Integer, String> function) {



    }
}


interface CiccioTest1 {
    void ciccio(Persona p);
}





public class Class2 {


    public static void print(Persona p, CiccioTest1 test) {
        test.ciccio(p);
    }


    public static void main(String[] args) {

        CiccioTest1 check = (Persona p) -> System.out.println(p.getName());

        Persona persona = new Persona();
        persona.setName("Winnino");

        print(persona, check);




    }

}
