package dev.juliolouzz.foodregistration;

import jakarta.persistence.*;

// transform a class into an entity of DB
@Entity
@Table(name = "tb_registration")
public class FoodModel {

    @Id // says that foodId that is not on the constructors, is an ID on the database
    @GeneratedValue(strategy = GenerationType.IDENTITY) // says how this ID will be generated
    private Long foodId;
    private String name;
    private String description;
    private int kcal;
    private int quantity;

    public FoodModel() {
    }

    public FoodModel(String name, String description, int kcal, int quantity) {
        this.name = name;
        this.description = description;
        this.kcal = kcal;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
