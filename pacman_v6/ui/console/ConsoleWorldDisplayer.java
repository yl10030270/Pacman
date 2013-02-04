package ca.bcit.cst.comp2526.assign6.solution.ui.console;


import ca.bcit.cst.comp2526.assign6.solution.Entity;
import ca.bcit.cst.comp2526.assign6.solution.EntityFactory;
import ca.bcit.cst.comp2526.assign6.solution.Location;
import ca.bcit.cst.comp2526.assign6.solution.Tile;
import ca.bcit.cst.comp2526.assign6.solution.World;
import ca.bcit.cst.comp2526.assign6.solution.game.Game;
import ca.bcit.cst.comp2526.assign6.solution.ui.WorldDisplayer;
import ca.bcit.cst.comp2526.assign6.solution.ui.WorldUpdater;
import java.awt.EventQueue;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.WindowConstants;


/**
 * Display a world to the console via System.out.
 * 
 * @author D'Arcy Smith
 * @version 1.1
 */
public class ConsoleWorldDisplayer
    implements WorldDisplayer,
               WorldUpdater
{
    /**
     * The world to be displayed.
     */
    private final World world;
    
    /**
     * Used to display the entities.
     */
    private final EntityFactory factory;
    
    /**
     * Construct a ConsoleWorldDisplayer with the specified values.
     * 
     * @param w    the world to display.
     * @param name the name of the world.
     * @param f    the entity factory to crate entities with.
     */
    public ConsoleWorldDisplayer(final World         w,
                                 final String        name,
                                 final EntityFactory f)
    {
        if(w == null)
        {
            throw new IllegalArgumentException("w cannot be null");
        }
        
        if(name == null)
        {
            throw new IllegalArgumentException("name cannot be null");
        }
        
        if(name.trim().isEmpty())
        {
            throw new IllegalArgumentException("name cannot be empty");
        }
               
        if(f == null)
        {
            throw new IllegalArgumentException("f cannot be null");
        }
        
        world   = w;
        factory = f;
    }

    /**
     * Display the world.
     */
    @Override
    public void displayWorld() 
    {
        for(int row = 0; row < world.getNumberOfRows(); row++)
        {
            for(int col = 0; col < world.getNumberOfColumns(); col++)
            {
                final Location location;
                final Tile     tile;
                final Entity   entity;
                
                location = Location.create(row, col, world);
                tile     = world.getTileAt(location);
                entity   = tile.getEntity();
                
                if(entity == null)
                {
                    System.out.print(factory.getLabelForNullEntity());
                }
                else
                {
                    final char c;
                    
                    c = entity.getLabel();
                    System.out.print(c);
                }
            }
            
            System.out.println();
        }
    }
    
    /**
     * Initialize the world.
     * 
     * @param game the game that the world will be played on.
     */
    @Override
    public void init(final Game game)
    {
        game.init(this);
    }

    /**
     * Redraw the whole world.
     */
    @Override
    public void drawChanges() 
    {
        displayWorld();
    }

    /**
     * Add a key listener for user input.  This creates a window to listen for input.
     *  
     * @param listener the key listener.
     */
    @Override
    public void addKeyListener(final KeyListener listener)
    {
        EventQueue.invokeLater(
                new Runnable() 
                {
                    @Override
                    public void run() 
                    {
                        final JFrame frame;

                        frame = new JFrame("Input Window");
                        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                        frame.pack();
                        frame.addKeyListener(listener);
                        frame.setVisible(true);
                    }
                });        
    }

    /**
     * Add a location to be redrawn.  This method does nothing, since you cannot redraw specific parts of the console.
     * 
     * @param location the location to be redrawn.
     */
    @Override
    public void addUpdateLocation(final Location location) 
    {
        // no point is storing these, have to repaint the whole screen anyways.
    }
}
