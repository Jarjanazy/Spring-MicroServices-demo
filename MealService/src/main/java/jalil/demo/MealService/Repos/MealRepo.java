package jalil.demo.MealService.Repos;

import jalil.demo.MealService.Entities.Meal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepo extends CrudRepository <Meal, Integer> {
}
