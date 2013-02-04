/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign4.solution.game.pacman.pathfinder;


import ca.bcit.cst.comp2526.assign4.solution.Direction;
import ca.bcit.cst.comp2526.assign4.solution.game.pacman.GhostEntity;
import ca.bcit.cst.comp2526.assign4.solution.game.pacman.PacManGame;
import ca.bcit.cst.comp2526.assign4.solution.game.pathfinder.AbstractPathFinder;
import java.util.ArrayList;
import java.util.List;


/**
 * Find the next move for a Ghost.
 *
 * @author Leon
 * @version 1.0
 */
public abstract class AbstractGhostPathFinder
    extends AbstractPathFinder<PacManGame, GhostEntity>
{
    /**
     * Get the directions that a ghost can move.
     *
     * @param game   - the game being played.
     * @param entity - the ghost that is moving.
     *
     * @return NORTH, EAST, SOUTH, WEST.
     */
    @Override
    protected List<Direction> getDirectionsToLookAt(final PacManGame game,
                                                    final GhostEntity entity)
    {
        final List<Direction> dirlist = new ArrayList<>();
        dirlist.add(Direction.NORTH);
        dirlist.add(Direction.EAST);
        dirlist.add(Direction.SOUTH);
        dirlist.add(Direction.WEST);
        return dirlist;

    }

}
