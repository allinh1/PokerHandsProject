package org.PokerHandSorter.GameController;

import org.PokerHandSorter.CardTypes.Card;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameController {
    private static int playerOneCount = 0;
    private static int playerTwoCount = 0;

    public void playOneGame() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert PokerLine:");
        System.out.println("Example: AH 9S 4D TD 8S 4H JS 3C TC 8D");

        String pokerLineString = scanner.nextLine();

        System.out.println(pokerLineString);

        List<Card> cardList = Stream.of(pokerLineString.split(" "))
                .map(Card::new)
                .collect(Collectors.toList());

        List<Card> playerOne = cardList.subList(0, 5);
        List<Card> playerTwo = cardList.subList(5, 10);

        Round r = new Round(playerOne, playerTwo);
        if (r.playerOneWins()) {
            System.out.println("Player 1 wins");
            playerOneCount++;
        } else {
            System.out.println("Player 2 wins");
        }
        results();
    }

    public void playManyGames() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("src/test/data/poker-hands.txt"));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to play: ");
        System.out.println("1: One Game (enter 1)");
        System.out.println("2: Many Games from test file (enter 2)");

        String userInput = scanner.nextLine();

        String pokerLines = null;

        while ((pokerLines = reader.readLine()) != null) {
            List<Card> cardList = Stream.of(pokerLines.split(" "))
                    .map(Card::new)
                    .collect(Collectors.toList());

            List<Card> playerOneCards = cardList.subList(0, 5);
            List<Card> playerTwoCards = cardList.subList(5, 10);

            Round r = new Round(playerOneCards, playerTwoCards);
            if (r.playerOneWins()) playerOneCount++;
            else {
                playerTwoCount++;
            }
        }
        results();

    }

    public static void results() {
        System.out.println("Player 1 wins: " + playerOneCount + " hands");
        System.out.println("Player 2 wins: " + playerTwoCount + " hands");
    }
}