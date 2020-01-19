package jalil.demo.MealService.DTO;

import jalil.demo.MealService.Entities.Meal;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
/* this DTO is used to return a meal or list of meals */
public class MealDTO {
    private List<Meal> meals = new ArrayList<>();

    /* for the single meal scenario*/
    public MealDTO(Meal meal){
        this.meals.add(meal);
    }
    /* for the list of meals scenario*/
    public MealDTO(List<Meal> meals){
        this.meals.addAll(meals);
    }
}
