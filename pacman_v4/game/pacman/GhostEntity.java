/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign4.solution.game.pacman;


import ca.bcit.cst.comp2526.assign4.solution.Direction;
import ca.bcit.cst.comp2526.assign4.solution.EntityData;
import ca.bcit.cst.comp2526.assign4.solution.game.pacman.pathfinder.AbstractGhostPathFinder;


/**
 * A ghost on a world.
 *
 * @author Leon
 * @version 1.0
 */
public abstract class GhostEntity
    extends AbstractPacManGameMovableEntity<GhostEntity>
{
    /**
     * the path finder to use.
     */
    private final AbstractGhostPathFinder pathFinder;

    /**
     * Construct a GhostEntity.
     *
     * @param data   - the values for the entity state.
     * @param finder - the path finder to use.
     */
    public GhostEntity(final EntityData data,
                       final AbstractGhostPathFinder finder)
    {
        super(data, new AttackingGhostMoveChecker(),
              new AttackingGhostCollisionHandler());
        if(finder == null)
        {
            throw new IllegalArgumentException("finder cannot be null");
        }
        pathFinder = finder;
    }

    /**
     * Get the desired direction to move. This uses the path finder.
     *
     * @param game - the game being played in.
     *
     * @return the direction that the ghost should move next.
     */
    @Override
    public Direction getDesiredDirection(final PacManGame game)
    {
        return pathFinder.getDirectionToMove(game, this);
    }

}
