/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign4.solution.entityfinder;


import ca.bcit.cst.comp2526.assign4.solution.Location;
import ca.bcit.cst.comp2526.assign4.solution.Tile;
import ca.bcit.cst.comp2526.assign4.solution.World;
import java.util.ArrayList;
import java.util.List;


/**
 * Search a world, tile at a time, to find all of the instances of the requested entity types.
 *
 * @author leon
 * @version 1.0
 */
public final class DefaultEntityFinder
    implements EntityFinder
{
    /**
     * Find all the entities on the world that match.
     *
     * @param world   - the world to search.
     * @param matcher - filter out the entities to look for.
     *
     * @return the tiles that have the matching entities.
     */
    @Override
    public List<Tile> findAllEntities(final World world,
                                      final EntityMatcher matcher)
    {
        if(world == null)
        {
            throw new IllegalArgumentException("world cannot be null");
        }
        if(matcher == null)
        {
            throw new IllegalArgumentException("matcher cannot be null");
        }
        final List<Tile> tilelist = new ArrayList<>();
        final int rows = world.getNumberOfRows();
        final int cols = world.getNumberOfColumns();
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                final Tile tmptile;
                tmptile = world.getTileAt(Location.create(i, j, world));
                matchEntityOnTile(tmptile, matcher, tilelist);
            }
        }
        return tilelist;
    }

    /**
     * Test if the entity that we are looking for exist on this tile.
     *
     * @param tmptile  the tile that be scanned.
     * @param matcher  filter out the entities to look for.
     * @param tilelist the tiles list that matching entities.
     */
    private void matchEntityOnTile(final Tile tmptile,
                                   final EntityMatcher matcher,
                                   final List<Tile> tilelist)
    {
        for(int k = 0; k < tmptile.getNumberOfEntities(); k++)
        {
            if(matcher.matches(tmptile.getEntity(k)))
            {
                tilelist.add(tmptile);
                break;
            }
        }
    }

    /**
     * Find all the entities on the world that match.
     *
     * @param world                    - the world to search.
     * @param matcher                  - filter out the entities to look for.
     * @param expectedNumberOfEntities - the number of entities expected.
     *
     * @return the tiles that have the matching entities and matching the expected number.
     *
     * @throws FoundTooManyEntitiesException - if the number of entities found is > expectedNumberOfEntities.
     * @throws FoundTooFewEntitiesException  - if the number of entities found is < expectedNumberOfEntities.
     */
    @Override
    public List<Tile> findSpecificNumberOfEntities(final World world,
                                                   final EntityMatcher matcher,
                                                   final int expectedNumberOfEntities)
        throws FoundTooManyEntitiesException,
               FoundTooFewEntitiesException
    {
        final int rows = world.getNumberOfRows();
        final int cols = world.getNumberOfColumns();
        if(expectedNumberOfEntities < 0)
        {
            throw new IllegalArgumentException("expectedNumberOfEntities must be >= 0, was: " + expectedNumberOfEntities);
        }
        if(expectedNumberOfEntities > rows * cols)
        {
            throw new IllegalArgumentException("expectedNumberOfEntities must be <= " + rows * cols + ", was: " +
                expectedNumberOfEntities);
        }
        final List<Tile> tilelist;
        tilelist = findAllEntities(world, matcher);
        final int find = tilelist.size();
        if(find > expectedNumberOfEntities)
        {
            throw new FoundTooManyEntitiesException(find, expectedNumberOfEntities);
        }
        if(find < expectedNumberOfEntities)
        {
            throw new FoundTooFewEntitiesException(find, expectedNumberOfEntities);
        }
        return tilelist;
    }

}
