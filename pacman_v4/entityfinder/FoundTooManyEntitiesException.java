/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign4.solution.entityfinder;


/**
 * Thrown when there were more entities found than were allowed.
 *
 * @author leon
 * @version 1.0
 */
public class FoundTooManyEntitiesException
    extends FoundWrongNumberOfEntitiesException
{
    /**
     * Construct a FoundTooManyEntitiesException with the specified values.
     *
     * @param maximum - number of entities allowed.
     * @param found   - the number of entities found.
     */
    public FoundTooManyEntitiesException(final int maximum,
                                         final int found)
    {
        super("many", maximum, found);
    }

}
