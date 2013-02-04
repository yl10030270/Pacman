/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign4.solution.game;


import ca.bcit.cst.comp2526.assign4.solution.Direction;
import ca.bcit.cst.comp2526.assign4.solution.Entity;
import ca.bcit.cst.comp2526.assign4.solution.MutableTile;
import ca.bcit.cst.comp2526.assign4.solution.Tile;


/**
 * An entity that is able to move on a world.
 *
 * @param <T> The type of game being played.
 * @param <E> The type of the moving entity.
 *
 * @author leon
 * @version 1.0
 */
public interface MovableEntity<T extends Game, E extends MovableEntity<T, E>>
    extends Entity
{
    /**
     * Set the move checker.
     *
     * @param checker checker - the move checker.
     */
    void setMoveChecker(MoveChecker<T, E> checker);

    /**
     * Get the move checker.
     *
     * @return the move checker.
     */
    MoveChecker<T, E> getMoveChecker();

    /**
     * Set the collision handler.
     *
     * @param handler - the collision handler.
     */
    void setCollisionDector(CollisionHandler<T, E> handler);

    /**
     * Get the collision handler.
     *
     * @return the collision handler.
     */
    CollisionHandler<T, E> getCollisionHandler();

    /**
     * Get the direction that this entity is moving in.
     *
     * @return the direction that the entity is moving in.
     */
    Direction getCurrentDirection();

    /**
     * Set the direction that this entity is moving in.
     *
     * @param direction - the direction that the entity is moving in.
     */
    void setCurrentDirection(Direction direction);

    /**
     * Get the direction that this entity wants to move in.
     *
     * @param game - the game this entity is in.
     *
     * @return the direction that this entity wants to move in.
     */
    Direction getDesiredDirection(T game);

    /**
     * Set the direction that this entity wants to move in.
     *
     * @param direction - the direction that the entity wants to move in.
     */
    void setDesiredDirection(Direction direction);

    /**
     * Check to see if this entity can move to a specific tile.
     *
     * @param tile      - the tile being moved to.
     * @param direction - the direction the entity is moving.
     *
     * @return true if this entity can move to the tile, false otherwise.
     */
    boolean canMoveTo(Tile tile,
                      Direction direction);

    /**
     * Handle a collision with another entity.
     *
     * @param tile - the tile that the collision is occurring on.
     * @param game - the game the collision is occurring in.
     *
     * @throws CollisionException - thrown if there is a problem with colliding entities.
     */
    void handleCollision(MutableTile tile,
                         T game)
        throws CollisionException;

}
