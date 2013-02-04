package ca.bcit.cst.comp2526.assign6.solution.entityfinder;


import ca.bcit.cst.comp2526.assign6.solution.Tile;
import ca.bcit.cst.comp2526.assign6.solution.World;
import java.util.List;


/**
 * Search a world, tile at a time, to find all of the instances of the requested entity types.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public interface EntityFinder
{
    /**
     * Find all the entities on the world that match.
     * 
     * @param world   the world to search.
     * @param matcher filter out the entities to look for.
     * @return        the tiles that have the matching entities.
     */
    List<Tile> findAllEntities(World         world,
                               EntityMatcher matcher);

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
    List<Tile> findSpecificNumberOfEntities(World         world,
                                            EntityMatcher matcher,
                                            int           expectedNumberOfEntities)
        throws FoundTooManyEntitiesException,
               FoundTooFewEntitiesException;
}
