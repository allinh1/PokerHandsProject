package org.PokerHandSorter;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.PokerHandSorter.Main.App;
import org.junit.Test;

import java.io.IOException;


public class AppTest 
{

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void mainAppLoadsTest() throws IOException {
        App.main(new String[] {});

    }




}
