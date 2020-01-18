package jalil.demo.RecepieService.Controllers;

import jalil.demo.RecepieService.Entities.Ingredient;
import jalil.demo.RecepieService.Entities.Recipe;
import jalil.demo.RecepieService.Services.RecepieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeController {

    private RecepieService recepieService;

    RecipeController(@Autowired RecepieService recepieService){
        this.recepieService = recepieService;
    }


    @GetMapping("/recipe/{recipeName}")
    public Recipe getRecipeByRecipeName(@PathVariable String recipeName){
        return recepieService.getRecipeByRecipeName(recipeName);
    }

    @GetMapping("/recipe/ingredient/{recipeName}")
    public List<Ingredient> getRecipeIngredients(@PathVariable String recipeName){
        return recepieService.getRecipeIngredients(recipeName);
    }

}
