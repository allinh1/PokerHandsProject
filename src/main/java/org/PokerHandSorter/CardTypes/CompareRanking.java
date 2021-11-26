package org.PokerHandSorter.CardTypes;

import org.PokerHandSorter.Enums.CardValue;
import org.PokerHandSorter.Enums.CombinationRank;

//import java.util.ArrayList;
//import java.util.Collections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompareRanking implements Comparable<CompareRanking> {

    private final CombinationRank rank;
    private final CardValue secondCheck;
    private final CardValue thirdCheck;
    private final List<CardValue> kicker;

    public CompareRanking(CombinationRank rank, CardValue secondCheck, CardValue thirdCheck, List<CardValue> kicker) {
        this.rank = rank;
        this.secondCheck = secondCheck == null ? CardValue.ZERO : secondCheck;
        this.thirdCheck = thirdCheck == null ? CardValue.ZERO : thirdCheck;
        List<CardValue> kickerTemp = new ArrayList<>(kicker);
//        Collections.sort(kickerTemp, Collections.reverseOrder());
        this.kicker = kicker;
    }

    @Override
    public int compareTo(CompareRanking o) {
        int compareTo = rank.compareTo(o.rank);

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
                rank, secondCheck, thirdCheck, kicker);
    }
}

