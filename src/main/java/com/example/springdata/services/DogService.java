package com.example.springdata.services;

import com.example.springdata.models.Dog;
import com.example.springdata.models.Owner;

public interface DogService {
    Long registerAccountForDog(Owner owner, String breed, String name, double weight);

    Dog getInfoAboutDogById(Long id);

    void loseWeight(double weight, Long id); // пёс худеет
    void getFat(double weight, Long id); // пёс толстеет
}

