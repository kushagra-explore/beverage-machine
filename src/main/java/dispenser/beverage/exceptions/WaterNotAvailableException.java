package dispenser.beverage.exceptions;

public class WaterNotAvailableException extends IngredientNotAvailableException{
    public WaterNotAvailableException(int level) {
        super("Sufficient Water Not Available(Curr Level : " + level + ") Fix: Please Refill");
    }
}
