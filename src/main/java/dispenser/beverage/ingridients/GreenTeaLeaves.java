package dispenser.beverage.ingridients;

public class GreenTeaLeaves extends Ingredient{
    public GreenTeaLeaves(int quantity){
        super(quantity, "GreenTeaLeaves");
    }

    @Override
    public Ingredient dispense(IngredientProvider provider) {
        return provider.dispense(this);
    }
}
