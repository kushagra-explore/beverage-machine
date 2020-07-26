package dispenser.beverage.containers;

import dispenser.beverage.exceptions.GingerNotAvailableException;
import dispenser.beverage.exceptions.GreenTeaNotAvailableException;
import dispenser.beverage.exceptions.IngredientNotAvailableException;
import dispenser.beverage.ingridients.Ginger;
import dispenser.beverage.ingridients.GreenTeaLeaves;

public class GreenTeaLeavesContainer extends IngredientContainer<GreenTeaLeaves>{

    public GreenTeaLeavesContainer(int capacity) {
        super(capacity);
    }

    public GreenTeaLeavesContainer(int capacity, int level) {
        super(capacity, level);
    }

    @Override
    public GreenTeaLeaves withdraw(int quantity) throws  GreenTeaNotAvailableException{
        if(this.level >= quantity) {
            synchronized (this){
                if(this.level >= quantity) {
                    this.level -= quantity;
                    return new GreenTeaLeaves(quantity);
                } else{
                    throw new GreenTeaNotAvailableException(this.level);
                }
            }
        } else {
            throw new GreenTeaNotAvailableException(this.level);
        }

    }
}
