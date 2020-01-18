package jalil.demo.RecepieService.Services;

import jalil.demo.RecepieService.Entities.Ingredient;
import jalil.demo.RecepieService.Entities.Recipe;
import jalil.demo.RecepieService.Repos.IngredientRepo;
import jalil.demo.RecepieService.Repos.RecipeRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecepieService {
    Logger logger = LoggerFactory.getLogger(RecepieService.class);

    private RecipeRepo recipeRepo;
    private IngredientRepo ingredientRepo;

    public RecepieService(@Autowired RecipeRepo recipeRepo, @Autowired IngredientRepo ingredientRepo){
        this.ingredientRepo = ingredientRepo;
        this.recipeRepo = recipeRepo;
    }


    public Recipe getRecipeByRecipeName(String recipeName){
        Recipe recipe = recipeRepo.getRecipeByRecipeName(recipeName);
        if (recipe == null){
            logger.info("No recipe is found for:" + recipeName);
        }
        return recipe;
    }

    public List<Ingredient> getRecipeIngredients(String recipeName){
        Recipe recipe = recipeRepo.getRecipeByRecipeName(recipeName);
        return recipe.getIngredients();
    }


}
