package com.roose.mealplanner.restservice.ingredient.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientEntity {

    @Id
    private String _id;

    private String name;

    private String category;

    private String measurementType;

//    @ElementCollection
//    @CollectionTable(name = "ingredient_tags", joinColumns = @JoinColumn(name = "ingredient_id"))
    private List<String> tags;

    private LocalDateTime lastUpdated;

    public IngredientEntity(IngredientDTO dto) {
        this(
                dto.get_id(),
                dto.getName(),
                dto.getCategory(),
                dto.getMeasurementType(),
                dto.getTags(),
                LocalDateTime.now()
        );
    }

    public IngredientEntity updateIngredient(IngredientDTO dto) {
        this.name = dto.getName();
        this.category = dto.getCategory();
        this.measurementType = dto.getMeasurementType();
        this.tags = dto.getTags();
        this.lastUpdated = LocalDateTime.now();
        return this;
    }
}


