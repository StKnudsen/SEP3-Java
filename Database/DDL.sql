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
    FOREIGN KEY (PostalCode) REFERENCES City (postalCode)
);

CREATE TABLE Restaurant
(
    id        INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    CVR       INT     NOT NULL,
    Name      VARCHAR NOT NULL,
    Theme     VARCHAR,
    AddressId INT,
    FOREIGN KEY (AddressId) REFERENCES Address (id)
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
    FOREIGN KEY (RecipeId) REFERENCES Recipe (id),
    FOREIGN KEY (IngredientId) REFERENCES Ingredient (id),
    FOREIGN KEY (UnitId) REFERENCES Unit (id)
);

CREATE TABLE Dish(
    id   INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    Name VARCHAR NOT NULL
);

CREATE TABLE DishIngredients(
    DishId int,
    IngredientsId int,
    PRIMARY KEY (DishId, IngredientsId),
    FOREIGN KEY (DishId) REFERENCES Dish (id),
    FOREIGN KEY (IngredientsId) REFERENCES Ingredient (id)
);

CREATE TABLE Users(
    id int GENERATED ALWAYS AS IDENTITY PRIMARY KEY ,
    UserName varchar NOT NULL ,
    Password varchar(32) NOT NULL,
    CONSTRAINT pwLength CHECK ( length(Password) = 32 )
);

CREATE TABLE IngredientAllergy(
    UserId int,
    IngredientId int,
    AllergyName varchar,
    PRIMARY KEY (UserId, IngredientId),
    FOREIGN KEY (UserId) REFERENCES Users (id),
    FOREIGN KEY (IngredientId) REFERENCES Ingredient (id)
);

CREATE TABLE IngredientPreference(
    UserId int,
    IngredientId int,
    PreferenceName varchar,
    PRIMARY KEY (UserId, IngredientId),
    FOREIGN KEY (UserId) REFERENCES Users (id),
    FOREIGN KEY (IngredientId) REFERENCES Ingredient (id)
);