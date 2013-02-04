package ca.bcit.cst.comp2526.assign6.solution;


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
     * Constant serialized ID used for compatibility.
     */
    private static final long serialVersionUID = 0;

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