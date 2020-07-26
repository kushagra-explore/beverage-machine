package dispenser.beverage.containers;

import dispenser.beverage.exceptions.IngredientNotAvailableException;
import dispenser.beverage.exceptions.WaterNotAvailableException;
import dispenser.beverage.ingridients.HotWater;

public class WaterContainer extends IngredientContainer<HotWater> {
    public WaterContainer(int capacity) {
        super(capacity);
    }

    public WaterContainer(int capacity, int level) {
        super(capacity, level);
    }

    @Override
    public HotWater withdraw(int quantity) throws  IngredientNotAvailableException{
        if(this.level >= quantity) {
            synchronized (this){
                if(this.level >= quantity) {
                    this.level -= quantity;
                    return new HotWater(quantity);
                } else{
                    throw new WaterNotAvailableException(this.level);
                }
            }
        } else {
            throw new WaterNotAvailableException(this.level);
        }
    }
}