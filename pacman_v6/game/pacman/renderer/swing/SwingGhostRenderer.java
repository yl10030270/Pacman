package ca.bcit.cst.comp2526.assign6.solution.game.pacman.renderer.swing;


import ca.bcit.cst.comp2526.assign6.solution.game.pacman.GhostEntity;
import ca.bcit.cst.comp2526.assign6.solution.game.pacman.PacManGame;
import ca.bcit.cst.comp2526.assign6.solution.ui.swing.AbstractSwingEntityRenderer;
import java.awt.Color;
import java.awt.Graphics2D;


/**
 * render a ghost.
 *
 * @author darcy
 * @version 1.0
 */
public class SwingGhostRenderer
    extends AbstractSwingEntityRenderer<PacManGame, GhostEntity>
{
    /**
     * do render.
     *
     * @param ghost      - the ghost need to render.
     * @param graphics   - graphics.
     * @param nullColour - colour for null.
     * @param width      - width.
     * @param height     - height.
     * @param game       - the game being played.
     */
    @Override
    protected void doRenderEntity(final GhostEntity ghost,
                                  final Graphics2D graphics,
                                  final Color nullColour,
                                  final int width,
                                  final int height,
                                  final PacManGame game)
    {
        graphics.setColor(ghost.getColour());
        graphics.fillOval(0, 0, width, height);
        graphics.fillRect(0, height / 2, width, height);
    }

}
