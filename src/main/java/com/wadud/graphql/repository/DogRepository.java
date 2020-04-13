package com.wadud.graphql.repository;

import com.wadud.graphql.model.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DogRepository extends CrudRepository<Dog, Long> {

    @Query("SELECT d FROM Dog d where d.breed = :breed ")
    String[] findDogBreed(@Param("breed") String breed);

    @Query("SELECT d.breed FROM Dog d where d.id = :id")
    Dog findDogBreedById(@Param("id") Long id);

    @Query("select d.name from Dog d")
    String[] findAllDogNames();

}
