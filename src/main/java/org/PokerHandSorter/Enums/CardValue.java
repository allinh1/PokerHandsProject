package org.PokerHandSorter.Enums;

import java.util.HashMap;
import java.util.Map;

public enum CardValue {

    TWO('2', 2),
    THREE('3', 3),
    FOUR('4', 4),
    FIVE('5', 5),
    SIX('6', 6),
    SEVEN('7', 7),
    EIGHT('8', 8),
    NINE('9', 9),
    TEN('T', 10),
    JACK('J', 11),
    QUEEN('Q', 12),
    KING('K', 13),
    ACE('A', 14),
    ZERO('0', 0);

    private final char name;
    public final int value;
    private static final Map<Character, CardValue> valueMap = new HashMap<>();

    static {
        for (CardValue c : CardValue.values()) {
            valueMap.put(c.getChar(), c);
        }
    }

    CardValue(char cardName, int value) {
        this.name = cardName;
        this.value = value;
    }

    public char getChar() {
        return name;
    }

    public static CardValue getValue(char value) {
        return valueMap.get(value);
    }

}

