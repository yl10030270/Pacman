package ca.bcit.cst.comp2526.assign6.solution.renderers;


import ca.bcit.cst.comp2526.assign6.solution.Entity;
import ca.bcit.cst.comp2526.assign6.solution.game.Game;
import ca.bcit.cst.comp2526.assign6.solution.ui.swing.AbstractSwingEntityRenderer;
import java.awt.Color;
import java.awt.Graphics2D;


/**
 * render null.
 *
 * @author darcy
 * @param <T>
 *
 * @version 1.0
 */
public class SwingNullRenderer<T extends Game>
    extends AbstractSwingEntityRenderer<T, Entity>
{
    /**
     * do render.
     *
     * @param entity     - the entity to render
     * @param graphics   - graphics.
     * @param nullColour - colour for null.
     * @param width      - width.
     * @param height     - height.
     * @param game       - the game being played.
     */
    @Override
    protected void doRenderEntity(final Entity entity,
                                  final Graphics2D graphics,
                                  final Color nullColour,
                                  final int width,
                                  final int height,
                                  final T game)
    {
        graphics.setColor(nullColour);
        graphics.fillRect(0, 0, width, height);
    }

}
