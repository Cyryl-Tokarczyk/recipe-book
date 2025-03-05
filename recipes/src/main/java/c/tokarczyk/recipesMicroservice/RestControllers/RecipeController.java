package c.tokarczyk.recipesMicroservice.RestControllers;

import c.tokarczyk.recipesMicroservice.DTOs.RecipeCollectionDTO;
import c.tokarczyk.recipesMicroservice.DTOs.RecipeDTO;
import c.tokarczyk.recipesMicroservice.Entities.Recipe;
import c.tokarczyk.recipesMicroservice.Entities.RecipeType;
import c.tokarczyk.recipesMicroservice.Services.RecipeService;
import c.tokarczyk.recipesMicroservice.Services.RecipeTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

@RestController
public class RecipeController {

    RecipeService recipeService;
    RecipeTypeService recipeTypeService;

    public RecipeController(RecipeService recipeService, RecipeTypeService recipeTypeService) {
        this.recipeService = recipeService;
        this.recipeTypeService = recipeTypeService;
    }

    @GetMapping("/recipes")
    public ResponseEntity<RecipeCollectionDTO> getRecipes() {
        List<Recipe> list = recipeService.findAll();

        RecipeCollectionDTO recipeListDTO = new RecipeCollectionDTO(list);

        return ResponseEntity.ok(recipeListDTO);
    }

    @GetMapping("/recipes/{id}")
    public ResponseEntity<RecipeDTO> getRecipeById(@PathVariable UUID id) {
        Recipe recipe = recipeService.findById(id);

        if (recipe == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(recipe.dto());
        }
    }

    @GetMapping("/recipes/type/{typeId}")
    public ResponseEntity<RecipeCollectionDTO> getRecipesByType(@PathVariable UUID typeId) {

        RecipeType recipeType = recipeTypeService.findById(typeId);

        if (recipeType == null) {
            return ResponseEntity.notFound().build();
        }

        List<Recipe> list = recipeService.findByRecipeType(recipeType);
        RecipeCollectionDTO recipeListDTO = new RecipeCollectionDTO(list);

        if (list.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(recipeListDTO);
        }
    }

    @PutMapping("/recipes")
    public ResponseEntity<?> addRecipe(@RequestBody RecipeDTO recipeDTO) {

        RecipeType recipeType = recipeTypeService.findById(recipeDTO.getType());

        if (recipeType == null) {
            return ResponseEntity.badRequest().build();
        }

        Recipe recipe = new Recipe().toBuilder()
                .uuid(UUID.randomUUID())
                .name(recipeDTO.getName())
                .calories(recipeDTO.getCalories())
                .recipeType(recipeType)
                .build();
        recipeService.save(recipe);

        try {
            return ResponseEntity.created(new URI("/recipes/" + recipe.getUuid().toString())).body(recipe.dto());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/recipes/{id}")
    public ResponseEntity<?> addOrUpdateRecipe(@RequestBody RecipeDTO recipeDTO, @PathVariable UUID id) {

        Recipe recipe = recipeService.findById(id);
        RecipeType recipeType = recipeTypeService.findById(recipeDTO.getType());

        if (recipeType == null) {
            return ResponseEntity.badRequest().build();
        }

        if (recipe == null) {

            recipe = new Recipe().toBuilder()
                            .uuid(id)
                            .name(recipeDTO.getName())
                            .calories(recipeDTO.getCalories())
                            .recipeType(recipeType)
                            .build();

        } else {

            recipe.setName(recipeDTO.getName());
            recipe.setCalories(recipeDTO.getCalories());
            recipe.setRecipeType(recipeType);

        }
        recipeService.save(recipe);

        try {
            return ResponseEntity.created(new URI("/recipes/" + id.toString())).body(recipe.dto());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/recipes/{id}")
    public ResponseEntity<?> deleteRecipe(@PathVariable UUID id) {
        Recipe recipe = recipeService.findById(id);

        if (recipe == null) {
            return ResponseEntity.notFound().build();
        } else {
            recipeService.deleteById(id);

            return ResponseEntity.accepted().build();
        }
    }
}
