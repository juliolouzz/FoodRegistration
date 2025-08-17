package dev.juliolouzz.foodregistration.Foods;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodService {

    private final FoodRepository foodRepository;
    private final FoodMapper foodMapper;

    public FoodService(FoodRepository foodRepository, FoodMapper foodMapper) {
        this.foodRepository = foodRepository;
        this.foodMapper = foodMapper;
    }

    // List all Foods
    public List<FoodDTO> listFoods() {
        List<FoodModel> foodModels = foodRepository.findAll();
        return foodModels.stream()
                .map(foodMapper::map)
                .collect(Collectors.toList());
    }

    //List all foods by ID
    public FoodDTO getFoodById(Long id) {
        Optional<FoodModel> foodById = foodRepository.findById(id);
        return foodById.map(foodMapper::map).orElse(null);
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
    public FoodDTO modifyFoodById(Long id, FoodDTO foodDTO) {
        Optional<FoodModel> foodExist = foodRepository.findById(id);
        if (foodExist.isPresent()) {
            FoodModel foodAltered = foodMapper.map(foodDTO);
            foodAltered.setFoodId(id);
            FoodModel updatedFood = foodRepository.save(foodAltered);
            return foodMapper.map(updatedFood);
        }
        return null;
    }
}
