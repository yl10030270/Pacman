package ca.bcit.cst.comp2526.assign6.solution.game.pacman.renderer.swing;


import ca.bcit.cst.comp2526.assign6.solution.game.pacman.PacManGame;
import ca.bcit.cst.comp2526.assign6.solution.game.pacman.TeleportEntity;
import ca.bcit.cst.comp2526.assign6.solution.ui.swing.AbstractSwingEntityRenderer;
import java.awt.Color;
import java.awt.Graphics2D;


/**
 * render teleporter.
 *
 * @author darcy
 * @version 1.0
 */
public class SwingTeleportRenderer
    extends AbstractSwingEntityRenderer<PacManGame, TeleportEntity>
{
    /**
     * do render.
     *
     * @param teleporter - the pellet need to render.
     * @param graphics   - graphics.
     * @param nullColour - colour for null.
     * @param width      - width.
     * @param height     - height.
     * @param game       - the game being played.
     */
    @Override
    protected void doRenderEntity(final TeleportEntity teleporter,
                                  final Graphics2D graphics,
                                  final Color nullColour,
                                  final int width,
                                  final int height,
                                  final PacManGame game)
    {
        graphics.setColor(teleporter.getColour());
        graphics.fillRect(0, 0, width, height);
    }

}
