package ca.bcit.cst.comp2526.assign4.solution.worldreader;


/**
 * Thrown when there is an error with the world data source.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public class WorldDataSourceException
    extends WorldDataException
{
    /**
     * Construct an WorldDataSourceException with the specified message.
     * 
     * @param ex 
     */
    public WorldDataSourceException(final Throwable ex)
    {
        super("Error reading world data",
              ex);
    }
}