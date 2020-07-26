package dispenser.beverage.exceptions;

public class MilkNotAvailableException extends IngredientNotAvailableException {
    public MilkNotAvailableException(int level) {
        super("Sufficient Milk Not Available(Curr Level : " + level + ") Fix: Please Refill");
    }
}
