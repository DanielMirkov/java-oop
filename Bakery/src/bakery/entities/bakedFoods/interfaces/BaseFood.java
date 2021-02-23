package Bakery.src.bakery.entities.bakedFoods.interfaces;

import static bakery.common.ExceptionMessages.*;

public abstract class BaseFood implements bakery.entities.bakedFoods.interfaces.BakedFood {

    private String name;
    private double portion;
    private double price;

    public BaseFood(String name, double portion, double price) {
        this.setName(name);
        this.setPortion(portion);
        this.setPrice(price);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }

    private void setPortion(double portion) {
        if (portion <= 0) {
            throw new IllegalArgumentException(INVALID_PORTION);
        }
        this.portion = portion;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }
        this.price = price;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public double getPortion() {
        return 0;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String toString() {
        //Returns a String with information about each food. The returned String must be in the following format:
        //"{currentBakedFoodName}: {currentPortion - formatted to the second digit}g - {currentPrice - formatted to the second digit}"
        return "BaseFood";
    }
}
