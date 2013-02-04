/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign4.solution.game;


import ca.bcit.cst.comp2526.assign4.solution.Entity;


/**
 * Handle collisions between two entities.
 *
 * @param <T> The type of game being played.
 * @param <E> The type of the moving entity.
 *
 * @author leon
 * @version 1.0
 */
public interface CollisionHandler<T extends Game, E extends MovableEntity<T, E>>
{
    /**
     * Handle the collision of the moving entity to the same tile as the other entity.
     *
     * @param movingEntity - the entity that moved.
     * @param otherEntity  - the entity being attacked.
     * @param game         - the game being played.
     *
     * @throws CollisionException - if the moving entity doesn't know how to handle a collision with the other entity.
     */
    void handleCollision(E movingEntity,
                         Entity otherEntity,
                         T game)
        throws CollisionException;

}
