package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

import java.util.ArrayList;
import java.util.List;

import static CounterStriker.common.ExceptionMessages.*;

public abstract class PlayerImpl implements Player {

    private String username;
    private int health;
    private int armor;
    private Gun gun;
    //    private List<Gun> gunsList;
    private List<String> playersList;
    private int additionalDamage;
//    private List<Player> immutableList;

    PlayerImpl(String username, int health, int armor, Gun gun) {
        this.setUsername(username);
        this.setHealth(health);
        this.setArmor(armor);
        this.setGun(gun);
        playersList = new ArrayList<>();
//       immutableList = Collections.unmodifiableList(playersList);

    }

    private void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(INVALID_PLAYER_NAME);
        }

            this.username = username;
    }


    private void setHealth(int health) {
//       if (isAlive) {
           if (health < 0) {
               throw new IllegalArgumentException(INVALID_PLAYER_HEALTH);
           }
//       }

        this.health = health;
    }

    private void setArmor(int armor) {
        if (armor < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_ARMOR);
        }
        this.armor = armor;
    }

    private void setGun(Gun gun) {
        if (gun == null) {
            throw new NullPointerException(INVALID_GUN);
        }
        this.gun = gun;
    }


    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getArmor() {
        return this.armor;
    }

    @Override
    public Gun getGun() {
        return this.gun;
        //TODO Fix Gun in map Value Player is Key
    }

    @Override
    public boolean isAlive() {
        return this.health > 0;
    }

    @Override
    public void takeDamage(int points) {

        if (isAlive()) {
            if (armor > 0) {
                setArmor(armor -= points);
                if (armor - points < 0) {
                    additionalDamage = Math.abs(armor - points);
                    setArmor(0);

                }
            } else if (armor == 0 && health > 0) {
                if (additionalDamage > 0) {
                    setHealth(health -= additionalDamage);
                    this.additionalDamage -= additionalDamage;
                }
                setHealth(health - points);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%s: %s", this.getClass()
        .getSimpleName(), this.username)).append(System.lineSeparator());
        stringBuilder.append(String.format("--Health: %d", this.health))
                .append(System.lineSeparator());
        stringBuilder.append(String.format("--Armor: %d", this.armor))
                .append(System.lineSeparator());
        stringBuilder.append(String.format("--Gun: %s", this.gun.getName()));

        return stringBuilder.toString().trim();

    }
}
