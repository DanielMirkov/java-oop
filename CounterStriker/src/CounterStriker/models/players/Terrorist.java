package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;
import CounterStriker.models.players.PlayerImpl;

public class Terrorist extends PlayerImpl {
    public Terrorist(String username, int health, int armor, Gun gun) {
        super(username, health, armor, gun);
    }
}
