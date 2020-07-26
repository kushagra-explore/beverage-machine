package dispenser.beverage.ingridients;

public class Ginger extends Ingredient{

    public Ginger(int quantity){
        super(quantity, "Ginger");
    }

    @Override
    public Ingredient dispense(IngredientProvider provider) {
        return provider.dispense(this);
    }
}
