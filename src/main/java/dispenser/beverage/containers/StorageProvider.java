package dispenser.beverage.containers;

import dispenser.beverage.exceptions.*;
import dispenser.beverage.ingridients.*;

public interface StorageProvider {
    Ginger dispenseGinger(int quantity) throws GingerNotAvailableException;
    Sugar dispenseSugar(int quantity) throws SugarNotAvailableException;
    GreenTeaLeaves dispenseGreenTeaLeaves(int quantity) throws GreenTeaNotAvailableException;
    HotMilk dispenseHotMilk(int quantity) throws MilkNotAvailableException;
    HotWater dispenseHotWater(int quantity) throws WaterNotAvailableException;
    TeaLeaves dispenseTeaLeaves(int quantity) throws TeaNotAvailableException;

    void refillMilk(int quantity);
    void refillWater(int quantity);
    void refillGinger(int quantity);
    void refillSugar(int quantity);
    void refillTeaLeaves(int quantity);
    void refillGreenTeaLeaves(int quantity);

    int getMilkLevel();
    int getWaterLevel();
    int getGingerLevel();
    int getSugarLevel();
    int getTeaLeavesLevel();
    int getGreenTeaLeavesLevel();
}
