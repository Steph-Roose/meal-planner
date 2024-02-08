package com.roose.mealplanner.restservice.ingredient.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class IngredientDTO {

    private final String _id;

    private final String name;

    private final String category;

    private final String measurementType;

    private final List<String> tags;

    private final LocalDateTime lastUpdated;

    public IngredientDTO(IngredientEntity entity) {
        this(
                entity.get_id(),
                entity.getName(),
                entity.getCategory(),
                entity.getMeasurementType(),
                entity.getTags(),
                entity.getLastUpdated()
        );
    }
}
