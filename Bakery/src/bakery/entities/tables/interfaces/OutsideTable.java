package Bakery.src.bakery.entities.tables.interfaces;

public class OutsideTable extends BaseTable {
    private final static double PRICE_PER_PERSON_INSIDE = 3.50;

    public OutsideTable(int tableNumber, int tableCapacity) {
        super(tableNumber, tableCapacity, PRICE_PER_PERSON_INSIDE);
    }
}
