package com.example.springdata.services;

import com.example.springdata.models.Dog;
import com.example.springdata.models.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.example.springdata.repositories.DogRepository;

import java.math.BigDecimal;

@Service
@Primary
public class DogServiceImpl implements DogService {

    private final DogRepository dogRepository;

    // Просим фреймворк инжектнуть сгенерированную реализацию интерфейса DogRepository
    @Autowired
    public DogServiceImpl(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Long registerAccountForDog(Owner owner, String breed, String name, double weight) {
        Dog dog = new Dog(breed, name, weight);
        dog.setOwner(owner);
        this.dogRepository.save(dog);
        return dog.getId();
    }

    @Override
    public Dog getInfoAboutDogById(Long id) {
        return this.dogRepository.findDogById(id);
    }

    @Override
    public void loseWeight(double weight, Long id) {

        Dog dog = this.dogRepository
                .findById(id)
                .orElseThrow();

        if (Double.compare(dog.getWeight(), (weight)) < 0) {
            System.out.println("Wtf you're air or nothing ???");
        }

        dog.setWeight(subtract(dog.getWeight(), (weight))); //вычитаем double веса
        this.dogRepository.save(dog);
    }

    /**
     * it could help me to subtract double {weight}
     */
    public static double subtract(double first, double second) {
        BigDecimal b1 = new BigDecimal(Double.toString(first));
        BigDecimal b2 = new BigDecimal(Double.toString(second));
        return b1.subtract(b2).doubleValue();
    }

    @Override
    public void getFat(double weight, Long id) {
        Owner owner = dogRepository.findDogById(id).getOwner();

        Dog dog = this.dogRepository.findById(id).orElseThrow();

        dog.setWeight(Double.sum(dog.getWeight(), (weight)));
        this.dogRepository.save(dog);
    }
}
