package dispenser.beverage.containers;

import dispenser.beverage.exceptions.IngredientNotAvailableException;
import dispenser.beverage.ingridients.Ingredient;

public abstract class IngredientContainer<T extends Ingredient> {
    private final int capacity;
    protected int level;

    public IngredientContainer(int capacity){
        this.capacity = capacity;
    }

    public IngredientContainer(int capacity, int level) {
        this.capacity = capacity;
        this.level = level;
    }

    public synchronized void refill(int value){
        this.level = Math.max(capacity, level + value);
    }

    public abstract T withdraw(int quantity) throws IngredientNotAvailableException;

    public int getCapacity() {
        return capacity;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "IngredientContainer{" +
                "capacity=" + capacity +
                ", level=" + level +
                '}';
    }
}
