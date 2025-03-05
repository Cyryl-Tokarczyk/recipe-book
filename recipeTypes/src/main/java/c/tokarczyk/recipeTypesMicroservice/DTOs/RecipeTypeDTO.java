package c.tokarczyk.recipeTypesMicroservice.DTOs;

import c.tokarczyk.recipeTypesMicroservice.Entities.RecipeType;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;

@Data
public class RecipeTypeDTO {

    String name;

    @JsonCreator
    public RecipeTypeDTO(String name) {
        this.name = name;
    }

    public RecipeTypeDTO(RecipeType recipeType) {
        this.name = recipeType.getName();
    }
}
