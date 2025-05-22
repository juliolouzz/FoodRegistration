package dev.juliolouzz.foodregistration.Meals;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MealsRepository extends JpaRepository<MealsModel, Long> {
}
