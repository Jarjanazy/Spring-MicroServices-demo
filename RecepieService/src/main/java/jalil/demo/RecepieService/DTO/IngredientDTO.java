package jalil.demo.RecepieService.DTO;

import jalil.demo.RecepieService.Entities.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
public class IngredientDTO {
    private List<String> ingredientsNames = new ArrayList<>();

    public IngredientDTO(Ingredient ingredient){
        this.ingredientsNames.add(ingredient.getIngredientName());
    }

    public IngredientDTO(List<Ingredient> ingredients){
        this.ingredientsNames.addAll(
                ingredients.
                        stream().
                        map(Ingredient::getIngredientName).
                        collect(Collectors.toList()));
    }
}
