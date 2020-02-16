package jalil.demo.ReactiveClient.Service;

import jalil.demo.ReactiveClient.DTO.RecipeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
public class RecipeService {
    Logger logger = LoggerFactory.getLogger(RecipeService.class);


    private WebClient.Builder webClient;

    @Autowired
    public RecipeService(WebClient.Builder webClient){
        this.webClient = webClient;
    }

    public Mono<RecipeDTO> getRecipe(String recipeName){
        return webClient
                .build()
                .get()
                .uri("http://RecipeService/recipe/{recipeName}", recipeName)
                .retrieve()
                .bodyToMono(RecipeDTO.class)
                .doOnNext(
                        recipeDTO -> logger.info("Received recipe: {} with ingredients: {}",
                                recipeDTO.getRecipeName(),
                                recipeDTO.getIngredients().getIngredientsNames())
                );
    }


}
