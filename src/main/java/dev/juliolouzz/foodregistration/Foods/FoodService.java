package dev.juliolouzz.foodregistration.Foods;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    private final FoodRepository foodRepository;
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }


    // List all Foods
    public List<FoodModel> listFoods() {
        return foodRepository.findAll();
    }

    //List all foods by ID
    public FoodModel getFoodById(Long id) {
        Optional<FoodModel> foodById = foodRepository.findById(id);
        return foodById.orElse(null);
    }

    // create new food
    public FoodModel createFood(FoodModel foodModel) {
        return foodRepository.save(foodModel);
    }

    //delete food by ID
    public void deleteFoodById(Long id) {
        foodRepository.deleteById(id);
    }

    //alter-update food by ID
    public FoodModel modifyFoodById(Long id, FoodModel foodUpdated) {
        if (foodRepository.existsById(id)) {
            foodUpdated.setFoodId(id);
            return foodRepository.save(foodUpdated);
        }
        return null;
    }
}
