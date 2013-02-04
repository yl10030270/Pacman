package ca.bcit.cst.comp2526.assign4.solution.ui;


import ca.bcit.cst.comp2526.assign4.solution.Location;
import java.awt.event.KeyListener;


/**
 * Update the world and get the user input.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public interface WorldUpdater
{
    /**
     * Add a location to be redrawn.
     * 
     * @param location the location to be redrawn.
     */
    void addUpdateLocation(Location location);
    
    /**
     * Draw the changes.
     */
    void drawChanges();
    
    /**
     * Add a key listener for user input.
     *  
     * @param listener the key listener.
     */
    void addKeyListener(KeyListener listener);
}