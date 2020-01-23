package jalil.demo.RecepieService.DAOTest;


import jalil.demo.RecepieService.DTO.IngredientDTO;
import jalil.demo.RecepieService.Entities.Ingredient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class IngredientDAOTest {
    @Test
    @DisplayName("Construct with a single Ingredient object")
    public void IngredientDAOConstructor_singleIngredientTest(){
        Ingredient ingredient = new Ingredient("test_ingredient");
        IngredientDTO ingredientDTO = new IngredientDTO(ingredient);

        assertThat(ingredientDTO.getIngredientsNames().size()).isEqualTo(1);
        assertThat(ingredientDTO.getIngredientsNames().get(0)).isEqualTo("test_ingredient");
    }

    @Test
    @DisplayName("Construct with a list of Ingredients")
    public void IngredientDAOConstructor_ListIngredientTest(){
        List<Ingredient> ingredientList = Arrays.asList(
                new Ingredient("test_ingredient1"),
                new Ingredient("test_ingredient2"),
                new Ingredient("test_ingredient3")
        );
        IngredientDTO ingredientDTO = new IngredientDTO(ingredientList);

        assertThat(ingredientDTO.getIngredientsNames().size()).isEqualTo(3);

        List<String> ingredientList_actual = Arrays.asList("test_ingredient1", "test_ingredient2", "test_ingredient3");
        assertThat(ingredientDTO.getIngredientsNames()).isEqualTo(ingredientList_actual);
    }


}
