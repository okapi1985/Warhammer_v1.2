package closeCombat;

import app.Dice;
import armies.generalModel.Model;
import regiment.Unit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CloseCombatPhase {

    List<Unit> initRankingList;
    List<Model> listOfAttackersHit = new ArrayList<>();
    List<Model> listOfAttackersWound = new ArrayList<>();
    List<Model> listOfDefendersFallen = new ArrayList<>();
    List<Model> listOfDefendersHit = new ArrayList<>();
    List<Model> listOfDefendersWound = new ArrayList<>();
    List<Model> listOfAttackersFallen = new ArrayList<>();

    public List<Unit> initiativeTest(Unit unit1, Unit unit2) {
        List<Unit> initRankingList = new ArrayList<>();
        initRankingList.add(unit1);
        initRankingList.add(unit2);
        Collections.sort(initRankingList,Collections.reverseOrder());
        return initRankingList;
    }

    public List<Model> attackersHit(List<Unit> initRankingList){
        Model modelAttackFirst = initRankingList.get(0).getUnitMap().get(0).get(0);
        Model modelAttackLast = initRankingList.get(1).getUnitMap().get(0).get(0);
        int weaponSkillTest = modelAttackFirst.getWeaponSkill() - modelAttackLast.getWeaponSkill();
        int attacksAmount = modelAttackFirst.getAttack();
        int attackersAmount = initRankingList.get(0).getUnitMap().get(0).size();

        for (int i = 0; i < attackersAmount; i++) {
            for (int j = 0; j < attacksAmount; j++) {
                if ((weaponSkillTest >= 1 && Dice.rollDice() >= 3) ||
                        ((weaponSkillTest < 1 && (modelAttackLast.getWeaponSkill() / modelAttackFirst.getWeaponSkill()) < 2) && Dice.rollDice() >= 4) ||
                        (modelAttackLast.getWeaponSkill() / modelAttackFirst.getWeaponSkill()) >= 2 && Dice.rollDice() >= 5) {
                    System.out.println(modelAttackFirst.getName() + " trafił " + modelAttackLast.getName());
                    listOfAttackersHit.add(modelAttackFirst);
                } else
                    System.out.println(modelAttackFirst.getName() + " nie trafił " + modelAttackLast.getName());
            }
        }
        return listOfAttackersHit;
    }

    public List<Model> attackersWound(List<Unit> initRankingList) {
        Model modelAttackFirst = initRankingList.get(0).getUnitMap().get(0).get(0);
        Model modelAttackLast = initRankingList.get(1).getUnitMap().get(0).get(0);
        int strengthTest = modelAttackFirst.getStrength() - modelAttackLast.getToughness();
        int attacksHit = listOfAttackersHit.size();

        while (attacksHit > 0) {
            if ((strengthTest >= 2 && Dice.rollDice() >= 2) ||
                    (strengthTest == 1 && Dice.rollDice() >= 3) ||
                    (strengthTest == 0 && Dice.rollDice() >= 4) ||
                    (strengthTest == -1 && Dice.rollDice() >= 5) ||
                    (strengthTest == -2 && Dice.rollDice() >= 6) ||
                    ((strengthTest == -3 && Dice.rollDice() == 6) && Dice.rollDice() >= 4) ||
                    ((strengthTest == -4 && Dice.rollDice() == 6) && Dice.rollDice() >= 5)) {
                System.out.println(modelAttackFirst.getName() + " ranił " + modelAttackLast.getName());
                listOfAttackersWound.add(modelAttackFirst);
            } else
                System.out.println(modelAttackFirst.getName() + " nie zranił " + modelAttackLast.getName());
            attacksHit--;
        }
        return listOfAttackersWound;
    }

    public List<Model> defendersSave(List<Unit> initRankingList) {
        Model modelAttackFirst = initRankingList.get(0).getUnitMap().get(0).get(0);
        Model modelAttackLast = initRankingList.get(1).getUnitMap().get(0).get(0);
        int modifier = modelAttackFirst.getStrength() - 3;
        int save = modelAttackLast.getSave();
        int saveTest = listOfAttackersWound.size();

        if (modifier < 0) {
            modifier = 0;
        }

        while (saveTest > 0) {
            if (modelAttackLast.getSave() > 6) {
                listOfDefendersFallen.add(modelAttackLast);
                if (modelAttackLast.getWounds() == 1) {
                    System.out.println(modelAttackLast.getName() + " poległ");
                } else {
                    modelAttackLast.setWounds(modelAttackLast.getWounds() - 1);
                    System.out.println(modelAttackLast.getName() + " otrzymał ranę");
                }
            } else if (save + modifier <= Dice.rollDice()) {
                System.out.println(modelAttackLast.getName() + " obronił się");
            } else {
                listOfDefendersFallen.add(modelAttackLast);
                if (modelAttackLast.getWounds() == 1) {
                    System.out.println(modelAttackLast.getName() + " poległ");
                } else {
                    modelAttackLast.setWounds(modelAttackLast.getWounds() - 1);
                    System.out.println(modelAttackLast.getName() + " otrzymał ranę");
                }
            }
            saveTest--;
        }
        return listOfDefendersFallen;
    }

    public List<Model> defendersHit(List<Unit> initRankingList){
        Model modelAttackFirst = initRankingList.get(0).getUnitMap().get(0).get(0);
        Model modelAttackLast = initRankingList.get(1).getUnitMap().get(0).get(0);
        int weaponSkillTest = modelAttackLast.getWeaponSkill() - modelAttackFirst.getWeaponSkill();
        int attacksAmount = modelAttackLast.getAttack();
        int attackersAmount = initRankingList.get(1).getUnitMap().get(0).size();

        for (int i = 0; i < attackersAmount; i++) {
            for (int j = 0; j < attacksAmount; j++) {
                if ((weaponSkillTest >= 1 && Dice.rollDice() >= 3) ||
                        ((weaponSkillTest < 1 && (modelAttackFirst.getWeaponSkill() / modelAttackLast.getWeaponSkill()) < 2) && Dice.rollDice() >= 4) ||
                        (modelAttackFirst.getWeaponSkill() / modelAttackLast.getWeaponSkill()) >= 2 && Dice.rollDice() >= 5) {
                    System.out.println(modelAttackLast.getName() + " trafił " + modelAttackFirst.getName());
                    listOfDefendersHit.add(modelAttackLast);
                } else
                    System.out.println(modelAttackLast.getName() + " nie trafił " + modelAttackFirst.getName());
            }
        }
        return listOfDefendersHit;
    }

    public List<Model> defendersWound(List<Unit> initRankingList) {
        Model modelAttackFirst = initRankingList.get(0).getUnitMap().get(0).get(0);
        Model modelAttackLast = initRankingList.get(1).getUnitMap().get(0).get(0);
        int strengthTest = modelAttackLast.getStrength() - modelAttackFirst.getToughness();
        int attacksHit = listOfDefendersHit.size();

        while (attacksHit > 0) {
            if ((strengthTest >= 2 && Dice.rollDice() >= 2) ||
                    (strengthTest == 1 && Dice.rollDice() >= 3) ||
                    (strengthTest == 0 && Dice.rollDice() >= 4) ||
                    (strengthTest == -1 && Dice.rollDice() >= 5) ||
                    (strengthTest == -2 && Dice.rollDice() >= 6) ||
                    ((strengthTest == -3 && Dice.rollDice() == 6) && Dice.rollDice() >= 4) ||
                    ((strengthTest == -4 && Dice.rollDice() == 6) && Dice.rollDice() >= 5)) {
                System.out.println(modelAttackLast.getName() + " ranił " + modelAttackFirst.getName());
                listOfDefendersWound.add(modelAttackLast);
            } else
                System.out.println(modelAttackLast.getName() + " nie zranił " + modelAttackFirst.getName());
            attacksHit--;
        }
        return listOfDefendersWound;
    }
    public List<Model> attackersSave(List<Unit> initRankingList) {
        Model modelAttackFirst = initRankingList.get(0).getUnitMap().get(0).get(0);
        Model modelAttackLast = initRankingList.get(1).getUnitMap().get(0).get(0);
        int modifier = modelAttackLast.getStrength() - 3;
        int save = modelAttackFirst.getSave();
        int saveTest = listOfDefendersWound.size();

        if (modifier < 0) {
            modifier = 0;
        }

        while (saveTest > 0) {
            if (modelAttackFirst.getSave() > 6) {
                listOfAttackersFallen.add(modelAttackFirst);
                if (modelAttackFirst.getWounds() == 1) {
                    System.out.println(modelAttackFirst.getName() + " poległ");
                } else {
                    modelAttackFirst.setWounds(modelAttackFirst.getWounds() - 1);
                    System.out.println(modelAttackFirst.getName() + " otrzymał ranę");
                }
            } else if (save + modifier <= Dice.rollDice()) {
                System.out.println(modelAttackFirst.getName() + " obronił się");
            } else {
                listOfAttackersFallen.add(modelAttackFirst);
                if (modelAttackFirst.getWounds() == 1) {
                    System.out.println(modelAttackFirst.getName() + " poległ");
                } else {
                    modelAttackFirst.setWounds(modelAttackFirst.getWounds() - 1);
                    System.out.println(modelAttackFirst.getName() + " otrzymał ranę");
                }
            }
            saveTest--;
        }
        return listOfAttackersFallen;
    }

}
