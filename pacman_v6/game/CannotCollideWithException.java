package ca.bcit.cst.comp2526.assign6.solution.game;

import ca.bcit.cst.comp2526.assign6.solution.Entity;


/**
 * Thrown when an entity collides with an entity that is should not have.
 *  
 * @author D'Arcy Smith
 * @version 1.0
 */
public class CannotCollideWithException
    extends CollisionException
{
    /**
     * Constant serialized ID used for compatibility.
     */
    private static final long serialVersionUID = 0;
    
    /**
     * Construct a CannotCollideWithException with the specified values.
     * 
     * @param a the entity that was moving.
     * @param v the the entity that was already on the tile.
     */
    protected CannotCollideWithException(final MovableEntity<? extends Game, ? extends MovableEntity> a,
                                         final Entity                                                 v)
    {
        super(a + " cannot collide with " + v, 
              a, 
              v);
    }
}
