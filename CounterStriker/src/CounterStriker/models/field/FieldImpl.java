package CounterStriker.models.field;

import CounterStriker.models.guns.Gun;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Terrorist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import static CounterStriker.common.OutputMessages.*;

public  class FieldImpl implements Field {

    private Collection<Player> counterTerrorists;
    private Collection<Terrorist> terrorists;

    public FieldImpl() {
        counterTerrorists = new ArrayList<>();
        terrorists = new ArrayList<>();
    }


    @Override
    public String start(Collection<Player> players) {
        Collection<Player> counterTerrorists = players.stream().filter(
                p -> p instanceof CounterTerrorist).collect(Collectors.toList());

        Collection<Player> terrorists = players.stream().filter(
                p -> p instanceof Terrorist).collect(Collectors.toList());

        while ((counterTerrorists.stream().anyMatch(Player::isAlive)
                && terrorists.stream().anyMatch(Player::isAlive))) {
            for (Player terrorist : terrorists) {
                for (Player counterTerrorist : counterTerrorists) {
                    counterTerrorist.takeDamage(terrorist.getGun().fire());
                }
            }

            counterTerrorists = counterTerrorists.stream().filter(Player::isAlive)
                    .collect(Collectors.toList());

            for (Player counterTerrorist : counterTerrorists) {
                for (Player terrorist : terrorists) {
                    terrorist.takeDamage(counterTerrorist.getGun().fire());
                }
            }

            terrorists = terrorists.stream().filter(Player::isAlive)
                    .collect(Collectors.toList());
        }
        return terrorists.stream().anyMatch(Player::isAlive) ? TERRORIST_WINS
                : COUNTER_TERRORIST_WINS;
    }

}
