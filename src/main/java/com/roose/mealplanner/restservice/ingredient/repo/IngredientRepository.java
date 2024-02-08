package com.roose.mealplanner.restservice.ingredient.repo;

import com.roose.mealplanner.restservice.ingredient.model.IngredientEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IngredientRepository extends MongoRepository<IngredientEntity, String> {
}
