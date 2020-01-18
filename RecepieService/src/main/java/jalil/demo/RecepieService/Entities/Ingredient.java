package jalil.demo.RecepieService.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(unique = true)
    private String ingredientName;

    @ManyToMany(mappedBy = "ingredients")
    private List<Recipe> recepies = new ArrayList<>();

    public Ingredient(String ingredientName){
        this.ingredientName = ingredientName;
    }
}
