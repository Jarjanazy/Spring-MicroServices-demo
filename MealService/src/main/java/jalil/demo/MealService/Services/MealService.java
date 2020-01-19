package jalil.demo.MealService.Services;

import jalil.demo.MealService.DTO.MealDTO;
import jalil.demo.MealService.DTO.RecipeDTO;
import jalil.demo.MealService.Entities.Meal;
import jalil.demo.MealService.Repos.MealRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MealService {
    private Logger logger = LoggerFactory.getLogger(MealService.class);

    private MealRepo mealRepo;
    /*used to make synchronises API calls*/
    private RestTemplate restTemplate;

    MealService(@Autowired MealRepo mealRepo, @Autowired RestTemplate restTemplate){
        this.mealRepo = mealRepo;
        this.restTemplate = restTemplate;
    }


    public MealDTO getMealByName(String mealName){
        Meal meal = mealRepo.findMealByMealName(mealName);
        if(meal == null){
            logger.info("No Meal found for meal name:" + mealName);
            return null;
        }

        return new MealDTO(meal);
    }

    public MealDTO getMealsByCountry(String countryName){
        List<Meal> meals = mealRepo.findMealsByMealCountry(countryName);
        if (meals.isEmpty()){
            logger.info("No Meals found for the country: " + countryName);
        }
        return new MealDTO(meals);
    }

    /* will make a call to the Recipe micro service to obtain the recipe and ingredients for a given meal name*/
    public RecipeDTO getMealRecipe(String mealName){
        /*for now the URL of the API is hard coded*/
        return restTemplate.getForObject("http://localhost:8082/recipe/" + mealName, RecipeDTO.class);
    }



}
