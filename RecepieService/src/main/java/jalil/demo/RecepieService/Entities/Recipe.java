package jalil.demo.RecepieService.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    /* for demo purposes we made the columns upper limit 1000 characters */
    @Column(length = 1000)
    private String preparation;

    @Column(unique = true)
    private String recipeName;

    @ManyToMany
    @JsonManagedReference // this annotation is used to eliminate the circular reference
    private List<Ingredient> ingredients = new ArrayList<>();

    public Recipe(String recipeName){
        this.recipeName = recipeName;
    }
}
