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
    public String createFood() {
        return "Food Created";
    }

    // show all foods(READ)
    @GetMapping("/list")
    public List<FoodModel> listAllFoods() {
        return foodService.listFoods();
    }

    // show food by id(READ)
    @GetMapping("/list/{id}")
    public FoodModel listFoodById(@PathVariable Long id) {
        return foodService.getFoodById(id);
    }

    // alter data of food(UPDATE)
    @PutMapping("/modifyID")
    public String modifyFoodByID() {
        return "modify Food By ID";
    }

    // delete food(DELETE)
    @DeleteMapping("/deleteID")
    public String deleteFoodByID() {
        return "delete Food By ID";
    }
}
