package dev.juliolouzz.foodregistration.Foods;

import dev.juliolouzz.foodregistration.Meals.MealsModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// transform a class into an entity of DB
@Entity
@Table(name = "tb_registration")
@NoArgsConstructor // Comes from Lombok, Handle empty Constructor
@AllArgsConstructor // Comes from Lombok, Add Constructor with all arguments
@Data // Comes from Lombok, Creates all getters and setters
public class FoodModel {

    @Id // says that foodId that is not on the constructors is an ID on the database
    @GeneratedValue(strategy = GenerationType.IDENTITY) // says how this ID will be generated
    private Long foodId;

    @Column(unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "calories")
    private Integer kcal;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "food_type")
    private String foodType;

    @Column(name = "img_url")
    private String imgUrl;

    //Many foods(ingredients) make just one meal
    @ManyToOne
    @JoinColumn(name = "meals_id") //Foreign Key
    private MealsModel meals;

}
