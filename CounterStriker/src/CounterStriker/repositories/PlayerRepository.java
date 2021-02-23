package CounterStriker.repositories;

import CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;

public class PlayerRepository<T extends Player> implements Repository<Player> {

    private Collection<Player> models;

    public PlayerRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<Player> getModels() {
        return this.models;
    }

    @Override
    public void add(Player model) {
        models.add(model);
    }

    @Override
    public boolean remove(Player model) {
        return models.remove(model);

    }


    @Override
    public Player findByName(String name) {

        return  this.models.stream().filter(m -> m.getUsername().equals(name))
                .findFirst().orElse(null);
    }

}
