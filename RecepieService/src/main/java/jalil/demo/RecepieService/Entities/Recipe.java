package jalil.demo.RecepieService.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

    @ManyToMany
    private List<Ingredient> ingredients;
}
