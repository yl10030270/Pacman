package ca.bcit.cst.comp2526.assign6.solution;


import java.util.Scanner;


/**
 * A set of utility methods for working with numbers.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public final class NumberUtils
{
    /**
     * Prevent accidental construction.
     */
    private NumberUtils()
    {        
    }
    
    /**
     * Check that a number is an integer.
     * 
     * @param value the value to check.
     * @return true if value is an int, false if it is not.
     */
    public static boolean isInt(final String value)
    {
        final Scanner scanner;
        
        if(value == null)
        {
            throw new IllegalArgumentException("value cannot be null");
        }
        
        scanner = new Scanner(value);

        try
        {
            final boolean retVal;
            
            if(scanner.hasNextInt())
            {
                scanner.nextInt();
                
                if(scanner.hasNext())
                {
                    retVal = false;
                }
                else
                {
                    retVal = true;
                }
            }
            else
            {
                retVal = false;
            }
            
            return (retVal);
        }
        finally
        {
            scanner.close();
        }
    }
}