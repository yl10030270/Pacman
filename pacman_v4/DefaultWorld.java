package ca.bcit.cst.comp2526.assign4.solution;


import java.util.EnumMap;
import java.util.List;
import java.util.Map;


/**
 * A collection of tiles that make up a map.
 *
 * @author Leon
 * @version 2.0
 */
public class DefaultWorld
    implements World
{
    /**
     * The tiles of the world.
     */
    protected final Tile[][] tiles;

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
     * Get the tiles immediately around the requested location. Only returns locations that are in the bounds
     * of the world, for example a corner tile only has 3 neighbors.
     *
     * @param location   - the location to look around (this is the central point).
     * @param directions - the directions to look around.
     *
     * @return the location of the tile in the cardinal direction.
     */
    private Map<Direction, Location> getTilesAroundCardinal(final Location location,
                                                            final List<Direction> directions)
    {
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
        final Map<Direction, Location> tilesAroundCardinal = new EnumMap<>(Direction.class);

        final int r = location.getRow();
        final int c = location.getColumn();

        if(directions.contains(Direction.NONE))
        {
            tilesAroundCardinal.put(Direction.NONE, Location.create(r, c, this));
        }
        if(isInBounds(r - 1, c) && directions.contains(Direction.NORTH))
        {
            tilesAroundCardinal.put(Direction.NORTH, Location.create(r - 1, c, this));
        }
        if(isInBounds(r, c + 1) && directions.contains(Direction.EAST))
        {
            tilesAroundCardinal.put(Direction.EAST, Location.create(r, c + 1, this));
        }
        if(isInBounds(r + 1, c) && directions.contains(Direction.SOUTH))
        {
            tilesAroundCardinal.put(Direction.SOUTH, Location.create(r + 1, c, this));
        }
        if(isInBounds(r, c - 1) && directions.contains(Direction.WEST))
        {
            tilesAroundCardinal.put(Direction.WEST, Location.create(r, c - 1, this));
        }
        return tilesAroundCardinal;
    }

    /**
     * Get the tiles immediately around the requested location. Only returns locations that are in the bounds of the
     * world, for example a corner tile only has 3 neighbors.
     *
     * @param location   - the location to look around (this is the central point).
     * @param directions - the directions to look around.
     *
     * @return the location of the tile in the direction.
     */
    @Override
    public Map<Direction, Location> getTilesAround(final Location location,
                                                   final List<Direction> directions)
    {
        final Map<Direction, Location> tilesAround = new EnumMap<>(getTilesAroundCardinal(location, directions));

        final int r = location.getRow();
        final int c = location.getColumn();

        if(isInBounds(r - 1, c + 1) && directions.contains(Direction.NORTH_EAST))
        {
            tilesAround.put(Direction.NORTH_EAST, Location.create(r - 1, c + 1, this));
        }
        if(isInBounds(r + 1, c + 1) && directions.contains(Direction.SOUTH_EAST))
        {
            tilesAround.put(Direction.SOUTH_EAST, Location.create(r + 1, c + 1, this));
        }
        if(isInBounds(r + 1, c - 1) && directions.contains(Direction.SOUTH_WEST))
        {
            tilesAround.put(Direction.SOUTH_WEST, Location.create(r + 1, c - 1, this));
        }
        if(isInBounds(r - 1, c - 1) && directions.contains(Direction.NORTH_WEST))
        {
            tilesAround.put(Direction.NORTH_WEST, Location.create(r - 1, c - 1, this));
        }
        return tilesAround;
    }

    /**
     * Check to see if the given row and column are on the world.
     *
     * @param row    - the row to check.
     * @param column - the column to check.
     *
     * @return true if the row/column are in range, false if they are not.
     */
    @Override
    public boolean isInBounds(final int row,
                              final int column)
    {
        boolean retval = true;

        if(row < 0 || column < 0)
        {
            retval = false;
        }
        if(row >= tiles.length || column >= tiles[0].length)
        {
            retval = false;
        }

        return retval;
    }

}
