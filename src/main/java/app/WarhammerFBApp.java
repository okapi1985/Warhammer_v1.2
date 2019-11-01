package app;

import armies.dwarfs.Clansman;
import armies.generalModel.Model;
import armies.skaven.Clanrat;
import regiment.FormationMethods;
import regiment.Unit;

public class WarhammerFBApp {
    public static void main(String[] args) {



        Model clansman = new Clansman("Clansman",3,4,3,3,4,
                1,2,1,9,1,5,7,true,true,
                false,false,false);
        Model clanrat = new Clanrat("Clanrat",5,3,3,3,3,
                1,4,1,5,1,4,5,true,true,
                true,false);

        FormationMethods formation = new FormationMethods();

        Unit clansmanUnit = formation.createUnit(clansman,4,5);
        formation.printUnit(clansmanUnit);
        formation.removeModel(clansmanUnit);
        formation.removeModel(clansmanUnit);

        System.out.println();

        Unit clanratUnit = formation.createUnit(clanrat,5,6);
        formation.printUnit(clanratUnit);
        formation.removeModel(clanratUnit);

        System.out.println();

        formation.printUnit(clansmanUnit);
        System.out.println();
        formation.printUnit(clanratUnit);


    }
}
