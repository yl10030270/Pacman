/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign4.solution.game;


import ca.bcit.cst.comp2526.assign4.solution.Entity;


/**
 * Handle collisions between two entities.
 *
 * @param <T> - The type of game being played.
 * @param <E> - The type of the moving entity.
 *
 * @author Leon
 * @version 1.0
 */
public abstract class AbstractCollisionHandler<T extends Game, E extends MovableEntity<T, E>>
    implements CollisionHandler<T, E>
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
    @Override
    public final void handleCollision(final E movingEntity,
                                      final Entity otherEntity,
                                      final T game)
        throws CollisionException
    {
        if(movingEntity == null)
        {
            throw new IllegalArgumentException("movingEntity cannot be null");
        }
        if(game == null)
        {
            throw new IllegalArgumentException("game cannot be null");
        }
        if(!doHandleCollision(movingEntity, otherEntity, game))
        {
            throw new CannotCollideWithException(movingEntity, otherEntity);
        }
    }

    /**
     * Handle the collision of the moving entity to the same tile as the other entity.
     *
     * @param movingEntity - the entity that moved.
     * @param otherEntity  - the entity being attacked.
     * @param game         - the game being played.
     *
     * @return true if the collision was handled, false otherwise.
     *
     * @throws CollisionException - if the moving entity doesn't know how to handle a collision with the other entity.
     */
    protected abstract boolean doHandleCollision(E movingEntity,
                                                 Entity otherEntity,
                                                 T game)
        throws CollisionException;

}
