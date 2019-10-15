/*
    Write a command-line program to sort the contents of this file in 
    1. ascending order by the length of the name, 
    2. then alphabetically
*/
package williamabernathycsc499homework1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class WilliamAbernathyCSC499Homework1 
{

    public static void main(String[] args) throws Exception
    {
        Scanner input = new Scanner(System.in);
        String userInput;
        String fileContents[];           // array of file contents
        int fileSize = 0;                // how many entries in file
        BufferedReader br;               // file reader for Sort Me.txt
        String line;
        String file = "Sort Me.txt";
        
        // check if user wants to print current file contents
        System.out.println("Would you like to view the original file contents? [yes/no]");
        userInput = input.next();
        userInput.toLowerCase();
        
        // check that input is correct
        while (userInput.equals("yes") && userInput.equals("y") && userInput.equals("no") && userInput.equals("n") ) 
        {
            System.out.println("Please type yes/no [y/n].");
            userInput = input.next();
            userInput.toLowerCase();
        }
        
        // if the user entered yes, print the file contents
        if (userInput.equals("y") || userInput.equals("yes"))
        {
            // print the contents of the original file. .read() will return
            // -1 if no char or string is found, signaling the end of the file
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) 
            {
                try 
                {
                    System.out.println(line.trim());
                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
            }
            br.close();
        }
        
        /* build array of file contents */
        
        // first get the number of contents
        br = new BufferedReader(new FileReader(file));
        while ((line = br.readLine()) != null) 
        {
            try
            {
                // if there's an empty line, skip it
                if (line.trim().isEmpty() || line == null) 
                {
                    continue;
                } 
                else 
                {
                    fileSize++;
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        br.close();
        
        // then init and fill the array
        int pos = 0;
        fileContents = new String[fileSize];
        br = new BufferedReader(new FileReader(file));
        while ((line = br.readLine()) != null) 
        {
            try
            {
                // skip over empty lines
                if (line.trim().isEmpty() || line == null) 
                {
                    continue;
                } 
                else 
                {
                    fileContents[pos] = line.trim();
                    pos++;
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        br.close();
        
        /* sort the array */
        
        // default .sort() sorts strings alphabetically
        Arrays.sort(fileContents);
        Arrays.sort(fileContents, Comparator.comparingInt(String::length));
        
        /* writing to a new file */
        
        // use a bufferedwriter to writer the contents of fileContents
        // to a new file called Sorted Names.txt
        BufferedWriter wr = new BufferedWriter(new FileWriter("Sorted Names.txt"));
        for(int i = 0; i < fileContents.length; i++) 
        {
            try
            {
                // write contents to our created file
                wr.write(fileContents[i]);
                // if it's the last line, don't add a new line
                if(i < fileContents.length - 1)
                {
                    wr.newLine();
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        
        System.out.println("The sorted contents of Sort Me.txt have been placed"
                + " in a newly created file, Sorted Names.txt in the current "
                + ".jar directory.");
        System.out.println("Exiting..");
        wr.close();
    }
    
}