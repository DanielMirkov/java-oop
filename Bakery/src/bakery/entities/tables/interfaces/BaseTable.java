package Bakery.src.bakery.entities.tables.interfaces;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;

import java.util.Collection;

import static bakery.common.ExceptionMessages.*;

public abstract class BaseTable implements bakery.entities.tables.interfaces.Table {

    //•	foodOrders - Collection<BakedFood> accessible only by the base class
    //•	drinkOrders – Collection<Drink> accessible only by the base class
    //•	tableNumber – int the table number
    //•	capacity - int the table capacity.
    //o	 It can’t be less than zero. In these cases, throw an IllegalArgumentException with message "Capacity has to be greater than 0"
    //•	numberOfPeople - int the count of people who want a table.
    //o	 cannot be less or equal to 0. In these cases, throw an IllegalArgumentException with message "Cannot place zero or less people!"
    //•	pricePerPerson – double the price per person for the table
    //•	isReserved - boolean returns true if the table is reserved, otherwise false.
    //•	price – double calculates the price for all people
    private Collection<BakedFood> bakedFoods;
    private Collection<Drink> drinks;
    private int tableNumber;
    private int tableCapacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    public BaseTable(int tableNumber, int tableCapacity, double pricePerPerson) {
        this.tableNumber = tableNumber;
        this.setTableCapacity(tableCapacity);
        this.pricePerPerson = pricePerPerson;
    }

    public void setTableCapacity(int tableCapacity) {
        if (tableCapacity < 0) {
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.tableCapacity = tableCapacity;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public int getTableNumber() {
        return 0;
    }

    @Override
    public int getCapacity() {
        return 0;
    }

    @Override
    public int getNumberOfPeople() {
        return 0;
    }

    @Override
    public double getPricePerPerson() {
        return 0;
    }

    @Override
    public boolean isReserved() {
        return false;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public void reserve(int numberOfPeople) {

    }

    @Override
    public void orderFood(BakedFood food) {

    }

    @Override
    public void orderDrink(Drink drink) {

    }

    @Override
    public double getBill() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public String getFreeTableInfo() {
        return null;
    }

    @Override
    public String toString() {
        return "Table";
    }
}
