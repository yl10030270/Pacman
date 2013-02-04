package ca.bcit.cst.comp2526.assign6.solution.game.pacman;


import ca.bcit.cst.comp2526.assign6.solution.game.AbstractMovableEntity;
import ca.bcit.cst.comp2526.assign6.solution.game.MovableEntityData;


/**
 * Abstraction for PacMan and the Ghosts.
 * 
 * @param <T> The type of the moving entity.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 * 
 */
public abstract class AbstractPacManGameMovableEntity<T extends AbstractPacManGameMovableEntity<T>>
    extends AbstractMovableEntity<PacManGame,
                                  T>
{
    /**
     * Construct an AbstractPacManGameMovableEntity with the specified values.
     * 
     * @param data    the values for the entity state.
     */
    protected AbstractPacManGameMovableEntity(final MovableEntityData<PacManGame, T> data)
    {
        super(data);
    }
}
