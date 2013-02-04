package ca.bcit.cst.comp2526.assign6.solution;


/**
 * A world that has access to the mutable tiles.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public class DefaultMutableWorld
    extends    DefaultWorld
    implements MutableWorld
{
    /**
     * Construct a world with the specified number of rows and columns.
     * 
     * @param rows    the number of rows in the world.
     * @param columns the number of columns on each row of the world.
     * @param bounds  the min/max size of the rows/columns.
     * 
     * @throws TooFewRowsException     If the rows is less than the minimum rows in the bounds.
     * @throws TooFewColumnsException  If the columns is less than the minimum columns in the bounds.
     * @throws TooManyRowsException    If the rows is greater than the maximum rows in the bounds.
     * @throws TooManyColumnsException If the rows is greater than the maximum columns in the bounds.
     */
    public DefaultMutableWorld(final int         rows,
                               final int         columns,
                               final WorldBounds bounds)
        throws TooFewRowsException, 
               TooManyRowsException, 
               TooFewColumnsException, 
               TooManyColumnsException
    { 
        super(rows, 
              columns,
              bounds);
    }
    
    /**
     * Create a tile for a particular location on the world.
     * 
     * @param row the row the tile is on.
     * @param column the col the tile is on.
     * 
     * @return a new tile with the specified location.
     */
    @Override
    protected MutableTile createTile(final int row,
                                     final int column)
    {
        final Location    location;
        final MutableTile tile;
        
        location = Location.create(row,
                                   column,
                                   this);
        tile     = new MutableTile(location,
                                   this);
        
        return (tile);
    }
    
    /**
     * Get the mutable tile at the specified location.
     * 
     * @param location the location of the tile to get.
     * 
     * @return the tile at the specified location.
     */
    @Override
    public MutableTile getTileAt(final Location location)
    {
        final Tile        tile;
        final MutableTile mutableTile;
        
        tile = super.getTileAt(location);
        
        if(tile instanceof MutableTile)
        {
            mutableTile = (MutableTile)tile;
        }
        else if(tile == null)
        {
            mutableTile = null;
        }
        else
        {
            throw new IllegalStateException("tile must be a MutableTile");
        }
        
        return (mutableTile);
    }
}
