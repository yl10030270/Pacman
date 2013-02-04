package ca.bcit.cst.comp2526.assign6.solution.game.pacman;


import ca.bcit.cst.comp2526.assign6.solution.Entity;
import ca.bcit.cst.comp2526.assign6.solution.game.AbstractCollisionHandler;
import ca.bcit.cst.comp2526.assign6.solution.game.CollisionException;


/**
 * The collision handler for ghosts that are attacking Pac Man.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public class AttackingGhostCollisionHandler
    extends AbstractCollisionHandler<PacManGame,
                                     GhostEntity>
{    
    /**
     * Handle the collision with entities that a ghost could encounter.
     * 
     * @param ghost       the ghost that is moving.
     * @param otherEntity the entity the ghost collided with.
     * @param game        the game that is playing.
     * 
     * @return true if the collision was handled.
     * 
     * @throws CollisionException if there is a problem teleporting.
     */
    @Override
    protected boolean doHandleCollision(final GhostEntity ghost, 
                                        final Entity      otherEntity, 
                                        final PacManGame  game) 
        throws CollisionException
    {
        final boolean handled;
        
        if(otherEntity == null)
        {
            handled = true;
        }
        else if(otherEntity instanceof DoorEntity)
        {
            handled = true;
        }
        else if(otherEntity instanceof GhostEntity)
        {
            handled = true;
        }
        else if(otherEntity instanceof PacManEntity)
        {
            handled = true;
        }
        else if(otherEntity instanceof PelletEntity)
        {
            handled = true;
        }
        else if(otherEntity instanceof PowerPelletEntity)
        {
            handled = true;
        }
        else if(otherEntity instanceof TeleportEntity)
        {
            game.teleport(ghost);
            handled = true;
        }
        else
        {
            handled = false;
        }
        
        return (handled);
    }
}
