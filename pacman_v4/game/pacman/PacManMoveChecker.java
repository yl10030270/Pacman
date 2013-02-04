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
 * Check the moves for Pac Man.
 *
 * @author Leon
 * @version 1.0
 */
public class PacManMoveChecker
    extends AbstractMoveChecker<PacManGame, PacManEntity>
{
    /**
     *
     * Can Pac Man move in that direction (NORTH, SOUTH, EAST, WEST).
     *
     * @param pacman    - the pacman that is moving
     * @param dimension - the distance and direction of the move.
     * @param direction - the direction the Pacman is moving already.
     *
     * @return true if pacman can move in the specified direction, false otherwise.
     */
    @Override
    protected boolean canMoveInThatDirection(final PacManEntity pacman,
                                             final Dimension dimension,
                                             final Direction direction)
    {
        return direction == dimension.getStrictDirection();
    }

    /**
     * Can the pacman move that far away? (1 square only)
     *
     * @param pacman    - the pacman that is moving
     * @param dimension - the distance and direction of the move.
     * @param direction - the direction the ghost is moving already.
     *
     * @return true if pacman can move in the specified distance, false otherwise.
     */
    @Override
    protected boolean canMoveThatDistance(final PacManEntity pacman,
                                          final Dimension dimension,
                                          final Direction direction)
    {
        final int x = dimension.getAbsoluteColumnDistance();
        final int y = dimension.getAbsoluteRowDistance();
        return Math.sqrt((double)x * x + y * y) == 1;
    }

    /**
     * Can the pacman move to the specified tile?
     *
     * @param pacman    - the pacman that is moving
     * @param tile      - the tile being moved to.
     * @param dimension - the distance and direction of the move.
     * @param direction - the direction the ghost is moving already.
     *
     * @return true if pacman can move to the specified tile, false otherwise.
     */
    @Override
    protected boolean canMoveToThatTile(final PacManEntity pacman,
                                        final Tile tile,
                                        final Dimension dimension,
                                        final Direction direction)
    {
        final Entity tmpEntity = tile.getEntity();
        final boolean retval;

        if(WallEntity.class.isInstance(tmpEntity) || tmpEntity instanceof InvisibleWallEntity ||
            tmpEntity instanceof DoorEntity)
        {
            retval = false;
        }
        else
        {
            retval = true;
        }

        return retval;

    }

}
