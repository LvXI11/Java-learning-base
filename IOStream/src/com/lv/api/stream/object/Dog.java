package com.lv.api.stream.object;

import java.io.Serializable;

public class Dog implements Serializable {
    private static final long serialVersionUID = 3323L;
    String name;
    int age;
    transient String secret;

    public Dog(String name, int age, String secret) {
        this.name = name;
        this.age = age;
        this.secret = secret;
    }
}
