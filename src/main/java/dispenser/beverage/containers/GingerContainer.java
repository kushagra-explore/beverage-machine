package dispenser.beverage.containers;

import dispenser.beverage.exceptions.GingerNotAvailableException;
import dispenser.beverage.ingridients.Ginger;

public class GingerContainer extends IngredientContainer<Ginger>{

    public GingerContainer(int capacity) {
        super(capacity);
    }

    @Override
    public Ginger withdraw(int quantity) throws GingerNotAvailableException {
        if(this.level >= quantity) {
            synchronized (this){
                if(this.level >= quantity) {
                    this.level -= quantity;
                    return new Ginger(quantity);
                } else{
                    throw new GingerNotAvailableException(this.level);
                }
            }
        } else {
            throw new GingerNotAvailableException(this.level);
        }

    }
}
