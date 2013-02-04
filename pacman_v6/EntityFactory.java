package ca.bcit.cst.comp2526.assign6.solution;


import ca.bcit.cst.comp2526.assign6.solution.ui.console.ConsoleEntityRenderer;
import ca.bcit.cst.comp2526.assign6.solution.ui.swing.SwingEntityRenderer;
import ca.bcit.cst.comp2526.assign6.solution.worldreader.UnknownEntityTypeException;
import java.awt.Color;


/**
 * Abstraction to create entities based on the value in a data source.
 * 
 * @author D'Arcy Smnith
 * @version 1.1
 */
public interface EntityFactory
{
    /**
     * Create an entity based on the character.
     * 
     * @param type     the type of entity to create.
     * @param location the location that the entity is on. 
     * 
     * @return the entity created.
     * 
     * @throws UnknownEntityTypeException if the type of entity is unrecognized.
     */
    Entity createEntity(char     type,
                        Location location)
        throws UnknownEntityTypeException;
    
    /**
     * Get the character for the null entity from a data source.
     * 
     * @return the character for reading the null entity.
     */
    char getKeyForNullEntity();
    
    /**
     * Get the character for the wall entity from a data source.
     * 
     * @return the character for reading the wall entity.
     */
    char getKeyForWallEntity();
    
    /**
     * Get the character for the null entity for displaying.
     * 
     * @return the character for displaying the null entity.
     */
    char getLabelForNullEntity();
    
    /**
     * Get the character for the wall entity for displaying.
     * 
     * @return the character for displaying the wall entity.
     */
    char getLabelForWallEntity();
    
    /**
     * Get the character for the null entity for displaying.
     * 
     * @return the colour for displaying the null entity.
     */
    Color getColourForNullEntity();
    
    /**
     * Get the character for the wall entity for displaying.
     * 
     * @return the colour for displaying the wall entity.
     */
    Color getColourForWallEntity();
    
    /**
     * Get the renderer used to draw the null entity via swing.
     * 
     * @return the renderer used to draw the null entity via swing.
     */
    SwingEntityRenderer getSwingEntityRendererForNullEntity();
    
    /**
     * Get the renderer used to draw the wall entity via swing.
     * 
     * @return the renderer used to draw the wall entity via swing.
     */
    SwingEntityRenderer getSwingEntityRendererForWallEntity();
    
    /**
     * Get the renderer used to draw the null entity via console.
     * 
     * @return the renderer used to draw the null entity via console.
     */
    ConsoleEntityRenderer getConsoleEntityRendererForNullEntity();
    
    /**
     * Get the renderer used to draw the wall entity via console.
     * 
     * @return the renderer used to draw the wall entity via console.
     */
    ConsoleEntityRenderer getConsoleEntityRendererForWallEntity();
}
