package dispenser.beverage.exceptions;

public class IngredientNotAvailableException extends RuntimeException {
    public IngredientNotAvailableException(){
        super();
    }
    public IngredientNotAvailableException(String message){
        super(message);
    }
}
