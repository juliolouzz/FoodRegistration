package dev.juliolouzz.foodregistration.Foods;


import dev.juliolouzz.foodregistration.Meals.MealsModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// It's a copy of the FoodModel, but without direct access to the database

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDTO {

    private Long id;
    private String name;
    private String description;
    private Integer kcal;
    private Integer quantity;
    private String foodType;
    private String imgUrl;
    private MealsModel meals;
}
