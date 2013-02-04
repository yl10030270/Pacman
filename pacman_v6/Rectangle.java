package ca.bcit.cst.comp2526.assign6.solution;


/**
 * Represents a rectangular area, such as a chess board.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public interface Rectangle
{
    /**
     * Get the number of rows on the rectangle.
     * 
     * @return the number of rows on the rectangle.
     */
    int getNumberOfRows();
    
    /**
     * Get the number of columns on the rectangle.
     * 
     * @return the number of columns on the rectangle.
     */
    int getNumberOfColumns();

    /**
     * Check to see if the location is already cached.
     * 
     * @param row    the row of the location.
     * @param column the column of the location.
     * 
     * @return true of the location is cached, false otherwise.
     */
    boolean containsLocation(int row,
                             int column);
    
    /**
     * Get the Location for the row/column from the cache.
     * 
     * @param row    the row of the location.
     * @param column the column of the location.
     * 
     * @return the location, if cached, or null if it is not cached.
     */
    Location getLocation(int row,
                         int column);

    /**
     * Add the location to the cache.
     * 
     * @param location the location to cache.
     * 
     * @return true if the location wasn't in the cache already, false if it was.
     */
    boolean addLocation(Location location);
}
