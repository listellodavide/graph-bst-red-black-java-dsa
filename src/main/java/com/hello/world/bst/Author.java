package com.hello.world.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public final class Author extends BasicDataType {

    String name;
    String surname;
    String experience;
    Boolean topSeller;
    List<String> languages = new ArrayList<>();

    public Author(UUID uuid, String name, String surname, String experience, Boolean topSeller, List<String> languages) {
        super(uuid);
        this.name = name;
        this.surname = surname;
        this.experience = experience;
        this.topSeller = topSeller;
        this.languages = languages;
    }

    public Author(Integer weight, String name, String surname, String experience, Boolean topSeller, List<String> languages) {
        super(weight);
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name) && Objects.equals(surname, author.surname) && Objects.equals(experience, author.experience) && Objects.equals(topSeller, author.topSeller) && Objects.equals(languages, author.languages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, experience, topSeller, languages);
    }
}
