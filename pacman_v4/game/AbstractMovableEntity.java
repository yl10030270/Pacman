/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign4.solution.game;


import ca.bcit.cst.comp2526.assign4.solution.AbstractEntity;
import ca.bcit.cst.comp2526.assign4.solution.Dimension;
import ca.bcit.cst.comp2526.assign4.solution.Direction;
import ca.bcit.cst.comp2526.assign4.solution.Entity;
import ca.bcit.cst.comp2526.assign4.solution.EntityData;
import ca.bcit.cst.comp2526.assign4.solution.Location;
import ca.bcit.cst.comp2526.assign4.solution.MutableTile;
import ca.bcit.cst.comp2526.assign4.solution.Tile;


/**
 * Convenience class for common movable entity features.
 *
 * @param <T> - The type of game being played.
 * @param <E> - The type of the moving entity.
 *
 * @author leon
 * @version 1.0
 */
public abstract class AbstractMovableEntity<T extends Game, E extends AbstractMovableEntity<T, E>>
    extends AbstractEntity
    implements MovableEntity<T, E>
{
    /**
     * the current direction.
     */
    private Direction currentDirection;

    /**
     * the desired direction.
     */
    private Direction desiredDirection;

    /**
     * checks to see if a move is valid or not.
     */
    private MoveChecker<T, E> moveChecker;

    /**
     * handles collisions with other entities.
     */
    private CollisionHandler<T, E> moveHandler;

    /**
     * Construct an AbstractEntity with the values.
     *
     * @param data    - the values used for the entity.
     * @param checker - checks to see if a move is valid or not.
     * @param handler - handles collisions with other entities.
     */
    protected AbstractMovableEntity(final EntityData data,
                                    final MoveChecker<T, E> checker,
                                    final CollisionHandler<T, E> handler)
    {
        super(data);
        if(checker == null)
        {
            throw new IllegalArgumentException("checker cannot be null");
        }
        if(handler == null)
        {
            throw new IllegalArgumentException("handler cannot be null");
        }
        currentDirection = Direction.NONE;
        desiredDirection = Direction.NONE;

        this.moveChecker = checker;
        this.moveHandler = handler;
    }

    /**
     * Set the current direction.
     *
     * @param d - the direction.
     */
    @Override
    public void setCurrentDirection(final Direction d)
    {
        currentDirection = d;
    }

    /**
     * Get the current direction.
     *
     * @return the current direction.
     */
    @Override
    public Direction getCurrentDirection()
    {
        return currentDirection;
    }

    /**
     * Set the desired direction for this entity.
     *
     * @param d - the desired direction.
     */
    @Override
    public void setDesiredDirection(final Direction d)
    {
        desiredDirection = d;
    }

    /**
     * Get the desired direction for this entity.
     *
     * @param game - the game the entity is playing in.
     *
     * @return the direction the entity wants to go.
     */
    @Override
    public Direction getDesiredDirection(final T game)
    {
        if(game == null)
        {
            throw new IllegalArgumentException("game cannot be null");
        }
        return desiredDirection;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        final StringBuilder str = new StringBuilder();
        str.append('\'').append(this.getKey()).append("' @ ").append(this.getLocation());
        str.append(" -> ");
        str.append(currentDirection);
        str.append(" -> ");
        str.append(desiredDirection);
        return str.toString();
    }

    /**
     * Check to see if this entity can move to the requested tile.
     *
     * @param tile      - the proposed tile.
     * @param direction - the the direction being moved from.
     *
     * @return true of this entity can move to the tile, false otherwise.
     */
    @Override
    @SuppressWarnings("unchecked")
    public final boolean canMoveTo(final Tile tile,
                                   final Direction direction)
    {
        if(tile == null)
        {
            throw new IllegalArgumentException("tile cannot be null");
        }
        if(direction == null)
        {
            throw new IllegalArgumentException("direction cannot be null");
        }
        return moveChecker.canMoveTo((E)this, tile, new Dimension(this.getLocation(), tile.getLocation()),
                                     direction);
    }

    /**
     * Handle a collision with another entity.
     *
     * @param tile - the tile that the collision is occurring on.
     * @param game - the game the collision is occurring in.
     *
     * @throws CollisionException - thrown if there is a problem with colliding entities.
     */
    @Override
    @SuppressWarnings("unchecked")
    public final void handleCollision(final MutableTile tile,
                                      final T game)
        throws CollisionException
    {
        if(tile == null)
        {
            throw new IllegalArgumentException("tile cannot be null");
        }
        if(game == null)
        {
            throw new IllegalArgumentException("game cannot be null");
        }
        if(!tile.getLocation().getRectangle().equals(game.getWorld()))
        {
            throw new IllegalArgumentException("cannot collide on a different rectangle");
        }
        final Location self = this.getLocation();
        final Location target = tile.getLocation();
        if(!self.equals(target))
        {
            throw new IllegalArgumentException("cannot collide with a different tile.  Expected: " + self.toString() +
                ", was: " + target.toString());
        }

        final Entity other = tile.getEntity(1);
        moveHandler.handleCollision((E)this, other, game);

    }

    /**
     * Set the move moveChecker.
     *
     * @param checker - the move moveChecker.
     */
    @Override
    public final void setMoveChecker(final MoveChecker<T, E> checker)
    {
        if(checker == null)
        {
            throw new IllegalArgumentException("checker cannot be null");
        }
        this.moveChecker = checker;
    }

    /**
     * Get the move moveChecker.
     *
     * @return the move moveChecker.
     */
    @Override
    public final MoveChecker<T, E> getMoveChecker()
    {
        return moveChecker;
    }

    /**
     * Set the collision handler.
     *
     * @param handler - the collision handler.
     */
    @Override
    public final void setCollisionDector(final CollisionHandler<T, E> handler)
    {
        if(handler == null)
        {
            throw new IllegalArgumentException("handler cannot be null");
        }
        this.moveHandler = handler;
    }

    /**
     * Get the collision handler.
     *
     * @return the collision handler.
     */
    @Override
    public final CollisionHandler<T, E> getCollisionHandler()
    {
        return moveHandler;
    }

}
