package org.PokerHandSorter;

import org.PokerHandSorter.CardTypes.CompareRanking;
import org.PokerHandSorter.Enums.CardValue;
import org.PokerHandSorter.Enums.CombinationRank;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompareRankingTest {

/*
 * compareTo method should return 0 when first hand has same ranking as second hand ranking.
 */

    @Test
    public void testEqualComparison()   {

        List<CardValue> kicker = new ArrayList<>();
        kicker.add(CardValue.KING);

        CompareRanking testHand = new CompareRanking(CombinationRank.PAIR, CardValue.ACE,CardValue.FIVE, kicker);
        CompareRanking testHand2 = new CompareRanking(CombinationRank.PAIR, CardValue.ACE,CardValue.FIVE, kicker);

        assertEquals(0, testHand.compareTo(testHand2), "Should be the same");

    }

/*
 *
 * compareTo method should return positive integer when first hand has higher ranking than second hand
 *
 * */

    @Test
    public void testStraightVsPairRankings() {
        List<CardValue> kicker1 = new ArrayList<>();
        List<CardValue> kicker2 = new ArrayList<>();


        CompareRanking testHand = new CompareRanking(CombinationRank.STRAIGHT, CardValue.ZERO,CardValue.ZERO, kicker1);
        CompareRanking testHand2 = new CompareRanking(CombinationRank.PAIR, CardValue.ZERO,CardValue.ZERO, kicker2);

        assertEquals(3, testHand.compareTo(testHand2), "Hand 1 should be win");
    }

    @Test
    public void testSameHandDifferentKicker() {
        List<CardValue> kicker1 = new ArrayList<>();
        kicker1.add(CardValue.ACE);
        List<CardValue> kicker2 = new ArrayList<>();
        kicker2.add(CardValue.TEN);

        CompareRanking testHand = new CompareRanking(CombinationRank.PAIR, CardValue.ZERO,CardValue.ZERO, kicker1);
        CompareRanking testHand2 = new CompareRanking(CombinationRank.PAIR, CardValue.ZERO,CardValue.ZERO, kicker2);

        assertEquals(4, testHand.compareTo(testHand2), "Hand 1 should be win with higher kicker");
    }

/*
 *
 * compareTo method should return negative integer when first hand has lower ranking than second
 *
 * */

    @Test
    public void testPlayerTwoWinner() {
        List<CardValue> kicker1 = new ArrayList<>();
        List<CardValue> kicker2 = new ArrayList<>();

        CompareRanking testHand = new CompareRanking(CombinationRank.STRAIGHT, CardValue.ZERO,CardValue.ZERO, kicker1);
        CompareRanking testHand2 = new CompareRanking(CombinationRank.FLUSH, CardValue.ZERO,CardValue.ZERO, kicker2);

        assertEquals(-1, testHand.compareTo(testHand2), "Hand 2 should be win");
    }
}
