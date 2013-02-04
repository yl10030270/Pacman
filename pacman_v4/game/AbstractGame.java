package ca.bcit.cst.comp2526.assign4.solution.game;


import ca.bcit.cst.comp2526.assign4.solution.MutableWorld;
import ca.bcit.cst.comp2526.assign4.solution.World;
import ca.bcit.cst.comp2526.assign4.solution.ui.WorldUpdater;
import java.awt.event.KeyListener;


/**
 * Abstraction for a a video game. The basics of this class come from http://www.java-gaming.org/index.php?topic=24220.0
 *
 * @author D'Arcy Smith
 * @version 1.0
 */
public abstract class AbstractGame
    implements Game
{
    /**
     * Number of nanoseconds in a second.
     */
    private static final long NANOSECONDS_IN_A_SECOND = 1000000000;

    /**
     * Number of milliseconds in a second.
     */
    private static final long MILLISECONDS_IN_A_SECOND = 1000000;

    /**
     * Handles updating the screen and getting keyboard input.
     */
    private WorldUpdater updater;

    /**
     * The world to play on.
     */
    protected final MutableWorld world;

    /**
     * Is the game paused?
     */
    private boolean paused;

    /**
     * How long ago was the last frame?
     */
    private long lastFpsTime;

    /**
     * Expected frames per second.
     */
    private int targetFPS;

    /**
     * Construct an AbstractGame with the specified arguments.
     *
     * @param w    the world to play on.
     * @param tFPS the target frames per second.
     */
    protected AbstractGame(final MutableWorld w,
                           final int tFPS)
    {
        if(w == null)
        {
            throw new IllegalArgumentException("w cannot be null");
        }

        if(tFPS < 1)
        {
            throw new IllegalArgumentException("tFPS must be >= 1, was: " + tFPS);
        }

        world = w;
        targetFPS = tFPS;
    }

    /**
     * Initialize the game. Can only be called once per game. Must be called before start is called.
     *
     * @param u the world updater.
     */
    @Override
    public final void init(final WorldUpdater u)
    {
        final KeyListener listener;

        if(u == null)
        {
            throw new IllegalArgumentException("u cannot be null");
        }

        if(updater != null)
        {
            throw new IllegalStateException("updater cannot be null");
        }

        updater = u;
        listener = getKeyListener();
        updater.addKeyListener(listener);
        doInit();
    }

    /**
     * Override this for game specific initialization.
     */
    protected void doInit()
    {
        // by default notbhing happens.
    }

    /**
     * Get the key listener to handle keyboard input from the user.
     *
     * @return the key listener.
     */
    protected abstract KeyListener getKeyListener();

    /**
     * Toggle the pause flag.
     */
    @Override
    public void togglePause()
    {
        paused ^= true;
    }

    /**
     * Is the game paused?
     *
     * @return true of the game is paused, false otherwise.
     */
    @Override
    public boolean isPaused()
    {
        return (paused);
    }

    /**
     * Get the target frames per second.
     *
     * @return the target frames per second.
     */
    @Override
    public int getTargetFPS()
    {
        return (targetFPS);
    }

    /**
     * Set the target frames per second.
     *
     * @param tFPS the target frames per second.
     */
    @Override
    public void setTargetFPS(final int tFPS)
    {
        if(tFPS < 1)
        {
            throw new IllegalArgumentException("tFPW must be >= 1, was: " + tFPS);
        }

        targetFPS = tFPS;
    }

    /**
     * Get the world that the game is playing with.
     *
     * @return the world that the game is playing with.
     */
    @Override
    public World getWorld()
    {
        return (world);
    }

    /**
     * Start the game.
     *
     * @throws CollisionException thrown if there is a problem with colliding entities.
     */
    @Override
    public final void start()
        throws CollisionException
    {
        long lastLoopTime;
        final long optimalTime;


        if(updater == null)
        {
            throw new IllegalStateException("updater cannot be null");
        }

        lastLoopTime = System.nanoTime();
        optimalTime = NANOSECONDS_IN_A_SECOND / targetFPS;


        // keep looping round til the game ends
        while(!(isOver()))
        {
            // work out how long its been since the last update, this
            // will be used to calculate how far the entities should
            // move this loop
            final long now;
            final long updateLength;
            final double delta;

            now = System.nanoTime();
            updateLength = now - lastLoopTime;
            lastLoopTime = now;
            delta = updateLength / ((double)optimalTime);

            // update the frame counter
            lastFpsTime += updateLength;

            // update our FPS counter if a second has passed since
            // we last recorded
            if(lastFpsTime >= NANOSECONDS_IN_A_SECOND)
            {
                lastFpsTime = 0;
            }

            if(!paused)
            {
                // update the game logic
                updateState(delta,
                            updater);

                // draw everything
                render(updater);
            }

            // we want each frame to take 10 milliseconds, to do this
            // we've recorded when we started the frame. We add 10 milliseconds
            // to this and then factor in the current time to give 
            // us our final value to wait for
            // remember this is in ms, whereas our lastLoopTime etc. vars are in ns.
            try
            {
                final long sleepTime;

                sleepTime = (lastLoopTime - System.nanoTime() + optimalTime) / MILLISECONDS_IN_A_SECOND;

                if(sleepTime > 0)
                {
                    Thread.sleep(sleepTime);
                }
            }
            catch(final InterruptedException ex)
            {
                // nothing bad happens if we wake up early
            }
        }
    }

    /**
     * Check if the game is over.
     *
     * @return true of the game is over, false otherwise.
     */
    protected abstract boolean isOver();

    /**
     * Update the game. This is called each time a frame occurs.
     *
     * @param delta   the difference in time from the last frame to the current frame.
     * @param updater the world updater.
     *
     * @throws CollisionException thrown if there is a problem with colliding entities.
     */
    protected abstract void updateState(double delta,
                                        WorldUpdater updater)
        throws CollisionException;

    /**
     * Redraw the world or changes to the world.
     *
     * @param updater the world updater.
     */
    protected abstract void render(WorldUpdater updater);

}
