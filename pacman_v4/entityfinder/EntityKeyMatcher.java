/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign4.solution.entityfinder;


import ca.bcit.cst.comp2526.assign4.solution.Entity;


/**
 * A filter to match entities by the key.
 *
 * @author leon
 * @version 1.0
 */
public final class EntityKeyMatcher
    implements EntityMatcher
{
    /**
     * the key to match on.
     */
    private final char key;

    /**
     * Construct an EntityKeyMatcher with the specified key.
     *
     * @param k - the key to match on.
     */
    public EntityKeyMatcher(final char k)
    {
        key = k;
    }

    /**
     * Tests whether or not the specified entity should be included in a entity list.
     *
     * @param entity - the entity to check.
     *
     * @return true if the entity is accepted, false if it is not.
     */
    @Override
    public boolean matches(final Entity entity)
    {
        return (entity == null) ?
               false :
               entity.getKey() == key;
    }

}
