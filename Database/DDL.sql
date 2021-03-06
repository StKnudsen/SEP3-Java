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
    Amount       DECIMAL(6, 1),
    UnitId       INT,
    PRIMARY KEY (RecipeId, IngredientId),
    FOREIGN KEY (RecipeId) REFERENCES Recipe (id) ON DELETE CASCADE,
    FOREIGN KEY (IngredientId) REFERENCES Ingredient (id) ON DELETE CASCADE,
    FOREIGN KEY (UnitId) REFERENCES Unit (id) ON DELETE CASCADE
);


CREATE TABLE Users
(
    id       SERIAL PRIMARY KEY,
    Role     VARCHAR     NOT NULL,
    Username VARCHAR     NOT NULL UNIQUE,
    Password VARCHAR(32) NOT NULL,
    CONSTRAINT nameLength CHECK ( LENGTH(Username) > 2 ),
    CONSTRAINT whiteSpace CHECK ( Username NOT LIKE '% %'),
    CONSTRAINT pwLength CHECK ( LENGTH(Password) = 32 )
);

/*
CREATE TABLE Restaurateur
(
    RestaurantId INT
) INHERITS (Users);*/


CREATE TABLE Restaurant
(
    id          INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    CVR         INT         NOT NULL,
    Name        VARCHAR     NOT NULL,
    OwnerId     INT,
    Theme       VARCHAR,
    AddressId   INT,
    PhoneNumber VARCHAR(11) NOT NULL CHECK ( PhoneNumber LIKE '+45%') UNIQUE,
    FOREIGN KEY (OwnerId) REFERENCES Users (id),
    FOREIGN KEY (AddressId) REFERENCES Address (id) ON DELETE SET NULL
);

CREATE TABLE FavoriteRestaurant
(
    UserId       INT,
    RestaurantId INT,
    PRIMARY KEY (UserId, RestaurantId),
    FOREIGN KEY (UserId) REFERENCES Users (id),
    FOREIGN KEY (RestaurantId) REFERENCES Restaurant (id)
);


CREATE TABLE Dish
(
    id           INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    Name         VARCHAR NOT NULL,
    Description  VARCHAR,
    RestaurantId INT     NOT NULL,
    FOREIGN KEY (RestaurantId) REFERENCES Restaurant (id) ON DELETE CASCADE
);

CREATE TABLE IngredientAllergy
(
    UserId       INT,
    IngredientId INT,
    PRIMARY KEY (UserId, IngredientId),
    FOREIGN KEY (UserId) REFERENCES Users (id) ON DELETE CASCADE,
    FOREIGN KEY (IngredientId) REFERENCES Ingredient (id) ON DELETE CASCADE
);

CREATE TABLE IngredientAversion
(
    UserId         INT,
    IngredientId   INT,
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

CREATE TABLE FoodGroupAversion
(
    UserId      INT,
    FoodGroupId INT,
    PRIMARY KEY (UserId, FoodGroupId),
    FOREIGN KEY (UserId) REFERENCES Users (id),
    FOREIGN KEY (FoodGroupId) REFERENCES FoodGroup (id)
);

CREATE TABLE Colours
(
    Name VARCHAR,
    Id   INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY
);

CREATE TABLE Animals
(
    Name VARCHAR,
    Id   INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY
);