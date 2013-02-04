/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign4.solution;


/**
 * A direction, like that found on a compass.
 *
 * @author leon
 */
public enum Direction
{
    /**
     * None.
     */
    NONE(0, 0),
    /**
     * North.
     */
    NORTH(0, -1),
    /**
     * NorthEast.
     */
    NORTH_EAST(1, -1),
    /**
     * East.
     */
    EAST(1, 0),
    /**
     * SouthEast.
     */
    SOUTH_EAST(1, 1),
    /**
     * South.
     */
    SOUTH(0, 1),
    /**
     * SouthWest.
     */
    SOUTH_WEST(-1, 1),
    /**
     * West.
     */
    WEST(-1, 0),
    /**
     * NorthWest.
     */
    NORTH_WEST(-1, -1);

    /**
     * The vertical value.
     */
    private final int vertical;

    /**
     * The horizontal value.
     */
    private final int horizontal;

    /**
     * Initialize the vertical and horizontal value of enum members.
     *
     * @param h - horizontal value.
     * @param v - vertical value.
     */
    private Direction(final int h,
                      final int v)
    {
        horizontal = h;
        vertical = v;
    }

    /**
     * Get the vertical distance.
     *
     * @return The vertical distance.
     */
    public int getVertical()
    {
        return vertical;
    }

    /**
     * Get the horizontal distance.
     *
     * @return horizontal distance.
     */
    public int getHorizontal()
    {
        return horizontal;
    }

    /**
     * Is it a cardinal (N, S, E, W) direction?
     *
     * @return true if it is a cardinal direction, false otherwise.
     */
    public boolean isCardinal()
    {
        return (vertical == 0 || horizontal == 0) && this != NONE;
    }

    /**
     * Get the opposite direction.
     *
     * @return The opposite direction.
     */
    public Direction getOpposite()
    {
        Direction reval;
        switch(this)
        {
            case NORTH:
                reval = SOUTH;
                break;
            case SOUTH:
                reval = NORTH;
                break;
            case EAST:
                reval = WEST;
                break;
            case WEST:
                reval = EAST;
                break;
            case NORTH_EAST:
                reval = SOUTH_WEST;
                break;
            case SOUTH_WEST:
                reval = NORTH_EAST;
                break;
            case NORTH_WEST:
                reval = SOUTH_EAST;
                break;
            case SOUTH_EAST:
                reval = NORTH_WEST;
                break;
            default:
                reval = NONE;
        }
        return reval;
    }

    /**
     * To get the Direction form its ordinal.
     *
     * @param ord - the ordinal of the Direction.
     *
     * @return the Direction
     */
    private Direction reOrdinal(final int ord)
    {
        return values()[ord];
    }

    /**
     * Get the next direction going clockwise.
     *
     * @return The next direction going clockwise.
     */
    public Direction getClockwise()
    {
        Direction retval;
        final int ord = ordinal();
        if(ord == 0)
        {
            retval = NONE;
        }
        else
        {
            retval = reOrdinal(ord % NORTH_WEST.ordinal() + 1);
        }
        return retval;
    }

    /**
     * Get the next cardinal direction going clockwise.
     *
     * @return The next cardinal direction going clockwise.
     */
    public Direction getClockwiseCardinal()
    {

        Direction next;
        next = this.getClockwise();
        return (next.isCardinal()) ?
               next :
               next.getClockwise();
    }

    /**
     * Get the next direction going counter-clockwise.
     *
     * @return The next direction going counter-clockwise.
     */
    public Direction getCounterClockwise()
    {
        Direction retval;
        final int ord = ordinal();
        if(ord == 0)
        {
            retval = NONE;
        }
        else if(ord == 1)
        {
            retval = NORTH_WEST;
        }
        else
        {
            retval = reOrdinal(ord - 1);
        }
        return retval;
    }

    /**
     * Get the next cardinal direction going counter-clockwise.
     *
     * @return The next cardinal direction going counter-clockwise.
     */
    public Direction getCounterClockwiseCardinal()
    {
        Direction next;
        next = this.getCounterClockwise();
        return (next.isCardinal()) ?
               next :
               next.getCounterClockwise();
    }

    /**
     * Get the nearest horizontal direction.
     *
     * @return The nearest horizontal direction.
     */
    public Direction getNearestHorizontal()
    {
        Direction retval = null;
        if(ordinal() == 0)
        {
            retval = NONE;
        }
        else
        {
            final int hor = getHorizontal();
            if(hor > 0)
            {
                retval = EAST;
            }
            if(hor < 0)
            {
                retval = WEST;
            }
        }
        return retval;
    }

    /**
     * Get the nearest vertical direction.
     *
     * @return The nearest horizontal direction.
     */
    public Direction getNearestVertical()
    {
        Direction retval = null;
        if(ordinal() == 0)
        {
            retval = NONE;
        }
        else
        {
            final int ver = getVertical();
            if(ver > 0)
            {
                retval = SOUTH;
            }
            if(ver < 0)
            {
                retval = NORTH;
            }
        }
        return retval;
    }

}