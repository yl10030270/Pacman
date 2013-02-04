package ca.bcit.cst.comp2526.assign6.solution;


import java.util.List;
import java.util.Map;


/**
 * A collection of tiles that make up a map.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public interface World
    extends Rectangle
{
    /**
     * Initialize the tiles on the world.
     */
    void init();
    
    /**
     * Get the tile at the specified location.
     * 
     * @param location the location of the tile to get.
     * 
     * @return the tile at the specified location.
     */
    Tile getTileAt(Location location);
    
    /**
     * Get the tiles immediately around the tile at the specified location.
     * 
     * @param location   the location to get the tiles around.
     * @param directions the directions to look.
     * 
     * @return the tiles that are around the location.
     */
    Map<Direction, Location> getTilesAround(Location        location,
                                            List<Direction> directions);

    /**
     * Check to see if the location at the desired row and column are in the bounds of the world.
     * 
     * @param row    the rows of the location.
     * @param column the column of the location.
     * 
     * @return true if the location would be in bounds, false otherwise.
     */
    boolean isInBounds(int row,
                       int column);
} 
