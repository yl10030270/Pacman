package ca.bcit.cst.comp2526.assign4.solution;


/**
 * Thrown when there are too few columns specified for a world.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public class TooFewColumnsException
    extends WorldSizeException
{
    /**
     * Construct a TooFewColumnsException with the specified data.
     * 
     * @param minimum the smallest allowed value.
     * @param cols    the actual value.
     */
    public TooFewColumnsException(final int minimum,
                                  final int cols)
    {
        super("few",
               "columns",
               ">=",
               minimum,
               cols);
    }
}