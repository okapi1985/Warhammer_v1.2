package regiment;

import java.util.Map;

public class Unit {

    Rank rank;

    private Map<Integer,Rank> unit;
    private boolean musician;
    private boolean standardBearer;

    public Unit(Map<Integer, Rank> unit, boolean musician, boolean standardBearer) {
        this.unit = unit;
        this.musician = musician;
        this.standardBearer = standardBearer;
    }

    public Map<Integer, Rank> getUnit() {
        return unit;
    }

    public void setUnit(Map<Integer, Rank> unit) {
        this.unit = unit;
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
