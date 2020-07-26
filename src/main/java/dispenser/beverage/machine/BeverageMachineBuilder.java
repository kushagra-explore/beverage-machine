package dispenser.beverage.machine;

import dispenser.beverage.containers.*;
import dispenser.beverage.containers.repository.CapacityRepository;
import dispenser.beverage.drinks.BeverageEnum;
import dispenser.beverage.drinks.repository.RecipeRepository;
import dispenser.beverage.ingridients.IngredientFacade;
import dispenser.beverage.ingridients.IngredientProvider;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Builder class to build machine
 */
public class BeverageMachineBuilder {

    private MilkContainer milkContainer;
    private WaterContainer waterContainer;
    private GingerContainer gingerContainer;
    private TeaLeavesContainer teaLeavesContainer;
    private GreenTeaLeavesContainer greenTeaLeavesContainer;
    private SugarContainer sugarContainer;
    private StorageProvider storageProvider;
    private IngredientProvider ingredientProvider;
    private RecipeRepository recipeRepository;
    private int numOfDispensers = 1;
    private ExecutorService executorService;

    public BeverageMachineBuilder simpleBuilder(){
        milkContainer = new MilkContainer(CapacityRepository.MILK_CAPACITY);
        waterContainer = new WaterContainer(CapacityRepository.WATER_CAPACITY);
        gingerContainer = new GingerContainer(CapacityRepository.GINGER_CAPACITY);
        sugarContainer = new SugarContainer(CapacityRepository.SUGAR_CAPACITY);
        greenTeaLeavesContainer = new GreenTeaLeavesContainer(CapacityRepository.GREEN_TEA_CAPACITY);
        teaLeavesContainer = new TeaLeavesContainer(CapacityRepository.TEA_CAPACITY);
        storageProvider = new StorageFacade(gingerContainer, sugarContainer, greenTeaLeavesContainer,
                teaLeavesContainer, milkContainer, waterContainer);
        ingredientProvider = new IngredientFacade(storageProvider);
        recipeRepository = new RecipeRepository();
        BeverageEnum.setRecipeRepository(recipeRepository);
        return this;
    }

    /**
     *
     * @param n number of instances of dispatcher
     * @return Builder
     */
    public BeverageMachineBuilder withDispensers(int n){
        this.numOfDispensers = n;
        this.executorService = Executors.newFixedThreadPool(n);
        return this;
    }

    /**
     * initially all containers are filled
     * @return builder
     */
    public BeverageMachineBuilder withFilledContainers(){
        milkContainer.refill(milkContainer.getCapacity());
        waterContainer.refill(waterContainer.getCapacity());
        gingerContainer.refill(gingerContainer.getCapacity());
        teaLeavesContainer.refill(teaLeavesContainer.getCapacity());
        sugarContainer.refill(sugarContainer.getCapacity());
        greenTeaLeavesContainer.refill(greenTeaLeavesContainer.getCapacity());
        return this;
    }

    public BeverageMachine build() {
        if (storageProvider == null) {
            return simpleBuilder().withDispensers(1).build();
        } else {
            return new BeverageMachine(ingredientProvider, recipeRepository, storageProvider, numOfDispensers, executorService);
        }
    }


}
