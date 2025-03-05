package c.tokarczyk.recipeTypesMicroservice.RestControllers;

import c.tokarczyk.recipeTypesMicroservice.DTOs.RecipeTypeCollectionDTO;
import c.tokarczyk.recipeTypesMicroservice.DTOs.RecipeTypeDTO;
import c.tokarczyk.recipeTypesMicroservice.Entities.RecipeType;
import c.tokarczyk.recipeTypesMicroservice.Services.RecipeTypeService;
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
    public ResponseEntity<RecipeTypeCollectionDTO> getRecipeTypes() {
        List<RecipeType> list = recipeTypeService.findAll();

        return ResponseEntity.ok(new RecipeTypeCollectionDTO(list));
    }

    @GetMapping("/recipeTypes/{id}")
    public ResponseEntity<RecipeTypeDTO> getRecipeTypeById(@PathVariable UUID id) {
        RecipeType recipeType = recipeTypeService.findById(id);

        if (recipeType == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(recipeType.dto());
        }
    }

    @PutMapping("/recipeTypes")
    public ResponseEntity<?> addRecipeType(@RequestBody RecipeTypeDTO recipeTypeDTO) {
        RecipeType recipeType = recipeTypeService.findByName(recipeTypeDTO.getName());

        if (recipeType == null) {

            recipeType = new RecipeType().toBuilder()
                    .uuid(UUID.randomUUID())
                    .name(recipeTypeDTO.getName())
                    .build();

        } else {

            recipeType.setName(recipeTypeDTO.getName());

        }
        recipeTypeService.save(recipeType);

        try {
            return ResponseEntity.created(new URI("/recipeTypes/" + recipeType.getUuid().toString())).body(recipeType.dto());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/recipeTypes/{id}")
    public ResponseEntity<?> addOrUpdateRecipeType(@RequestBody RecipeTypeDTO recipeTypeDTO, @PathVariable UUID id) {

        RecipeType recipeType = recipeTypeService.findById(id);

        if (recipeType == null) {

            recipeType = new RecipeType().toBuilder()
                    .uuid(id)
                    .name(recipeTypeDTO.getName())
                    .build();

        } else {

            recipeType.setName(recipeTypeDTO.getName());

        }
        recipeTypeService.save(recipeType);

        try {
            return ResponseEntity.created(new URI("/recipeTypes/" + recipeType.getUuid().toString())).body(recipeType.dto());
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
