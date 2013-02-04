package ca.bcit.cst.comp2526.assign6.solution;


/**
 * Thrown when there is an error with the world data.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public abstract class InvalidWorldException
    extends Exception
{
    /**
     * Construct an InvalidWorldException with the specified message.
     * 
     * @param msg the message describing the error.
     */
    protected InvalidWorldException(final String msg)
    {
        super(msg);
    }
    
    /**
     * Construct an InvalidWorldException with the specified message and cause.
     * 
     * @param msg the message describing the error.
     * @param cause the root cause of the error.
     */
    protected InvalidWorldException(final String    msg,
                                    final Throwable cause)
    {
        super(msg,
              cause);
    }
}