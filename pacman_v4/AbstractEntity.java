package ca.bcit.cst.comp2526.assign4.solution;


import java.awt.Color;
import java.util.Objects;


/**
 * Convenience class for common entity features.
 *
 * @author Leon
 * @version 2.0
 */
public abstract class AbstractEntity
    implements Entity
{
    /**
     * The location of the entity on the world.
     */
    private Location location;

    /**
     * The label of the entity.
     */
    private final EntityData endata;

    /**
     * Construct an AbstractEntity with the specified label.
     *
     * @param data - the values used for the entity.
     */
    protected AbstractEntity(final EntityData data)
    {
        if(data == null)
        {
            throw new IllegalArgumentException("data cannot be null");
        }
        endata = data;
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
        return endata.getKey();
    }

    /**
     * Get the label.
     *
     * @return the label.
     */
    @Override
    public char getLabel()
    {
        return endata.getLabel();

    }

    /**
     * Get the colour of the entity.
     *
     * @return the colour of the entity.
     */
    @Override
    public Color getColour()
    {
        return endata.getColour();
    }

    @Override
    public String toString()
    {
        return ("'" + endata.getKey() + "' @ " + location);
    }

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

                if(endata.getLabel() == other.endata.getLabel() &&
                    endata.getKey() == other.endata.getKey() &&
                    endata.getColour().equals(other.endata.getColour()))
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

    @Override
    public int hashCode()
    {
        return endata.getKey();
    }

}
