package ca.bcit.cst.comp2526.assign6.solution.ui.swing;


import ca.bcit.cst.comp2526.assign6.solution.Entity;
import ca.bcit.cst.comp2526.assign6.solution.EntityFactory;
import ca.bcit.cst.comp2526.assign6.solution.Tile;
import ca.bcit.cst.comp2526.assign6.solution.game.Game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


/**
 * Displays a tile of a world.
 *
 * @param <T> the type of game being played.
 *
 * @author D'Arcy Smith
 * @version 1.0
 */
public class TilePanel<T extends Game>
    extends JPanel
{
    /**
     * Constant serialized ID used for compatibility.
     */
    private static final long serialVersionUID = 0;

    /**
     * The tile to display.
     */
    private final transient Tile tile;

    /**
     * The entity factory.
     */
    private final transient EntityFactory factory;

    /**
     * the game.
     */
    private final T game;

    /**
     * Construct a TilePanel with the specified values.
     *
     * @param t the tile to display.
     * @param f the entity factory.
     * @param g the game being played.
     */
    public TilePanel(final Tile t,
                     final EntityFactory f,
                     final T g)
    {
        tile = t;
        factory = f;
        game = g;
    }

    /**
     * Get the tile that is being displayed.
     *
     * @return the tile being displayed.
     */
    public Tile getTile()
    {
        return (tile);
    }

    /**
     * Draw the top entity on the tile.
     *
     * @param g the graphics context.
     */
    @Override
    @SuppressWarnings("unchecked")
    public void paintComponent(final Graphics g)
    {
        final Entity entity;
        final Color nullColour;

        entity = tile.getEntity();
        nullColour = factory.getColourForNullEntity();
        setBackground(nullColour);
        super.paintComponent(g);

        if(entity != null)
        {
            final SwingEntityRenderer renderer;

            renderer = entity.getSwingRenderer();
            renderer.renderEnity(entity,
                                 (Graphics2D)g,
                                 factory.getColourForNullEntity(),
                                 getWidth(),
                                 getHeight(),
                                 game);
        }
    }

}
