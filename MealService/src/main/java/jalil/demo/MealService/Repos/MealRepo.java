package jalil.demo.MealService.Repos;

import jalil.demo.MealService.Entities.Meal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepo extends CrudRepository <Meal, Integer> {
     Meal findMealByMealName(String name);
     List<Meal> findMealsByMealCountry(String countryName);
}
