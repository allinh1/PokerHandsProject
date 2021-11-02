package org.PokerHandSorter.CardTypes;

import org.PokerHandSorter.Enums.CardSuit;
import org.PokerHandSorter.Enums.CardValue;

public class Card implements Comparable<Card> {
    private final CardValue value;
    private final CardSuit suit;

    public Card(CardValue value, CardSuit suit) {
        this.value = value;
        this.suit = suit;
    }

    public Card(String s) {
        this(CardValue.getValue(s.charAt(0)), CardSuit.getSuit(s.charAt(1)));
    }

    public CardValue getValue() {
        return value;
    }

    public CardSuit getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Card o) {
        return value.compareTo(o.value);
    }

    @Override
    public String toString() {
        return String.format("%s_%s", value.getChar(), suit.getChar());
    }
}