package ca.bcit.cst.comp2526.assign4.solution;


/**
 * Thrown when there are too many columns specified for a world.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public class TooManyColumnsException
    extends WorldSizeException
{
    /**
     * Construct a TooManyColumnsException with the specified data.
     * 
     * @param maximum the largest allowed value.
     * @param cols    the actual value.
     */
    public TooManyColumnsException(final int maximum,
                                   final int cols)
    {
        super("many",
              "columns",
              "<=",
              maximum,
              cols);
    }
}