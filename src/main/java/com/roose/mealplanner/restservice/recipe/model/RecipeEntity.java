package com.roose.mealplanner.restservice.recipe.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecipeEntity {

    @Id
    private String _id;

    private String title;

    private String description;

    private int prepTime;

    private int cookTime;

    private String servings;

    private String defaultInstructions;

//    @ElementCollection
//    @CollectionTable(name = "recipe_tags", joinColumns = @JoinColumn(name = "recipe_id"))
    private List<String> tags = new ArrayList<>();

    public RecipeEntity(RecipeDTO dto) {
        this(
                dto.get_id(),
                dto.getTitle(),
                dto.getDescription(),
                dto.getPrepTime(),
                dto.getCookTime(),
                dto.getServings(),
                dto.getDefaultInstructions(),
                dto.getTags()
        );
    }
}
