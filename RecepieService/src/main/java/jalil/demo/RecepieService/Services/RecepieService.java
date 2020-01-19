package jalil.demo.RecepieService.Services;

import jalil.demo.RecepieService.DTO.IngredientDTO;
import jalil.demo.RecepieService.DTO.RecipeDTO;
import jalil.demo.RecepieService.Entities.Ingredient;
import jalil.demo.RecepieService.Entities.Recipe;
import jalil.demo.RecepieService.Repos.IngredientRepo;
import jalil.demo.RecepieService.Repos.RecipeRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecepieService {
    Logger logger = LoggerFactory.getLogger(RecepieService.class);

    private RecipeRepo recipeRepo;
    private IngredientRepo ingredientRepo;

    public RecepieService(@Autowired RecipeRepo recipeRepo, @Autowired IngredientRepo ingredientRepo){
        this.ingredientRepo = ingredientRepo;
        this.recipeRepo = recipeRepo;
    }


    public RecipeDTO getRecipeByRecipeName(String recipeName){
        Recipe recipe = recipeRepo.getRecipeByRecipeName(recipeName);
        if (recipe == null){
            logger.info("No recipe is found for:" + recipeName);
            return null;
        }
        /* create RecipeDTO from Recipe*/
        return new RecipeDTO(
                    recipe.getPreparation(),
                    recipe.getRecipeName(),
                    /* create list of IngredientDTO from list of Ingredient*/
                    recipe.getIngredients()
        );
    }

    public IngredientDTO getRecipeIngredients(String recipeName){
        Recipe recipe = recipeRepo.getRecipeByRecipeName(recipeName);
        if (recipe == null){
            return null;
        }
        return new IngredientDTO(recipe.getIngredients());
    }


}
