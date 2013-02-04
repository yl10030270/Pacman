package ca.bcit.cst.comp2526.assign4.solution.ui;


import ca.bcit.cst.comp2526.assign4.solution.game.Game;


/**
 * The abstraction of displaying a world.
 *
 * @author D'Arcy Smith
 * @version 1.1
 */
public interface WorldDisplayer
{
    /**
     * Display the world.
     * 
     * @throws WorldDisplayerException  
     */
    void displayWorld()
        throws WorldDisplayerException;
    
    /**
     * Initialize the world.
     * 
     * @param game the game that the world will be played on.
     */
    void init(Game game);
}
