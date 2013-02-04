package ca.bcit.cst.comp2526.assign6.solution;


/**
 * Thrown when there are too few rows specified for a world.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public class TooFewRowsException
    extends WorldSizeException
{
    /**
     * Constant serialized ID used for compatibility.
     */
    private static final long serialVersionUID = 0;

    /**
     * Construct a TooFewRowsException with the specified data.
     * 
     * @param minimum the smallest allowed value.
     * @param rows    the actual value.
     */
    public TooFewRowsException(final int minimum,
                               final int rows)
    {
        super("few",
              "rows",
              ">=",
              minimum,
              rows);
    }
}
