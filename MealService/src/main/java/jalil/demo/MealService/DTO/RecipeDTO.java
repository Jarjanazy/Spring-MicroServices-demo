package jalil.demo.MealService.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;



/* this class is made to be a copy of the Recipe entity class in the Recipe micro service*/
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class RecipeDTO {
    private String preparation;
    private String recipeName;
    private IngredientDTO ingredients;

}
