package ca.bcit.cst.comp2526.assign6.solution.ui.console;


import ca.bcit.cst.comp2526.assign6.solution.Entity;
import ca.bcit.cst.comp2526.assign6.solution.game.Game;


/**
 * console entity render.
 *
 * @author darcy
 * @param <T>
 * @param <E>
 * 
 * @version 1.0
 */
public class ConsoleEntityRenderer<T extends Game, E extends Entity>
{
    /**
     * render entity.
     *
     * @param entity - the entity need to render.
     * @param game   - the game being played.
     */
    public void renderEnity(final E entity,
                            final T game)
    {
        if(entity == null)
        {
            throw new IllegalArgumentException("entity cannot be null");
        }

        if(game == null)
        {
            throw new IllegalArgumentException("game cannot be null");
        }

        System.out.print(entity.getLabel());
    }

}