/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign4.solution.game;


import ca.bcit.cst.comp2526.assign4.solution.Entity;


/**
 * Thrown when an entity collides with an entity that is should not have.
 *
 * @author leon
 * @version 1.0
 */
public class CannotCollideWithException
    extends CollisionException
{
    /**
     * Construct a CannotCollideWithException with the specified values.
     *
     * @param a - the entity that was moving.
     * @param v - the the entity that was already on the tile.
     */
    public CannotCollideWithException(
        final MovableEntity<? extends Game, ? extends MovableEntity> a,
        final Entity v)
    {
        super(a.toString() + " cannot collide with " + v, a, v);
    }

}
