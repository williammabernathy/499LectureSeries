import java.io.File;
import java.io.IOException;
import junit.framework.Assert;
import williamabernathycsc499homework1.CompareOutput;

public class CompareTestAscending 
{
    
    CompareOutput doesMatchAscending;
    
    public CompareTestAscending() 
    {
        
    }
    
    //@BeforeClass
    public static void setUpClass() 
    {
        
    }
    
    //@AfterClass
    public static void tearDownClass() 
    {
        
    }
    
    //@Before
    public void setUp() 
    {
        // declare the two files to be compared
        File sorted = new File("Sorted Names Ascending.txt");
        File toCompare = new File("SortedTestAscending.txt");
        
        // build our test object to pass the two files
        doesMatchAscending = new CompareOutput(sorted, toCompare);
    }
    
    //@Test
    public void testCompare() throws IOException
    {
        // if files match, returns true
        Assert.assertEquals(true, doesMatchAscending.compareFiles());
    }
    
    //@After
    public void tearDown() 
    {
        
    }
}
