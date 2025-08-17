package dev.juliolouzz.foodregistration.Foods;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> createFood(@RequestBody FoodDTO foodDTO) {
        FoodDTO newFood = foodService.createFood(foodDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Food created with id: " + newFood.getName() + " (ID): " + newFood.getId());
    }

    // show all foods(READ)
    @GetMapping("/list")
    public ResponseEntity<List<FoodDTO>> listAllFoods() {
        List<FoodDTO> food = foodService.listFoods();
        return ResponseEntity.ok(food);
    }

    // show food by id(READ)
    @GetMapping("/list/{id}")
    public ResponseEntity<?> listFoodById(@PathVariable Long id) {
        FoodDTO food = foodService.getFoodById(id);
        if (food != null) {
            return ResponseEntity.ok(food);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Food with ID " + id + " not found");
        }
    }

    // alter data of food(UPDATE)
    @PutMapping("/modify/{id}")
    public ResponseEntity<?> modifyFoodByID(@PathVariable Long id, @RequestBody FoodDTO foodUpdated) {
        FoodDTO food = foodService.modifyFoodById(id, foodUpdated);
        if (food != null) {
            return ResponseEntity.ok(food);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Food with ID " + id + " not found");
        }
    }

    // delete food(DELETE)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFoodById(@PathVariable Long id) {
        if (foodService.getFoodById(id) != null) {
            foodService.deleteFoodById(id);
            return ResponseEntity.ok("Food with ID " + id + " deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Food with ID " + id + " not found");
        }
    }
}
