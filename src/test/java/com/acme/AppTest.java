package com.acme;

import static org.junit.Assert.assertTrue;

import com.acme.chat.server.HistoryController;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Collection;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private static final String TEST_HISTORY = "C:\\Users\\Java_6\\alekale\\java-profiling\\src\\test\\testHistory.txt";
    private static final String UTF8_HISTORY = "C:\\Users\\Java_6\\alekale\\java-profiling\\src\\test\\wrongEncodedHistory.txt";
    /**
     * Rigorous Test :-)
     */
    private HistoryController testHistoryController;
    @Before
    public void beforeTest(){
        testHistoryController = new HistoryController();
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testHistoryIsNotEmpty(){
        Collection<String> history = testHistoryController.getHistory(new File(TEST_HISTORY));
        assertTrue(history.size() > 0);
    }

    @Test
    public void testHistoryWithWrongEncoding(){
        Collection<String> history = testHistoryController.getHistory(new File(UTF8_HISTORY));
        history.stream().forEach(s -> System.out.println(s));
    }
}
