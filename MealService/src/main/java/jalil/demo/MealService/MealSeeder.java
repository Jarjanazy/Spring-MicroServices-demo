package jalil.demo.MealService;

import jalil.demo.MealService.Entities.Meal;
import jalil.demo.MealService.Repos.MealRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/* this runner method is used to run and add Meal records to the DB */
@Component
public class MealSeeder implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(MealSeeder.class);

    private MealRepo mealRepo;

   MealSeeder(@Autowired MealRepo mealRepo){
       this.mealRepo = mealRepo;
   }

    @Override
    public void run(String... args) throws Exception {
       List<Meal> meals = new ArrayList<>();
       meals.add(new Meal("hamburger", "USA"));
       meals.add(new Meal("mouhshi", "Syria"));
        meals.add(new Meal("safarjaliye", "Syria"));

       mealRepo.saveAll(meals);
       logger.info("Added new Meals");
    }
}
