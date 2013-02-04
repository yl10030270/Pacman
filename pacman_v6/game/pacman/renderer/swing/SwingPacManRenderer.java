package ca.bcit.cst.comp2526.assign6.solution.game.pacman.renderer.swing;


import ca.bcit.cst.comp2526.assign6.solution.Direction;
import ca.bcit.cst.comp2526.assign6.solution.game.pacman.PacManEntity;
import ca.bcit.cst.comp2526.assign6.solution.game.pacman.PacManGame;
import ca.bcit.cst.comp2526.assign6.solution.ui.swing.AbstractSwingEntityRenderer;
import java.awt.Color;
import java.awt.Graphics2D;


/**
 * render pac man.
 *
 * @author darcy
 * @version 1.0
 */
public class SwingPacManRenderer
    extends AbstractSwingEntityRenderer<PacManGame, PacManEntity>
{
    /**
     * magic number 90.
     */
    private static final int NINTY = 90;

    /**
     * number 30.
     */
    private static final int THIRTY = 30;

    /**
     * number 3.
     */
    private static final int THREE = 3;

    /**
     * number 4.
     */
    private static final int FOUR = 4;

    /**
     * number 5.
     */
    private static final int FIVE = 5;

    /**
     * switch helper method.
     *
     * @param dir - direction to switch
     *
     * @return - base value
     */
    private int directioSwitch(final Direction dir)
    {
        int base;
        switch(dir)
        {
            case EAST:
            {
                base = 0;
                break;
            }
            case NORTH:
            {
                base = NINTY;
                break;
            }
            case WEST:
            {
                base = NINTY * 2;
                break;
            }
            case SOUTH:
            {
                base = NINTY * THREE;
                break;
            }
            default:
            {
                throw new IllegalStateException(dir + " is not valid!");
            }
        }
        return base;
    }

    /**
     * do render.
     *
     * @param pacman     - the pacman wall need to render.
     * @param graphics   - graphics.
     * @param nullColour - colour for null.
     * @param width      - width.
     * @param height     - height.
     * @param game       - the game being played.
     */
    @Override
    protected void doRenderEntity(final PacManEntity pacman,
                                  final Graphics2D graphics,
                                  final Color nullColour,
                                  final int width,
                                  final int height,
                                  final PacManGame game)
    {
        final Direction direction;

        graphics.setColor(pacman.getColour());
        graphics.fillOval(0, 0, width, height);
        graphics.setColor(Color.black);
        direction = pacman.getCurrentDirection();

        if(direction != Direction.NONE)
        {
            final int mouthPosition;
            final int base;

            mouthPosition = pacman.getMouthPosition();

            base = directioSwitch(direction);

            if(mouthPosition == 1 || mouthPosition == FIVE)
            {
                graphics.fillArc(0, 0, width, height, base - THIRTY, NINTY - THIRTY);
            }
            else if(mouthPosition == 2 || mouthPosition == FOUR)
            {
                graphics.fillArc(0, 0, width, height, base - NINTY / 2, NINTY);
            }
            else if(mouthPosition == THREE)
            {
                graphics.fillArc(0, 0, width, height, base - (NINTY - THIRTY), NINTY + THIRTY);
            }

            pacman.moveMouth();
        }
    }

}
