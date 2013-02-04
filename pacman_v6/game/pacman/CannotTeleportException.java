package ca.bcit.cst.comp2526.assign6.solution.game.pacman;


import ca.bcit.cst.comp2526.assign6.solution.Entity;
import ca.bcit.cst.comp2526.assign6.solution.Location;
import ca.bcit.cst.comp2526.assign6.solution.game.CollisionException;
import ca.bcit.cst.comp2526.assign6.solution.game.Game;
import ca.bcit.cst.comp2526.assign6.solution.game.MovableEntity;


/**
 * Thrown when pacman or a ghost calls teleport without being on a tile with a teleport entity on it.
 * @author D'Arcy Smith
 * @version 1.0
 */
public class CannotTeleportException
    extends CollisionException
{
    /**
     * Constant serialized ID used for compatibility.
     */
    private static final long serialVersionUID = 0;
    
    /**
     * Construct a CannotTeleportException with the specified values.
     * 
     * @param location the location of the tile that teleport was called on.
     * @param a        the entity that was moving.
     * @param v        the the entity that was already on the tile.
     */
    public CannotTeleportException(final Location                                               location,
                                   final MovableEntity<? extends Game, ? extends MovableEntity> a,
                                   final Entity                                                 v)
    {
        super("Cannot teleport from " + location.getRow() + ", " + location.getColumn(),
              a,
              v);
    }
}
