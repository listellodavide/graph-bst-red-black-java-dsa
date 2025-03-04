package com.hello.world.bst;

import java.util.Objects;
import java.util.UUID;

public final class Student extends BasicDataType {

    String name;
    String surname;
    int age;

    // Constructor
    public Student(String name, String surname, int age) {
        super();
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Student(UUID uuid, String name, String surname, int age) {
        super(uuid);
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Student(Integer weight, String name, String surname, int age) {
        super(weight);
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "uuid= " + super.getUuid() +
                ", weight= " + super.getWeight() +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name) && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }
}

