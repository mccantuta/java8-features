package com.mccl.poc;

import java.util.List;

public class Person {
    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(List<String> list) {
        this.name = list.get(0);
        this.address = list.get(1);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String returnFullData() {
        return name + " " + address;
    }
}
