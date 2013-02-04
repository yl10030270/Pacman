package ca.bcit.cst.comp2526.assign6.solution.entityfinder;


/**
 * Thrown when there were more entities found than were allowed.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public class FoundTooManyEntitiesException
    extends FoundWrongNumberOfEntitiesException
{
    /**
     * Constant serialized ID used for compatibility.
     */
    private static final long serialVersionUID = 0;

    /**
     * Construct a FoundTooManyEntitiesException with the specified values.
     * 
     * @param maximum number of entities allowed.
     * @param found the number of entities found.
     */
    public FoundTooManyEntitiesException(final int maximum,
                                         final int found)
    {
        super("many",
              maximum,
              found);
    }
}
