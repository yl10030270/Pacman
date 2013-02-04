package ca.bcit.cst.comp2526.assign6.solution;


import ca.bcit.cst.comp2526.assign6.solution.game.Game;
import ca.bcit.cst.comp2526.assign6.solution.ui.console.ConsoleEntityRenderer;
import ca.bcit.cst.comp2526.assign6.solution.ui.swing.SwingEntityRenderer;
import java.awt.Color;


/**
 * The data used to create an entity.
 *
 * @param <T>
 * @param <E>
 *
 * @author D'Arcy Smith
 * @version 1.1
 */
public class EntityData<T extends Game, E extends Entity>
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
     * Swing Entity Render.
     */
    private final SwingEntityRenderer swingRenderer;

    /**
     * Console Entity Render.
     */
    private final ConsoleEntityRenderer consoleRenderer;

    /**
     * Construct an EntityData with the specified values.
     *
     * @param k   the key.
     * @param lbl the label.
     * @param c   the colour.
     * @param sr  the swing renderer.
     * @param cr  the console renderer.
     */
    public EntityData(final char k,
                      final char lbl,
                      final Color c,
                      final SwingEntityRenderer<T, E> sr,
                      final ConsoleEntityRenderer<T, E> cr)
    {
        if(c == null)
        {
            throw new IllegalArgumentException("c cannot be null");
        }

        if(sr == null)
        {
            throw new IllegalArgumentException("sr cannot be null");
        }

        if(cr == null)
        {
            throw new IllegalArgumentException("cr cannot be null");
        }

        key = k;
        label = lbl;
        colour = c;
        swingRenderer = sr;
        consoleRenderer = cr;
    }

    /**
     * Get the key.
     *
     * @return the key.
     */
    public char getKey()
    {
        return (key);
    }

    /**
     * Get the label..
     *
     * @return the label.
     */
    public char getLabel()
    {
        return label;
    }

    /**
     * Get the colour.
     *
     * @return the colour.
     */
    public Color getColour()
    {
        return colour;
    }

    /**
     * Get the renderer to use when drawing with Swing.
     *
     * @return the renderer to use when drawing with Swing.
     */
    public SwingEntityRenderer getSwingRenderer()
    {
        return (swingRenderer);
    }

    /**
     * Get the renderer to use when drawing with the Console.
     *
     * @return the renderer to use when drawing with the Console
     */
    public ConsoleEntityRenderer getConsoleRenderer()
    {
        return (consoleRenderer);
    }

}
