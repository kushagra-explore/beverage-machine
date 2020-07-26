package dispenser.beverage.containers;

import dispenser.beverage.exceptions.*;
import dispenser.beverage.ingridients.*;
import lombok.AllArgsConstructor;

/**
 * this class provides facade of containers
 */
@AllArgsConstructor
public class StorageFacade implements StorageProvider{

    private final GingerContainer gingerContainer;
    private final SugarContainer sugarContainer;
    private final GreenTeaLeavesContainer greenTeaLeavesContainer;
    private final TeaLeavesContainer teaLeavesContainer;
    private final MilkContainer milkContainer;
    private final WaterContainer waterContainer;

    @Override
    public Ginger dispenseGinger(int quantity) throws GingerNotAvailableException {
        return gingerContainer.withdraw(quantity);
    }

    @Override
    public Sugar dispenseSugar(int quantity) throws SugarNotAvailableException {
        return sugarContainer.withdraw(quantity);
    }

    @Override
    public GreenTeaLeaves dispenseGreenTeaLeaves(int quantity) throws GreenTeaNotAvailableException {
        return greenTeaLeavesContainer.withdraw(quantity);
    }

    @Override
    public HotMilk dispenseHotMilk(int quantity) throws MilkNotAvailableException {
        return milkContainer.withdraw(quantity);
    }

    @Override
    public HotWater dispenseHotWater(int quantity) throws WaterNotAvailableException {
        return waterContainer.withdraw(quantity);
    }

    @Override
    public TeaLeaves dispenseTeaLeaves(int quantity) throws TeaNotAvailableException {
        return teaLeavesContainer.withdraw(quantity);
    }

    @Override
    public void refillMilk(int quantity) {
        milkContainer.refill(quantity);
    }

    @Override
    public void refillWater(int quantity) {
        waterContainer.refill(quantity);
    }

    @Override
    public void refillGinger(int quantity) {
        gingerContainer.refill(quantity);
    }

    @Override
    public void refillSugar(int quantity) {
        sugarContainer.refill(quantity);
    }

    @Override
    public void refillTeaLeaves(int quantity) {
        teaLeavesContainer.refill(quantity);
    }

    @Override
    public void refillGreenTeaLeaves(int quantity) {
        greenTeaLeavesContainer.refill(quantity);
    }

    @Override
    public int getMilkLevel() {
        return milkContainer.getLevel();
    }

    @Override
    public int getWaterLevel() {
        return waterContainer.getLevel();
    }

    @Override
    public int getGingerLevel() {
        return gingerContainer.getLevel();
    }

    @Override
    public int getSugarLevel() {
        return sugarContainer.getLevel();
    }

    @Override
    public int getTeaLeavesLevel() {
        return teaLeavesContainer.getLevel();
    }

    @Override
    public int getGreenTeaLeavesLevel() {
        return greenTeaLeavesContainer.getLevel();
    }
}
