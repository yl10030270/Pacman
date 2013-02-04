package ca.bcit.cst.comp2526.assign6.solution.game.pacman.renderer.swing;


import ca.bcit.cst.comp2526.assign6.solution.game.pacman.PacManGame;
import ca.bcit.cst.comp2526.assign6.solution.game.pacman.PelletEntity;
import ca.bcit.cst.comp2526.assign6.solution.ui.swing.AbstractSwingEntityRenderer;
import java.awt.Color;
import java.awt.Graphics2D;


/**
 * render pellet.
 *
 * @author darcy
 * @version 1.0
 */
public class SwingPelletRenderer
    extends AbstractSwingEntityRenderer<PacManGame, PelletEntity>
{
    /**
     * do render.
     *
     * @param pellet     - the pellet need to render.
     * @param graphics   - graphics.
     * @param nullColour - colour for null.
     * @param width      - width.
     * @param height     - height.
     * @param game       - the game being played.
     */
    @Override
    protected void doRenderEntity(final PelletEntity pellet,
                                  final Graphics2D graphics,
                                  final Color nullColour,
                                  final int width,
                                  final int height,
                                  final PacManGame game)
    {
        final int halfWidth;
        final int halfHeight;
        final int quarterWidth;
        final int quarterHeight;

        halfWidth = width / 2;
        halfHeight = height / 2;
        quarterWidth = width / Integer.parseInt("4");
        quarterHeight = height / Integer.parseInt("4");
        graphics.setColor(pellet.getColour());
        graphics.fillOval(quarterWidth, quarterHeight, width - halfWidth, height - halfHeight);
    }

}
