package dispenser.beverage.machine;

import dispenser.beverage.containers.StorageProvider;
import dispenser.beverage.containers.repository.CapacityRepository;
import dispenser.beverage.drinks.Beverage;
import dispenser.beverage.drinks.BeverageEnum;
import dispenser.beverage.drinks.repository.RecipeRepository;
import dispenser.beverage.exceptions.IngredientNotAvailableException;
import dispenser.beverage.exceptions.RecipeNotDefinedException;
import dispenser.beverage.ingridients.Ingredient;
import dispenser.beverage.ingridients.IngredientProvider;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
/*
 * This class represents a beverage machine
 * unique Beverage Id is generated for each new beverage
 */
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class BeverageMachine {
    private final IngredientProvider ingredientProvider;
    private final RecipeRepository recipeRepository;
    private final StorageProvider storageProvider;
    private final int numOfDispensers;
    private final ExecutorService executorService;
    private final AtomicInteger beverageId = new AtomicInteger(0);

    /*
     * Dispenses beverage
     * @param type of beverage
     */
    public void dispense(BeverageEnum beverageEnum){
        executorService.execute(() -> {
                dispenseBeverage(beverageEnum);
        });
    }

    private void dispenseBeverage(BeverageEnum beverageEnum) {
        List<Ingredient> recipe = beverageEnum.getIngredients();
        if(recipe == null || recipe.isEmpty()){
            throw new RecipeNotDefinedException();
        }
        int orderId = beverageId.getAndIncrement();
        System.out.println("Preparing " + beverageEnum.getValue() + " id: "+ orderId);
        try {
            recipe.forEach(ingredient -> ingredient.dispense(ingredientProvider));
        } catch(IngredientNotAvailableException e){
            System.out.println("Can prepare beverage with id : " + orderId + " because " + e.getMessage());
            return;
        }
        Beverage beverage = new Beverage(recipe, beverageEnum);
        System.out.println("Your drink id " + orderId + " (" + beverage.getBeverageEnum().getValue() + ") is ready");
    }

    /**
     *
     * @return beverage List available
     */
    public List<BeverageEnum> getBeverageList() {
        return Arrays.asList(BeverageEnum.values());
    }

    /**
     *
     * @param quantity of item to be refilled
     */
    public void refillGinger(int quantity){
        storageProvider.refillGinger(quantity);
    }
    /**
     *
     * @param quantity of item to be refilled
     */
    public void refillTeaLeaves(int quantity){
        storageProvider.refillTeaLeaves(quantity);
    }
    /**
     *
     * @param quantity of item to be refilled
     */
    public void refillWater(int quantity){
        storageProvider.refillWater(quantity);
    }
    public void refillGreenTeaLeaves(int quantity){
        storageProvider.refillGreenTeaLeaves(quantity);
    }
    public void refillSugar(int quantity){
        storageProvider.refillSugar(quantity);
    }
    public void refillMilk(int quantity){
        storageProvider.refillMilk(quantity);
    }

    /**
     * prints current quantity of all ingredients
     */
    public void getLevels(){
        System.out.println("Levels");
        System.out.println("Green Tea " + storageProvider.getGreenTeaLeavesLevel());
        System.out.println("Ginger " + storageProvider.getGingerLevel());
        System.out.println("Milk " + storageProvider.getMilkLevel());
        System.out.println("Sugar " + storageProvider.getSugarLevel());
        System.out.println("Tea Leaves " + storageProvider.getTeaLeavesLevel());
        System.out.println("Water " + storageProvider.getWaterLevel());
        System.out.println("Levels Done!");
    }

    /**
     * refills all ingredients
     */
    public void refillAll(){
        refillSugar(CapacityRepository.SUGAR_CAPACITY);
        refillWater(CapacityRepository.WATER_CAPACITY);
        refillMilk(CapacityRepository.MILK_CAPACITY);
        refillTeaLeaves(CapacityRepository.TEA_CAPACITY);
        refillGinger(CapacityRepository.GINGER_CAPACITY);
        refillGreenTeaLeaves(CapacityRepository.GREEN_TEA_CAPACITY);
    }
}

