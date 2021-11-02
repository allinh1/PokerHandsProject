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

//    public int getValue() {
//        return value;
//    }

    public static CardValue getValue(char value) {
        return valueMap.get(value);
    }

//    public static CardValue getValueSwitch(char value) {
//        switch (value){
//            case 'A' : return ACE;
//            case 'K' : return KING;
//            case 'Q' : return QUEEN;
//            case 'J' : return JACK;
//            case 'T' : return TEN;
//            case '9' : return NINE;
//            case '8' : return EIGHT;
//            case '7' : return SEVEN;
//            case '6' : return SIX;
//            case '5' : return FIVE;
//            case '4' : return FOUR;
//            case '3': return THREE;
//            case '2': return TWO;
//        }
//        return null;
//    }
}

