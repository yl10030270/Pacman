package ca.bcit.cst.comp2526.assign6.solution;


/**
 * A distance and direction from one location to another location.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public final class Dimension
{
    /**
     * The distance between the rows.
     */
    private final int rowDistance;

    /**
     * The distance between the columns.
     */
    private final int columnDistance;

    /**
     * The direction between the locations, may be null.
     */
    private final Direction direction;

    /**
     * The general non-cardinal direction between the locations, may be null.
     */
    private final Direction generalDirection;

    /**
     * The closest direction between the locations, may be null.
     */
    private final Direction closestDirection;
    
    /**
     * Construct a Dimension between the specified points.
     * 
     * @param fromLocation the location to start from.
     * @param toLocation the location to end at.
     */
    public Dimension(final Location fromLocation,
                     final Location toLocation)
    {
        if(fromLocation == null)
        {
            throw new IllegalArgumentException("fromLocation cannot be null");
        }
        
        if(toLocation == null)
        {
            throw new IllegalArgumentException("toLocation cannot be null");
        }
        
        rowDistance    = toLocation.getRow()    - fromLocation.getRow();
        columnDistance = toLocation.getColumn() - fromLocation.getColumn();

        // not moving at all
        if(rowDistance == 0 && columnDistance == 0)
        {
            direction        = Direction.NONE;
            generalDirection = Direction.NONE;
            closestDirection = Direction.NONE;
        }
        else
        {
            final Direction baseDirection;
                        
            // North Westish
            if(rowDistance <= 0 && columnDistance <= 0)
            {
                baseDirection = Direction.NORTH_WEST;
            }
            // North Eastish
            else if(rowDistance <= 0 && columnDistance >= 0)
            {
                baseDirection = Direction.NORTH_EAST;
            }
            // South Westish
            else if(rowDistance >= 0 && columnDistance <= 0)
            {
                baseDirection = Direction.SOUTH_WEST;
            }
            // South Eastish
            else
            {
                baseDirection = Direction.SOUTH_EAST;
            }
            
            final int vertical;
            final int horizontal;
            final int diagonal;
            final int absoluteDifference;
            
            absoluteDifference = Math.abs(Math.abs(rowDistance) - Math.abs(columnDistance));
            
            if(absoluteDifference == 0)
            {
                direction        = baseDirection;                               // NW, NE, SW, SE
                generalDirection = baseDirection;                               // NW, NE, SW, SE
            }
            else if(rowDistance == 0)
            {
                direction        = baseDirection.getNearestHorizontal();        // W, E, W, E
                generalDirection = baseDirection.getNearestHorizontal();        // W, E, W, E
            }
            else if(columnDistance == 0)
            {
                direction        = baseDirection.getNearestVertical();          // N, N, S, S
                generalDirection = baseDirection.getNearestVertical();          // N, N, S, S
            }
            else
            {
                direction        = null;
                generalDirection = baseDirection;                               // NW, NE, SW, SE
            }

            vertical   = Math.abs(columnDistance);
            horizontal = Math.abs(rowDistance);
            diagonal   = Math.abs(Math.max(horizontal, vertical) - Math.min(horizontal, vertical));

            if(diagonal < horizontal && diagonal < vertical)
            {
                closestDirection = baseDirection;                                // NW, NE, SW, SE
            }
            else if(horizontal < diagonal && horizontal < vertical)
            {
                closestDirection = baseDirection.getNearestHorizontal();        // W, E, W, E
            }
            else if(vertical < diagonal && vertical < horizontal)
            {
                closestDirection = baseDirection.getNearestVertical();          // N, N, S, S
            }
            else
            {
                closestDirection = null;
            }
        }
    }
    
    /**
     * Get the distance between the rows.
     * 
     * @return The distance between the rows.
     */
    public int getRowDistance()
    {
        return (rowDistance);
    }
    
    /**
     * Get the distance between the columns.
     * 
     * @return The distance between the columns.
     */
    public int getColumnDistance()
    {
        return (columnDistance);
    }
    
    /**
     * Get the absolute distance between the rows.
     * 
     * @return The absolute distance between the rows.
     */
    public int getAbsoluteRowDistance()
    {
        return (Math.abs(rowDistance));
    }
    
    /**
     * Get the absolute distance between the columns.
     * 
     * @return The absolute distance between the columns.
     */
    public int getAbsoluteColumnDistance()
    {
        return (Math.abs(columnDistance));
    }
    
    /**
     * Get the direction between the locations.
     * 
     * @return The direction between the locations, may be null.
     */
    public Direction getStrictDirection()
    {
        return (direction);
    }
    
    /**
     * Get the general (non-cardinal) direction between the locations.
     * 
     * @return The general (non-cardinal) direction between the locations, may be null.
     */
    public Direction getGeneralDirection()
    {        
        return (generalDirection);
    }
        
    /**
     * Get the closest direction between the locations.
     * 
     * @return The closest direction between the locations, may be null.
     */
    public Direction getClosestDirection()
    {        
        return (closestDirection);
    }
}
