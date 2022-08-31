package com.example.springdata;

import com.example.springdata.models.Dog;
import com.example.springdata.models.Owner;
import com.example.springdata.models.Achievement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.springdata.services.DogService;
import com.example.springdata.services.OwnerService;
import com.example.springdata.services.AchievementService;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private OwnerService ownerService;
    private DogService dogService;
    private AchievementService achievementService;

    @Autowired
    public ConsoleRunner(OwnerService ownerService, DogService dogService, AchievementService achievementService) {
        this.ownerService = ownerService;
        this.dogService = dogService;
        this.achievementService = achievementService;
    }

    @Override
    public void run(String... args) throws Exception {

        // Создадим владельца собаки
        Owner owner_1 = new Owner("Shaggy", 25, true);
        // Используя сервисы зарегиструю владельца
        // Сервис через репозитории добавит владельца и его собаку в базу данных
        ownerService.registerOwner(owner_1);
        long dogId_1 = dogService.registerAccountForDog(owner_1, "GreatDane", "Scooby-Doo", 40.5);
        dogService.loseWeight(5, dogId_1); // сбросил вес
        dogService.getFat(15, dogId_1); // наелся начос
        Dog dog_1 = dogService.getInfoAboutDogById(dogId_1);
        long achievementId_1 = achievementService.registerAccountForAchievement(dog_1, 4, "5 4 4 5", "eating");
        achievementService.plusProgress("2 2 2 1", dogId_1); // начислим ещё баллов


        Owner owner_2 = new Owner("Cruella", 45, true);
        ownerService.registerOwner(owner_2);
        long dogId_2 = dogService.registerAccountForDog(owner_2, "Dalmatian", "Lucky", 15.5);
        dogService.getFat(1.9, dogId_2); // наелся начос
        Dog dog_2 = dogService.getInfoAboutDogById(dogId_2);
        achievementService.registerAccountForAchievement(dog_2, 2, "1 5 5 4", "running");
        achievementService.plusProgress("1 1 5 1", dogId_2); // начислим ещё баллов


        long dogId_3 = dogService.registerAccountForDog(owner_2, "Dalmatian", "Roly-Poly", 35.9);
        Dog dog_3 = dogService.getInfoAboutDogById(dogId_3);
        dogService.loseWeight(10, dogId_3); // сбросил вес
        achievementService.registerAccountForAchievement(dog_3, 10, "5 5 5 5", "barking");
        achievementService.plusProgress("1 2 2 1", dogId_3); // начислим ещё баллов

        long dogId_4 = dogService.registerAccountForDog(owner_2, "Dalmatian", "Spanky", 40);
        Dog dog_4 = dogService.getInfoAboutDogById(dogId_4);
        dogService.getFat(18, dogId_4); // наелся начос
        achievementService.registerAccountForAchievement(dog_4, 1, "1 1 1 2", "jumping");
        achievementService.plusProgress("1 0 0 1", dogId_4); // начислим ещё баллов


    }
}


