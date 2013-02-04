package ca.bcit.cst.comp2526.assign6.solution.ui.swing;


import ca.bcit.cst.comp2526.assign6.solution.EntityFactory;
import ca.bcit.cst.comp2526.assign6.solution.MutableWorld;
import ca.bcit.cst.comp2526.assign6.solution.game.Game;
import ca.bcit.cst.comp2526.assign6.solution.ui.WorldDisplayer;
import ca.bcit.cst.comp2526.assign6.solution.ui.WorldDisplayerException;
import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;
import javax.swing.WindowConstants;


/**
 * Display a world to the console via a JFrame.
 *
 * @author D'Arcy Smith
 * @version 1.0
 */
public class SwingWorldDisplayer
    implements WorldDisplayer
{
    /**
     * The name of the world.
     */
    private final String worldName;

    /**
     * The world to display.
     */
    private final MutableWorld world;

    /**
     * The game being played.
     */
    private final Game game;

    /**
     * The factory used to deal with entities.
     */
    private final EntityFactory factory;

    /**
     * Construct a SwingWorldDisplayer with the specified values.
     * 
     * @param w    the world to display.
     * @param name the name of the world.
     * @param g    the game being played.
     * @param f    the entity factory.
     */
    public SwingWorldDisplayer(final MutableWorld  w,
                               final String        name, 
                               final Game          g,
                               final EntityFactory f)
    {
        world     = w;
        worldName = name;
        game      = g;
        factory   = f;
    }
    
    /**
     * Create and display the JFrame.
     * 
     * @throws WorldDisplayerException if there is an issue creating or displaying the world.
     */
    @Override
    public void displayWorld() 
        throws WorldDisplayerException
    {
        try 
        {
            EventQueue.invokeAndWait(
                    new Runnable() 
                    {
                        @Override
                        public void run() 
                        {
                            final WorldFrame worldFrame;
                            
                            worldFrame = new WorldFrame(worldName, 
                                                        world);
                            worldFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                            worldFrame.init(factory, game);
                            game.init(worldFrame);        
                            worldFrame.pack();
                            worldFrame.setVisible(true);
                        }
                    });
        } 
        catch(final InterruptedException ex)
        {
            throw new WorldDisplayerException("Error creating displayer", 
                                              ex);
        }
        catch(final InvocationTargetException ex)
        {
            throw new WorldDisplayerException("Error creating displayer", 
                                              ex);
        }
    }
    
    /**
     * Does nothing.
     * 
     * @param g the game being played.
     */
    @Override
    public void init(final Game g)
    {
        // nothing to be done here, already done in the displayWorld mwthod.
    }
}
