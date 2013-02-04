/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign4.solution.entityfinder;


import ca.bcit.cst.comp2526.assign4.solution.Entity;


/**
 * A filter for entities.
 *
 * @author leon
 * @version 1.0
 */
public interface EntityMatcher
{
    /**
     * Tests whether or not the specified entity should be included in a entity list.
     *
     * @param entity - the entity to check.
     *
     * @return true if the entity is accepted, false if it is not.
     */
    boolean matches(Entity entity);

}
