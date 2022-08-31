package com.example.springdata.services;

import com.example.springdata.models.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springdata.repositories.OwnerRepository;

import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    // Просим фреймворк инжектнуть сгенерированную реализацию интерфейса OwnerRepository
    @Autowired
    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public void registerOwner(Owner owner) {
        Optional<Owner> found = this.ownerRepository.
                findByOwnerName(owner.getOwnerName());

        if (found.isEmpty()) {
            this.ownerRepository.save(owner);
        }
    }
}

