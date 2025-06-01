package main;

import java.util.List;

public class HandRank {
    private int value;
    private List<Integer> buildTieBreakingList;


    public HandRank(int value, List<Integer> buildTieBreakingList) {
        this.value = value;
        this.buildTieBreakingList = buildTieBreakingList;
    }

    public int getValue() {
        return this.value;
    }

    public List<Integer> getTieBreakingList() {
        return this.buildTieBreakingList;
    }
}
