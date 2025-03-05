package c.tokarczyk.recipesMicroservice.Repositories;

import c.tokarczyk.recipesMicroservice.Entities.RecipeType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RecipeTypeRepository extends JpaRepository<RecipeType, UUID> {

}
