package ca.bcit.cst.comp2526.assign6.solution.worldreader;


import ca.bcit.cst.comp2526.assign6.solution.DefaultMutableWorld;
import ca.bcit.cst.comp2526.assign6.solution.Entity;
import ca.bcit.cst.comp2526.assign6.solution.EntityFactory;
import ca.bcit.cst.comp2526.assign6.solution.Location;
import ca.bcit.cst.comp2526.assign6.solution.MutableTile;
import ca.bcit.cst.comp2526.assign6.solution.MutableWorld;
import ca.bcit.cst.comp2526.assign6.solution.TooFewColumnsException;
import ca.bcit.cst.comp2526.assign6.solution.TooFewRowsException;
import ca.bcit.cst.comp2526.assign6.solution.TooManyColumnsException;
import ca.bcit.cst.comp2526.assign6.solution.TooManyRowsException;
import ca.bcit.cst.comp2526.assign6.solution.WorldBounds;
import java.util.List;


/**
 * Convenience class for common world reading features.
 *
 * @author D'Arcy Smith
 * @version 1.0
 */
public abstract class AbstractWorldReader
    implements WorldReader
{
    /**
     * Read a world from a data source.
     *
     * @param worldName the name of the world to read.
     * @param factory   used to create entities.
     * @param bounds    the bounds of the world.
     *
     * @return the world.
     *
     * @throws TooFewRowsException        thrown if the number of rows specified is smaller than the bounds.
     * @throws TooManyRowsException       thrown if the number of rows specified is larger than the bounds.
     * @throws TooFewColumnsException     thrown if the number of columns specified is smaller than the bounds.
     * @throws TooManyColumnsException    thrown if the number of columns specified is larger than the bounds.
     * @throws ShortRowException          thrown if there are too few entities on a row.
     * @throws LongRowException           thrown if there are too many entities on a row.
     * @throws RowsNotIntegerException    thrown if the rows are not an integer.
     * @throws ColumnsNotIntegerException thrown if the columns are not an integer.
     * @throws UnknownEntityTypeException thrown if the data has an unknown entity type.
     * @throws EmptyDataException         thrown if there is no data in the data source.
     * @throws MissingRowsException       thrown if the data has too few rows.
     * @throws ExtraRowsException         thrown if the data has too many rows.
     * @throws WorldDataSourceException   thrown if there is an underlying problem reading from the data source.
     * @throws DecompressionException     thrown if decompression have problems.
     */
    @Override
    public final DefaultMutableWorld readWorld(final String worldName,
                                               final EntityFactory factory,
                                               final WorldBounds bounds)
        throws TooFewRowsException,
               TooManyRowsException,
               TooFewColumnsException,
               TooManyColumnsException,
               ShortRowException,
               LongRowException,
               RowsNotIntegerException,
               ColumnsNotIntegerException,
               UnknownEntityTypeException,
               MissingRowsException,
               ExtraRowsException,
               EmptyDataException,
               WorldDataSourceException,
               DecompressionException
    {
        if(worldName == null)
        {
            throw new IllegalArgumentException("worldName cannot be null");
        }

        if(worldName.trim().isEmpty())
        {
            throw new IllegalArgumentException("worldName cannot be empty");
        }

        if(factory == null)
        {
            throw new IllegalArgumentException("factory cannot be null");
        }

        if(bounds == null)
        {
            throw new IllegalArgumentException("bounds cannot be null");
        }

        openWorldData(worldName);

        try
        {
            final int rows;
            final int columns;
            final List<String> worldContents;
            final DefaultMutableWorld world;

            rows = getNumberOfRows(worldName);
            columns = getNumberOfColumns(worldName);
            worldContents = getWorldContents(worldName);
            world = createWorld(rows,
                                columns,
                                bounds,
                                factory,
                                worldContents);

            return (world);
        }
        finally
        {
            closeWorldData(worldName);
        }
    }

    /**
     * Create a world from the contents.
     *
     * @param rows     the number of rows in the world.
     * @param columns  the number of columns in the world.
     * @param bounds   the bounds of the world.
     * @param factory  used to create entities.
     * @param contents the data lines of the world.
     *
     * @return the world.
     *
     * @throws TooFewRowsException        thrown if the number of rows specified is smaller than the bounds.
     * @throws TooManyRowsException       thrown if the number of rows specified is larger than the bounds.
     * @throws TooFewColumnsException     thrown if the number of columns specified is smaller than the bounds.
     * @throws TooManyColumnsException    thrown if the number of columns specified is larger than the bounds.
     * @throws ShortRowException          thrown if there are too few entities on a row.
     * @throws LongRowException           thrown if there are too many entities on a row.
     * @throws UnknownEntityTypeException thrown if the data has an unknown entity type.
     * @throws MissingRowsException       thrown if the data has too few rows.
     * @throws ExtraRowsException         thrown if the data has too many rows.
     */
    private DefaultMutableWorld createWorld(final int rows,
                                            final int columns,
                                            final WorldBounds bounds,
                                            final EntityFactory factory,
                                            final List<String> contents)
        throws TooFewRowsException,
               TooManyRowsException,
               TooFewColumnsException,
               TooManyColumnsException,
               ShortRowException,
               LongRowException,
               UnknownEntityTypeException,
               MissingRowsException,
               ExtraRowsException
    {
        final DefaultMutableWorld world;

        world = new DefaultMutableWorld(rows,
                                        columns,
                                        bounds);
        if(rows < contents.size())
        {
            throw new ExtraRowsException(rows,
                                         contents.size());
        }

        if(rows > contents.size())
        {
            throw new MissingRowsException(rows,
                                           contents.size());
        }

        world.init();

        fillInWorld(columns,
                    contents,
                    factory,
                    world);

        return (world);
    }

    /**
     * Place the entities found in the contents onto the world.
     *
     * @param columns  the number of columns in the world.
     * @param contents the data lines of the world.
     * @param factory  used to create entities.
     * @param world    the world to place the entities on.
     *
     * @throws ShortRowException          thrown if there are too few entities on a row.
     * @throws LongRowException           thrown if there are too many entities on a row.
     * @throws UnknownEntityTypeException thrown if the data has an unknown entity type.
     */
    private void fillInWorld(final int columns,
                             final List<String> contents,
                             final EntityFactory factory,
                             final MutableWorld world)
        throws ShortRowException,
               LongRowException,
               UnknownEntityTypeException
    {
        int row;

        row = 0;

        for(final String line : contents)
        {
            int column;

            column = 0;

            if(columns > line.length())
            {
                throw new ShortRowException(row,
                                            columns,
                                            line.length());
            }

            if(columns < line.length())
            {
                throw new LongRowException(row,
                                           columns,
                                           line.length());
            }

            for(final char entityChar : line.toCharArray())
            {
                final Location location;
                final Entity entity;

                location = Location.create(row,
                                           column,
                                           world);
                entity = factory.createEntity(entityChar,
                                              location);

                if(entity != null)
                {
                    final MutableTile tile;

                    tile = world.getTileAt(location);
                    tile.addEntity(entity);
                }

                column++;
            }

            row++;
        }
    }

    /**
     * Open the data source.
     *
     * @param worldName the name of the world.
     *
     * @throws EmptyDataException       if there is no data in the data source.
     * @throws WorldDataSourceException if there is a problem with the data source.
     */
    protected abstract void openWorldData(String worldName)
        throws EmptyDataException,
               WorldDataSourceException;

    /**
     * Close the data source.
     *
     * @param worldName the name of the world.
     */
    protected abstract void closeWorldData(String worldName);

    /**
     * Get the number of rows on the world.
     *
     * @param worldName the name of the world.
     *
     * @return the number of rows on the word.
     *
     * @throws RowsNotIntegerException if the rows is not an integer.
     */
    protected abstract int getNumberOfRows(String worldName)
        throws RowsNotIntegerException;

    /**
     * Get the number of columns on the world.
     *
     * @param worldName the name of the world.
     *
     * @return the number of columns on the word.
     *
     * @throws ColumnsNotIntegerException if the column is not an integer.
     */
    protected abstract int getNumberOfColumns(String worldName)
        throws ColumnsNotIntegerException;

    /**
     * Get the lines that represent the entities on the world.
     *
     * @param worldName the name of the world.
     *
     * @return the lines that represent the entities on the world.
     *
     * @throws DecompressionException - decompression error.
     */
    protected abstract List<String> getWorldContents(String worldName)
        throws DecompressionException;

}
