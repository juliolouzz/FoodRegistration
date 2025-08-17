package dev.juliolouzz.foodregistration.Foods;

import org.springframework.stereotype.Component;

@Component
public class FoodMapper {

    public FoodModel map(FoodDTO foodDTO) {
        FoodModel foodModel = new FoodModel();
        foodModel.setFoodId(foodDTO.getId());
        foodModel.setName(foodDTO.getName());
        foodModel.setDescription(foodDTO.getDescription());
        foodModel.setKcal(foodDTO.getKcal());
        foodModel.setQuantity(foodDTO.getQuantity());
        foodModel.setFoodType(foodDTO.getFoodType());
        foodModel.setImgUrl(foodDTO.getImgUrl());
        foodModel.setMeals(foodDTO.getMeals());
        return foodModel;
    }

    public FoodDTO map(FoodModel foodModel) {
        FoodDTO foodDTO = new FoodDTO();
        foodDTO.setName(foodModel.getName());
        foodDTO.setDescription(foodModel.getDescription());
        foodDTO.setId(foodModel.getFoodId());
        foodDTO.setKcal(foodModel.getKcal());
        foodDTO.setQuantity(foodModel.getQuantity());
        foodDTO.setFoodType(foodModel.getFoodType());
        foodDTO.setImgUrl(foodModel.getImgUrl());
        foodDTO.setMeals(foodModel.getMeals());
        return foodDTO;
    }

}
