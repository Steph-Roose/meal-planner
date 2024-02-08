package com.roose.mealplanner.restservice.ingredient.impl;

import com.roose.mealplanner.restservice.ingredient.IngredientService;
import com.roose.mealplanner.restservice.ingredient.model.IngredientDTO;
import com.roose.mealplanner.restservice.ingredient.model.IngredientEntity;
import com.roose.mealplanner.restservice.ingredient.repo.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    final IngredientRepository ingredientRepo;


    @Override
    public Stream<IngredientDTO> getIngredients() {
        return ingredientRepo.findAll().stream().map(IngredientDTO::new);
    }

    @Override
    public Optional<IngredientDTO> getIngredient(String id) {
        return ingredientRepo.findById(id).map(IngredientDTO::new);
    }

    @Override
    public IngredientDTO addIngredient(IngredientDTO dto) {
        IngredientEntity entity = new IngredientEntity(dto);
        IngredientEntity result = ingredientRepo.save(entity);

        return new IngredientDTO(result);
    }

    @Override
    public Optional<IngredientDTO> updateIngredient(String id, IngredientDTO dto) {
        return ingredientRepo.findById(id)
                .map(entity -> entity.updateIngredient(dto))
                .map(ingredientRepo::save)
                .map(IngredientDTO::new);
    }

    @Override
    public boolean removeIngredient(String id) {
        ingredientRepo.deleteById(id);
        return ingredientRepo.findById(id).isEmpty();
    }
}
