package org.PokerHandSorter.Enums;

public enum CombinationRank {

    HIGH_CARD(1),
    PAIR(2),
    TWO_PAIRS(3),
    THREE_OF_A_KIND(4),
    STRAIGHT(5),
    FLUSH(6),
    FULL_HOUSE(7),
    FOUR_OF_A_KIND(8),
    STRAIGHT_FLUSH(9),
    ROYAL_FLUSH(10);

    private final int rank;

    CombinationRank(int rank) {
        this.rank = rank;
    }

//    // public method to return int to compare rank of one combination to another
//    public int printRank() {
//        return rank;
//    }
}
