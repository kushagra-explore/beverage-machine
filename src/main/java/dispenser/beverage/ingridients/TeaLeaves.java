package dispenser.beverage.ingridients;

public class TeaLeaves extends  Ingredient{
    public TeaLeaves(int quantity){
        super(quantity, "TeaLeaves");
    }

    @Override
    public Ingredient dispense(IngredientProvider provider) {
        return null;
    }
}
