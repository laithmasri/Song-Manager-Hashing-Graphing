import java.io.IOException;
import student.TestCase;

/**
 * This is the testing class for the Parser.
 * 
 * @author laith21
 * @version Nov 10th
 */
public class ParserTest extends TestCase {

    /**
     * This sets up the testing cases.
     */
    public void setUp() {
        //
    }


    /**
     * This method tests if the file reader is working fine.
     * 
     * @throws IOException
     */
    public void testParser() throws IOException {
        Parser parser = new Parser(10, "P4sampleInput.txt");
        String ans = systemOut().getHistory();
        String output = Parser.readFile("P4sampleOutput.txt");
        assertEquals(ans, output);
    }
}
