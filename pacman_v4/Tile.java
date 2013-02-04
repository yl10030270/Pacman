package ca.bcit.cst.comp2526.assign4.solution;


import java.util.Stack;


/**
 * A place on a world (think of it like a square on a chess board).
 *
 * @author Leon
 * @version 2.0
 */
public class Tile
{
    /**
     * The location of the tile.
     */
    protected final Location location;

    /**
     * The entity that is on the tile, null if there is no entity.
     */
    protected Stack<Entity> entities;

    /**
     * Construct a Tile with the specified location.
     *
     * @param loc the location of the tile.
     * @param w   the world that the tile is on.
     */
    public Tile(final Location loc,
                final World w)
    {
        if(loc == null)
        {
            throw new IllegalArgumentException("loc cannot be null");
        }

        if(w == null)
        {
            throw new IllegalArgumentException("w cannot be null");
        }

        location = loc;

        entities = new Stack<>();
        entities.push(null);
    }

    /**
     * Get the location of the tike on the world.
     *
     * @return the location of the tile.
     */
    public Location getLocation()
    {
        return (location);
    }

    /**
     * Get the entity that is on the tile.
     *
     * @return the entity on the tile, or null if the tile has no entity.
     */
    public Entity getEntity()
    {
        return getEntity(0);
    }

    /**
     * Get the entity that is the specified distance from the top of the group of entities.
     *
     * @param fromTop - how far down the group of entities to look.
     *
     * @return the entity at the specified position.
     */
    public Entity getEntity(final int fromTop)
    {
        if(fromTop < 0)
        {
            throw new IllegalArgumentException("fromTop must be >= 0, was: " + fromTop);
        }
        final int size;
        size = entities.size();
        if(fromTop >= size)
        {
            throw new IllegalArgumentException("fromTop must be < " + size + ", was: " + fromTop);
        }
        return entities.elementAt(size - 1 - fromTop);

    }

    /**
     * Get the number of entities on the tile.
     *
     * @return the number of entities on the tile.
     */
    public int getNumberOfEntities()
    {
        return entities.size();
    }

    @Override
    public String toString()
    {
        final StringBuilder builder;

        builder = new StringBuilder();
        builder.append(location);
        builder.append(" --> ");
        builder.append(entities.toString());

        return (builder.toString());
    }

}
