/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign4.solution.game;


import ca.bcit.cst.comp2526.assign4.solution.World;
import ca.bcit.cst.comp2526.assign4.solution.ui.WorldUpdater;


/**
 * Abstraction for a a video game.
 *
 * @author leon
 * @version 1.0
 */
public interface Game
{
    /**
     * Initialize the game with an updater.
     *
     * @param updater - the updater used to redraw the world.
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
     * @param tFPS - the target frames per second.
     */
    void setTargetFPS(int tFPS);

    /**
     * Start the game.
     *
     * @throws CollisionException - thrown if there is a problem with colliding entities.
     */
    void start()
        throws CollisionException;

}
