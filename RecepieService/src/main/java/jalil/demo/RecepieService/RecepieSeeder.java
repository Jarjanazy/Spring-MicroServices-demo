package jalil.demo.RecepieService;

import jalil.demo.RecepieService.Entities.Ingredient;
import jalil.demo.RecepieService.Entities.Recipe;
import jalil.demo.RecepieService.Repos.IngredientRepo;
import jalil.demo.RecepieService.Repos.RecipeRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class RecepieSeeder implements CommandLineRunner {
    private static Logger logger = LoggerFactory.getLogger(RecepieSeeder.class);

    private RecipeRepo recipeRepo;
    private IngredientRepo ingredientRepo;

    public RecepieSeeder(@Autowired RecipeRepo recipeRepo, @Autowired IngredientRepo ingredientRepo){
        this.recipeRepo = recipeRepo;
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Ingredient> hamburger_ingredients = Arrays.asList(new Ingredient("salt"),
                new Ingredient("ham"),
                new Ingredient("bread"),
                new Ingredient("tomatoes"));

        ingredientRepo.saveAll(hamburger_ingredients);
        logger.debug("Hamburger ingredients are added");

        Recipe hamburger_recipe = new Recipe("Hamburger");
        hamburger_recipe.setIngredients(hamburger_ingredients);
        hamburger_recipe.setPreparation("Fry ham, add it between two breads, spread salt, put tomatoes, Eat!!");

        recipeRepo.save(hamburger_recipe);
        logger.info("Hamburger recipe added");

    }
}
