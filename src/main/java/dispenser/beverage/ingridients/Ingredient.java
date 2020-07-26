package dispenser.beverage.ingridients;



public abstract class Ingredient {
    private final int ingredientQuantity;
    private final String name;

    public Ingredient(int quantity, String name){
        this.name = name;
        this.ingredientQuantity = quantity;
    }

    public int getIngredientQuantity() {
        return ingredientQuantity;
    }

    public String getName() {
        return name;
    }

    /**
     * uses visitor Pattern to get ingredient from container
     * @param provider
     * @return dispensed ingredient
     */
    public abstract Ingredient dispense(IngredientProvider provider);

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredientQuantity=" + ingredientQuantity +
                ", name='" + name + '\'' +
                '}';
    }
}
