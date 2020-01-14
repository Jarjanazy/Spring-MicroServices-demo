package jalil.demo.MealService.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter @NoArgsConstructor // Lombok annotations are used to auto generate getters and setters
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String mealName;
    private String mealCountry;

    Meal(String mealName, String mealCountry){
        this.mealCountry = mealCountry;
        this.mealName = mealName;
    }

}
