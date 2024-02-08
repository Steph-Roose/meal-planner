package com.roose.mealplanner.restservice.recipe.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class RecipeDTO {

    private final String _id;

    private final String title;

    private final String description;

    private final int prepTime;

    private final int cookTime;

    private final String servings;

    private final String defaultInstructions;

    private final List<String> tags;

    public RecipeDTO(RecipeEntity entity) {
        this(
                entity.get_id(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getPrepTime(),
                entity.getCookTime(),
                entity.getServings(),
                entity.getDefaultInstructions(),
                entity.getTags()
        );
    }

}
