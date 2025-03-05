package c.tokarczyk.recipeTypesMicroservice.DTOs;

import c.tokarczyk.recipeTypesMicroservice.Entities.RecipeType;
import lombok.Data;
import org.springframework.data.util.Pair;

import java.util.List;
import java.util.UUID;

@Data
public class RecipeTypeCollectionDTO {

    List<Pair<UUID, String>> list;

    public RecipeTypeCollectionDTO(List<RecipeType> list) {
        this.list = list.stream().map(recipeType -> Pair.of(recipeType.getUuid(), recipeType.getName())).toList();
    }

}
