package Bakery.src.bakery.entities.bakedFoods.interfaces;

public class Bread extends BaseFood {

    private final static double INITIAL_BREAD_PORTION = 245;
    public Bread(String name, double portion, double price) {
        super(name, INITIAL_BREAD_PORTION, price);
    }
}
