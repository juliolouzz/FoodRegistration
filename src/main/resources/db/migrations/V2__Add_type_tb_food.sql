-- V2: Migrations to add the column type on table registration(FoodModel) --

ALTER TABLE tb_registration
ADD COLUMN food_type VARCHAR(255);