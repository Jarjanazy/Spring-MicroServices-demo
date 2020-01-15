package jalil.demo.RecepieService.Repos;

import jalil.demo.RecepieService.Entities.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepo extends CrudRepository<Recipe, Integer> {
}
