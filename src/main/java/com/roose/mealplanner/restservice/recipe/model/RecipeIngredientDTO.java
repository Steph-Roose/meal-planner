package com.roose.mealplanner.restservice.recipe.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class RecipeIngredientDTO {

    private final String _id;

    private final String name;

    private final int qty;

    private final String measurement;

    private final String type;

    private final String group;

    private final String ingredient_list_group;

    private final String prefix;

    private final String substituteId;

    private final String notes;

    private final String shoppingNotes;

    private final String preppingNotes;

    private final LocalDateTime lastUpdated;

    public RecipeIngredientDTO(RecipeIngredientEntity entity) {
        this(
                entity.get_id(),
                entity.getName(),
                entity.getQty(),
                entity.getMeasurement(),
                entity.getType(),
                entity.getGroup(),
                entity.getIngredientListGroup(),
                entity.getPrefix(),
                entity.getSubstituteId(),
                entity.getNotes(),
                entity.getShoppingNotes(),
                entity.getPreppingNotes(),
                entity.getLastUpdated()
        );
    }
}
