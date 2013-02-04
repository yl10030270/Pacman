package ca.bcit.cst.comp2526.assign6.solution.worldreader;


/**
 * Thrown when there are too many rows in world data.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public class ExtraRowsException
    extends NumberOfRowsException
{
    /**
     * Constant serialized ID used for compatibility.
     */
    private static final long serialVersionUID = 0;

    /**
     * Construct an ExtraRowsException with the specified message.
     * 
     * @param required the number of rows required.
     * @param actual   the actual number of rows provided.
     */
    public ExtraRowsException(final int required,
                              final int actual)
    {
        super("many",
              required,
              actual);
    }
}