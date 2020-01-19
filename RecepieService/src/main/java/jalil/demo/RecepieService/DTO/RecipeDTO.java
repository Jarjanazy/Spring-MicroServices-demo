package jalil.demo.RecepieService.DTO;

import jalil.demo.RecepieService.Entities.Ingredient;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
public class RecipeDTO {
    private String preparation;
    private String recipeName;
    private IngredientDTO ingredients;

    public RecipeDTO(String preparation, String recipeName, List<Ingredient> ingredients){
        this.preparation = preparation;
        this.recipeName = recipeName;
        this.ingredients = new IngredientDTO(ingredients);
    }
}
