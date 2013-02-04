package ca.bcit.cst.comp2526.assign6.solution.ui.swing;


import ca.bcit.cst.comp2526.assign6.solution.EntityFactory;
import ca.bcit.cst.comp2526.assign6.solution.Location;
import ca.bcit.cst.comp2526.assign6.solution.MutableWorld;
import ca.bcit.cst.comp2526.assign6.solution.Tile;
import ca.bcit.cst.comp2526.assign6.solution.game.Game;
import ca.bcit.cst.comp2526.assign6.solution.ui.WorldUpdater;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Collection;
import java.util.HashSet;
import javax.swing.JFrame;


/**
 * A frame used to display a world and play a game.
 *
 * @param <T>
 *
 * @author D'Arcy Smith
 * @version 1.0
 */
public class WorldFrame<T extends Game>
    extends JFrame
    implements WorldUpdater
{
    /**
     * Constant serialized ID used for compatibility.
     */
    private static final long serialVersionUID = 0;

    /**
     * The world the game is being played on.
     */
    private final transient MutableWorld world;

    /**
     * The locations that need to be updated next time the world is redrawn.
     */
    private transient Collection<Location> locationsToUpdate;

    
    {
        locationsToUpdate = new HashSet<Location>();
    }

    /**
     * Construct a WorldFrame with the specified values.
     *
     * @param title the title of the window.
     * @param w     the world the game is being played on.
     */
    public WorldFrame(final String title,
                      final MutableWorld w)
    {
        super(title);

        world = w;
    }

    /**
     * Create the tile panels.
     *
     * @param factory the entity factory.
     * @param game    the game being played.
     */
    public void init(final EntityFactory factory,
                     final T game)
    {
        final LayoutManager layout;

        layout = new GridLayout(world.getNumberOfRows(),
                                world.getNumberOfColumns());
        setLayout(layout);

        for(int row = 0; row < world.getNumberOfRows(); row++)
        {
            for(int col = 0; col < world.getNumberOfColumns(); col++)
            {
                final Location location;
                final Tile tile;
                final TilePanel panel;

                location = Location.create(row, col, world);
                tile = world.getTileAt(location);
                panel = createTilePanel(tile,
                                        factory,
                                        game);
                add(panel);
            }
        }
    }

    /**
     * Create a tile panel.
     *
     * @param tile    the tile to wrap.
     * @param factory the entity factory.
     *
     * @param game    - the game being play.
     *
     * @return the tile panel that wraps the tile.
     */
    private TilePanel createTilePanel(final Tile tile,
                                      final EntityFactory factory,
                                      final T game)
    {
        final TilePanel panel;

        panel = new TilePanel(tile,
                              factory,
                              game);

        return (panel);
    }

    /**
     * Draw the tiles that changes since the last redraw.
     */
    @Override
    public void drawChanges()
    {
        final Container contentPane;

        contentPane = getContentPane();

        for(final Location location : locationsToUpdate)
        {
            final int row;
            final int column;
            final int index;
            final TilePanel tilePanel;

            row = location.getRow();
            column = location.getColumn();
            index = (row * (world.getNumberOfRows() - 2)) + column;
            tilePanel = (TilePanel)contentPane.getComponent(index);
            tilePanel.repaint();
        }

        locationsToUpdate.clear();
    }

    /**
     * Add a location to be redrawn.
     *
     * @param location the location to be redrawn.
     */
    @Override
    public void addUpdateLocation(final Location location)
    {
        locationsToUpdate.add(location);
    }

    /**
     * read object.
     *
     * @param stream - input stream.
     *
     * @throws IOException            - io exception.
     * @throws ClassNotFoundException - can't find class.
     */
    private void readObject(final ObjectInputStream stream)
        throws IOException,
               ClassNotFoundException
    {
        stream.defaultReadObject();
        locationsToUpdate = new HashSet<Location>();
    }

}
