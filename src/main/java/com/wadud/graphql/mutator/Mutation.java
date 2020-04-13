package com.wadud.graphql.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.wadud.graphql.exception.DogNotFoundException;
import com.wadud.graphql.model.Dog;
import com.wadud.graphql.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class Mutation implements GraphQLMutationResolver {
    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Dog newDog(String name, String breed, String origin) {
        Dog dog = new Dog(name, breed, origin);
        dogRepository.save(dog);
        return dog;
    }

    public Boolean deleteDog(Long id) {
        dogRepository.deleteById(id);
        return true;
    }

    public Dog updateDog(String name, Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if (optionalDog.isPresent()) {
            Dog dog = optionalDog.get();
            dog.setName(name);
            dogRepository.save(dog);
            return dog;
        } else {
            throw new DogNotFoundException("Location not found", id);
        }
    }
}
