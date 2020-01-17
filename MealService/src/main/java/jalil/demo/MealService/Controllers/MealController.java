package jalil.demo.MealService.Controllers;

import jalil.demo.MealService.Entities.Meal;
import jalil.demo.MealService.Services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MealController {

    private MealService mealService;

    MealController(@Autowired MealService mealService){
        this.mealService = mealService;
    }

    @GetMapping("/meal/{mealName}")
    public Meal getMealByName(@PathVariable String mealName){
        return mealService.getMealByName(mealName);
    }

    @GetMapping("/meal/country/{countryName}")
    public List<Meal> getMealsByCountry(@PathVariable String countryName){
        return mealService.getMealsByCountry(countryName);
    }

}
