package com.example.springdata.models;


import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

@Entity(name = "owner")
public class Owner {

    // Идентификатор
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String ownerName;
    private int age;
    private boolean membership;

    /**
     * 1 owner = many dogs
     */
    @OneToMany(targetEntity = Dog.class, mappedBy = "owner")
    private Set<Dog> dogs;

    public Owner() {
    }

    public Owner(String ownerName, int age, boolean membership) {
        this.ownerName = ownerName;
        this.age = age;
        this.membership = membership;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getAge() {
        return age;
    }
    public boolean getMembership() {
        return membership;
    }
    // Список собак как коллекция для чтения
    public Set<Dog> getDogs() {
        return Collections.unmodifiableSet(dogs);
    }

    public void setDogs(Set<Dog> dogs) {
        this.dogs = dogs;
    }
}
