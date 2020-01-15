package jalil.demo.RecepieService.Repos;

import jalil.demo.RecepieService.Entities.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepo extends CrudRepository<Ingredient, Integer> {
}
