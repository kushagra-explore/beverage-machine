package dispenser.beverage.ingridients;

import dispenser.beverage.containers.StorageProvider;
import dispenser.beverage.exceptions.*;

/**
 * This class is to present a facade for dispensing from ingredients
 */
public class IngredientFacade implements IngredientProvider{

    private final StorageProvider storageProvider;

    public IngredientFacade(StorageProvider storageProvider){
        this.storageProvider = storageProvider;
    }

    @Override
    public Ingredient dispense(Ginger ginger) throws GingerNotAvailableException {
        return storageProvider.dispenseGinger(ginger.getIngredientQuantity());
    }

    @Override
    public Ingredient dispense(GreenTeaLeaves greenTeaLeaves) throws GreenTeaNotAvailableException {
        return storageProvider.dispenseGreenTeaLeaves(greenTeaLeaves.getIngredientQuantity());
    }

    @Override
    public Ingredient dispense(HotMilk hotMilk) throws MilkNotAvailableException {
        return storageProvider.dispenseHotMilk(hotMilk.getIngredientQuantity());
    }

    @Override
    public Ingredient dispense(HotWater hotWater) throws WaterNotAvailableException {
        return storageProvider.dispenseHotWater(hotWater.getIngredientQuantity());
    }

    @Override
    public Ingredient dispense(Sugar sugar) throws SugarNotAvailableException {
        return storageProvider.dispenseSugar(sugar.getIngredientQuantity());
    }

    @Override
    public Ingredient dispense(TeaLeaves teaLeaves) throws TeaNotAvailableException {
        return storageProvider.dispenseTeaLeaves(teaLeaves.getIngredientQuantity());
    }
}
