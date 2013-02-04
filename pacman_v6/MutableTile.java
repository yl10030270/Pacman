package ca.bcit.cst.comp2526.assign6.solution;


/**
 * A tile that can change the entity that is on it.
 *  
 * @author D'Arcy Smith
 * @version 1.1
 */
public class MutableTile
    extends Tile
{
    /**
     * The world that the tile is on.
     */
    private final MutableWorld mutableWorld;
    
    /**
     * Construct a MutableTile with the specified location.
     * 
     * @param loc the location of the tile.
     * @param w   the world that the tile is on.
     */
    public MutableTile(final Location     loc,
                       final MutableWorld w)
    {
        super(loc,
              w);
        
        mutableWorld = w;
    }

    /**
     * Add an entity to the tile.
     * 
     * If there is already an entity on the tile then it winds up one place further down the group of entities.
     * The entity being placed on the tile has its location set to the location of the tile.
     * 
     * @param entity the entity to place on the tile, may be null.
     * 
     */
    public void addEntity(final Entity entity)
    {
        final Location oldLocation;

        if(entity == null)
        {
            throw new IllegalArgumentException("entity cannot be null");
        }
        
        oldLocation = entity.getLocation();

        if(oldLocation != null)
        {
            final MutableTile oldTile;
            final boolean     removed;
            
            oldTile = mutableWorld.getTileAt(oldLocation);
            removed = oldTile.removeEntity(entity);
            
            if(!(removed))
            {
                throw new IllegalStateException(entity + " was not removed");
            }
        }

        entity.setLocation(location);
        
        entities.push(entity);
    }
   
    /**
     * Remove the specified entity from the tile.  Also sets the location of the entity to null.
     * 
     * @param entity the entity to remove.
     * @return true if the entity was removed, false if it was not.
     */
    public boolean removeEntity(final Entity entity)
    {
        final int     index;
        final boolean retVal;
        
        if(entity == null)
        {
            throw new IllegalArgumentException("entity cannot be null");
        }
        
        index = entities.indexOf(entity);

        if(index < 0)
        {   
            retVal = false;
        }
        else
        {
            entities.remove(index);
            entity.setLocation(null);
            retVal = true;
        }
        
        return (retVal);
    }
}
