package ca.bcit.cst.comp2526.assign6.solution.ui.swing;


import ca.bcit.cst.comp2526.assign6.solution.Entity;
import ca.bcit.cst.comp2526.assign6.solution.game.Game;
import java.awt.Color;
import java.awt.Graphics2D;


/**
 * render entity.
 *
 * @author darcy
 * @param <T>
 * @param <E>
 *
 * @version 1.0
 */
public abstract class AbstractSwingEntityRenderer<T extends Game, E extends Entity>
    implements SwingEntityRenderer<T, E>
{
    /**
     * do render.
     *
     * @param entity     - the entity need to render
     * @param graphics   - graphics.
     * @param nullColour - colour for null.
     * @param width      - width.
     * @param height     - height.
     * @param game       - the game being played.
     */
    @Override
    public final void renderEnity(final E entity,
                                  final Graphics2D graphics,
                                  final Color nullColour,
                                  final int width,
                                  final int height,
                                  final T game)
    {
        if(entity == null)
        {
            throw new IllegalArgumentException("entity cannot be null");
        }

        if(graphics == null)
        {
            throw new IllegalArgumentException("graphics cannot be null");
        }

        if(nullColour == null)
        {
            throw new IllegalArgumentException("nullColour cannot be null");
        }

        if(width < 1)
        {
            throw new IllegalArgumentException("width must be >= 1, was: " + width);
        }

        if(height < 1)
        {
            throw new IllegalArgumentException("height must be >= 1, was: " + height);
        }

        if(game == null)
        {
            throw new IllegalArgumentException("game cannot be null");
        }

        doRenderEntity(entity,
                       graphics,
                       nullColour,
                       width,
                       height,
                       game);
    }

    /**
     * do render.
     *
     * @param entity     - the entity need to render
     * @param graphics   - graphics.
     * @param nullColour - colour for null.
     * @param width      - width.
     * @param height     - height.
     * @param game       - the game being played.
     */
    protected abstract void doRenderEntity(E entity,
                                           Graphics2D graphics,
                                           Color nullColour,
                                           int width,
                                           int height,
                                           T game);

}