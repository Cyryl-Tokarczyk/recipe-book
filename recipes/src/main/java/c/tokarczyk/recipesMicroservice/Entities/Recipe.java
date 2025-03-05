package c.tokarczyk.recipesMicroservice.Entities;

import c.tokarczyk.recipesMicroservice.DTOs.RecipeDTO;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Tolerate;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Setter
@Getter
@Table(name = "recipes")
public class Recipe implements Comparable<Recipe>, Serializable {

    @Id
    private UUID uuid;

    @Column(name = "recipe_name")
    String name;

    @Column(name = "recipe_calories")
    int calories;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_type")
    RecipeType recipeType;

    @Tolerate
    public Recipe() {

    }

    @Override
    public String toString() {
        return this.getName() + " " + this.getCalories() + " kcal " + this.getRecipeType().getUuid();
    }

    @Override
    public int compareTo(Recipe o) {
        return this.getName().compareTo(o.getName());
    }

    public RecipeDTO dto() {
        return new RecipeDTO(this);
    }
}
