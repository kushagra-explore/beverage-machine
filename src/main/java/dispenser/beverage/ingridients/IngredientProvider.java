package dispenser.beverage.ingridients;

import dispenser.beverage.exceptions.*;

public interface IngredientProvider {
    Ingredient dispense(Ginger ginger) throws GingerNotAvailableException;
    Ingredient dispense(GreenTeaLeaves greenTeaLeaves) throws GreenTeaNotAvailableException;
    Ingredient dispense(HotMilk hotMilk) throws MilkNotAvailableException;
    Ingredient dispense(HotWater hotWater) throws WaterNotAvailableException;
    Ingredient dispense(Sugar sugar) throws SugarNotAvailableException;
    Ingredient dispense(TeaLeaves teaLeaves) throws TeaNotAvailableException;
}
