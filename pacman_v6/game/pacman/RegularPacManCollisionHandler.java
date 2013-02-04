package ca.bcit.cst.comp2526.assign6.solution.game.pacman;


import ca.bcit.cst.comp2526.assign6.solution.Entity;
import ca.bcit.cst.comp2526.assign6.solution.game.AbstractCollisionHandler;
import ca.bcit.cst.comp2526.assign6.solution.game.CollisionException;


/**
 * Handle collisions of Pac Man with other entities.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public class RegularPacManCollisionHandler
    extends AbstractCollisionHandler<PacManGame,
                                      PacManEntity>
{    
    /**
     * Handle the collision with entities that Pac Man could encounter.
     * 
     * @param pacman      the pacman that is moving.
     * @param otherEntity the entity the ghost collided with.
     * @param game        the game that is playing.
     * 
     * @return true if the collision was handled.
     * 
     * @throws CollisionException if there is a problem teleporting.
     */
    @Override
    protected boolean doHandleCollision(final PacManEntity pacman, 
                                        final Entity       otherEntity, 
                                        final PacManGame   game) 
        throws CollisionException
    {
        final boolean handled;
        
        if(otherEntity == null)
        {
            handled = true;
        }
        else if(otherEntity instanceof GhostEntity)
        {
            handled = true;
        }
        else if(otherEntity instanceof PelletEntity)
        {
            game.eatPellet((PelletEntity)otherEntity);
            handled = true;
        }
        else if(otherEntity instanceof PowerPelletEntity)
        {
            game.eatPowerPellet((PowerPelletEntity)otherEntity);
            handled = true;
        }
        else if(otherEntity instanceof TeleportEntity)
        {
            game.teleport(pacman);
            handled = true;
        }
        else
        {
            handled = false;
        }
        
        return (handled);
    }
}
