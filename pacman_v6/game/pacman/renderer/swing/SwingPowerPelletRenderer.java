package ca.bcit.cst.comp2526.assign6.solution.game.pacman.renderer.swing;


import ca.bcit.cst.comp2526.assign6.solution.game.pacman.PacManGame;
import ca.bcit.cst.comp2526.assign6.solution.game.pacman.PowerPelletEntity;
import ca.bcit.cst.comp2526.assign6.solution.ui.swing.AbstractSwingEntityRenderer;
import java.awt.Color;
import java.awt.Graphics2D;


/**
 * render power pellet.
 *
 * @author darcy
 * @version 1.0
 */
public class SwingPowerPelletRenderer
    extends AbstractSwingEntityRenderer<PacManGame, PowerPelletEntity>
{
    /**
     * do render.
     *
     * @param powerPellet - the pellet need to render.
     * @param graphics    - graphics.
     * @param nullColour  - colour for null.
     * @param width       - width.
     * @param height      - height.
     * @param game        - the game being played.
     */
    @Override
    protected void doRenderEntity(final PowerPelletEntity powerPellet,
                                  final Graphics2D graphics,
                                  final Color nullColour,
                                  final int width,
                                  final int height,
                                  final PacManGame game)
    {
        if(game.getTicks() % Integer.parseInt("7") != 0)
        {
            final int halfWidth;
            final int halfHeight;
            final int quarterWidth;
            final int quarterHeight;

            halfWidth = width / Integer.parseInt("3");
            halfHeight = height / Integer.parseInt("3");
            quarterWidth = width / Integer.parseInt("6");
            quarterHeight = height / Integer.parseInt("6");
            graphics.setColor(powerPellet.getColour());
            graphics.fillOval(quarterWidth, quarterHeight, width - halfWidth, height - halfHeight);
        }
    }

}
