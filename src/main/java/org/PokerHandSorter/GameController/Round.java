package org.PokerHandSorter.GameController;

import org.PokerHandSorter.CardTypes.Card;
import org.PokerHandSorter.CardTypes.Hand;

import java.util.List;

public class Round {

    public final Hand playerOne;
    public final Hand playerTwo;

    public Round(List<Card> playerOneHand, List<Card> playerTwoHand) {
        this.playerOne = new Hand(playerOneHand);
        this.playerTwo = new Hand(playerTwoHand);
    }

    public boolean playerOneWins() {
        return playerOne.compareTo(playerTwo) > 0;
    }
}
