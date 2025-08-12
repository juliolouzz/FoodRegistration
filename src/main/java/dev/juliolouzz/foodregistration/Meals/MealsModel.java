package dev.juliolouzz.foodregistration.Meals;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.juliolouzz.foodregistration.Foods.FoodModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_meals")
@NoArgsConstructor // Comes from Lombok, Handle empty Constructor
@AllArgsConstructor // Comes from Lombok, Add Constructor with all arguments
@Data // Comes from Lombok, Creates all getters and setters
public class MealsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    //One Meal is made of Many foods(ingredients)
    @OneToMany(mappedBy = "meals") // mapped on the @ManyToOne on the other table with name meals on the other table
    @JsonIgnore
    private List<FoodModel> food;


}
