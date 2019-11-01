package armies.dwarfs;

import armies.generalModel.Model;

public class Clansman extends Model {

    private boolean handWeapon;
    private boolean lightArmour;
    private boolean heavyArmour;
    private boolean greatWeapon;
    private boolean shield;

    private String single = "X";

    public Clansman(String name, int movement, int weaponSkill, int ballisticSkill, int strength, int toughness,
                    int wounds, int initiative, int attack, int leadership, int unitStrength, int save, int points,
                    boolean handWeapon, boolean lightArmour, boolean heavyArmour, boolean greatWeapon, boolean shield) {
        super(name, movement, weaponSkill, ballisticSkill, strength, toughness, wounds, initiative, attack, leadership,
                unitStrength, save, points);
        this.handWeapon = handWeapon;
        this.lightArmour = lightArmour;
        this.heavyArmour = heavyArmour;
        this.greatWeapon = greatWeapon;
        this.shield = shield;
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
        if (lightArmour){
            setHeavyArmour(false);
        }
        this.lightArmour = lightArmour;
    }

    public boolean isHeavyArmour() {
        return heavyArmour;
    }

    public void setHeavyArmour(boolean heavyArmour) {
        if (heavyArmour){
            setLightArmour(false);
        }
        this.heavyArmour = heavyArmour;
    }

    public boolean isGreatWeapon() {
        return greatWeapon;
    }

    public void setGreatWeapon(boolean greatWeapon) {
        if (greatWeapon){
            setShield(false);
        }
        this.greatWeapon = greatWeapon;
    }

    public boolean isShield() {
        return shield;
    }

    public void setShield(boolean shield) {
        if (shield){
            setGreatWeapon(false);
        }
        this.shield = shield;
    }

    @Override
    public String toString() {
        return single;
    }
}
