package ca.bcit.cst.comp2526.assign4.solution;


/**
 * Thrown when there are too many rows specified for a world.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public class TooManyRowsException
    extends WorldSizeException
{
    /**
     * Construct a TooManyRowsException with the specified data.
     * 
     * @param maximum the largest allowed value.
     * @param rows    the actual value.
     */
    public TooManyRowsException(final int maximum,
                                final int rows)
    {
       super("many",
             "rows",
             "<=",
             maximum,
             rows);
    }
}