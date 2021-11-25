package org.PokerHandSorter;

import org.PokerHandSorter.CardTypes.Card;
import org.PokerHandSorter.CardTypes.Hand;
import org.PokerHandSorter.Enums.CardSuit;
import org.PokerHandSorter.Enums.CardValue;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HandClassTest {
    // [AH, AS, AD, TD, 8S, 4H, JS, 3C, TC, 8D]
    //"AH AS AD TD 8S 4H JS 3C TC 8D"


    @Test
    public void testAddingCardsToHand() {
        List<Card> test = new ArrayList<>();


        System.out.println(test);


    }

    @Test
    public void testStraight() {
        List<Card> testHand = new ArrayList<>();
        testHand.add(new Card("4H"));
        testHand.add(new Card("6D"));
        testHand.add(new Card("7S"));
        testHand.add(new Card("8H"));
        testHand.add(new Card("5D"));

        List<Card> testHand2 = new ArrayList<>();

        Hand test = new Hand(testHand);


    }

    @Test
    public void testFlush() {
        List<Card> testHand = new ArrayList<>();
        testHand.add(new Card("4H"));
        testHand.add(new Card("6D"));
        testHand.add(new Card("7S"));
        testHand.add(new Card("8H"));
        testHand.add(new Card("5D"));

    }

    @Test
    public void testPairs() {

    }

    @Test
    public void testTriples() {

    }

    @Test
    public void testQuads() {

    }

    @Test
    public void checkBuilderClass() {

    }
}
