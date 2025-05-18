package dev.juliolouzz.foodregistration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food_api")
public class FoodController {

    @GetMapping("/welcome")
    public String Welcome() {
        return "Welcome";
    }
}
