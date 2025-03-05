package c.tokarczyk.recipesMicroservice.Repositories;

import c.tokarczyk.recipesMicroservice.Entities.Recipe;
import c.tokarczyk.recipesMicroservice.Entities.RecipeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, UUID> {

    Optional<List<Recipe>> findByRecipeType(RecipeType recipeType);

}