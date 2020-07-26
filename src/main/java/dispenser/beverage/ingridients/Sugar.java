package dispenser.beverage.ingridients;

public class Sugar extends Ingredient{
    public Sugar(int quantity){
        super(quantity, "Sugar");
    }

    @Override
    public Ingredient dispense(IngredientProvider provider) {
        return null;
    }
}
