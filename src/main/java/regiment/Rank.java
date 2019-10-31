package regiment;

import armies.generalModel.Model;

import java.util.Map;
import java.util.TreeMap;

public class Rank {

    private TreeMap<Integer, Model> rankMap;

    public Rank(TreeMap<Integer, Model> rankMap) {
        this.rankMap = rankMap;
    }

    public TreeMap<Integer, Model> getRankMap() {
        return rankMap;
    }

    public void setRankMap(TreeMap<Integer, Model> rankMap) {
        this.rankMap = rankMap;
    }

    @Override
    public String toString() {
//        final StringBuilder sb = new StringBuilder("Rank{");
//        sb.append("rank=").append(rank);
//        sb.append('}');
        return " ";
    }
}
