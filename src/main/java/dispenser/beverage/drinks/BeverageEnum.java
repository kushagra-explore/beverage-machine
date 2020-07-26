package dispenser.beverage.drinks;

import dispenser.beverage.drinks.repository.RecipeRepository;
import dispenser.beverage.exceptions.RecipeNotDefinedException;
import dispenser.beverage.ingridients.Ingredient;

import java.util.List;

public enum BeverageEnum implements BeverageRecipe{
    GINGER_TEA("ginger tea"){
        @Override
        public List<Ingredient> getIngredients() throws RecipeNotDefinedException {
            return recipeRepository.getRecipe(this);
        }
    },
    GREEN_TEA("green tea") {
        @Override
        public List<Ingredient> getIngredients() throws RecipeNotDefinedException {
            return recipeRepository.getRecipe(this);
        }
    },
    BLACK_TEA("black tea") {
        @Override
        public List<Ingredient> getIngredients() throws RecipeNotDefinedException {
            return recipeRepository.getRecipe(this);
        }
    },
    HOT_MILK("hot milk") {
        @Override
        public List<Ingredient> getIngredients() throws RecipeNotDefinedException {
            return recipeRepository.getRecipe(this);
        }
    },
    HOT_WATER("hot water") {
        @Override
        public List<Ingredient> getIngredients() throws RecipeNotDefinedException {
            return recipeRepository.getRecipe(this);
        }
    };
    private static RecipeRepository recipeRepository;
    private final String value;
    BeverageEnum(String value){
        this.value = value;
    }
    public String getValue() {
        return value;
    }
    public static void setRecipeRepository(RecipeRepository recipeRepository){
        BeverageEnum.recipeRepository = recipeRepository;
    }

}
