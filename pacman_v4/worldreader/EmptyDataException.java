package ca.bcit.cst.comp2526.assign4.solution.worldreader;


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
     * Construct an EmptyDataException.
     * 
     */
    public EmptyDataException()
    {
        super("World is empty");
    }
}