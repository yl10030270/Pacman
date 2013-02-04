package ca.bcit.cst.comp2526.assign6.solution.game;

import ca.bcit.cst.comp2526.assign6.solution.Entity;


/**
 * Thrown when there is an issue handling a collision between two entities.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public abstract class CollisionException
    extends Exception
{
    /**
     * Constant serialized ID used for compatibility.
     */
    private static final long serialVersionUID = 0;
    
    /**
     * The attacking entity.
     */
    private final MovableEntity<? extends Game, ? extends MovableEntity> attacker;
    
    /**
     * The victim entity.
     */
    private final Entity victem;
    
    /**
     * Construct a CollisionException with the specified message.
     * 
     * @param msg the error message.
     * @param a   the entity that was moving.
     * @param v   the the entity that was already on the tile.
     */
    protected CollisionException(final String                                                 msg,
                                 final MovableEntity<? extends Game, ? extends MovableEntity> a,
                                 final Entity                                                 v)
    {
        super(msg);
        
        attacker = a;
        victem   = v;
    }
    
    /**
     * Get the attacking entity.
     * 
     * @return the attacking entity.
     */
    public MovableEntity<? extends Game, ? extends MovableEntity> getAttacker()
    {
        return (attacker);
    }
    
    /**
     * Get the victim entity.
     * 
     * @return the victim entity.
     */
    public Entity getVictim()
    {
        return (victem);
    }
}
