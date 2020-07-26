package dispenser.beverage.exceptions;

public class GingerNotAvailableException extends IngredientNotAvailableException{
    public GingerNotAvailableException(int level){
        super("Sufficient Ginger Not Available(Curr Level : " + level + ") Fix: Please Refill");
    }
}
