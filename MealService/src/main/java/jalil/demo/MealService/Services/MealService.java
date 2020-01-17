package jalil.demo.MealService.Services;

import jalil.demo.MealService.Entities.Meal;
import jalil.demo.MealService.Repos.MealRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {
    private Logger logger = LoggerFactory.getLogger(MealService.class);

    private MealRepo mealRepo;

    MealService(@Autowired MealRepo mealRepo){
        this.mealRepo = mealRepo;
    }


    public Meal getMealByName(String mealName){
        Meal meal = mealRepo.findMealByMealName(mealName);
        if(meal == null){
            logger.info("No Meal found for meal name:" + mealName);
            return null;
        }
        return meal;
    }

    public List<Meal> getMealsByCountry(String countryName){
        List<Meal> meals = mealRepo.findMealsByMealCountry(countryName);
        if (meals.isEmpty()){
            logger.info("No Meals found for the country: " + countryName);
        }
        return meals;
    }




}
