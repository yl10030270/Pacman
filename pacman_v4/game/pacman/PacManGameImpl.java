package ca.bcit.cst.comp2526.assign4.solution.game.pacman;


import ca.bcit.cst.comp2526.assign4.solution.Direction;
import ca.bcit.cst.comp2526.assign4.solution.Entity;
import ca.bcit.cst.comp2526.assign4.solution.Location;
import ca.bcit.cst.comp2526.assign4.solution.MutableTile;
import ca.bcit.cst.comp2526.assign4.solution.MutableWorld;
import ca.bcit.cst.comp2526.assign4.solution.Tile;
import ca.bcit.cst.comp2526.assign4.solution.entityfinder.DefaultEntityFinder;
import ca.bcit.cst.comp2526.assign4.solution.entityfinder.EntityFinder;
import ca.bcit.cst.comp2526.assign4.solution.entityfinder.EntityKeyMatcher;
import ca.bcit.cst.comp2526.assign4.solution.entityfinder.FoundTooFewEntitiesException;
import ca.bcit.cst.comp2526.assign4.solution.entityfinder.FoundTooManyEntitiesException;
import ca.bcit.cst.comp2526.assign4.solution.game.AbstractGame;
import ca.bcit.cst.comp2526.assign4.solution.game.CollisionException;
import ca.bcit.cst.comp2526.assign4.solution.ui.WorldUpdater;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;


