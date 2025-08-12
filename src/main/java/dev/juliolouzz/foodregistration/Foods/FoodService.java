package dev.juliolouzz.foodregistration.Foods;

import org.springframework.stereotype.Service;

import java.util.List;

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
}
