DROP SCHEMA IF EXISTS dnnr CASCADE;
CREATE SCHEMA dnnr;
SET SCHEMA 'dnnr';

CREATE TABLE City
(
    postalCode INT PRIMARY KEY,
    Cityname   VARCHAR NOT NULL
);

CREATE TABLE Address
(
    id          INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    StreetName  VARCHAR NOT NULL,
    HouseNumber INT     NOT NULL,
    PostalCode  INT,
    FOREIGN KEY (PostalCode) REFERENCES City (postalCode) ON DELETE CASCADE
);

CREATE TABLE Restaurant
(
    id        INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    CVR       INT     NOT NULL,
    Name      VARCHAR NOT NULL,
    Theme     VARCHAR,
    AddressId INT,
    FOREIGN KEY (AddressId) REFERENCES Address (id) ON DELETE SET NULL
);

CREATE TABLE FavoriteRestaurant
(
    id           INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    RestaurantId INT UNIQUE NOT NULL
);

CREATE TABLE Recipe
(
    id   INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    Name VARCHAR NOT NULL
);

CREATE TABLE Ingredient
(
    id   INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    Name VARCHAR NOT NULL
);

CREATE TABLE Unit
(
    id   INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    Name VARCHAR NOT NULL
);

CREATE TABLE RecipeIngredients
(
    RecipeId     INT,
    IngredientId INT,
    Amount       DECIMAL(6, 2),
    UnitId       INT,
    PRIMARY KEY (RecipeId, IngredientId),
    FOREIGN KEY (RecipeId) REFERENCES Recipe (id) ON DELETE CASCADE,
    FOREIGN KEY (IngredientId) REFERENCES Ingredient (id) ON DELETE CASCADE,
    FOREIGN KEY (UnitId) REFERENCES Unit (id) ON DELETE CASCADE
);

CREATE TABLE Dish
(
    id   INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    Name VARCHAR NOT NULL
);

CREATE TABLE DishIngredients
(
    DishId        INT,
    IngredientsId INT,
    PRIMARY KEY (DishId, IngredientsId),
    FOREIGN KEY (DishId) REFERENCES Dish (id) ON DELETE CASCADE,
    FOREIGN KEY (IngredientsId) REFERENCES Ingredient (id) ON DELETE CASCADE
);

CREATE TABLE Users
(
    id       INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    Username VARCHAR     NOT NULL UNIQUE,
    Password VARCHAR(32) NOT NULL,
    CONSTRAINT nameLength CHECK ( LENGTH(Username) < 2 ),
    CONSTRAINT pwLength CHECK ( LENGTH(Password) = 32 )
);

CREATE TABLE IngredientAllergy
(
    UserId       INT,
    IngredientId INT,
    AllergyName  VARCHAR,
    PRIMARY KEY (UserId, IngredientId),
    FOREIGN KEY (UserId) REFERENCES Users (id) ON DELETE CASCADE,
    FOREIGN KEY (IngredientId) REFERENCES Ingredient (id) ON DELETE CASCADE
);

CREATE TABLE IngredientPreference
(
    UserId         INT,
    IngredientId   INT,
    PreferenceName VARCHAR,
    PRIMARY KEY (UserId, IngredientId),
    FOREIGN KEY (UserId) REFERENCES Users (id) ON DELETE CASCADE,
    FOREIGN KEY (IngredientId) REFERENCES Ingredient (id) ON DELETE CASCADE
);

CREATE TABLE FoodGroup
(
    id   INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    Name VARCHAR NOT NULL
);

CREATE TABLE FoodGroupIngredients
(
    FoodGroupId  INT,
    IngredientId INT,
    PRIMARY KEY (FoodGroupId, IngredientId),
    FOREIGN KEY (FoodGroupId) REFERENCES FoodGroup (id),
    FOREIGN KEY (IngredientId) REFERENCES Ingredient (id)
);

CREATE TABLE FoodGroupAllergy
(
    UserId      INT,
    FoodGroupId INT,
    PRIMARY KEY (UserId, FoodGroupId),
    FOREIGN KEY (UserId) REFERENCES Users (id),
    FOREIGN KEY (FoodGroupId) REFERENCES FoodGroup (id)
);

CREATE TABLE FoodGroupPreference
(
    UserId      INT,
    FoodGroupId INT,
    PRIMARY KEY (UserId, FoodGroupId),
    FOREIGN KEY (UserId) REFERENCES Users (id),
    FOREIGN KEY (FoodGroupId) REFERENCES FoodGroup (id)
);