package ca.bcit.cst.comp2526.assign6.solution.game;

import ca.bcit.cst.comp2526.assign6.solution.World;
import ca.bcit.cst.comp2526.assign6.solution.ui.WorldUpdater;


/**
 * Abstraction for a a video game.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public interface Game
{
    /**
     * Initialize the game with an updater.
     * 
     * @param updater the updater used to redraw the world.
     */
    void init(WorldUpdater updater);
    
    /**
     * Get the world that the game is playing with.
     * 
     * @return the world that the game is playing with.
     */
    World getWorld();

    /**
     * Pause/Un-pause the game.
     */
    void togglePause();
    
    /**
     * See if the game is paused.
     * 
     * @return true of the game is paused, false if is not.
     */
    boolean isPaused();

    /**
     * Get the target frames per second.
     * 
     * @return the target frames per second.
     */
    int getTargetFPS();
    
    /**
     * Set the target frames per second.
     * 
     * @param tFPS the target frames per second.
     */
    void setTargetFPS(int tFPS);
    
    /**
     * Start the game.
     * 
     * @throws CollisionException thrown if there is a problem with colliding entities.
     */
    void start()
        throws CollisionException;
    
    /**
     * Get the number of ticks since the start of the game.  The ticks are increments
     * at the start of each game loop iteration.
     *
     * @return the number of ticks since the start of the game.
     */
    int getTicks();
}
