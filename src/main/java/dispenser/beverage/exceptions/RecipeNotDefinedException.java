package dispenser.beverage.exceptions;

public class RecipeNotDefinedException extends RuntimeException{
    public RecipeNotDefinedException() {
        super("This drink is not available yet");
    }
}
