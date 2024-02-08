package com.roose.mealplanner.restservice.recipe.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecipeIngredientEntity {

    @Id
    private String _id;

    private String name;

    private int qty;

    private String measurement;

    private String type;

    private String group;

    private String ingredientListGroup;

    private String prefix;

    private String substituteId;

    private String notes;

    private String shoppingNotes;

    private String preppingNotes;

    private LocalDateTime lastUpdated;

    public RecipeIngredientEntity(RecipeIngredientDTO dto) {
        this(
                dto.get_id(),
                dto.getName(),
                dto.getQty(),
                dto.getMeasurement(),
                dto.getType(),
                dto.getGroup(),
                dto.getIngredient_list_group(),
                dto.getPrefix(),
                dto.getSubstituteId(),
                dto.getNotes(),
                dto.getShoppingNotes(),
                dto.getPreppingNotes(),
                LocalDateTime.now()
        );
    }

    public RecipeIngredientEntity updateRecipeIngredient(RecipeIngredientDTO dto) {
        this.name = dto.getName();
        this.qty = dto.getQty();
        this.measurement = dto.getMeasurement();
        this.type = dto.getType();
        this.group = dto.getGroup();
        this.ingredientListGroup = dto.getIngredient_list_group();
        this.prefix = dto.getPrefix();
        this.substituteId = dto.getSubstituteId();
        this.notes = dto.getNotes();
        this.shoppingNotes = dto.getShoppingNotes();
        this.preppingNotes = dto.getPreppingNotes();
        this.lastUpdated = LocalDateTime.now();
        return this;
    }
}
