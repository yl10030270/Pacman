package ca.bcit.cst.comp2526.assign4.solution;


import java.awt.Color;


/**
 * A "thing" on a tile of a world.
 *
 * @author Leon
 * @version 2.0
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
     * Get the key for the entity. This is the character that represents the entity in the data.
     *
     * @return the key.
     */
    char getKey();

    /**
     * Get the label for the entity. This is the character that represents
     * the entity on the console.
     *
     * @return the label of the entity.
     */
    char getLabel();

    /**
     * Get the colour of the entity. This is the colour used to draw the entity on a GUI.
     *
     * @return the colour of the entity.
     */
    Color getColour();

}
