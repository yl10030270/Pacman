package ca.bcit.cst.comp2526.assign6.solution.game.pathfinder;


import ca.bcit.cst.comp2526.assign6.solution.Direction;
import ca.bcit.cst.comp2526.assign6.solution.game.Game;
import ca.bcit.cst.comp2526.assign6.solution.game.MovableEntity;


/**
 * Find the direction to move next.
 * 
 * @param <T> The type of game being played.
 * @param <E> The type of the moving entity.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public interface PathFinder<T extends Game, 
                            E extends MovableEntity<T, E>>
{
    /**
     * Get the direction to move next.
     * 
     * @param game         the game being played.
     * @param movingEntity the entity that is moving.
     * 
     * @return the direction to move next.
     */
    Direction getDirectionToMove(T game,
                                 E movingEntity);
}
