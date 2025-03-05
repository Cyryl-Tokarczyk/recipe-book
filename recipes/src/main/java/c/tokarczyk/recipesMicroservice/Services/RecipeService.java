package c.tokarczyk.recipesMicroservice.Services;

import c.tokarczyk.recipesMicroservice.Entities.Recipe;
import c.tokarczyk.recipesMicroservice.Entities.RecipeType;
import c.tokarczyk.recipesMicroservice.Repositories.RecipeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class RecipeService {

    private RecipeRepository repository;

    public RecipeService(RecipeRepository repository) {
        this.repository = repository;
    }

    public void save(Recipe recipe) {
        repository.save(recipe);
    }

    public void deleteById(UUID uuid) {
        repository.deleteById(uuid);
    }

    @Transactional
    public List<Recipe> findAll() {
        return repository.findAll();
    }

    public List<Recipe> findByRecipeType(RecipeType recipeType) {
        return repository.findByRecipeType(recipeType).orElse(Collections.emptyList());
    }

    public Recipe findById(UUID id) {
        return repository.findById(id).orElse(null);
    }

}
