package com.roose.mealplanner.restservice.ingredient;

import com.roose.mealplanner.restservice.ingredient.error.BadRequestException;
import com.roose.mealplanner.restservice.ingredient.error.IngredientNotFoundException;
import com.roose.mealplanner.restservice.ingredient.model.IngredientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static com.roose.mealplanner.restservice.ingredient.IngredientControllerV1.BASE_URI;

@RestController
@RequiredArgsConstructor
@RequestMapping(BASE_URI)
public class IngredientControllerV1 {

    public static final String BASE_URI = "/api/v1/ingredients";
    private final IngredientService ingredientService;

    @GetMapping("")
    public ResponseEntity<List<IngredientDTO>> getIngredients() {
        return ResponseEntity.ok(ingredientService.getIngredients().toList());
    }

    @GetMapping("/{ingredientId}")
    public ResponseEntity<IngredientDTO> getIngredientById(@PathVariable("ingredientId") final String ingredientId) {
        return ingredientService.getIngredient(ingredientId)
                .map(ResponseEntity::ok)
                .orElseThrow(IngredientNotFoundException::new);
    }

    @PostMapping("")
    public ResponseEntity<Object> addIngredient(@RequestBody final IngredientDTO ingredientDTO) throws URISyntaxException {
        if(ingredientDTO.get_id() != null) {
            throw new BadRequestException("Not allowed to set ID when creating a new ingredient");
        }
        final IngredientDTO body = ingredientService.addIngredient(ingredientDTO);
        return ResponseEntity.created(new URI(BASE_URI + "/" + body.get_id())).build();
    }

    @PutMapping("/{ingredientId}")
    public ResponseEntity<IngredientDTO> updateIngredient(@PathVariable("ingredientId") final String ingredientId, @RequestBody final IngredientDTO ingredientDTO) {
        return ingredientService.updateIngredient(ingredientId, ingredientDTO)
                .map(ResponseEntity::ok)
                .orElseThrow(IngredientNotFoundException::new);
    }

    @DeleteMapping("/{ingredientId}")
    public ResponseEntity<Object> removeIngredient(@PathVariable("ingredientId") final String ingredientId) {
        if(ingredientService.removeIngredient(ingredientId)) {
            return ResponseEntity.ok().build();
        } else {
            throw new IngredientNotFoundException();
        }
    }
}
