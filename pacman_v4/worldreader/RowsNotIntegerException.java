package ca.bcit.cst.comp2526.assign4.solution.worldreader;


/**
 * Thrown when the rows in the data source are not an integer.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public class RowsNotIntegerException
    extends NotAnIntegerException
{
    /**
     * Construct a RowsNotIntegerException with the specified data.
     * 
      * @param value the value that was not an integer.
    */
    public RowsNotIntegerException(final String value)
    {
        super("rows", 
               value);
    }
}