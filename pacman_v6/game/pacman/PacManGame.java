package ca.bcit.cst.comp2526.assign6.solution.game.pacman;


import ca.bcit.cst.comp2526.assign6.solution.game.Game;


/**
 * A PacMan game.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public interface PacManGame
    extends Game
{
    /**
     * Teleport an entity from one location to another.
     * 
     * @param entity the entity being teleported.
     * 
     * @throws CannotTeleportException if there is a problem teleporting the entity.
     */
    void teleport(AbstractPacManGameMovableEntity<?> entity)
        throws CannotTeleportException;
    
    /**
     * Eat a pellet.
     * 
     * @param pellet the pellet to eat.
     */
    void eatPellet(PelletEntity pellet);
    
    /**
     * Eat a power pellet.
     * 
     * @param powerPellet the power pellet to eat.
     */
    void eatPowerPellet(PowerPelletEntity powerPellet);
}
