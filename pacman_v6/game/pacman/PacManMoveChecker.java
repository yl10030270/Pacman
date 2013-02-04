package ca.bcit.cst.comp2526.assign6.solution.game.pacman;


import ca.bcit.cst.comp2526.assign6.solution.Dimension;
import ca.bcit.cst.comp2526.assign6.solution.Direction;
import ca.bcit.cst.comp2526.assign6.solution.Entity;
import ca.bcit.cst.comp2526.assign6.solution.Tile;


/**
 * Check the moves for Pac Man.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public class PacManMoveChecker
    extends AbstractPacManGameMoveChecker<PacManEntity>
{
    @Override
    protected boolean doCanMoveInThatDirection(final PacManEntity entity,
                                               final Dimension    dimension,
                                               final Direction    direction)
    {
        final Direction strictDirection;
        final boolean   retVal;
        
        strictDirection = dimension.getStrictDirection();
        retVal          = strictDirection.equals(direction);
        
        return (retVal);
    }
    
    /**
     * Can the pacman move to the specified tile?
     * 
     * @param pacman    the pacman that is moving
     * @param tile      the tile being moved to.
     * @param dimension the distance and direction of the move.
     * @param direction the direction the pacman is moving already.
     * 
     * @return true if pacman can move to the specified tile, false otherwise.
     */
    @Override
    protected boolean doCanMoveToThatTile(final PacManEntity pacman,
                                          final Tile         tile,
                                          final Dimension    dimension,
                                          final Direction    direction)
    {
        final boolean retVal;
        final Entity  other;

        other = tile.getEntity();

        if(other instanceof DoorEntity)
        {
            retVal = false;
        }
        else
        {
            retVal = true;
        }
       
        return (retVal);
    }
}
