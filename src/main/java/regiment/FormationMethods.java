package regiment;

import armies.generalModel.Model;

import java.util.Map;
import java.util.TreeMap;

public class FormationMethods {


    public Rank createRank(Model model, int rankSize){
        TreeMap<Integer,Model> rankMap = new TreeMap<>();
        Rank rank = new Rank(rankMap);
        for (int i=0;i<rankSize;i++){
            rankMap.put(i,model);
        }
        return rank;
    }

    public Unit createUnit(Rank rank, int ranksNumber){
        TreeMap<Integer,Rank> unitMap = new TreeMap<>();
        Unit unit = new Unit(unitMap);
        for (int i=0;i<ranksNumber;i++){
            unitMap.put(i,rank);
        }
        return unit;
    }

    public void printUnit(Unit unit, Rank rank, char single){
        int rankAmount = unit.getUnitMap().size();
        int rankSize = rank.getRankMap().size();
        for (int i = 0; i < rankAmount; i++){
            for (int j = 0; j < rankSize; j++){
                System.out.print(single+" ");
            }
            System.out.println();
        }
    }
}
