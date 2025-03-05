package c.tokarczyk.recipeTypesMicroservice.Services;

import c.tokarczyk.recipeTypesMicroservice.Entities.RecipeType;
import c.tokarczyk.recipeTypesMicroservice.Repositories.RecipeTypeRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class RecipeTypeService {

    private RecipeTypeRepository repository;

    private RestTemplate recipesRepository;

    public RecipeTypeService(
            RecipeTypeRepository repository,
            RestTemplateBuilder builder,
            @Value("${RECIPES_URL}") String recipesUrl
            ) {
        this.repository = repository;
        this.recipesRepository = builder.rootUri(recipesUrl).build();
    }

    public void save(RecipeType recipeType) {
        repository.save(recipeType);
        recipesRepository.put("/recipeTypes/" + recipeType.getUuid(), null);
    }

    public List<RecipeType> findAll() {
        return repository.findAll();
    }

    public RecipeType findByName(String name) {
        return repository.findByName(name).orElse(null);
    }

    public RecipeType findById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
        recipesRepository.delete("/recipeTypes/" + id);
    }
}
