package org.PokerHandSorter.Main;


import org.PokerHandSorter.GameController.GameController;

import java.io.IOException;


public class App {


    public static void main(String[] args) throws IOException {

        GameController test = new GameController();
//        test.playOneGame();
        test.playAllGames();

    }
}
