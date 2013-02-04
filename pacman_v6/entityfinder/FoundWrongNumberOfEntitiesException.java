package ca.bcit.cst.comp2526.assign6.solution.entityfinder;


import ca.bcit.cst.comp2526.assign6.solution.InvalidWorldException;


/**
 * Thrown when the wrong number of entities were found.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public abstract class FoundWrongNumberOfEntitiesException
    extends InvalidWorldException
{
    /**
     * The expected min or max number of entities.
     */
    private final int expectedNumberOfEntities;
    
    /**
     * The actual number of entities found.
     */
    private final int actualNumberOfEntities;
    
    /**
     * Construct a FoundWrongNumberOfEntitiesException with the specified values.
     * 
     * @param adjective "few" or "many".
     * @param expected  the expected number of values.
     * @param actual    the actual number of values.
     */
    protected FoundWrongNumberOfEntitiesException(final String adjective,
                                                  final int    expected,
                                                  final int    actual)
    {
        super("Too " + adjective + " entities must be " + expected + ", was: " + actual);

        expectedNumberOfEntities = expected;
        actualNumberOfEntities   = actual;
    }

    /**
     * The expected number of entities.
     * 
     * @return the expected number of entities.
     */
    public int getExpectedNumberOfEntities()
    {
        return (expectedNumberOfEntities);
    }

    /**
     * The actual number of entities found.
     * 
     * @return the actual number of entities.
     */
    public int getActualNumberOfEntities()
    {
        return (actualNumberOfEntities);
    }
}
