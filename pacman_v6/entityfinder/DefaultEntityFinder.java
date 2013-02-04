package ca.bcit.cst.comp2526.assign6.solution.entityfinder;


import ca.bcit.cst.comp2526.assign6.solution.Entity;
import ca.bcit.cst.comp2526.assign6.solution.Location;
import ca.bcit.cst.comp2526.assign6.solution.Tile;
import ca.bcit.cst.comp2526.assign6.solution.World;
import java.util.ArrayList;
import java.util.List;


/**
 * Search a world, tile at a time, to find all of the instances of the requested entity types.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public final class DefaultEntityFinder
    implements EntityFinder
{
    /**
     * Find all the entities on the world that match.
     * 
     * @param world   the world to search.
     * @param matcher filter out the entities to look for.
     * @return        the tiles that have the matching entities.
     */
    @Override
    public List<Tile> findAllEntities(final World         world,
                                      final EntityMatcher matcher) 
    {
        final List<Tile> matchingTiles;
        final int        numberOfRows;
        final int        numberOfColumns;
        
        if(world == null)
        {
            throw new IllegalArgumentException("world cannot be null");
        }
        
        if(matcher == null)
        {
            throw new IllegalArgumentException("matcher cannot be null");
        }
        
        numberOfRows    = world.getNumberOfRows();
        numberOfColumns = world.getNumberOfColumns();
        matchingTiles   = new ArrayList<Tile>(numberOfRows * numberOfColumns);
        
        for(int row = 0; row < numberOfRows; row++)
        {
            for(int col = 0; col < numberOfColumns; col++)
            {
                final Location location;
                final Tile     tile;
                final Entity   entity;
                final boolean  accepted;
                
                location = Location.create(row, col, world);
                tile     = world.getTileAt(location);
                entity   = tile.getEntity();
                accepted = matcher.matches(entity);
                
                if(accepted)
                {
                    matchingTiles.add(tile);
                }
            }
        }
        
        return (matchingTiles);
    }
    
    /**
     * Find all the entities on the world that match.
     * 
     * @param world   the world to search.
     * @param matcher filter out the entities to look for.
     * @param expectedNumberOfEntities the number of entities expected.
     * @return the tiles that have the matching entities.
     * @throws FoundTooManyEntitiesException if the number of entities found is > expectedNumberOfEntities.
     * @throws FoundTooFewEntitiesException if the number of entities found is < expectedNumberOfEntities.
     */
    @Override
    public List<Tile> findSpecificNumberOfEntities(final World         world,
                                                   final EntityMatcher matcher,
                                                   final int           expectedNumberOfEntities)
        throws FoundTooManyEntitiesException,
               FoundTooFewEntitiesException
    {        
        final List<Tile> matchingTiles;
        final int        actualNumberOfEntities;
        final int        maxEntities;
        
        if(expectedNumberOfEntities < 0)
        {
            throw new IllegalArgumentException("expectedNumberOfEntities must be >= 0, was: " + expectedNumberOfEntities);
        }
        
        maxEntities =  world.getNumberOfRows() * world.getNumberOfColumns();
        
        if(expectedNumberOfEntities > maxEntities)
        {
            throw new IllegalArgumentException("expectedNumberOfEntities must be <= " + maxEntities + ", was: " + expectedNumberOfEntities);
        }
        
        matchingTiles          = findAllEntities(world,
                                                 matcher);
        actualNumberOfEntities = matchingTiles.size();
        
        if(actualNumberOfEntities > expectedNumberOfEntities)
        {
            throw new FoundTooManyEntitiesException(actualNumberOfEntities, 
                                                    expectedNumberOfEntities);
        }        
        
        if(actualNumberOfEntities < expectedNumberOfEntities)
        {
            throw new FoundTooFewEntitiesException(actualNumberOfEntities, 
                                                   expectedNumberOfEntities);
        }
        
        return (matchingTiles);
    }
}
