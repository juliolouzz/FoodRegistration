package dev.juliolouzz.foodregistration.Foods;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    private final FoodRepository foodRepository;
    private final FoodMapper foodMapper;

    public FoodService(FoodRepository foodRepository, FoodMapper foodMapper) {
        this.foodRepository = foodRepository;
        this.foodMapper = foodMapper;
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
    public FoodDTO createFood(FoodDTO foodDTO) {
        FoodModel foodModel = foodMapper.map(foodDTO);
        foodRepository.save(foodModel);
        return foodMapper.map(foodModel);
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
