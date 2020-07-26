package dispenser.beverage.exceptions;

public class TeaNotAvailableException extends IngredientNotAvailableException{
    public TeaNotAvailableException(int level) {
        super("Sufficient Tea Not Available(Curr Level : " + level + ") Fix: Please Refill");
    }
}
