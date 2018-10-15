package com.acme;



import com.acme.chat.server.HistoryController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private static final String FILE = "the_file.txt";
    private static final String NOT_EXISTED_FILE = "not_existed_file.txt";

    private static final String FIRST_LINE = "The first line";
    private static final String SECOND_LINE = "The second line";

    private static final String UTF_8 = "UTF-8";
    private static final String CP_866 = "cp8667";

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    /**
     * Rigorous Test :-)
     */
    private HistoryController testHistoryController;
    private File testFile;

    @Before
    public void beforeTest(){
        testHistoryController = new HistoryController();
        testFile = new File(FILE);
        createTestFile(UTF_8);
        System.setOut(new PrintStream(out));

    }

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testHistoryContainsMessage(){
        assertTrue(testHistoryController.getHistory(testFile, UTF_8).contains(FIRST_LINE));

    }

    @Test
    public void testHistoryWithWrongEncoding(){
        testHistoryController.getHistory(testFile, "");
        assertEquals("Incorrect enconding\n", out.toString());
    }

    @Test
    public void testFileNotFound(){
        testHistoryController.getHistory(new File(NOT_EXISTED_FILE), CP_866);
        assertEquals("Unable to get history!\n", out.toString());
    }

    @Test(expected = NullPointerException.class)
    public void testHistoryWithNullEncoding(){
        testHistoryController.getHistory(testFile, null);
    }


    @After
    public void clean(){
        new File(FILE).delete();
    }

    private static void createTestFile(String encoding){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(FILE, encoding);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        writer.println(FIRST_LINE);
        writer.println(SECOND_LINE);
        writer.close();
    }

}
