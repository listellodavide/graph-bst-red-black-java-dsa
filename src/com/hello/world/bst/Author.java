package com.hello.world.bst;

import java.util.ArrayList;
import java.util.List;

public class Author {

    String name;
    String surname;
    String experience;
    Boolean topSeller;
    List<String> languages = new ArrayList<>();

    public Author(String name, String surname, String experience, Boolean topSeller, List<String> languages) {
        this.name = name;
        this.surname = surname;
        this.experience = experience;
        this.topSeller = topSeller;
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", experience='" + experience + '\'' +
                ", topSeller=" + topSeller +
                ", languages=" + languages +
                '}';
    }
}
