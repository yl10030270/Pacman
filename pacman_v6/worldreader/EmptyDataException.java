package ca.bcit.cst.comp2526.assign6.solution.worldreader;


/**
 * Thrown when there is no data in the word data source.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public class EmptyDataException
    extends WorldDataException
{
    /**
     * Constant serialized ID used for compatibility.
     */
    private static final long serialVersionUID = 0;

    /**
     * Construct an EmptyDataException.
     * 
     */
    public EmptyDataException()
    {
        super("World is empty");
    }
}