/**
 * AN implementation of the Pac Man game.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public class PacManGameImpl
    extends AbstractGame 
    implements PacManGame
{
    /**
     * Create the entities for the game.
     */
    private final PacManEntityFactory factory;
    
    /**
     * THe PacManEntity (player).
     */
    private final PacManEntity pacman;
    
    /**
     * The BlinkyGhostEntity.
     */
    private final GhostEntity blinky;
    
    /**
     * The PinkyGhostEntity.
     */
    private final GhostEntity pinky;
    
    /**
     * The InkyGhostEntity.
     */
    private final GhostEntity inky;
    
    /**
     * The ClydeGhostEntity.
     */
    private final GhostEntity clyde;
    
    /**
     * The first teleporter.
     */
    private final TeleportEntity teleportA;
    
    /**
     * The second teleporter.
     */
    private final TeleportEntity teleportB;
    
    /**
     * Construct a PacManGameImpl with the specified values.
     * 
     * @param w    the world being played on,
     * @param f    the entity factory to create entities with.
     * @param tFPS the target frames per second.
     * 
     * @throws FoundTooManyEntitiesException if there are too many of a required entity.
     * @throws FoundTooFewEntitiesException  of there are too few of a required entity.
     */
    public PacManGameImpl(final MutableWorld        w,
                          final PacManEntityFactory f,
                          final int                 tFPS)
        throws FoundTooManyEntitiesException, 
               FoundTooFewEntitiesException
    {
        super(w,
              tFPS);
        
        final List<TeleportEntity> teleporters;
        
        if(w == null)
        {
            throw new IllegalArgumentException("w cannot be null");
        }
        
        if(f == null)
        {
            throw new IllegalArgumentException("f cannot be null");
        }
        
        if(tFPS <= 0)
        {
            throw new IllegalArgumentException("tFPS must be > 0, was: " + tFPS);
        }
        
        factory     = f;
        pacman      = findPacMan();
        blinky      = findBlinky();
        pinky       = findPinky();
        inky        = findInky();
        clyde       = findClyde();
        teleporters = findTeleporters();
        teleportA   = teleporters.get(0);
        teleportB   = teleporters.get(1);
    }
    
    /**
     * Get the key listener to handle keyboard input from the user.
     * 
     * @return the key listener.
     */
    @Override
    protected KeyListener getKeyListener()
    {
        return (new KeyHandler());
    }
    
    /**
     * Check if the game is over.
     * 
     * @return false.
     */
    @Override
    public boolean isOver()
    {
        // stop when all the pellets are gone or out of lives
        return (false);
    }
    
    /**
     * Find the PacMan entity on the world.
     * 
     * @return the PacManEntity.
     * 
     * @throws FoundTooManyEntitiesException if more than one PacManEntity is found.
     * @throws FoundTooFewEntitiesException  if no PacManEntity is found.
     */
    private PacManEntity findPacMan()
        throws FoundTooManyEntitiesException, 
               FoundTooFewEntitiesException
    {
        final PacManEntity entity;
        
        entity = findSingleEntityMustExist(factory.getKeyForPacManEntity());

        return (entity);
    }
    
    /**
     * Find the BlinkyGhost entity on the world.
     * 
     * @return the BlinkyGhostEntity.
     * 
     * @throws FoundTooManyEntitiesException if more than one BlinkyGhostEntity is found.
     * @throws FoundTooFewEntitiesException  if no BlinkyGhostEntity is found.
     */
    private GhostEntity findBlinky()
        throws FoundTooManyEntitiesException, 
               FoundTooFewEntitiesException
    {
        final GhostEntity entity;
        
        entity = findGhostEntity(factory.getKeyForBlinkyGhostEntity());

        return (entity);
    }
    
    /**
     * Find the PinkyGhost entity on the world.
     * 
     * @return the PinkyGhostEntity.
     * 
     * @throws FoundTooManyEntitiesException if more than one PinkyGhostEntity is found.
     * @throws FoundTooFewEntitiesException  if no PinkyGhostEntity is found.
     */
    private GhostEntity findPinky()
        throws FoundTooManyEntitiesException, 
               FoundTooFewEntitiesException
    {
        final GhostEntity entity;
        
        entity = findGhostEntity(factory.getKeyForPinkyGhostEntity());

        return (entity);
    }
    
    /**
     * Find the InkyGhost entity on the world.
     * 
     * @return the InkyGhostEntity.
     * 
     * @throws FoundTooManyEntitiesException if more than one InkyGhostEntity is found.
     * @throws FoundTooFewEntitiesException  if no InkyGhostEntity is found.
     */
    private GhostEntity findInky()
        throws FoundTooManyEntitiesException, 
               FoundTooFewEntitiesException
    {
        final GhostEntity entity;
        
        entity = findGhostEntity(factory.getKeyForInkyGhostEntity());

        return (entity);
    }

    /**
     * Find the ClydeGhost entity on the world.
     * 
     * @return the BlinkyGhostEntity.
     * 
     * @throws FoundTooManyEntitiesException if more than one ClydeGhost is found.
     * @throws FoundTooFewEntitiesException  if no ClydeGhost is found.
     */
    private GhostEntity findClyde()
        throws FoundTooManyEntitiesException, 
               FoundTooFewEntitiesException
    {
        final GhostEntity entity;
        
        entity = findGhostEntity(factory.getKeyForClydeGhostEntity());

        return (entity);
    }

    /**
     * Find a Ghost entity on the world.
     * 
     * @param key the key of the ghost to find.
     * 
     * @return the GhostEntity.
     * 
     * @throws FoundTooManyEntitiesException if more than one of the specified Ghost is found.
     * @throws FoundTooFewEntitiesException  if none of the specified Ghost is found.
     */
    private GhostEntity findGhostEntity(final char key)
        throws FoundTooManyEntitiesException, 
               FoundTooFewEntitiesException
    {
        final GhostEntity entity;
        
        entity = findSingleEntityMustExist(key);

        return (entity);
    }
    
    /**
     * Find the teleporters on the world.
     * 
     * @return the Teleporter entities.
     * 
     * @throws FoundTooManyEntitiesException if more than two of the specified entity is found.
     * @throws FoundTooFewEntitiesException  if less than two of the specified entity is found.
     */
    private List<TeleportEntity> findTeleporters()
        throws FoundTooManyEntitiesException, 
               FoundTooFewEntitiesException
    {
        final List<TeleportEntity> entities;
        
        entities = findMultipleEntitiesMustExist(factory.getKeyForTeleportEntity(),
                                                 2);

        return (entities);
    }
    
    /**
     * Find a single entity on the world.
     * 
     * @param <T> The type of entity being searched for..
     * @param key the key of the entity to find.
     * 
     * @return the entity.
     * 
     * @throws FoundTooManyEntitiesException if more than one of the specified entity is found.
     * @throws FoundTooFewEntitiesException  if none of the specified entity is found.
     */
    private <T extends Entity> T findSingleEntityMustExist(final char key)
        throws FoundTooManyEntitiesException, 
               FoundTooFewEntitiesException
    {
        final List<T> entities;
        final T       entity;
        
        entities = findMultipleEntitiesMustExist(key, 1);
        entity   = entities.get(0);
        
        return (entity);
    }

    /**
     * Find a multiple entities on the world.
     * 
     * @param <T> The type of entity being searched for..
     * @param key                      the key of the entity to find.
     * @param expectedNumberofEntities the expected number of entities on the world. 
     * 
     * @return the entities.
     * 
     * @throws FoundTooManyEntitiesException if more than the expected number of the specified entity is found.
     * @throws FoundTooFewEntitiesException  if fewer than the expected number of the specified entity is found.
     */
    private <T extends Entity> List<T> findMultipleEntitiesMustExist(final char key,
                                                                     final int  expectedNumberofEntities)
        throws FoundTooManyEntitiesException, 
               FoundTooFewEntitiesException
    {
        final EntityFinder     finder;
        final EntityKeyMatcher matcher;
        final List<Tile>       tiles;
        final List<T>          entities;        
        
        finder  = new DefaultEntityFinder();
        matcher = new EntityKeyMatcher(key);
        tiles   = finder.findSpecificNumberOfEntities(world,
                                                      matcher,
                                                      expectedNumberofEntities);
        
        entities = new ArrayList<T>(tiles.size());
        
        for(final Tile tile : tiles)
        {
            final Entity entity;
            final char   entityKey;
            
            entity = tile.getEntity();

            if(entity == null)
            {
                throw new IllegalStateException("entity cannot be null");
            }
            
            entityKey = entity.getKey();
            
            if(key != entityKey)
            {
                throw new IllegalStateException("entity must have key: '" + key + "', but was: '" + entityKey + "'");
            }
            
            entities.add((T)entity);
        }
                
        return (entities);
    }

    /**
     * Update the game.  This is called each time a frame occurs.  Move PacMan and then the ghosts.
     * 
     * @param delta   the difference in time from the last frame to the current frame.
     * @param updater the game updater.
     * 
     * @throws CollisionException thrown if there is a problem with colliding entities.
     */
    @Override
    protected void updateState(final double       delta,
                               final WorldUpdater updater) 
        throws CollisionException
    {
        movePacMan(updater);
        moveGhosts(updater);
    }

    /**
     * Move the player.
     * 
     * @param updater the game updater.
     * 
     * @throws CollisionException thrown if there is a problem with colliding entities.
     */
    private void movePacMan(final WorldUpdater updater)
        throws CollisionException
    {
        moveEntity(pacman,
                   updater);
    }

    /**
     * Move the ghosts.
     * 
     * @param updater the game updater.
     * 
     * @throws CollisionException thrown if there is a problem with colliding entities.
     */
    private void moveGhosts(final WorldUpdater updater)
        throws CollisionException
    {
        moveGhost(blinky, 
                  updater);
        moveGhost(pinky, 
                  updater);
        moveGhost(inky, 
                  updater);
        moveGhost(clyde,
                  updater);
    }
    
    /**
     * Move a ghost.
     * 
     * @param ghost the ghost to move.
     * @param updater the game updater.
     * 
     * @throws CollisionException thrown if there is a problem with colliding entities.
     */
    private void moveGhost(final GhostEntity  ghost,
                           final WorldUpdater updater)
        throws CollisionException
    {
        moveEntity(ghost,
                   updater);
    }

    /**
     * Move an entity.  First try the desired entity, if that doesn't work try 
     * the current direction.
     * 
     * @param entity  the entity that is moving.
     * @param updater the game updater.
     * 
     * @return true of the entity was moved, false if it was not.
     * 
     * @throws CollisionException thrown if there is a problem with colliding entities.
     */
    private boolean moveEntity(final AbstractPacManGameMovableEntity<?> entity,
                               final WorldUpdater                       updater)
        throws CollisionException
    {
        final Direction desiredDirection;
        boolean         retVal;
        
        desiredDirection = entity.getDesiredDirection(this);
        retVal           = moveEntity(entity, 
                                      updater, 
                                      desiredDirection);

        if(retVal)
        {
            entity.setCurrentDirection(desiredDirection);
        }
        else
        {
            final Direction currentDirection;
            
            currentDirection = entity.getCurrentDirection();
            retVal           = moveEntity(entity, 
                                          updater, 
                                          currentDirection);
        }
        
        return (retVal);
    }
    
    /**
     * Move an entity in the specified direction.  If the entity moved then the 
     * updater is notified about the locations that changed and need to be redrawn.
     * 
     * @param entity    the entity to move.
     * @param updater   the game updater.
     * @param direction the direction to move.
     * 
     * @return true if the entity moved, false otherwise.
     * 
     * @throws CollisionException thrown if there is a problem with colliding entities.
     */
    private boolean moveEntity(final AbstractPacManGameMovableEntity<?> entity,
                               final WorldUpdater                       updater,
                               final Direction                          direction)
        throws CollisionException
    {
        final boolean retVal;
        
        if(direction == Direction.NONE)
        {
            retVal = false;
        }
        else
        {
            final int      byRows;
            final int      byColumns;
            final Location fromLocation;
            final int      fromRow;
            final int      fromColumn;
            final boolean  rowInRange;
            final boolean  columnInRange;
            
            if(entity == null)
            {
                throw new IllegalArgumentException("entity cannot be null");
            }

            if(updater == null)
            {
                throw new IllegalArgumentException("updater cannot be null");
            }

            byRows        = direction.getVertical();
            byColumns     = direction.getHorizontal();
            fromLocation  = entity.getLocation();

            if(fromLocation == null)
            {
                throw new IllegalStateException("fromLocation cannot be null " + entity);
            }

            fromRow       = fromLocation.getRow();
            fromColumn    = fromLocation.getColumn();
            rowInRange    = checkBounds(fromRow + byRows,
                                        0,
                                        world.getNumberOfRows() - 1);            
            columnInRange = checkBounds(fromColumn + byColumns,
                                        0,
                                        world.getNumberOfColumns() - 1);

            if(rowInRange && columnInRange)
            {
                final Location    toLocation;
                final MutableTile toTile;

                toLocation = Location.create(fromRow    + byRows, 
                                             fromColumn + byColumns, 
                                             world);
                toTile     = world.getTileAt(toLocation);

                if(entity.canMoveTo(toTile,
                                    direction))
                {
                    toTile.addEntity(entity);
                    entity.handleCollision(toTile,
                                           this);                    
                    updater.addUpdateLocation(fromLocation);
                    updater.addUpdateLocation(entity.getLocation());
                    retVal = true;
                }
                else
                {
                    retVal = false;
                }
            }
            else
            {
                retVal = false;
            }
        }
        
        return (retVal);
    }
            
    /**
     * Check to see if a number is in range.
     * 
     * @param actual the value to check.
     * @param min    the smallest allowable value.
     * @param max    the largest allowable value.
     * 
     * @return true if actual is in between min/max inclusively.
     */
    private static boolean checkBounds(final int actual,
                                       final int min,
                                       final int max)
    {
        final boolean retVal;
        
        if(actual < min)
        {
            retVal = false;
        }        
        else if(actual > max)
        {
            retVal = false;
        }
        else
        {
            retVal = true;
        }
        
        return (retVal);
    }

    /**
     * Redraw the world or changes to the world.
     * 
     * @param updater the world updater.
     */
    @Override
    public void render(final WorldUpdater updater) 
    {
        updater.drawChanges();
    }
    
    /**
     * Change the desired direction of PacMan, if the game is not paused.
     * 
     * @param direction the new desired direction.
     */
    private void changeDesiredDirection(final Direction direction)
    {
        if(!isPaused())
        {
            pacman.setDesiredDirection(direction);
        }
    }

    /**
     * Teleport an entity from one location to another.
     * 
     * @param entity the entity being teleported.
     * 
     * @throws CannotTeleportException if there is a problem teleporting the entity.
     */
    @Override
    public void teleport(final AbstractPacManGameMovableEntity<?> entity)
        throws CannotTeleportException
    {
        final Location    fromLocation;
        final Location    teleportALocation;
        final Location    teleportBLocation;
        final Location    toLocation;
        final MutableTile toTile;
        
        fromLocation      = entity.getLocation();
        teleportALocation = teleportA.getLocation();
        teleportBLocation = teleportB.getLocation();
        
        if(fromLocation.equals(teleportALocation))
        {
            toLocation = teleportBLocation;
        }
        else if(fromLocation.equals(teleportBLocation))
        {
            toLocation = teleportALocation;
        }
        else
        {
            final Tile fromTile;
            
            fromTile = world.getTileAt(fromLocation);
            
            throw new CannotTeleportException(fromLocation,
                                              entity,
                                              fromTile.getEntity(1));
        }
        
        toTile = world.getTileAt(toLocation);
        toTile.addEntity(entity);
    }

    /**
     * Eat a pellet.
     * 
     * @param pellet the pellet to eat.
     */
    @Override
    public void eatPellet(final PelletEntity pellet)
    {
        if(pellet == null)
        {
            throw new IllegalArgumentException("pellet cannot be null");
        }
        
        eat(pellet);
    }

    /**
     * Eat a power pellet.
     * 
     * @param powerPellet the power pellet to eat.
     */
    @Override
    public void eatPowerPellet(final PowerPelletEntity powerPellet)
    {
        if(powerPellet == null)
        {
            throw new IllegalArgumentException("powwerPellet cannot be null");
        }

        eat(powerPellet);
    }
    
    /**
     * Eat an entity, this will remove the entity from the tile it is currently on.
     * 
     * @param entity the entity to eat.
     */
    private void eat(final Entity entity)
    {
        final Location    location;
        final MutableTile tile;
        
        location = entity.getLocation();
        tile     = world.getTileAt(location);
        tile.removeEntity(entity);
    }
    
    /**
     * Handle the user input for moving Pac Man.
     */
    private class KeyHandler
        extends KeyAdapter
    {
        /**
         * Set the desired direction or toggle the pause state.
         * 
         * @param e the key that was pressed.
         */
        @Override
        public void keyPressed(final KeyEvent e) 
        {
            switch(e.getKeyCode())
            {
                case KeyEvent.VK_W:
                {
                    changeDesiredDirection(Direction.NORTH);
                    break;
                }
                case KeyEvent.VK_A:
                {
                    changeDesiredDirection(Direction.WEST);
                    break;
                }
                case KeyEvent.VK_D:
                {
                    changeDesiredDirection(Direction.EAST);
                    break;
                }
                case KeyEvent.VK_S:
                {
                    changeDesiredDirection(Direction.SOUTH);
                    break;
                }
                case KeyEvent.VK_X:
                {
                    changeDesiredDirection(Direction.NONE);
                    break;
                }
                case KeyEvent.VK_P:
                {
                    togglePause();
                    break;
                }
                default:
                {
                    // shut PMD up
                    break;
                }
            }
        }
    }
}
