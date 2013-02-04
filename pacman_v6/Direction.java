package ca.bcit.cst.comp2526.assign6.solution;


/**
 * A direction, like that found on a compass.
 *
 * @author D'Arcy Smith
 * @version 1.0
 */
public enum Direction
{
    /**
     *
     */
    NONE(0, 0, false),
    /**
     * North.
     */
    NORTH(-1, 0, true),
    /**
     * Nort East.
     */
    NORTH_EAST(-1, 1, false),
    /**
     * East.
     */
    EAST(0, 1, true),
    /**
     * South East.
     */
    SOUTH_EAST(1, 1, false),
    /**
     * South.
     */
    SOUTH(1, 0, true),
    /**
     * South West.
     */
    SOUTH_WEST(1, -1, false),
    /**
     * West.
     */
    WEST(0, -1, true),
    /**
     * North West.
     */
    NORTH_WEST(-1, -1, false);

    /**
     * The vertical distance.
     */
    private final int vertical;

    /**
     * The horizontal distance.
     */
    private final int horizontal;

    /**
     * Is it a cardinal direction (N, S, E, W)?
     */
    private final boolean cardinal;

    /**
     * For exception message.
     */
    private static final String UNKOWN_DIRECTION = "Unknown direction ";

    /**
     * Construct a dimension with the specified values.
     *
     * @param v the vertical (rows) distance.
     * @param h the horizontal (columns) distance.
     * @param c is it a cardinal direction?
     */
    private Direction(final int v,
                      final int h,
                      final boolean c)
    {
        vertical = v;
        horizontal = h;
        cardinal = c;
    }

    /**
     * Get the vertical distance.
     *
     * @return The vertical distance.
     */
    public int getVertical()
    {
        return (vertical);
    }

    /**
     * Get the horizontal distance.
     *
     * @return The horizontal distance.
     */
    public int getHorizontal()
    {
        return (horizontal);
    }

    /**
     * Is it a cardinal (N, S, E, W) direction?
     *
     * @return true if it i a cardinal direction, false otherwide.
     */
    public boolean isCardinal()
    {
        return (cardinal);
    }

    /**
     * Get the opposite direction.
     *
     * @return The opposite direction.
     */
    public Direction getOpposite()
    {
        final Direction opposite;

        switch(this)
        {
            case NORTH:
            {
                opposite = Direction.SOUTH;
                break;
            }
            case NORTH_EAST:
            {
                opposite = Direction.SOUTH_WEST;
                break;
            }
            case EAST:
            {
                opposite = Direction.WEST;
                break;
            }
            case SOUTH_EAST:
            {
                opposite = Direction.NORTH_WEST;
                break;
            }
            case SOUTH:
            {
                opposite = Direction.NORTH;
                break;
            }
            case SOUTH_WEST:
            {
                opposite = Direction.NORTH_EAST;
                break;
            }
            case WEST:
            {
                opposite = Direction.EAST;
                break;
            }
            case NORTH_WEST:
            {
                opposite = Direction.SOUTH_EAST;
                break;
            }
            case NONE:
            {
                opposite = NONE;
                break;
            }
            default:
            {
                throw new IllegalStateException(UNKOWN_DIRECTION + this);
            }
        }

        return (opposite);
    }

    /**
     * Get the next direction going clockwise.
     *
     * @return The next direction going clockwise.
     */
    public Direction getClockwise()
    {
        final Direction next;

        switch(this)
        {
            case NORTH:
            {
                next = Direction.NORTH_EAST;
                break;
            }
            case NORTH_EAST:
            {
                next = Direction.EAST;
                break;
            }
            case EAST:
            {
                next = Direction.SOUTH_EAST;
                break;
            }
            case SOUTH_EAST:
            {
                next = Direction.SOUTH;
                break;
            }
            case SOUTH:
            {
                next = Direction.SOUTH_WEST;
                break;
            }
            case SOUTH_WEST:
            {
                next = Direction.WEST;
                break;
            }
            case WEST:
            {
                next = Direction.NORTH_WEST;
                break;
            }
            case NORTH_WEST:
            {
                next = Direction.NORTH;
                break;
            }
            case NONE:
            {
                next = NONE;
                break;
            }
            default:
            {
                throw new IllegalStateException(UNKOWN_DIRECTION + this);
            }
        }

        return (next);
    }

    /**
     * Get the next cardinal direction going clockwise.
     *
     * @return The next cardinal direction going clockwise.
     */
    public Direction getClockwiseCardinal()
    {
        final Direction next;

        switch(this)
        {
            case NORTH:
            {
                next = Direction.EAST;
                break;
            }
            case NORTH_EAST:
            {
                next = Direction.EAST;
                break;
            }
            case EAST:
            {
                next = Direction.SOUTH;
                break;
            }
            case SOUTH_EAST:
            {
                next = Direction.SOUTH;
                break;
            }
            case SOUTH:
            {
                next = Direction.WEST;
                break;
            }
            case SOUTH_WEST:
            {
                next = Direction.WEST;
                break;
            }
            case WEST:
            {
                next = Direction.NORTH;
                break;
            }
            case NORTH_WEST:
            {
                next = Direction.NORTH;
                break;
            }
            case NONE:
            {
                next = NONE;
                break;
            }
            default:
            {
                throw new IllegalStateException(UNKOWN_DIRECTION + this);
            }
        }

        return (next);
    }

