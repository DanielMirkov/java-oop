package CounterStriker.models.guns;

import static CounterStriker.common.ExceptionMessages.*;

public abstract class GunImpl implements Gun {

    private String name;
    private int bulletsCount;


    GunImpl(String name, int bulletsCount) {
        this.setName(name);
        this.setBulletsCount(bulletsCount);
    }


    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new  NullPointerException(INVALID_GUN_NAME);
        }
        this.name = name;
    }

    private void setBulletsCount(int gunBullets) {
        if (gunBullets < 0) {
            throw new IllegalArgumentException(INVALID_GUN_BULLETS_COUNT);
        }
        this.bulletsCount = gunBullets;
    }

    protected void decreaseBullets(int amount) {

        setBulletsCount(this.bulletsCount -= amount);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBulletsCount() {
        return this.bulletsCount;
    }

    //    @Override
//    public int fire() {
//        if (gunBullets <= 0) {
//            return 0;
//        }
//        return this.gunBullets - 1;
//    }
}
