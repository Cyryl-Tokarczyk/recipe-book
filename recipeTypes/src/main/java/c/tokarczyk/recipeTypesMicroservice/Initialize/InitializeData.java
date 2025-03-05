package c.tokarczyk.recipeTypesMicroservice.Initialize;

import c.tokarczyk.recipeTypesMicroservice.Entities.RecipeType;
import c.tokarczyk.recipeTypesMicroservice.Services.RecipeTypeService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {

    private final RecipeTypeService recipeTypeService;

    @Autowired
    public InitializeData(RecipeTypeService recipeTypeService) {
        this.recipeTypeService = recipeTypeService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (recipeTypeService.findAll().isEmpty()) {
            RecipeType lunch = RecipeType.builder()
                    .uuid(UUID.randomUUID())
                    .name("Lunch")
                    .build();

            RecipeType breakfast = RecipeType.builder()
                    .uuid(UUID.randomUUID())
                    .name("Breakfast")
                    .build();

            recipeTypeService.save(lunch);
            recipeTypeService.save(breakfast);
        }
    }

}
