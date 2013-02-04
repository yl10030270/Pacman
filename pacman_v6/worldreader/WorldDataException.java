package ca.bcit.cst.comp2526.assign6.solution.worldreader;

import ca.bcit.cst.comp2526.assign6.solution.InvalidWorldException;


/**
 * Thrown when there is an error with the world data.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public class WorldDataException
    extends InvalidWorldException
{
    /**
     * Constant serialized ID used for compatibility.
     */
    private static final long serialVersionUID = 0;
    
    /**
     * Construct a WorldDataException with the specified message.
     * 
     * @param msg the message describing the error.
     */
    protected WorldDataException(final String msg)
    {
        super(msg);
    }
    
    /**
     * Construct a WorldDataException with the specified message.
     * 
     * @param msg the message describing the error.
     * @param cause  
     */
    protected WorldDataException(final String    msg,
                                 final Throwable cause)
    {
        super(msg,
              cause);
    }
}
