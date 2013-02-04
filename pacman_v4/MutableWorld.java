package ca.bcit.cst.comp2526.assign4.solution;


/**
 * A collection of tiles that make up a map.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public interface MutableWorld
    extends World
{
    /**
     * Get the tile at the specified location.
     * 
     * @param location the location of the tile to get.
     * 
     * @return the tile at the specified location.
     */
    @Override
    MutableTile getTileAt(Location location);
}
