/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign4.solution.game.pacman;


import ca.bcit.cst.comp2526.assign4.solution.EntityData;
import ca.bcit.cst.comp2526.assign4.solution.game.AbstractMovableEntity;
import ca.bcit.cst.comp2526.assign4.solution.game.CollisionHandler;
import ca.bcit.cst.comp2526.assign4.solution.game.MoveChecker;


/**
 * Abstraction for PacMan and the Ghosts.
 *
 * @param <T> - The type of the moving entity.
 *
 * @author leon
 * @version 1.0
 */
public abstract class AbstractPacManGameMovableEntity<T extends AbstractPacManGameMovableEntity<T>>
    extends AbstractMovableEntity<PacManGame, T>
{
    /**
     * Construct an AbstractPacManGameMovableEntity with the specified values.
     *
     * @param data    - the values for the entity state.
     * @param checker - the move checker.
     * @param handler - the collision handler.
     */
    protected AbstractPacManGameMovableEntity(final EntityData data,
                                              final MoveChecker<PacManGame, T> checker,
                                              final CollisionHandler<PacManGame, T> handler)
    {
        super(data, checker, handler);
    }

}
