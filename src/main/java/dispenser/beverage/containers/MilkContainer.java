package dispenser.beverage.containers;

import dispenser.beverage.exceptions.IngredientNotAvailableException;
import dispenser.beverage.exceptions.MilkNotAvailableException;
import dispenser.beverage.ingridients.HotMilk;

public class MilkContainer extends IngredientContainer<HotMilk>{
    public MilkContainer(int capacity) {
        super(capacity);
    }

    public MilkContainer(int capacity, int level) {
        super(capacity, level);
    }

    @Override
    public HotMilk withdraw(int quantity) throws IngredientNotAvailableException {
        if(this.level >= quantity) {
            synchronized (this){
                if(this.level >= quantity) {
                    this.level -= quantity;
                    return new HotMilk(quantity);
                } else{
                    throw new MilkNotAvailableException(this.level);
                }
            }
        } else {
            throw new MilkNotAvailableException(this.level);
        }
    }
}
