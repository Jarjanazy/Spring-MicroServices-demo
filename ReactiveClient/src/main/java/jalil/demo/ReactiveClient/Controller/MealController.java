package jalil.demo.ReactiveClient.Controller;

import jalil.demo.ReactiveClient.Service.MealService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class MealController {
    private Logger log = LoggerFactory.getLogger(MealController.class);

    private MealService mealService;

    public MealController(@Autowired MealService mealService){
        this.mealService = mealService;
    }

    @GetMapping("/meal/{mealName}")
    public Mono<String> getMealByName(@PathVariable String mealName){
        return mealService.getMealByName(mealName);
    }

}
