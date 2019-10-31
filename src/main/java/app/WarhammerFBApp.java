package app;

import armies.dwarfs.Clansman;
import armies.generalModel.Model;
import armies.skaven.Clanrat;
import regiment.FormationMethods;
import regiment.Rank;
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

        Rank clansmanRank = formation.createRank(clansman,5);
        Unit clansmanUnit = formation.createUnit(clansmanRank,2);
        formation.printUnit(clansmanUnit, clansmanRank,'O');

        System.out.println();

        Rank clanratRank = formation.createRank(clanrat,6);
        Unit clanratUnit = formation.createUnit(clanratRank,5);
        formation.printUnit(clanratUnit, clanratRank,'X');

        clanratUnit.getUnitMap().get(4).getRankMap().pollLastEntry();
        System.out.println();

        formation.printUnit(clanratUnit, clanratRank,'X');


    }
}
