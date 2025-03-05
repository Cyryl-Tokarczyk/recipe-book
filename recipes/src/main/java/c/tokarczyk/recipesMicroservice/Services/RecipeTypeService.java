package c.tokarczyk.recipesMicroservice.Services;

import c.tokarczyk.recipesMicroservice.Entities.RecipeType;
import c.tokarczyk.recipesMicroservice.Repositories.RecipeTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RecipeTypeService {

    private RecipeTypeRepository repository;

    public RecipeTypeService(RecipeTypeRepository repository) {
        this.repository = repository;
    }

    public void save(RecipeType recipeType) {
        repository.save(recipeType);
    }

    public List<RecipeType> findAll() {
        return repository.findAll();
    }

    public RecipeType findById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
