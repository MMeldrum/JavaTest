package com.companything.entities;

import java.util.ArrayList;
import java.util.List;

public class Product {

    String name;
    List<Question> questions = new ArrayList<>();

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return name;
    }
}
