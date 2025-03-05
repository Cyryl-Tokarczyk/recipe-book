package c.tokarczyk.recipesMicroservice.DTOs;

import c.tokarczyk.recipesMicroservice.Entities.Recipe;
import lombok.Data;
import org.springframework.data.util.Pair;

import java.util.List;
import java.util.UUID;

@Data
public class RecipeCollectionDTO {

    List<Pair<UUID, String>> list;

    public RecipeCollectionDTO(List<Recipe> list) {
        this.list = list.stream().map(recipe -> Pair.of(recipe.getUuid(), recipe.getName())).toList();
    }
}
