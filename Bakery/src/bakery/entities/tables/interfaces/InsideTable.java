package Bakery.src.bakery.entities.tables.interfaces;

public class InsideTable extends BaseTable {
    private final static double PRICE_PER_PERSON_INSIDE = 2.50;

    public InsideTable(int tableNumber, int tableCapacity) {
        super(tableNumber, tableCapacity, PRICE_PER_PERSON_INSIDE);
    }
}
