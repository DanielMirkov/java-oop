package Bakery.src.bakery.repositories.interfaces;

import java.util.Collection;

public class DrinkRepositoryImpl<T extends bakery.entities.drinks.interfaces.Drink> implements bakery.repositories.interfaces.DrinkRepository<T> {
    @Override
    public T getByNameAndBrand(String drinkName, String drinkBrand) {
        return null;
    }

    @Override
    public Collection<T> getAll() {
        return null;
    }

    @Override
    public void add(T t) {

    }
}
