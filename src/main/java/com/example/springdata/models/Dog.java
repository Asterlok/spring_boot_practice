package com.example.springdata.models;

import javax.persistence.*;
@Entity(name = "dog")
public class Dog {

    // Идентификатор
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String breed; //порода
    private String name;  //кличка
    private double weight; //вес


    /**
     * 1 dog == 1 owner
     * 1 owner == many dogs
     */
    @ManyToOne
    private Owner owner;

    public Dog() {
    }

    public Dog(String breed, String name, double weight) {
        this.breed = breed;
        this.name = name;
        setWeight(weight);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getWeight() {
        return weight;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
