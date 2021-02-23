package Bakery.src.bakery.repositories.interfaces;

import java.util.Collection;

public class TableRepositoryImpl<T extends bakery.entities.tables.interfaces.Table> implements bakery.repositories.interfaces.TableRepository<T> {
    @Override
    public T getByNumber(int number) {
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
