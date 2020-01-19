package jalil.demo.RecepieService.Controllers;

import jalil.demo.RecepieService.DTO.IngredientDTO;
import jalil.demo.RecepieService.DTO.RecipeDTO;
import jalil.demo.RecepieService.Services.RecepieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RecipeController {

    private RecepieService recepieService;

    RecipeController(@Autowired RecepieService recepieService){
        this.recepieService = recepieService;
    }


    @GetMapping("/recipe/{recipeName}")
    public RecipeDTO getRecipeByRecipeName(@PathVariable String recipeName){
        return recepieService.getRecipeByRecipeName(recipeName);
    }

    @GetMapping("/recipe/ingredient/{recipeName}")
    public IngredientDTO getRecipeIngredients(@PathVariable String recipeName){
        return recepieService.getRecipeIngredients(recipeName);
    }

}
