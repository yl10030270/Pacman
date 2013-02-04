/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign4.solution.entityfinder;


import ca.bcit.cst.comp2526.assign4.solution.InvalidWorldException;


/**
 * Thrown when the wrong number of entities were found.
 *
 * @author leon
 * @version 1.0
 */
public class FoundWrongNumberOfEntitiesException
    extends InvalidWorldException
{
    /**
     * the expected number of entities.
     */
    private final int epc;

    /**
     * the actual number of entities.
     */
    private final int act;

    /**
     * Construct a FoundWrongNumberOfEntitiesException with the specified values.
     *
     * @param adjective - "few" or "many".
     * @param expected  - the expected number of entities.
     * @param actual    - the actual number of entities.
     */
    protected FoundWrongNumberOfEntitiesException(final String adjective,
                                                  final int expected,
                                                  final int actual)
    {
        super("Too " + adjective + " entities must be " + expected + ", was: " + actual);
        epc = expected;
        act = actual;
    }

    /**
     * The expected number of entities.
     *
     * @return the expected number of entities.
     */
    public int getExpectedNumberOfEntities()
    {
        return epc;
    }

    /**
     * The actual number of entities found.
     *
     * @return the actual number of entities.
     */
    public int getActualNumberOfEntities()
    {
        return act;
    }

}
