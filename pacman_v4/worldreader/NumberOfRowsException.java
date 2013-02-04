package ca.bcit.cst.comp2526.assign4.solution.worldreader;


/**
 * Thrown when there are not the proper number of rows in world data.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public abstract class NumberOfRowsException
    extends WorldDataException
{
    /**
     * The required number of rows.
     */
    private final int requiredValue;

    /**
     * The actual number of rows.
     */
    private final int actualValue;
    
    /**
     * Construct an ExtraRowsException with the specified data.
     * 
     * @param adjective "many" or "few".
     * @param required  the number of rows required.
     * @param actual    the actual number of rows provided.
     */
    protected NumberOfRowsException(final String adjective,
                                    final int    required,
                                    final int    actual)
    {
        super("Too " + adjective + " rows must be: " + required + ", was: " + actual);
        
        requiredValue = required;
        actualValue   = actual;
    }

    /**
     * The required number of rows.
     * 
     * @return required number of rows.
     * 
     */
    public int getRequiredValue()
    {
        return (requiredValue);
    }

    /**
     * The actual number of rows.
     * 
     * @return actual number of rows.
     */
    public int getActualValue()
    {
        return (actualValue);
    }
}