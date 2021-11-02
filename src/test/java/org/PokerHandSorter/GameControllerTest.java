package org.PokerHandSorter;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameControllerTest {

    @Test
    public void findDataFile() {
        Path path = Paths.get("src/test/data/poker-hands.txt");
        assertTrue(Files.exists(path));
        assertTrue(Files.isReadable(path));
    }

    @Test
    public void directoryExists() {

    }

    @Test
    public void readDataFile() {
        Path path = Paths.get("src/test/data/poker-hands.txt");
//        System.out.println(path);
//        BufferedReader testReader = new BufferedReader();
    }
}
