package jalil.demo.ReactiveClient.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class RecipeDTO {
    private String preparation;
    private String recipeName;
    private IngredientDTO ingredients;


}
