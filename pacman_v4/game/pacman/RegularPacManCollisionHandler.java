/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign4.solution.game.pacman;


import ca.bcit.cst.comp2526.assign4.solution.Entity;
import ca.bcit.cst.comp2526.assign4.solution.WallEntity;
import ca.bcit.cst.comp2526.assign4.solution.game.AbstractCollisionHandler;
import ca.bcit.cst.comp2526.assign4.solution.game.CollisionException;


/**
 * Handle collisions of Pac Man with other entities.
 *
 * @author Leon
 * @version 1.0
 */
public class RegularPacManCollisionHandler
    extends AbstractCollisionHandler<PacManGame, PacManEntity>
{
    /**
     * Handle the collision with entities that Pac Man could encounter.
     *
     * @param pacman      - the pacman that is moving.
     * @param otherEntity - the entity the ghost collided with.
     * @param game        - the game that is playing.
     *
     * @return true if the collision was handled.
     *
     * @throws CollisionException - if there is a problem teleporting.
     */
    @Override
    protected boolean doHandleCollision(final PacManEntity pacman,
                                        final Entity otherEntity,
                                        final PacManGame game)
        throws CollisionException
    {
        final boolean retval;
        if(otherEntity == null)
        {
            retval = true;
        }
        else if(otherEntity instanceof WallEntity || otherEntity instanceof InvisibleWallEntity)
        {
            retval = false;
        }
        else if(otherEntity instanceof DoorEntity || otherEntity instanceof PacManEntity)
        {
            retval = false;
        }
        else if(otherEntity.getKey() == new PacManEntityFactory().getKeyForTeleportEntity())
        {
            game.teleport(pacman);
            retval = true;
        }
        else if(otherEntity instanceof PelletEntity)
        {
            game.eatPellet((PelletEntity)otherEntity);
            retval = true;
        }
        else if(otherEntity instanceof PowerPelletEntity)
        {
            game.eatPowerPellet((PowerPelletEntity)otherEntity);
            retval = true;
        }
        else
        {
            retval = true;
        }

        return retval;
    }

}
