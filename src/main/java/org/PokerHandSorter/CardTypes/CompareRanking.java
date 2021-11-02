package org.PokerHandSorter.CardTypes;

import org.PokerHandSorter.Enums.CardValue;
import org.PokerHandSorter.Enums.CombinationRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompareRanking implements Comparable<CompareRanking> {

    private final CombinationRank rankCheck;
    private final CardValue secondCheck;
    private final CardValue thirdCheck;
    private final List<CardValue> kicker;

    public CompareRanking(CombinationRank rankCheck, CardValue secondCheck, CardValue thirdCheck, List<CardValue> kicker) {
        this.rankCheck = rankCheck;
        this.secondCheck = secondCheck == null ? CardValue.ZERO : secondCheck;
        this.thirdCheck = thirdCheck == null ? CardValue.ZERO : thirdCheck;
        List<CardValue> kickerTemp = new ArrayList<>(kicker);
        Collections.sort(kickerTemp, Collections.reverseOrder());
        this.kicker = kicker;
    }

//    public CombinationRank getRank() {
//        return rank;
//    }
//
//    public CardValue getFirstCheck() {
//        return firstCheck;
//    }
//
//    public CardValue getSecondCheck() {
//        return secondCheck;
//    }
//
//    public List<CardValue> getKicker() {
//        return kicker;
//    }

    @Override
    public int compareTo(CompareRanking o) {
        int compareTo = rankCheck.compareTo(o.rankCheck);
        if (compareTo != 0) return compareTo;

        compareTo = secondCheck.compareTo(o.secondCheck);
        if (compareTo != 0) return compareTo;

        compareTo = thirdCheck.compareTo(o.thirdCheck);
        if (compareTo != 0) return compareTo;

        for (int i = 0; i < kicker.size(); i++) {
            compareTo = kicker.get(i).compareTo(o.kicker.get(i));
            if (compareTo != 0) return compareTo;
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.format(
                "[%s,%s,%s,%s]",
                rankCheck, secondCheck, thirdCheck, kicker);
    }
}

