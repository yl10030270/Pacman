package ca.bcit.cst.comp2526.assign4.solution.worldreader;


/**
 * Thrown when the columns in the data source are not an integer.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public class ColumnsNotIntegerException
    extends NotAnIntegerException
{
    /**
     * Construct a ColumnsNotIntegerException with the specified message.
     * 
     * @param value the value that was not an integer.
     */
    public ColumnsNotIntegerException(final String value)
    {
        super("columns", 
               value);
    }
}