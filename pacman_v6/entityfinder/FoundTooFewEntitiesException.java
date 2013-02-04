package ca.bcit.cst.comp2526.assign6.solution.entityfinder;


/**
 * Thrown when there were fewer entities found than were required.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public class FoundTooFewEntitiesException
    extends FoundWrongNumberOfEntitiesException
{
    /**
     * Constant serialized ID used for compatibility.
     */
    private static final long serialVersionUID = 0;

    /**
     * Construct a FoundTooFewEntitiesException with the specified values.
     * 
     * @param minimum number of entities allowed.
     * @param found the number of entities found.
     */
    public FoundTooFewEntitiesException(final int minimum,
                                        final int found)
    {
        super("few",
              minimum,
              found);
    }
}
