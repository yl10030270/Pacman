package ca.bcit.cst.comp2526.assign6.solution;

import java.util.Stack;


/**
 * A place on a world (think of it like a square on a chess board).
 *
 * @author D'Arcy Smith
 * @version 1.1
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
    protected final Stack<Entity> entities;
    
    {
        entities = new Stack<Entity>();
        entities.push(null);
    }
    

    /**
     * Construct a Tile with the specified location.  The tile will always have a null entity on it at the very least.
     * 
     * @param loc the location of the tile.
     * @param w   the world that the tile is on.
     */
    public Tile(final Location loc,
                final World     w)
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
     * Get the entity that is on the top of the tile.
     *  
     * @return the entity on the tile, or null if the tile has no entity.
     */
    public Entity getEntity()
    {
        final Entity entity;
        
        entity = entities.peek();
        
        return (entity);
    }
    
    /**
     * Get the entity that is the specified distance from the top of the group of entities.
     * 
     * @param fromTop how far down the group of entities to look.
     * @return the entity at the specified position.
     */
    public Entity getEntity(final int fromTop)
    {
        final int    size;
        final Entity entity;
        
        if(fromTop < 0)
        {
            throw new IllegalArgumentException("fromTop must be >= 0, was: " + fromTop);
        }
        
        size = entities.size();
        
        if(fromTop >= size)
        {
            throw new IllegalArgumentException("fromTop must be < " + size + ", was: " + fromTop);
        }
        
        entity = entities.get(size - 1 - fromTop);
        
        return (entity);
    }
    
    /**
     * Get the number of entities on the tile.
     * 
     * @return the number of entities on the tile.
     */
    public int getNumberOfEntities()
    {
        return (entities.size());
    }
        
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        final StringBuilder builder;
        
        builder = new StringBuilder();
        builder.append(location);
        builder.append(" --> ");
        builder.append(entities);
        
        return (builder.toString());
    }
}
