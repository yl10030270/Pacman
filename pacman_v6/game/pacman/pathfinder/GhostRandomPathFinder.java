package ca.bcit.cst.comp2526.assign6.solution.game.pacman.pathfinder;


import ca.bcit.cst.comp2526.assign6.solution.Direction;
import ca.bcit.cst.comp2526.assign6.solution.game.pacman.GhostEntity;
import ca.bcit.cst.comp2526.assign6.solution.game.pacman.PacManGame;
import java.util.Collections;
import java.util.List;


/**
 * Pick a new direction at random.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public final class GhostRandomPathFinder
    extends AbstractGhostPathFinder
{    
    /**
     * Pick a random direction to move in.
     * 
     * @param game               the game being played.
     * @param ghost              the ghost being moved.
     * @param possibleDirections the directions that it is possible for the ghost to move in.
     *
     * @return one of the possible directions at random.  If there are no possible directions then do a 180 turn.
     */
    @Override
    protected Direction chooseDirection(final PacManGame      game,
                                        final GhostEntity     ghost,
                                        final List<Direction> possibleDirections)
    {
        final Direction newDirection;
        
        if(possibleDirections.isEmpty())
        {
            final Direction currentDirection;
            final Direction oppositeDirection;
            
            currentDirection  = ghost.getCurrentDirection();
            oppositeDirection = currentDirection.getOpposite();
            ghost.setCurrentDirection(oppositeDirection);
            newDirection = oppositeDirection;
        }
        else
        {
            Collections.shuffle(possibleDirections);
            newDirection = possibleDirections.get(0);
        }
        
        return (newDirection);
    }
}
