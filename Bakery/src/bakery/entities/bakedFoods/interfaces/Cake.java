package Bakery.src.bakery.entities.bakedFoods.interfaces;

public class Cake extends BaseFood {

    private final static double INITIAL_BREAD_PORTION = 200;

    public Cake(String name, double portion, double price) {
        super(name, INITIAL_BREAD_PORTION, price);

    }
}
