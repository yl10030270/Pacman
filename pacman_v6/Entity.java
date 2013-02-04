package ca.bcit.cst.comp2526.assign6.solution;


import ca.bcit.cst.comp2526.assign6.solution.ui.console.ConsoleEntityRenderer;
import ca.bcit.cst.comp2526.assign6.solution.ui.swing.SwingEntityRenderer;
import java.awt.Color;


/**
 * A "thing" on a tile of a world.
 * 
 * @author D'Arcy Smith
 * @version 1.1
 */
public interface Entity
{
    /**
     * Set the location of the entity.
     * 
     * @param loc the location of the entity.
     */    
    void setLocation(Location loc);
    
    /**
     * Get the location of the entity.
     * 
     * @return the location of the entity.
     */
    Location getLocation();
    
    /**
     * Get the key for the entity.  This is the character that represents
     * the entity in the data.
     * 
     * @return the key.
     */
    char getKey();
    
    /**
     * Get the label for the entity.  This is the character that represents
     * the entity on the console.
     * 
     * @return the label of the entity.
     */
    char getLabel();
    
    /**
     * Get the colour of the entity.  This is the colour used to draw the entity on a GUI.
     * 
     * @return the colour of the entity.
     */
    Color getColour();

    /**
     * Get the renderer used to draw this entity via swing.
     * 
     * @return the renderer used to draw this entity via swing.
     */
    SwingEntityRenderer getSwingRenderer();
    
    /**
     * Get the renderer used to draw this entity via the console.
     * 
     * @return the renderer used to draw this entity via the console.
     */
    ConsoleEntityRenderer getConsoleRenderer();
}
