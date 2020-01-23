package jalil.demo.RecepieService.DTO;

import jalil.demo.RecepieService.Entities.Ingredient;
import jalil.demo.RecepieService.Entities.Recipe;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
public class RecipeDTO {
    private String preparation;
    private String recipeName;
    private IngredientDTO ingredients;

    public RecipeDTO(Recipe recipe){
        this.preparation = recipe.getPreparation();
        this.recipeName = recipe.getRecipeName();
        this.ingredients = new IngredientDTO(recipe.getIngredients());
    }
}
