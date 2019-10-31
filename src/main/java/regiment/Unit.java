package regiment;

import java.util.Map;
import java.util.TreeMap;

public class Unit {

    Rank rank;

    private TreeMap<Integer,Rank> unitMap;
    private boolean musician;
    private boolean standardBearer;

    public Unit(TreeMap<Integer, Rank> unitMap, boolean musician, boolean standardBearer) {
        this.unitMap = unitMap;
        this.musician = musician;
        this.standardBearer = standardBearer;
    }

    public Unit(TreeMap<Integer, Rank> unitMap) {
        this.unitMap = unitMap;
    }

    public TreeMap<Integer, Rank> getUnitMap() {
        return unitMap;
    }

    public void setUnitMap(TreeMap<Integer, Rank> unitMap) {
        this.unitMap = unitMap;
    }

    public boolean isMusician() {
        return musician;
    }

    public void setMusician(boolean musician) {
        this.musician = musician;
    }

    public boolean isStandardBearer() {
        return standardBearer;
    }

    public void setStandardBearer(boolean standardBearer) {
        this.standardBearer = standardBearer;
    }

    @Override
    public String toString() {
//            for (int i = 0; i < unit.size(); i++){
//                for (int j = 0; j <rank.getRank().size(); j++){
//                    System.out.print("O ");
//                }
//                System.out.println();
//            }
//
        return "";
    }
}
