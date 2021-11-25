package org.PokerHandSorter;

import org.PokerHandSorter.CardTypes.Card;
import org.PokerHandSorter.Enums.CardSuit;
import org.PokerHandSorter.Enums.CardValue;
import org.junit.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CardClassTest {

    @Test
    public void testGetCardValue() {
        Card testCard = new Card("AH");
        assertTrue(testCard.getValue() == CardValue.ACE);
    }

    @Test
    public void testGetCardSuit() {
        Card testCard = new Card("AS");
        assertTrue(testCard.getSuit() == CardSuit.SPADES);
    }

    @Test
    public void testCardToString() {
        Card testCard = new Card("AH");
        assertEquals("A_H", testCard.toString());
    }
}
