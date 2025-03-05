package c.tokarczyk.recipeTypesMicroservice.Repositories;

import c.tokarczyk.recipeTypesMicroservice.Entities.RecipeType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RecipeTypeRepository extends JpaRepository<RecipeType, UUID> {

    Optional<RecipeType> findByName(String name);

}
