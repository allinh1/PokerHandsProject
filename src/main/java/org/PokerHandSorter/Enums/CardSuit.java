package org.PokerHandSorter.Enums;

import java.util.HashMap;
import java.util.Map;

public enum CardSuit {
    HEARTS('H'),
    SPADES('S'),
    DIAMONDS('D'),
    CLUBS('C');

    public static CardSuit NULL;
    private final char suitChar;
    private static final Map<Character, CardSuit> valueMap = new HashMap<>();

    static {
        for (CardSuit c : CardSuit.values()) {
            valueMap.put(c.getChar(), c);
        }
    }

    CardSuit(char cardString) {
        this.suitChar = cardString;
    }

    public char getChar() {
        return suitChar;
    }

    public static CardSuit getSuit(char value) {
        return valueMap.get(value);
    }
}
