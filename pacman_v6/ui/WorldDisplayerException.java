package ca.bcit.cst.comp2526.assign6.solution.ui;


/**
 * Thrown when there is an error with displaying thw world.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public class WorldDisplayerException
    extends Exception
{
    /**
     * Constant serialized ID used for compatibility.
     */
    private static final long serialVersionUID = 0;

    /**
     * Construct a WorldDisplayerException with the specified message.
     * 
     * @param msg the message.
     */
    public WorldDisplayerException(final String msg)
    {
        super(msg);
    }
    
    /**
     * Construct a WorldDisplayerException with the specified message and cause.
     * 
     * @param msg   the message.
     * @param cause the underlying exception.
     */
    public WorldDisplayerException(final String    msg, 
                                   final Throwable cause)
    {
        super(msg, cause);
    }
}
