package dev.juliolouzz.foodregistration.Meals;

import dev.juliolouzz.foodregistration.Foods.FoodModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_meals")
public class MealsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int kcal;

    //One Meal is made of Many foods(ingredients)
    @OneToMany(mappedBy = "meals") // mapped on the @ManyToOne on the other table with name meals on the other table
    private List<FoodModel> food;


}
