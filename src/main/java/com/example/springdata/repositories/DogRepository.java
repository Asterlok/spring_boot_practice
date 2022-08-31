package com.example.springdata.repositories;

import com.example.springdata.models.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {
    Dog findDogById(Long id);
}

