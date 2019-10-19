
import java.io.File;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import williamabernathycsc499homework1.CompareOutput;

public class CompareTest {
    
    CompareOutput doesMatch;
    
    public CompareTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() 
    {
        // declare the two files to be compared
        File sorted = new File("Sorted Names.txt");
        File toCompare = new File("SortedTest.txt");
        
        // build our test object to pass the two files
        doesMatch = new CompareOutput(sorted, toCompare);
    }
    
    @Test
    public void testCompare() throws IOException
    {
        // if files match, returns true
        Assert.assertEquals(true, doesMatch.compareFiles());
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
