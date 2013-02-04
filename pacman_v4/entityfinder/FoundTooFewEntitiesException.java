/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign4.solution.entityfinder;


/**
 * Thrown when there were fewer entities found than were required.
 *
 * @author leon
 * @version 1.0
 */
public class FoundTooFewEntitiesException
    extends FoundWrongNumberOfEntitiesException
{
    /**
     * Construct a FoundTooFewEntitiesException with the specified values.
     *
     * @param minimum - number of entities allowed.
     * @param found   - the number of entities found.
     */
    public FoundTooFewEntitiesException(final int minimum,
                                        final int found)
    {
        super("few", minimum, found);
    }

}
