package dispenser.beverage.drinks.repository;

import dispenser.beverage.drinks.BeverageEnum;
import dispenser.beverage.exceptions.RecipeNotDefinedException;
import dispenser.beverage.ingridients.*;

import java.util.*;

public class RecipeRepository {
    private static final Map<BeverageEnum, List<Ingredient>> beverageIngredientListMap = new HashMap<>();

    static{
        beverageIngredientListMap.put(BeverageEnum.GINGER_TEA, Arrays.asList(new Ginger(5),
                new HotMilk(10), new HotWater(10), new TeaLeaves(5)));
        beverageIngredientListMap.put(BeverageEnum.HOT_MILK, Collections.singletonList(new HotMilk(15)));
        beverageIngredientListMap.put(BeverageEnum.BLACK_TEA, Arrays.asList(new HotWater(20),
                new TeaLeaves(5)));
        beverageIngredientListMap.put(BeverageEnum.GREEN_TEA, Arrays.asList(new HotWater(20),
                new GreenTeaLeaves(5)));
        beverageIngredientListMap.put(BeverageEnum.HOT_WATER, Collections.singletonList(new HotWater(20)));
    }

    public List<Ingredient> getRecipe(BeverageEnum beverageEnum) throws RecipeNotDefinedException {
        List<Ingredient> ingredientList = beverageIngredientListMap.get(beverageEnum);
        if(ingredientList == null){
            throw new RecipeNotDefinedException();
        }
        return ingredientList;
    }
}
