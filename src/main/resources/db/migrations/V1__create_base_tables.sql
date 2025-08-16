-- Meals table (minimal columns; add more later if your entity has them)
CREATE TABLE IF NOT EXISTS tb_meals (
    id   BIGSERIAL PRIMARY KEY,   -- PK here
    name VARCHAR(255) UNIQUE,
    description TEXT,
    kcal INTEGER
);

-- Food registration table matches your annotations
CREATE TABLE IF NOT EXISTS tb_registration (
    food_id     BIGSERIAL PRIMARY KEY,
    name        VARCHAR(255) UNIQUE,
    description TEXT,
    calories    INTEGER,
    quantity    INTEGER,
    img_url     VARCHAR(1024),
    meals_id    BIGINT REFERENCES tb_meals(id)
);