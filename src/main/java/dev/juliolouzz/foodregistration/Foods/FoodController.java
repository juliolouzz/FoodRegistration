package dev.juliolouzz.foodregistration.Foods;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food_api")
public class FoodController {

    //inject the FoodService to use its methods in the controller
    private final FoodService foodService;
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/welcome")
    public String Welcome() {
        return "Welcome";
    }

    // add food (CREATE)
    @PostMapping("/create")
    public FoodDTO createFood(@RequestBody FoodDTO foodDTO) {
        return foodService.createFood(foodDTO);
    }

    // show all foods(READ)
    @GetMapping("/list")
    public List<FoodDTO> listAllFoods() {
        return foodService.listFoods();
    }

    // show food by id(READ)
    @GetMapping("/list/{id}")
    public FoodDTO listFoodById(@PathVariable Long id) {
        return foodService.getFoodById(id);
    }

    // alter data of food(UPDATE)
    @PutMapping("/modify/{id}")
    public FoodDTO modifyFoodByID(@PathVariable Long id, @RequestBody FoodDTO foodUpdated) {
        return foodService.modifyFoodById(id, foodUpdated);
    }

    // delete food(DELETE)
    @DeleteMapping("/delete/{id}")
    public void deleteFoodById(@PathVariable Long id) {
        foodService.deleteFoodById(id);
    }
}
