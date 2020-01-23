package jalil.demo.RecepieService.DAOTest;

import jalil.demo.RecepieService.DTO.RecipeDTO;
import jalil.demo.RecepieService.Entities.Ingredient;
import jalil.demo.RecepieService.Entities.Recipe;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class RecipeDAOTest {

    @Test
    @DisplayName("Construct a Recipe object")
    public void RecipeDTOConstructorTest(){
        Recipe recipe = new Recipe("test_recipeName");
        recipe.setPreparation("test_preparation");
        recipe.setIngredients(
                Arrays.asList(new Ingredient("test_ingredient1"), new Ingredient("test_ingredient2"))
        );
        RecipeDTO recipeDTO = new RecipeDTO(recipe);

        assertThat(recipeDTO.getRecipeName()).isEqualTo("test_recipeName");
        assertThat(recipeDTO.getPreparation()).isEqualTo("test_preparation");

        List<String> actualIngredientList = Arrays.asList("test_ingredient1", "test_ingredient2");
        assertThat(recipeDTO.getIngredients().getIngredientsNames()).isEqualTo(actualIngredientList);
    }
}
