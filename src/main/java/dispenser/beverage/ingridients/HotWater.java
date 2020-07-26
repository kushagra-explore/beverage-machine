package dispenser.beverage.ingridients;

public class HotWater extends Ingredient{
    public HotWater(int quantity){
        super(quantity, "HotWater");
    }

    @Override
    public Ingredient dispense(IngredientProvider provider) {
        return provider.dispense(this);
    }
}
