package c.tokarczyk.recipeTypesMicroservice.Entities;

import c.tokarczyk.recipeTypesMicroservice.DTOs.RecipeTypeDTO;
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

    @Column(name = "recipe_type_name")
    String name;

    @Tolerate
    public RecipeType() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeType that = (RecipeType) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        String result = this.getName() + '\n';
        return result;
    }

    public RecipeTypeDTO dto() {
        return new RecipeTypeDTO(this);
    }
}
