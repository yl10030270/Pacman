/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign4.solution;


import java.awt.Color;


/**
 * The data used to create an entity.
 *
 * @author leon
 * @version 1.0
 */
public final class EntityData
{
    /**
     * The key.
     */
    private final char key;

    /**
     * The label.
     */
    private final char label;

    /**
     * The colour.
     */
    private final Color colour;

    /**
     * Construct an EntityData with the specified values.
     *
     * @param k   - the key.
     * @param lbl - the label.
     * @param c   - the color.
     */
    public EntityData(final char k,
                      final char lbl,
                      final Color c)
    {
        if(c == null)
        {
            throw new IllegalArgumentException("c cannot be null");
        }
        key = k;
        label = lbl;
        colour = c;
    }

    /**
     * Get the key.
     *
     * @return - the key.
     */
    public char getKey()
    {
        return key;
    }

    /**
     * Get the label.
     *
     * @return the label.
     */
    public char getLabel()
    {
        return label;
    }

    /**
     * Get the color.
     *
     * @return the color.
     */
    public Color getColour()
    {
        return colour;
    }

}
