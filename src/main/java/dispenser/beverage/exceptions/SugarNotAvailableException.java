package dispenser.beverage.exceptions;

public class SugarNotAvailableException extends IngredientNotAvailableException{
    public SugarNotAvailableException(int level) {
        super("Sufficient Sugar Not Available(Curr Level : " + level + ") Fix: Please Refill");
    }
}
