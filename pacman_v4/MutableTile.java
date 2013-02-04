package ca.bcit.cst.comp2526.assign4.solution;


/**
 * A tile that can change the entity that is on it.
 *
 * @author Leon
 * @version 2.0
 */
public class MutableTile
    extends Tile
{
    /**
     * the world that the tile is on.
     */
    private final MutableWorld world;

    /**
     * Construct a MutableTile with the specified location.
     *
     * @param loc the location of the tile.
     * @param w   the world that the tile is on.
     */
    public MutableTile(final Location loc,
                       final MutableWorld w)
    {
        super(loc,
              w);
        world = w;
    }

    /**
     * Add an entity to the tile. If there is already an entity on the tile then it winds up one place further down the
     * group of entities.
     * The entity being placed on the tile has its location set to the location of the tile.
     *
     * @param entity - the entity to place on the tile, may be null.
     */
    public void addEntity(final Entity entity)
    {
        if(entity == null)
        {
            throw new IllegalArgumentException("entity cannot be null");
        }
        final Location fromLocation = entity.getLocation();
        if(fromLocation != null)
        {

            final MutableTile fromTile;
            fromTile = world.getTileAt(fromLocation);
            fromTile.removeEntity(entity);

        }
        entity.setLocation(this.location);
        entities.push(entity);
    }

    /**
     * Remove the specified entity from the tile. Also sets the location of the entity to null.
     *
     * @param entity - the entity to remove.
     *
     * @return true if the entity was removed, false if it was not.
     */
    public boolean removeEntity(final Entity entity)
    {
        boolean retval;
        if(entity == null)
        {
            throw new IllegalArgumentException("entity cannot be null");
        }
        retval = entities.removeElement(entity);
        if(retval)
        {
            entity.setLocation(null);
        }
        return retval;
    }

//    /**
//     * Set the entity for the tile.
//     * If there is already an entity on the tile then that entity has its location set to null.
//     * If the entity being placed on the tile is not null then that entity has its location set to the location of the tile.
//     * 
//     * @param movingEntity the entity to place on the tile, may be null.
//     * 
//     * @return the entity that was on the tile already, or null if there was no pre-existing entity.
//     */
//    public Entity setEntity(final Entity movingEntity)
//    {
//        final Entity existingEntity;
//
//        existingEntity = entity;
//        
//        // pick the entity being moved up off of the tile it is already on
//        if(movingEntity != null)
//        {
//            final Location fromLocation;
//                        
//            fromLocation = movingEntity.getLocation();
//            
//            if(fromLocation != null)
//            {
//                final MutableTile fromTile;
//                
//                fromTile = mutableWorld.getTileAt(fromLocation);            
//                fromTile.setEntity(null);
//            }
//            
//            movingEntity.setLocation(null);
//        }
//        
//        // remove the existing entiity        
//        if(existingEntity != null)
//        {
//            existingEntity.setLocation(null);
//        }
//        
//        // put the entity on to its new home
//        entity = movingEntity;
//        
//        if(movingEntity != null)
//        {
//            movingEntity.setLocation(location);
//        }
//        
//        return (existingEntity);
//    }
} //class end
