package jalil.demo.ReactiveClient.Controller;

import jalil.demo.ReactiveClient.DTO.RecipeDTO;
import jalil.demo.ReactiveClient.Service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class RecipeController {
    private RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService){
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe/{recipeName}")
    public Mono<RecipeDTO> getRecipe(@PathVariable String recipeName){
        return recipeService.getRecipe(recipeName);
    }



}
