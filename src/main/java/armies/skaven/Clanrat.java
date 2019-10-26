package armies.skaven;

import armies.generalModel.Model;

public class Clanrat extends Model {

    private boolean handWeapon;
    private boolean lightArmour;
    private boolean shield;
    private boolean spear;

    public Clanrat(String name, int movement, int weaponSkill, int ballisticSkill, int strength, int toughness,
                   int wounds, int initiative, int attack, int leadership, int unitStrength, int save, int points,
                   boolean handWeapon, boolean lightArmour, boolean shield, boolean spear) {
        super(name, movement, weaponSkill, ballisticSkill, strength, toughness, wounds, initiative, attack, leadership,
                unitStrength, save, points);
        this.handWeapon = handWeapon;
        this.lightArmour = lightArmour;
        this.shield = shield;
        this.spear = spear;
    }

    public boolean isHandWeapon() {
        return handWeapon;
    }

    public void setHandWeapon(boolean handWeapon) {
        this.handWeapon = handWeapon;
    }

    public boolean isLightArmour() {
        return lightArmour;
    }

    public void setLightArmour(boolean lightArmour) {
        this.lightArmour = lightArmour;
    }

    public boolean isShield() {
        return shield;
    }

    public void setShield(boolean shield) {
        this.shield = shield;
    }

    public boolean isSpear() {
        return spear;
    }

    public void setSpear(boolean spear) {
        this.spear = spear;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Clanrat{");
        sb.append("handWeapon=").append(handWeapon);
        sb.append(", lightArmour=").append(lightArmour);
        sb.append(", shield=").append(shield);
        sb.append(", spear=").append(spear);
        sb.append('}');
        return sb.toString();
    }
}
