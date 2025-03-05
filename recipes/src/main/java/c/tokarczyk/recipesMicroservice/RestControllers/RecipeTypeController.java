package c.tokarczyk.recipesMicroservice.RestControllers;

import c.tokarczyk.recipesMicroservice.Entities.RecipeType;
import c.tokarczyk.recipesMicroservice.Services.RecipeTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

@RestController
public class RecipeTypeController {

    RecipeTypeService recipeTypeService;

    public RecipeTypeController(RecipeTypeService recipeTypeService) {
        this.recipeTypeService = recipeTypeService;
    }

    @GetMapping("/recipeTypes")
    public ResponseEntity<List<UUID>> getRecipeTypes() {
        List<RecipeType> list = recipeTypeService.findAll();

        return ResponseEntity.ok(RecipeType.toListOfUuids(list));
    }

    @GetMapping("/recipeTypes/{id}")
    public ResponseEntity<UUID> getRecipeTypeById(@PathVariable UUID id) {
        RecipeType recipeType = recipeTypeService.findById(id);

        if (recipeType == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(recipeType.getUuid());
        }
    }

    @PutMapping("/recipeTypes/{id}")
    public ResponseEntity<?> addRecipeType(@PathVariable UUID id) {
        RecipeType recipeType = recipeTypeService.findById(id);

        if (recipeType == null) {

            recipeType = new RecipeType().toBuilder()
                    .uuid(id)
                    .build();

        }
        recipeTypeService.save(recipeType);

        try {
            return ResponseEntity.created(new URI("/recipeTypes/" + recipeType.getUuid().toString())).body(recipeType.getUuid());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/recipeTypes/{id}")
    public ResponseEntity<?> deleteRecipeType(@PathVariable UUID id) {
        RecipeType recipeType = recipeTypeService.findById(id);

        if (recipeType == null) {
            return ResponseEntity.notFound().build();
        } else {
            recipeTypeService.deleteById(id);

            return ResponseEntity.accepted().build();
        }
    }

}
