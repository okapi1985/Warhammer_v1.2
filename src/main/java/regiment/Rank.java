package regiment;

import armies.generalModel.Model;

import java.util.Map;

class Rank {

    private Map<Integer, Model> rank;

    public Rank(Map<Integer, Model> rank) {
        this.rank = rank;
    }

    public Map<Integer, Model> getRank() {
        return rank;
    }

    public void setRank(Map<Integer, Model> rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
//        final StringBuilder sb = new StringBuilder("Rank{");
//        sb.append("rank=").append(rank);
//        sb.append('}');
        return " ";
    }
}
