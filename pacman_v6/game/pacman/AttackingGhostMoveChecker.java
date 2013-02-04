package ca.bcit.cst.comp2526.assign6.solution.game.pacman;


import ca.bcit.cst.comp2526.assign6.solution.Dimension;
import ca.bcit.cst.comp2526.assign6.solution.Direction;
import ca.bcit.cst.comp2526.assign6.solution.Entity;
import ca.bcit.cst.comp2526.assign6.solution.Tile;


/**
 * Check to see if the ghost can move to a new location.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public class AttackingGhostMoveChecker
    extends AbstractPacManGameMoveChecker<GhostEntity>
{
    /**
     * Can the ghost move in that direction (NORTH, SOUTH, EAST, WEST).
     * 
     * @param ghost     the ghost that is moving
     * @param dimension the distance and direction of the move.
     * @param direction the direction the ghost is moving already.
     * 
     * @return true if the ghost can move in the specified direction, false otherwise.
     */
    @Override
    protected boolean doCanMoveInThatDirection(final GhostEntity ghost,
                                               final Dimension   dimension,
                                               final Direction   direction)
    {
        final Direction strictDirection;
        final boolean   retVal;
        
        strictDirection = dimension.getStrictDirection();
        
        if(strictDirection.getOpposite().equals(direction))
        {
            retVal = false;
        }
        else
        {
            final Direction currentDirection;

            currentDirection = ghost.getCurrentDirection();
            retVal           = strictDirection.equals(direction) && !(currentDirection.getOpposite().equals(direction));
        }
        
        return (retVal);
    }

    /**
     * Can the ghost move to the specified tile?  (not a wall, and only north though the door).
     * 
     * @param ghost     the ghost that is moving
     * @param tile      the tile being moved to.
     * @param dimension the distance and direction of the move.
     * @param direction the direction the ghost is moving already.
     * 
     * @return true if the ghost can move to the specified tile, false otherwise.
     */
    @Override
    protected boolean doCanMoveToThatTile(final GhostEntity ghost,
                                          final Tile        tile,
                                          final Dimension   dimension,
                                          final Direction   direction)
    {
        final Entity    other;
        final boolean   retVal;

        other = tile.getEntity();
        
        if(other instanceof DoorEntity)
        {
            final Direction directionToTile;
            
            directionToTile = dimension.getStrictDirection();
        
            retVal = direction.equals(directionToTile) && direction.equals(Direction.NORTH);
        }
        else
        {
            retVal = true;
        }
        
        return (retVal);
    }
}
