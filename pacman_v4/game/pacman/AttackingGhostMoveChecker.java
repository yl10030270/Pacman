/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign4.solution.game.pacman;


import ca.bcit.cst.comp2526.assign4.solution.Dimension;
import ca.bcit.cst.comp2526.assign4.solution.Direction;
import ca.bcit.cst.comp2526.assign4.solution.Entity;
import ca.bcit.cst.comp2526.assign4.solution.Tile;
import ca.bcit.cst.comp2526.assign4.solution.WallEntity;
import ca.bcit.cst.comp2526.assign4.solution.game.AbstractMoveChecker;


/**
 * Check to see if the ghost can move to a new location.
 *
 * @author Leon
 * @version 1.0
 */
public class AttackingGhostMoveChecker
    extends AbstractMoveChecker<PacManGame, GhostEntity>
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
    protected boolean canMoveInThatDirection(final GhostEntity ghost,
                                             final Dimension dimension,
                                             final Direction direction)
    {
        final Direction directionToTile;
        final boolean retVal;

        directionToTile = dimension.getStrictDirection();

        if(directionToTile == null)
        {
            retVal = false;
        }
        else if(directionToTile.isCardinal())
        {
            if(directionToTile.getOpposite().equals(direction))
            {
                retVal = false;
            }
            else
            {
                final Direction currentDirection;

                currentDirection = ghost.getCurrentDirection();
                retVal = directionToTile.equals(direction) && !(currentDirection.getOpposite().equals(direction));
            }
        }
        else
        {
            retVal = false;
        }

        return (retVal);
    }

    /**
     * Can the ghost move that far away? (1 square only)
     *
     * @param ghost     - the ghost that is moving
     * @param dimension - the distance and direction of the move.
     * @param direction - the direction the ghost is moving already.
     *
     * @return true if the ghost can move in the specified distance, false otherwise.
     */
    @Override
    protected boolean canMoveThatDistance(final GhostEntity ghost,
                                          final Dimension dimension,
                                          final Direction direction)
    {
        final int x = dimension.getAbsoluteColumnDistance();
        final int y = dimension.getAbsoluteRowDistance();
        return Math.sqrt((double)x * x + y * y) == 1;
        //        if(dimension.getStrictDirection() == Direction.NORTH || dimension.getStrictDirection() == Direction.SOUTH)
        //        {
        //            retval = (dimension.getAbsoluteRowDistance() == 1);
        //        }
        //        else
        //        {
        //            retval = (dimension.getAbsoluteColumnDistance() == 1);
        //        }
    }

    /**
     * Can the ghost move to the specified tile? (not a wall, and only north though the door).
     *
     * @param ghost     - the ghost that is moving
     * @param tile      - the tile being moved to.
     * @param dimension - the distance and direction of the move.
     * @param direction - the direction the ghost is moving already.
     *
     * @return true if the ghost can move to the specified tile, false otherwise.
     */
    @Override
    protected boolean canMoveToThatTile(final GhostEntity ghost,
                                        final Tile tile,
                                        final Dimension dimension,
                                        final Direction direction)
    {
        final Entity tmpEntity = tile.getEntity();
        final boolean retval;

        if(WallEntity.class.isInstance(tmpEntity) || tmpEntity instanceof InvisibleWallEntity)
        {
            retval = false;
        }
        else if(tmpEntity instanceof DoorEntity)
        {
            retval = (dimension.getStrictDirection() == Direction.NORTH && direction == Direction.NORTH);
        }
        else
        {
            retval = true;
        }

        return retval;
    }

}
