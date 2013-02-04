package ca.bcit.cst.comp2526.assign6.solution.worldreader;


import ca.bcit.cst.comp2526.assign6.solution.Location;


/**
 * Thrown when there is an unknown entity type in the world data.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public class UnknownEntityTypeException
    extends WorldDataException
{
    /**
     * Constant serialized ID used for compatibility.
     */
    private static final long serialVersionUID = 0;
    
    /**
     * The character representing the entity.
     */
    private final char key;
    
    /**
     * The row of the entity.
     */
    private final int row;
    
    /**
     * The column of the entity.
     */
    private final int column;
    
    /**
     * Construct an UnknownEntityTypeException with the specified data.
     * 
     * @param c        the type of entity requested.
     * @param location the location of the entity.
     */
    public UnknownEntityTypeException(final char     c,
                                      final Location location)
    {
        super("Unknown entity type \"" + c + "\" @ " + location);
        
        key    = c;
        row    = location.getRow();
        column = location.getColumn();
    }
    
    /**
     * Get the character representing the entity.
     * 
     * @return character representing the entity.
     */
    public char getKey()
    {
        return (key);
    }
    
    /**
     * Get the row that the unknown entity is on.
     * 
     * @return the row that the unknown entity is on.
     */
    public int getRow()
    {
        return (row);
    }
    
    /**
     * Get the column that the unknown entity is on.
     * 
     * @return the column that the unknown entity is on.
     */
    public int getColumn()
    {
        return (column);
    }
}