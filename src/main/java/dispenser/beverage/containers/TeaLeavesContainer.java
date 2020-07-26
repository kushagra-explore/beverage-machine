package dispenser.beverage.containers;

import dispenser.beverage.exceptions.IngredientNotAvailableException;
import dispenser.beverage.exceptions.TeaNotAvailableException;
import dispenser.beverage.ingridients.GreenTeaLeaves;
import dispenser.beverage.ingridients.TeaLeaves;

public class TeaLeavesContainer extends IngredientContainer<TeaLeaves>{
    public TeaLeavesContainer(int capacity) {
        super(capacity);
    }

    public TeaLeavesContainer(int capacity, int level) {
        super(capacity, level);
    }

    @Override
    public TeaLeaves withdraw(int quantity) throws  IngredientNotAvailableException{
        if(this.level >= quantity) {
            synchronized (this){
                if(this.level >= quantity) {
                    this.level -= quantity;
                    return new TeaLeaves(quantity);
                } else{
                    throw new TeaNotAvailableException(this.level);
                }
            }
        } else {
            throw new TeaNotAvailableException(this.level);
        }

    }
}
