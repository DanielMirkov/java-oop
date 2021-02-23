package Bakery.src.bakery.repositories.interfaces;

import java.util.Collection;

public class FoodRepositoryImpl<T extends bakery.entities.bakedFoods.interfaces.BakedFood> implements bakery.repositories.interfaces.FoodRepository<T> {
    @Override
    public T getByName(String name) {
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
