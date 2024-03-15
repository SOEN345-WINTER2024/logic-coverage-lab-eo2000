import org.junit.Test;
import static org.junit.Assert.*;

public class CheckItTest {
    //Predicate Coverage : testCheckItTrue and testCheckItFalse 
    //Clause Coverage: each condiction tested with true and false 
    // CACC :  achieved by ensuring that all control flow paths are executed and data flow between different parts of the method is correctly tested.
    //: RACC : achieved by designing test cases that cover both the requirements of the code (true and false conditions) and introducing mutations (changing inputs) to ensure that the tests detect changes in behavior.
   
  @Test
    public void testCheckItTrue() {
        // Test when a is true
        assertTrue(runCheckIt(true, false, false));
        assertTrue(runCheckIt(true, true, false));
        assertTrue(runCheckIt(true, true, true));
    }

    @Test
    public void testCheckItFalse() {
        // Test when a is false and b, c are false
        assertFalse(runCheckIt(false, false, false));
        // Test when a is false, b is true, and c is false
        assertFalse(runCheckIt(false, true, false));
        // Test when a is false, b is false, and c is true
        assertFalse(runCheckIt(false, false, true));
        // Test when a is false, b is true, and c is true
        assertFalse(runCheckIt(false, true, true));
    }

    private boolean runCheckIt(boolean a, boolean b, boolean c) {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        CheckIt.checkIt(a, b, c);

        String output = outContent.toString().trim();

        System.setOut(System.out);

        return output.equals("P is true");
    }
}
