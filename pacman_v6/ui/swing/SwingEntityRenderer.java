package ca.bcit.cst.comp2526.assign6.solution.ui.swing;


import ca.bcit.cst.comp2526.assign6.solution.Entity;
import ca.bcit.cst.comp2526.assign6.solution.game.Game;
import java.awt.Color;
import java.awt.Graphics2D;


/**
 * entity render.
 *
 * @author darcy
 * @param <T>
 * @param <E>
 *
 * @version 1.0
 */
public interface SwingEntityRenderer<T extends Game, E extends Entity>
{
    /**
     * render.
     *
     * @param entity     - the entity need to render
     * @param graphics   - graphics.
     * @param nullColour - colour for null.
     * @param width      - width.
     * @param height     - height.
     * @param game       - the game being played.
     */
    void renderEnity(E entity,
                     Graphics2D graphics,
                     Color nullColour,
                     int width,
                     int height,
                     T game);

}