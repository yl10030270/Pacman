package ca.bcit.cst.comp2526.assign4.solution;


/**
 * A location (row/column) on a rectangle.
 *
 * @author D'Arcy Smith
 * @version 1.0
 */
public final class Location
{
    /**
     * The row of the world.
     */
    private final int row;

    /**
     * The column of the world.
     */
    private final int column;

    /**
     * The size of the world.
     */
    private final Rectangle rectangle;

    /**
     * The hashCode value.
     */
    private final int hashCodeValue;

    /**
     * Construct a Location with the specified row and column on the specified world.
     *
     * @param r    the row.
     * @param c    the column.
     * @param rect the size of the world.
     */
    private Location(final int r,
                     final int c,
                     final Rectangle rect)
    {
        rectangle = rect;
        checkBounds("row",
                    r,
                    0,
                    rect.getNumberOfRows() - 1);
        checkBounds("column",
                    c,
                    0,
                    rect.getNumberOfColumns() - 1);
        row = r;
        column = c;
        hashCodeValue = ((row * (rect.getNumberOfRows() - 1)) + row) + column;
    }

    /**
     * Create a location with the specified row/col bounded by the world.
     *
     * @param row       the row of the location.
     * @param column    the column of the location.
     * @param rectangle the size of the area.
     *
     * @return the location.
     */
    public static Location create(final int row,
                                  final int column,
                                  final Rectangle rectangle)
    {
        final Location location;

        if(rectangle == null)
        {
            throw new IllegalArgumentException("bounds cannot be null");
        }

        location = new Location(row,
                                column,
                                rectangle);

        return (location);
    }

    /**
     * Verify that the row or column is in the bounds of the rectangle.
     *
     * @param name   "row" or "column", used for the error message.
     * @param actual the actual value.
     * @param min    the smallest possible legal value.
     * @param max    the largest possible legal value.
     */
    private static void checkBounds(final String name,
                                    final int actual,
                                    final int min,
                                    final int max)
    {
        if(actual < min)
        {
            throw new IllegalArgumentException(name + " too low, was " + actual + " must be >= " + min);
        }

        if(actual > max)
        {
            throw new IllegalArgumentException(name + " too high, was " + actual + " must be <= " + max);
        }
    }

    /**
     * Get the row.
     *
     * @return the row,
     */
    public int getRow()
    {
        return (row);
    }

    /**
     * Get the column.
     *
     * @return the column,
     */
    public int getColumn()
    {
        return (column);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        return ("(" + row + ", " + column + ")");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj)
    {
        final boolean retVal;

        if(obj == null)
        {
            retVal = false;
        }
        else
        {
            if(getClass() == obj.getClass())
            {
                final Location other;

                other = (Location)obj;

                if(rectangle.getNumberOfRows() == other.rectangle.getNumberOfRows() &&
                    rectangle.getNumberOfColumns() == other.rectangle.getNumberOfColumns())
                {
                    retVal = ((row == other.row) && (column == other.column));
                }
                else
                {
                    retVal = false;
                }
            }
            else
            {
                retVal = false;
            }
        }

        return (retVal);
    }

    /**
     * Get the hash code. The formula is ((row * rows) + row) + column
     *
     * @return the hash code.
     */
    @Override
    public int hashCode()
    {
        return (hashCodeValue);
    }

    /**
     * Get the size of the area.
     *
     * @return the size of the area.
     */
    public Rectangle getRectangle()
    {
        return (rectangle);
    }

}
