package com.wadud.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.wadud.graphql.exception.DogNotFoundException;
import com.wadud.graphql.model.Dog;
import com.wadud.graphql.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class Query implements GraphQLQueryResolver {
    private final DogRepository repository;

    public Query(DogRepository repository) {
        this.repository = repository;
    }

    public Iterable<Dog> findAllDogs() {
        return repository.findAll();
    }

    public String[] findDogBreeds(String breed) {
        return repository.findDogBreed(breed);
    }

    public Dog findDogBreedById(Long id) {
        Optional<Dog> foundDog = Optional.ofNullable(repository.findDogBreedById(id));
        if (foundDog.isPresent()) {
            return foundDog.get();
        } else {
            throw new DogNotFoundException("Dog not valid", id);
        }
    }

    public String[] findAllDogNames() {
        return repository.findAllDogNames();
    }
}
