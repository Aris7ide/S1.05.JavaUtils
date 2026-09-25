package service;

import java.io.Serializable;

public class PersonClass implements Serializable {
    String name;
    String surname;
    int age;

    public PersonClass(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " " + surname + ". Age: " + age;
    }


}
