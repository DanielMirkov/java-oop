package Bakery.src.bakery.entities.drinks.interfaces;

import static bakery.common.ExceptionMessages.*;

public abstract class BaseDrink implements bakery.entities.drinks.interfaces.Drink {
    private String name;
    private int portion;
    private double price;
    private String brand;


    public BaseDrink(String name, int portion, double price, String brand) {
        this.setName(name);
        this.setPortion(portion);
        this.setPrice(price);
        this.setBrand(brand);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }

    public void setPortion(int portion) {
        if (portion <= 0) {
            throw new IllegalArgumentException(INVALID_PORTION);
        }
        this.portion = portion;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }
        this.price = price;
    }

    public void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_BRAND);
        }
        this.brand = brand;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getPortion() {
        return 0;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String getBrand() {
        return null;
    }

    @Override
    public String toString() {
        //Returns a String with information about each drink. The returned String must be in the following format:
        //"{current drink name} {current brand name} - {current portion}ml - {current price - formatted to the second digit}lv"
        return "BaseDrink";
    }
}
