package ca.bcit.cst.comp2526.assign6.solution;


/**
 * Thrown when there is an error with the size of the world.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public abstract class WorldSizeException
    extends InvalidWorldException
{
    /**
     * The expected number of rows or columns.
     */
    private final int expectedValue;
    
    /**
     * The actual number of rows or columns.
     */
    private final int actualValue;
    
    /**
     * Construct a WorldSizeException with the specified message.
     * 
     * @param adjective "few" or "many".
     * @param type      "rows" or "columns".
     * @param sign      ">=" or "<=".
     * @param expected  the expected value.
     * @param actual    the actual value.
     */
    protected WorldSizeException(final String adjective,
                                 final String type,
                                 final String sign,
                                 final int    expected,
                                 final int    actual)
    {
        super("Too " + adjective + " " + type + " must be " + sign + " " + expected + ", was: " + actual);

        expectedValue = expected;
        actualValue   = actual;
    }

    /**
     * Get the expected number of rows or columns.
     * 
     * @return the expected number of rows or columns.
     */
    public int getExpectedValue()
    {
        return (expectedValue);
    }

    /**
     * Get the actual number of rows or columns.
     * 
     * @return the actual number of rows or columns.
     */
    public int getActualValue()
    {
        return (actualValue);
    }
}
