package ca.bcit.cst.comp2526.assign4.solution.worldreader;


/**
 * Thrown when a rows has too few entities in world data.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public class ShortRowException
    extends RowSizeException
{
    /**
     * Construct an ShortRowException with the specified data.
     * 
     * @param r        the row.
     * @param expected the expected number of columns.
     * @param actual   the actual number of columns.
     */
    public ShortRowException(final int r,
                             final int expected,
                             final int actual)
    {
        super("few",
              r,
              expected,
              actual);
    }
}