package CounterStriker.models.guns;



public class Rifle extends GunImpl {

    private static final int BULLETS_TO_SHOOT = 10;

    public Rifle(String gunName, int gunBullets) {
        super(gunName, gunBullets);
    }

    @Override
    public int fire() {
        if (super.getBulletsCount() < BULLETS_TO_SHOOT) {
            return 0;
        }
        super.decreaseBullets(BULLETS_TO_SHOOT);
        return BULLETS_TO_SHOOT;
    }
}
