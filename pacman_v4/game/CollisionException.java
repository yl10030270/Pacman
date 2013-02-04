/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign4.solution.game;


import ca.bcit.cst.comp2526.assign4.solution.Entity;


/**
 * Thrown when there is an issue handling a collision between two entities.
 *
 * @author leon
 * @version 1.0
 */
public abstract class CollisionException
    extends Exception
{
    /**
     * the entity that was moving.
     */
    private final MovableEntity<? extends Game, ? extends MovableEntity> attacker;

    /**
     * the the entity that was already on the tile.
     */
    private final Entity victim;

    /**
     * Construct a CollisionException with the specified message.
     *
     * @param msg - the error message.
     * @param a   - the entity that was moving.
     * @param v   - the the entity that was already on the tile.
     */
    protected CollisionException(final String msg,
                                 final MovableEntity<? extends Game, ? extends MovableEntity> a,
                                 final Entity v)
    {
        super(msg);
        attacker = a;
        victim = v;
    }

    /**
     * Get the attacking entity.
     *
     * @return the attacking entity.
     */
    public MovableEntity<? extends Game, ? extends MovableEntity> getAttacker()
    {
        return attacker;
    }

    /**
     * Get the victim entity.
     *
     * @return the victim entity.
     */
    public Entity getVictim()
    {
        return victim;
    }

}
