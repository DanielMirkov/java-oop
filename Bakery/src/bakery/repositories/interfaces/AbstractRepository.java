package Bakery.src.bakery.repositories.interfaces;

import java.util.Collection;

public abstract class AbstractRepository<T> implements Repository<T> {

    private Collection<T> models;

    @Override
    public Collection<T> getAll() {
        return null;
    }

    @Override
    public void add(T t) {

    }
}
