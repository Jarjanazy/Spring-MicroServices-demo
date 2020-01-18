package jalil.demo.RecepieService.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

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
    private List<Ingredient> ingredients = new ArrayList<>();

    public Recipe(String recipeName){
        this.recipeName = recipeName;
    }
}
