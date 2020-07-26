package dispenser.beverage.drinks;

import dispenser.beverage.exceptions.RecipeNotDefinedException;
import dispenser.beverage.ingridients.Ingredient;

import java.util.List;

public interface BeverageRecipe {
    List<Ingredient> getIngredients() throws RecipeNotDefinedException;
}
