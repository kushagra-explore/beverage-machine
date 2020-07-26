package dispenser.beverage.exceptions;

public class GreenTeaNotAvailableException extends IngredientNotAvailableException{
    public GreenTeaNotAvailableException(int level) {
        super("Sufficient Green Tea Not Available(Curr Level : " + level + ") Fix: Please Refill");
    }
}
