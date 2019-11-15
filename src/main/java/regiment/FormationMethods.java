package regiment;

import armies.generalModel.Model;

import java.io.PrintStream;
import java.util.Map;
import java.util.TreeMap;

public class FormationMethods {

    PrintStream out = System.out;

    public Unit createUnit(Model model, int ranksNumber, int rankSize) {
        TreeMap<Integer, Model> rank = new TreeMap<>();
        TreeMap<Integer, TreeMap<Integer, Model>> unitMap = new TreeMap<>();
        Unit unit = new Unit(unitMap);
        for (int j = 0; j < ranksNumber; j++) {
            for (int i = 0; i < rankSize; i++) {
                rank.put(i, model);
                }
                unitMap.put(j, new TreeMap<>(rank));
            }
            return unit;
        }


    public void printUnit(Unit unit){
        for (Map.Entry<Integer,TreeMap<Integer,Model>> entry: unit.getUnitMap().entrySet()){
            System.out.println(entry.getValue());
        }
    }

    public void removeModel(Unit unit){
        int lastRank = unit.getUnitMap().size()-1;
        TreeMap<Integer,Model> rank = unit.getUnitMap().get(lastRank);
        rank.pollLastEntry();
    }
}
