package ca.bcit.cst.comp2526.assign6.solution.worldreader;


/**
 * Thrown when a rows has too many entities in world data.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public class LongRowException
    extends RowSizeException
{
    /**
     * Constant serialized ID used for compatibility.
     */
    private static final long serialVersionUID = 0;
    
    /**
     * Construct an LongRowException with the specified data.
     * 
     * @param r        the row.
     * @param expected the expected number of columns.
     * @param actual   the actual number of columns.
     */
    public LongRowException(final int r,
                            final int expected,
                            final int actual)
    {
        super("many",
              r,
              expected,
              actual);
    }
}