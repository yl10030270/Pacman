package ca.bcit.cst.comp2526.assign6.solution.game.pacman.renderer.swing;


import ca.bcit.cst.comp2526.assign6.solution.game.pacman.DoorEntity;
import ca.bcit.cst.comp2526.assign6.solution.game.pacman.PacManGame;
import ca.bcit.cst.comp2526.assign6.solution.ui.swing.AbstractSwingEntityRenderer;
import java.awt.Color;
import java.awt.Graphics2D;


/**
 * rend a door.
 *
 * @author darcy
 * @version 1.0
 */
public class SwingDoorRenderer
    extends AbstractSwingEntityRenderer<PacManGame, DoorEntity>
{
    /**
     * do render.
     *
     * @param door       - the door need to render.
     * @param graphics   - graphics.
     * @param nullColour - colour for null.
     * @param width      - width.
     * @param height     - height.
     * @param game       - the game being played.
     */
    @Override
    protected void doRenderEntity(final DoorEntity door,
                                  final Graphics2D graphics,
                                  final Color nullColour,
                                  final int width,
                                  final int height,
                                  final PacManGame game)
    {
        graphics.setColor(door.getColour());
        graphics.fillRect(0, 0, width, height);
    }

}
