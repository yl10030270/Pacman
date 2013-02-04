package ca.bcit.cst.comp2526.assign6.solution.game;


import ca.bcit.cst.comp2526.assign6.solution.AbstractEntity;
import ca.bcit.cst.comp2526.assign6.solution.Dimension;
import ca.bcit.cst.comp2526.assign6.solution.Direction;
import ca.bcit.cst.comp2526.assign6.solution.Location;
import ca.bcit.cst.comp2526.assign6.solution.MutableTile;
import ca.bcit.cst.comp2526.assign6.solution.Tile;


/**
 * Convenience class for common movable entity features.
 * 
 * @param <T> The type of game being played.
 * @param <E> The type of the moving entity.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public abstract class AbstractMovableEntity<T extends Game,
                                             E extends AbstractMovableEntity<T, E>>
    extends    AbstractEntity
    implements MovableEntity<T, E>
{
    /**
     * Checks to see if a move is valid or not.
     */
    private MoveChecker<T, E> moveChecker;

    /**
     * Handles collisions with other entities.
     */
    private CollisionHandler<T, E> collisionHandler;

    /**
     * The direction this entity is currently moving.
     */
    private Direction currentDirection;    

    /**
     * The direction this entity would like to be moving in.
     */
    private Direction desiredDirection;
    
    /**
     * Construct an AbstractEntity with the values.
     * 
     * @param data    the values used for the entity.
     */
    protected AbstractMovableEntity(final MovableEntityData      data)
    {
        super(data);
               
        moveChecker      = data.getMoveChecker();
        collisionHandler = data.getCollisionHandler();
        currentDirection = Direction.NONE;
        desiredDirection = Direction.NONE;
    }
    
    /**
     * Set the current direction.
     * 
     * @param d the direction.
     */
    @Override
    public void setCurrentDirection(final Direction d)
    {
        currentDirection = d;
    }

    /**
     * Get the current direction.
     * 
     * @return the current direction.
     */
    @Override
    public Direction getCurrentDirection()
    {
        return (currentDirection);
    }
    
    /**
     * Set the desired direction for this entity.
     * 
     * @param d  the desired direction.
     */
    @Override
    public void setDesiredDirection(final Direction d)
    {
        desiredDirection = d;
    }
    
    /**
     * Get the desired direction for this entity.
     * 
     * @param game the game the entity is playing in.
     * 
     * @return the direction the entity wants to go.
     */
    @Override
    public Direction getDesiredDirection(final T game)
    {
        if(game == null)
        {
            throw new IllegalArgumentException("game cannot be null");
        }

        return (desiredDirection);
    }

    @Override
    public String toString()
    {
        return (super.toString() + " -> " + currentDirection + " -> " + desiredDirection);
    }
    
    /**
     * Check to see if this entity can move to the requested tile.
     * 
     * @param tile      the proposed tile.
     * @param direction the the direction being moved from.
     * 
     * @return true of this entity can move to the tile, false otherwise.
     */
    @Override
    public final boolean canMoveTo(final Tile      tile,
                                   final Direction direction)
    {
        final boolean   retVal;
        final Location  fromLocation;
        final Location  toLocation;
        final Dimension dimension;
        
        if(tile == null)
        {
            throw new IllegalArgumentException("tile cannot be null");
        }
        
        if(direction == null)
        {
            throw new IllegalArgumentException("direction cannot be null");
        }
        
        fromLocation = getLocation();
        toLocation   = tile.getLocation();
        dimension    = new Dimension(fromLocation, 
                                     toLocation);
        
        retVal = moveChecker.canMoveTo((E)this,
                                       tile,
                                       dimension,
                                       direction);
        
        return (retVal);
    }

    /**
     * Handle a collision with another entity.
     * 
     * @param tile the tile that the collision is occurring on.
     * @param game the game the collision is occurring in.
     * 
     * @throws CollisionException thrown if there is a problem with colliding entities.
     */
    @Override
    public final void handleCollision(final MutableTile tile,
                                      final T           game) 
        throws CollisionException
    {
        if(tile == null)
        {
            throw new IllegalArgumentException("tile cannot be null");
        }
        
        if(game == null)
        {
            throw new IllegalArgumentException("game cannot be null");
        }

        if(getLocation().getRectangle() != tile.getLocation().getRectangle())
        {
            throw new IllegalArgumentException("cannot collide on a different rectangle");
        }
        
        if(!(getLocation().equals(tile.getLocation())))
        {
            throw new IllegalArgumentException("cannot collide with a different tile.  Expected: " + 
                                               getLocation() + ", was: " + tile.getLocation());
        }
        
        collisionHandler.handleCollision((E)this, 
                                          tile.getEntity(1),
                                          game);
    }

    /**
     * Set the move checker.
     * 
     * @param checker the move checker.
     */
    @Override
    public final void setMoveChecker(final MoveChecker<T, E> checker)
    {
        if(checker == null)
        {
            throw new IllegalArgumentException("checker cannot be null");
        }
        
        moveChecker = checker;
    }

    /**
     * Get the move checker.
     * 
     * @return the move checker.
     */
    @Override
    public final MoveChecker<T, E> getMoveChecker()
    {
        return (moveChecker);
    }

    /**
     * Set the collision handler.
     * 
     * @param handler the collision handler.
     */
    @Override
    public final void setCollisionDector(final CollisionHandler<T, E> handler)
    {
        if(handler == null)
        {
            throw new IllegalArgumentException("handler cannot be null");
        }
        
        collisionHandler = handler;
    }

    /**
     * Get the collision handler.
     * 
     * @return the collision handler.
     */
    @Override
    public final CollisionHandler<T, E> getCollisionHandler()
    {
        return (collisionHandler);
    }
}


