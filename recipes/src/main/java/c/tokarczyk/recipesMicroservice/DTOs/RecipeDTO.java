package c.tokarczyk.recipesMicroservice.DTOs;

import c.tokarczyk.recipesMicroservice.Entities.Recipe;
import lombok.Data;

import java.util.UUID;

@Data
public class RecipeDTO implements Comparable<RecipeDTO> {

    String name;

    int calories;

    UUID type;

    public RecipeDTO(String name, int calories, UUID type) {
        this.name = name;
        this.calories = calories;
        this.type = type;
    }

    public RecipeDTO(Recipe recipe) {
        this.name = recipe.getName();
        this.calories = recipe.getCalories();
        this.type = recipe.getRecipeType().getUuid();
    }

    @Override
    public int compareTo(RecipeDTO o) {
        return this.getName().compareTo(o.getName());
    }
}
