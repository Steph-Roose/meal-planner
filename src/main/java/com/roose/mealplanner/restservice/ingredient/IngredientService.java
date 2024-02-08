package com.roose.mealplanner.restservice.ingredient;

import com.roose.mealplanner.restservice.ingredient.model.IngredientDTO;

import java.util.Optional;
import java.util.stream.Stream;

public interface IngredientService {

    Stream<IngredientDTO> getIngredients();

    Optional<IngredientDTO> getIngredient(String id);

    IngredientDTO addIngredient(IngredientDTO ingredientDTO);

    Optional<IngredientDTO> updateIngredient(String id, IngredientDTO ingredientDTO);

    boolean removeIngredient(String id);
}
