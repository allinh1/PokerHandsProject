package org.PokerHandSorter;

import org.PokerHandSorter.CardTypes.Card;
import org.PokerHandSorter.CardTypes.Hand;
import org.PokerHandSorter.Enums.CardSuit;
import org.PokerHandSorter.Enums.CardValue;
import org.PokerHandSorter.GameController.Round;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoundTest {

    String testCardList = "AH AS AD TD 8S 4H JS 3C TC 8D";

    @Test
    public void testInputHand() {
        List<Card> test = Stream.of(testCardList.split(" "))
                .map(Card::new)
                .collect(Collectors.toList());

        System.out.println(test);
        assertTrue(test.size() == 10);
    }


    @Test
    public void testCount() {
        int playerOneCount = 0;
        int playerTwoCount = 0;

        List<Card> test = Stream.of(testCardList.split(" "))
                .map(Card::new)
                .collect(Collectors.toList());

        // hand1
        List<Card> playerOne = test.subList(0, 5);
        System.out.println(playerOne);
        // hand2
        List<Card> playerTwo = test.subList(5, 10);

        Round r = new Round(playerOne, playerTwo);
        r.playerOneWins();
    }
}
