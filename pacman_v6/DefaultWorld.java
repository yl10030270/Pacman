package ca.bcit.cst.comp2526.assign6.solution;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/**
 * A collection of tiles that make up a map.
 *
 * @author D'Arcy Smith
 * @version 1.1
 */
public class DefaultWorld
    implements World
{
    /**
     * location cache map.
     */
    private final Map<Integer, Map<Integer, Location>> locationCache;

    /**
     * The tiles of the world.
     */
    protected final Tile[][] tiles;

    
    {
        locationCache = new HashMap<Integer, Map<Integer, Location>>();
    }

    /**
     *
     * Construct a world with the specified number of rows and columns.
     *
     * @param rows    the number of rows in the world.
     * @param columns the number of columns on each row of the world.
     * @param b       the min/max size of the rows/columns.
     *
     * @throws TooFewRowsException     If the rows is less than the minimum rows in the bounds.
     * @throws TooFewColumnsException  If the columns is less than the minimum columns in the bounds.
     * @throws TooManyRowsException    If the rows is greater than the maximum rows in the bounds.
     * @throws TooManyColumnsException If the rows is greater than the maximum columns in the bounds.
     */
    public DefaultWorld(final int rows,
                        final int columns,
                        final WorldBounds b)
        throws TooFewRowsException,
               TooManyRowsException,
               TooFewColumnsException,
               TooManyColumnsException
    {
        if(b == null)
        {
            throw new IllegalArgumentException("b cannot be null");
        }

        b.checkIsInBounds(rows, columns);
        tiles = new Tile[rows][columns];
    }

    /**
     * Initialize the tiles on the world.
     *
     * @see #createTile(int, int)
     */
    @Override
    public final void init()
    {
        for(int row = 0; row < tiles.length; row++)
        {
            for(int column = 0; column < tiles[row].length; column++)
            {
                final Tile tile;

                tile = createTile(row,
                                  column);
                tiles[row][column] = tile;
            }
        }
    }

    /**
     * Create a tile for a particular location on the world.
     *
     * @param row    the row the tile is on.
     * @param column the col the tile is on.
     *
     * @return a new tile with the specified location.
     */
    protected Tile createTile(final int row,
                              final int column)
    {
        final Location location;
        final Tile tile;

        location = Location.create(row,
                                   column,
                                   this);
        tile = new Tile(location,
                        this);

        return (tile);
    }

    /**
     * Get the number of rows on the world.
     *
     * @return the number of rows on the world.
     */
    @Override
    public int getNumberOfRows()
    {
        return (tiles.length);
    }

    /**
     * Get the number of columns on the world.
     *
     * @return the number of columns on the world.
     */
    @Override
    public int getNumberOfColumns()
    {
        return (tiles[0].length);
    }

    /**
     * Get the tile at the specified location.
     *
     * @param location the location of the tile to get.
     *
     * @return the tile at the specified location.
     */
    @Override
    public Tile getTileAt(final Location location)
    {
        final int row;
        final int column;
        final Tile tile;

        if(location == null)
        {
            throw new IllegalArgumentException("location cannot be null");
        }

        if(location.getRectangle() != this)
        {
            throw new IllegalArgumentException("cannot use a different rectangle");
        }

        row = location.getRow();
        column = location.getColumn();
        tile = tiles[row][column];

        return (tile);
    }

    /**
     * Get the tiles immediately around the requested location. Only returns locations that
     * are in the bounds of the world, for example a corner tile only has 3 neighbours.
     *
     * @param location   the location to look around (this is the central point).
     * @param directions the directions to look around.
     *
     * @return the location of the tile in the direction.
     */
    @Override
    public Map<Direction, Location> getTilesAround(final Location location,
                                                   final List<Direction> directions)
    {
        final Map<Direction, Location> tilesAround;

        if(location == null)
        {
            throw new IllegalArgumentException("location cannot be null");
        }

        if(directions == null)
        {
            throw new IllegalArgumentException("directions cannot be null");
        }

        if(directions.isEmpty())
        {
            throw new IllegalArgumentException("directions cannot be empty");
        }

        tilesAround = new TreeMap<Direction, Location>();

        for(final Direction direction : directions)
        {
            final int row;
            final int column;
            final int byRows;
            final int byColumns;

            row = location.getRow();
            column = location.getColumn();
            byRows = direction.getVertical();
            byColumns = direction.getHorizontal();

            if(isInBounds(row + byRows,
                          column + byColumns))
            {
                final Location toLocation;

                toLocation = Location.create(row + byRows,
                                             column + byColumns,
                                             this);
                tilesAround.put(direction,
                                toLocation);
            }
        }

        return (tilesAround);
    }

    /**
     * Check to see if the given row and column are on the world.
     *
     * @param row    the row to check.
     * @param column the column to check.
     *
     * @return true if the row/column are in range, false if they are not.
     */
    @Override
    public boolean isInBounds(final int row,
                              final int column)
    {
        final int numberOfRows;
        final int numberOfColumns;
        final boolean retVal;

        numberOfRows = getNumberOfRows();
        numberOfColumns = getNumberOfColumns();

        if(row < 0)
        {
            retVal = false;
        }
        else if(row >= numberOfRows)
        {
            retVal = false;
        }
        else if(column < 0)
        {
            retVal = false;
        }
        else if(column >= numberOfColumns)
        {
            retVal = false;
        }
        else
        {
            retVal = true;
        }

        return (retVal);
    }

    /**
     * Check to see if the location is already cached.
     *
     * @param row    the row of the location.
     * @param column the column of the location.
     *
     * @return true of the location is cached, false otherwise.
     */
    @Override
    public boolean containsLocation(final int row,
                                    final int column)
    {
        final Location location;

        location = getLocation(row, column);

        return (location != null);
    }

    /**
     * Get the Location for the row/column from the cache.
     *
     * @param row    the row of the location.
     * @param column the column of the location.
     *
     * @return the location, if cached, or null if it is not cached.
     */
    @Override
    public Location getLocation(final int row,
                                final int column)
    {
        final Map<Integer, Location> locations;
        final Location location;

        locations = locationCache.get(row);

        if(locations == null)
        {
            location = null;
        }
        else
        {
            location = locations.get(column);
        }

        return (location);
    }

    /**
     * Add the location to the cache.
     *
     * @param location the location to cache.
     *
     * @return true if the location wasn't in the cache already, false if it was.
     */
    @Override
    public boolean addLocation(final Location location)
    {
        final Integer row;
        final Integer column;
        Map<Integer, Location> locations;
        Location existingLocation;
        final boolean retVal;

        if(location == null)
        {
            throw new IllegalArgumentException("location cannot be null");
        }

        row = location.getRow();
        column = location.getColumn();
        locations = locationCache.get(row);

        if(locations == null)
        {
            locations = new HashMap<Integer, Location>();
            locationCache.put(row, locations);
        }

        existingLocation = locations.get(column);

        if(existingLocation == null)
        {
            locations.put(column, location);
            retVal = true;
        }
        else
        {
            retVal = false;
        }

        return (retVal);
    }

}
