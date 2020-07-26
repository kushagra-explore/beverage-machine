package dispenser.beverage.drinks;

import dispenser.beverage.ingridients.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Getter
public class Beverage {
    private final List<Ingredient> ingredientList;
    private final BeverageEnum beverageEnum;

}
