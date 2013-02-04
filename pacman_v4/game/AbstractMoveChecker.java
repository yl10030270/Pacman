/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign4.solution.game;


import ca.bcit.cst.comp2526.assign4.solution.Dimension;
import ca.bcit.cst.comp2526.assign4.solution.Direction;
import ca.bcit.cst.comp2526.assign4.solution.Rectangle;
import ca.bcit.cst.comp2526.assign4.solution.Tile;


/**
 * Check to see if an entity can move to a particular tile.
 *
 * @param <T> - The type of game being played.
 * @param <E> - The type of the moving entity.
 *
 * @author leon
 * @version 1.0
 */
public abstract class AbstractMoveChecker<T extends Game, E extends MovableEntity<T, E>>
    implements MoveChecker<T, E>
{
    /**
     * Check to see if the entity can move to the tile.
     *
     * @param movingEntity - the entity that is moving to the tile.
     * @param tile         - the tile being moved to.
     * @param dimension    - the distance and direction to the tile from where the entity is moving from.
     * @param direction    - the direction that the entity is currently traveling.
     *
     * @return true if the entity can move to the tile, false if it cannot.
     */
    @Override
    public final boolean canMoveTo(final E movingEntity,
                                   final Tile tile,
                                   final Dimension dimension,
                                   final Direction direction)
    {
        if(movingEntity == null)
        {
            throw new IllegalArgumentException("movingEntity cannot be null");
        }
        if(tile == null)
        {
            throw new IllegalArgumentException("tile cannot be null");
        }
        if(dimension == null)
        {
            throw new IllegalArgumentException("dimension cannot be null");
        }
        if(direction == null)
        {
            throw new IllegalArgumentException("direction cannot be null");
        }
        final Rectangle fromworld = movingEntity.getLocation().getRectangle();
        final Rectangle toworld = tile.getLocation().getRectangle();
        boolean retval = false;


        if(canMoveToThatRectangle(fromworld, toworld) && direction == dimension.getStrictDirection())
        {
            retval = (canMoveInThatDirection(movingEntity, dimension, direction) &&
                canMoveThatDistance(movingEntity, dimension, direction) &&
                canMoveToThatTile(movingEntity, tile, dimension, direction));
        }

        return retval;
    }

    /**
     * Can the entity move from one world to another?
     *
     * @param toRectangle   - the world being moved to.
     * @param fromRectengle - the world being moved from.
     *
     * @return true if the rectangles are the same, false otherwise.
     */
    protected boolean canMoveToThatRectangle(final Rectangle toRectangle,
                                             final Rectangle fromRectengle)
    {
        return (toRectangle.equals(fromRectengle));
    }

    /**
     *
     * Can the entity move to the tile from the specified direction.
     *
     * @param movingEntity - the entity that is moving to the tile.
     * @param dimension    - the distance and direction to the tile from where the entity is moving from.
     * @param direction    - the direction that the entity is currently traveling.
     *
     * @return true if the entity move to the tile from the specified direction, false if it cannot.
     */
    protected abstract boolean canMoveInThatDirection(E movingEntity,
                                                      Dimension dimension,
                                                      Direction direction);

    /**
     * Can the entity move to the tile given that it is that far away?.
     *
     * @param movingEntity - the entity that is moving to the tile.
     * @param dimension    - the distance and direction to the tile from where the entity is moving from.
     * @param direction    - the direction that the entity is currently traveling.
     *
     * @return true if the entity move to the tile given that it is that far away, false otherwise.
     */
    protected abstract boolean canMoveThatDistance(E movingEntity,
                                                   Dimension dimension,
                                                   Direction direction);

    /**
     * Can the entity move to the tile given given any other criteria on top of the other canXXX methods.
     *
     * @param movingEntity - the entity that is moving to the tile.
     * @param tile         - the tile being moved to.
     * @param dimension    - the distance and direction to the tile from where the entity is moving from.
     * @param direction    - the direction that the entity is currently traveling.
     *
     * @return if the entity can move, false otherwise.
     */
    protected abstract boolean canMoveToThatTile(E movingEntity,
                                                 Tile tile,
                                                 Dimension dimension,
                                                 Direction direction);

}
