package ca.bcit.cst.comp2526.assign6.solution.worldreader;


/**
 * Thrown when there are not enough rows in world data.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public class MissingRowsException
    extends NumberOfRowsException
{
    /**
     * Constant serialized ID used for compatibility.
     */
    private static final long serialVersionUID = 0;

    /**
     * Construct a MissingRowsException with the specified message.
     * 
     * @param required the number of rows required.
     * @param actual   the actual number of rows provided.
     */
    public MissingRowsException(final int required,
                                final int actual)
    {
        super("few",
              required,
              actual);
    }
}
