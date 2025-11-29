package com.utility.model;

public abstract class Person {
    protected String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {   // encapsulation
        return name;
    }

    public abstract double computePay();   // abstraction
}
