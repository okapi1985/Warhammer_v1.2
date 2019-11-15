package app;

import armies.dwarfs.Clansman;
import armies.generalModel.Model;
import armies.skaven.Clanrat;
import closeCombat.CloseCombatPhase;
import regiment.FormationMethods;
import regiment.Unit;

import java.util.List;

public class WarhammerFBApp {
    public static void main(String[] args) {

        CloseCombatPhase closeCombat = new CloseCombatPhase();



        Model clansman = new Clansman("Clansman",3,4,3,3,4,
                1,2,1,9,1,4,7,true,true,
                false,false,true);

        Model clanrat = new Clanrat("Clanrat",5,3,3,3,3,
                1,4,1,5,1,4,5,true,true,
                true,false);

        FormationMethods formation = new FormationMethods();

        Unit clansmanUnit = formation.createUnit(clansman,4,5);
        formation.printUnit(clansmanUnit);
//        formation.removeModel(clansmanUnit);
//        formation.removeModel(clansmanUnit);

        System.out.println();

        Unit clanratUnit = formation.createUnit(clanrat,5,6);
        formation.printUnit(clanratUnit);
//        formation.removeModel(clanratUnit);

        System.out.println();

        List<Unit> attackFirst = closeCombat.initiativeTest(clanratUnit,clansmanUnit);
        System.out.println(attackFirst.get(0).getUnitMap().get(0).get(0).getName()+" unit atakuje pierwszy");
        System.out.println();

        closeCombat.attackersHit(attackFirst);

        System.out.println();
        System.out.println();

        closeCombat.attackersWound(attackFirst);

        System.out.println();
        System.out.println();

        closeCombat.defendersSave(attackFirst);

        System.out.println();
        System.out.println();

        closeCombat.defendersHit(attackFirst);

        System.out.println();
        System.out.println();

        closeCombat.defendersWound(attackFirst);

        System.out.println();
        System.out.println();

        closeCombat.attackersSave(attackFirst);

    }
}
