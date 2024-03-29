package williamabernathycsc499homework1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CompareOutput 
{
    // our two files to compare
    File sorted;
    File compare;
    
    // constructor
    public CompareOutput(File sorted, File compare)
    {
        this.sorted = sorted;
        this.compare = compare;
    }
    
    public boolean compareFiles() throws IOException
    {
        // convert both files to a byte array for easy comparison
        // NOTE: this is poor practice for large files
        byte[] appSorted = Files.readAllBytes(sorted.toPath());
        byte[] testFile = Files.readAllBytes(compare.toPath());
        
        // if the arrays match, return true
        if (Arrays.equals(appSorted, testFile))
            return true;
        else
            return false;
    }
    
}
