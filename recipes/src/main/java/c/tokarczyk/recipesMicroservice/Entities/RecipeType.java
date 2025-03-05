package c.tokarczyk.recipesMicroservice.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Tolerate;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Setter
@Getter
@Table(name = "recipe_types")
public class RecipeType implements Serializable {

    @Id
    private UUID uuid;

    @OneToMany(mappedBy = "recipeType", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    List<Recipe> recipes;

    @Tolerate
    public RecipeType() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeType that = (RecipeType) o;
        return Objects.equals(getRecipes(), that.getRecipes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid());
    }

    @Override
    public String toString() {
        String result = "";
        for (Recipe r : this.getRecipes()) {
            result += '\t' + r.getName() + '\n';
        }
        return result;
    }

    public static List<UUID> toListOfUuids(List<RecipeType> list) {
        return list.stream().map(RecipeType::getUuid).toList();
    }
}
