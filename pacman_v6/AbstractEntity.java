package ca.bcit.cst.comp2526.assign6.solution;


import ca.bcit.cst.comp2526.assign6.solution.ui.console.ConsoleEntityRenderer;
import ca.bcit.cst.comp2526.assign6.solution.ui.swing.SwingEntityRenderer;
import java.awt.Color;
import java.util.Objects;


/**
 * Convenience class for common entity features.
 *
 * @author D'Arcy Smith
 * @version 1.1
 */
public abstract class AbstractEntity
    implements Entity
{
    /**
     * The location of the entity on the world.
     */
    private Location location;

    /**
     * The key of the entity, as defined by the EntityFactory.
     */
    private final char key;

    /**
     * The label of the entity.
     */
    private final char label;

    /**
     * The colour of the entity on a GUI.
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
     * Construct an AbstractEntity with the specified values.
     *
     * @param data the values used for the entity.
     */
    protected AbstractEntity(final EntityData data)
    {
        if(data == null)
        {
            throw new IllegalArgumentException("data cannot be null");
        }

        key = data.getKey();
        label = data.getLabel();
        colour = data.getColour();
        swingRenderer = data.getSwingRenderer();
        consoleRenderer = data.getConsoleRenderer();
    }

    /**
     * Set the location of the entity.
     *
     * @param loc the location to place the entity.
     */
    @Override
    public void setLocation(final Location loc)
    {
        location = loc;
    }

    /**
     * Get the location of the entity.
     *
     * @return the location of the entity.
     */
    @Override
    public Location getLocation()
    {
        return (location);
    }

    /**
     * Get the key.
     *
     * @return the key.
     */
    @Override
    public char getKey()
    {
        return (key);
    }

    /**
     * Get the label.
     *
     * @return the label.
     */
    @Override
    public char getLabel()
    {
        return (label);
    }

    /**
     * Get the colour of the entity.
     *
     * @return the colour of the entity.
     */
    @Override
    public Color getColour()
    {
        return (colour);
    }

    /**
     * Get the renderer used to draw this entity via swing.
     *
     * @return the renderer used to draw this entity via swing.
     */
    @Override
    public SwingEntityRenderer getSwingRenderer()
    {
        return (swingRenderer);
    }

    /**
     * Get the renderer used to draw this entity via the console.
     *
     * @return the renderer used to draw this entity via the console.
     */
    @Override
    public ConsoleEntityRenderer getConsoleRenderer()
    {
        return (consoleRenderer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        return ("'" + key + "' @ " + location);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj)
    {
        final boolean retVal;

        if(obj == null)
        {
            retVal = false;
        }
        else
        {
            if(getClass() == obj.getClass())
            {
                final AbstractEntity other;

                other = (AbstractEntity)obj;

                if(key == other.key &&
                    label == other.label &&
                    colour.equals(other.colour))
                {
                    retVal = Objects.equals(this.location, other.location);
                }
                else
                {
                    retVal = false;
                }
            }
            else
            {
                retVal = false;
            }
        }

        return (retVal);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode()
    {
        return (key);
    }

}