    /**
     * Get the next direction going counter-clockwise.
     *
     * @return The next direction going counter-clockwise.
     */
    public Direction getCounterClockwise()
    {
        final Direction next;

        switch(this)
        {
            case NORTH:
            {
                next = Direction.NORTH_WEST;
                break;
            }
            case NORTH_EAST:
            {
                next = Direction.NORTH;
                break;
            }
            case EAST:
            {
                next = Direction.NORTH_EAST;
                break;
            }
            case SOUTH_EAST:
            {
                next = Direction.EAST;
                break;
            }
            case SOUTH:
            {
                next = Direction.SOUTH_EAST;
                break;
            }
            case SOUTH_WEST:
            {
                next = Direction.SOUTH;
                break;
            }
            case WEST:
            {
                next = Direction.SOUTH_WEST;
                break;
            }
            case NORTH_WEST:
            {
                next = Direction.WEST;
                break;
            }
            case NONE:
            {
                next = NONE;
                break;
            }
            default:
            {
                throw new IllegalStateException(UNKOWN_DIRECTION + this);
            }
        }

        return (next);
    }

    /**
     * Get the next cardinal direction going counter-clockwise.
     *
     * @return The next cardinal direction going counter-clockwise.
     */
    public Direction getCounterClockwiseCardinal()
    {
        final Direction next;

        switch(this)
        {
            case NORTH:
            {
                next = Direction.WEST;
                break;
            }
            case NORTH_EAST:
            {
                next = Direction.NORTH;
                break;
            }
            case EAST:
            {
                next = Direction.NORTH;
                break;
            }
            case SOUTH_EAST:
            {
                next = Direction.EAST;
                break;
            }
            case SOUTH:
            {
                next = Direction.EAST;
                break;
            }
            case SOUTH_WEST:
            {
                next = Direction.SOUTH;
                break;
            }
            case WEST:
            {
                next = Direction.SOUTH;
                break;
            }
            case NORTH_WEST:
            {
                next = Direction.WEST;
                break;
            }
            case NONE:
            {
                next = NONE;
                break;
            }
            default:
            {
                throw new IllegalStateException(UNKOWN_DIRECTION + this);
            }
        }

        return (next);
    }

    /**
     * Get the nearest horizontal direction.
     *
     * @return The nearest horizontal direction.
     */
    public Direction getNearestHorizontal()
    {
        final Direction nearest;

        switch(this)
        {
            case NORTH:
            {
                nearest = null;
                break;
            }
            case NORTH_EAST:
            {
                nearest = Direction.EAST;
                break;
            }
            case EAST:
            {
                nearest = Direction.EAST;
                break;
            }
            case SOUTH_EAST:
            {
                nearest = Direction.EAST;
                break;
            }
            case SOUTH:
            {
                nearest = null;
                break;
            }
            case SOUTH_WEST:
            {
                nearest = Direction.WEST;
                break;
            }
            case WEST:
            {
                nearest = Direction.WEST;
                break;
            }
            case NORTH_WEST:
            {
                nearest = Direction.WEST;
                break;
            }
            case NONE:
            {
                nearest = NONE;
                break;
            }
            default:
            {
                throw new IllegalStateException(UNKOWN_DIRECTION + this);
            }
        }

        return (nearest);
    }

    /**
     * Get the nearest vertical direction.
     *
     * @return The nearest horizontal direction.
     */
    public Direction getNearestVertical()
    {
        final Direction nearest;

        switch(this)
        {
            case NORTH:
            {
                nearest = Direction.NORTH;
                break;
            }
            case NORTH_EAST:
            {
                nearest = Direction.NORTH;
                break;
            }
            case EAST:
            {
                nearest = null;
                break;
            }
            case SOUTH_EAST:
            {
                nearest = Direction.SOUTH;
                break;
            }
            case SOUTH:
            {
                nearest = Direction.SOUTH;
                break;
            }
            case SOUTH_WEST:
            {
                nearest = Direction.SOUTH;
                break;
            }
            case WEST:
            {
                nearest = null;
                break;
            }
            case NORTH_WEST:
            {
                nearest = Direction.NORTH;
                break;
            }
            case NONE:
            {
                nearest = NONE;
                break;
            }
            default:
            {
                throw new IllegalStateException(UNKOWN_DIRECTION + this);
            }
        }

        return (nearest);
    }

}
