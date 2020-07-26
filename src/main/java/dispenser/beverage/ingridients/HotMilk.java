package dispenser.beverage.ingridients;

public class HotMilk extends Ingredient{

    public HotMilk(int quantity){
        super(quantity, "HotMilk");
    }

    @Override
    public Ingredient dispense(IngredientProvider provider) {
        return provider.dispense(this);
    }
}
