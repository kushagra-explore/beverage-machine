package dispenser.beverage.containers;

import dispenser.beverage.exceptions.SugarNotAvailableException;
import dispenser.beverage.ingridients.Sugar;

public class SugarContainer extends IngredientContainer<Sugar>{

    public SugarContainer(int capacity) {
        super(capacity);
    }
    public SugarContainer(int capacity, int level) {
        super(capacity, level);
    }
    @Override
    public Sugar withdraw(int quantity) throws SugarNotAvailableException {
        if(this.level >= quantity) {
            synchronized (this){
                if(this.level >= quantity) {
                    this.level -= quantity;
                    return new Sugar(quantity);
                } else{
                    throw new SugarNotAvailableException(this.level);
                }
            }
        } else {
            throw new SugarNotAvailableException(this.level);
        }

    }
}
