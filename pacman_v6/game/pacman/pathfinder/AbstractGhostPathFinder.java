package ca.bcit.cst.comp2526.assign6.solution.game.pacman.pathfinder;


import ca.bcit.cst.comp2526.assign6.solution.Direction;
import ca.bcit.cst.comp2526.assign6.solution.game.pacman.GhostEntity;
import ca.bcit.cst.comp2526.assign6.solution.game.pacman.PacManGame;
import ca.bcit.cst.comp2526.assign6.solution.game.pathfinder.AbstractPathFinder;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * Find the next move for a Ghost.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public abstract class AbstractGhostPathFinder
    extends AbstractPathFinder<PacManGame,
                               GhostEntity>
{
    /**
     * Get the directions that a ghost can move.
     * 
     * @param game   the game being played.
     * @param entity the ghost that is moving.
     * 
     * @return NORTH, EAST, SOUTH, WEST.
     */
    @Override
    protected List<Direction> getDirectionsToLookAt(final PacManGame  game,
                                                    final GhostEntity entity)
    {
        final List<Direction> directions;
        
        directions =  Arrays.asList(Direction.NORTH,
                                    Direction.EAST,
                                    Direction.SOUTH,
                                    Direction.WEST);
        
        return (Collections.unmodifiableList(directions));
    }
}
