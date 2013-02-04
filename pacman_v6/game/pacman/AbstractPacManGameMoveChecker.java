package ca.bcit.cst.comp2526.assign6.solution.game.pacman;


import ca.bcit.cst.comp2526.assign6.solution.Dimension;
import ca.bcit.cst.comp2526.assign6.solution.Direction;
import ca.bcit.cst.comp2526.assign6.solution.Entity;
import ca.bcit.cst.comp2526.assign6.solution.Tile;
import ca.bcit.cst.comp2526.assign6.solution.WallEntity;
import ca.bcit.cst.comp2526.assign6.solution.game.AbstractMoveChecker;


/**
 * Check the moves for a Pac Man game entity.
 * 
 * @param <T> the type of entity being moved.
 * @author D'Arcy Smith
 * @version 1.0
 */
public abstract class AbstractPacManGameMoveChecker<T extends AbstractPacManGameMovableEntity<T>>
    extends AbstractMoveChecker<PacManGame,
                                T>
{
    /**
     * Can the entity move in that direction (NORTH, SOUTH, EAST, WEST).
     * 
     * @param entity    the entity that is moving
     * @param dimension the distance and direction of the move.
     * @param direction the direction the entity is moving already.
     * 
     * @return true if the entity can move in the specified direction, false otherwise.
     */
    @Override
    protected final boolean canMoveInThatDirection(final T         entity,
                                                   final Dimension dimension,
                                                   final Direction direction)
    {
        final Direction strictDirection;
        final boolean   retVal;
        
        strictDirection = dimension.getStrictDirection();
        
        if(strictDirection == null)
        {
            retVal = false;
        }
        else if(strictDirection.isCardinal())
        {
            retVal = doCanMoveInThatDirection(entity, 
                                              dimension,
                                              direction);
        }
        else
        {
            retVal = false;
        }
        
        return (retVal);
    }

    /**
     * Can the entity move that far away? (1 square only)
     * 
     * @param entity    the entity that is moving
     * @param dimension the distance and direction of the move.
     * @param direction the direction the entity is moving already.
     * 
     * @return true if entity can move in the specified distance, false otherwise.
     */
    @Override
    protected boolean canMoveThatDistance(final T         entity,
                                          final Dimension dimension,
                                          final Direction direction)
    {
        final int     rowDistance;
        final int     columnDistance;
        final boolean retVal;
        
        rowDistance    = dimension.getAbsoluteRowDistance();
        columnDistance = dimension.getAbsoluteColumnDistance();        
        retVal         = (rowDistance + columnDistance == 1);
        
        return (retVal);
    }
    
    /**
     * Can the entity move to the specified tile?
     * 
     * @param entity    the entity that is moving
     * @param tile      the tile being moved to.
     * @param dimension the distance and direction of the move.
     * @param direction the direction the entity is moving already.
     * 
     * @return true if entity can move to the specified tile, false otherwise.
     */
    @Override
    protected final boolean canMoveToThatTile(final T         entity,
                                              final Tile      tile,
                                              final Dimension dimension,
                                              final Direction direction)
    {
        final boolean retVal;
        final Entity  other;

        other = tile.getEntity();

        if(other instanceof WallEntity)
        {
            retVal = false;
        }
        else if(other instanceof InvisibleWallEntity)
        {
            retVal = false;
        }
        else
        {
            retVal = doCanMoveToThatTile(entity,
                                         tile,
                                         dimension,
                                         direction);
        }
       
        return (retVal);
    }
    
    /**
     * Can the entity move to the specified direction?
     * 
     * @param entity    the entity that is moving
     * @param dimension the distance and direction of the move.
     * @param direction the direction the entity is moving already.
     * 
     * @return true if the entity can move in the specified direction, false otherwise.
     */
    protected abstract boolean doCanMoveInThatDirection(T         entity,
                                                        Dimension dimension,
                                                        Direction direction);
    
    /**
     * Can the entity move to the specified direction?
     * 
     * @param entity    the entity that is moving
     * @param tile      the tile being moved to.
     * @param dimension the distance and direction of the move.
     * @param direction the direction the entity is moving already.
     * 
     * @return true if the entity can move to the specified tile, false otherwise.
     */
    protected  abstract boolean doCanMoveToThatTile(T         entity,
                                                    Tile      tile,
                                                    Dimension dimension,
                                                    Direction direction);
}
