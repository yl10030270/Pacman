/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign4.solution.game.pathfinder;


import ca.bcit.cst.comp2526.assign4.solution.Direction;
import ca.bcit.cst.comp2526.assign4.solution.Location;
import ca.bcit.cst.comp2526.assign4.solution.World;
import ca.bcit.cst.comp2526.assign4.solution.game.Game;
import ca.bcit.cst.comp2526.assign4.solution.game.MovableEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Find the direction to move next.
 *
 * @param <T> - The type of game being played.
 * @param <E> - The type of the moving entity.
 *
 * @author Leon
 * @version 1.0
 */
public abstract class AbstractPathFinder<T extends Game, E extends MovableEntity<T, E>>
    implements PathFinder<T, E>
{
    /**
     * Get the direction to move next.
     *
     * @param game         - the game being played.
     * @param movingEntity - the entity that is moving.
     *
     * @return the direction to move next.
     */
    @Override
    public final Direction getDirectionToMove(final T game,
                                              final E movingEntity)
    {
        if(game == null)
        {
            throw new IllegalArgumentException("game cannot be null");
        }
        if(movingEntity == null)
        {
            throw new IllegalArgumentException("entity cannot be null");
        }
        final List<Direction> possibleDirections = getPossibleDirections(game, movingEntity);
        return chooseDirection(game, movingEntity, possibleDirections);

    }

    /**
     * Get the directions that the entity can possible move to.
     *
     * @param game   - the game being played.
     * @param entity - the entity that is moving.
     *
     * @return the directions that the entity can possibly move to.
     */
    protected List<Direction> getPossibleDirections(final T game,
                                                    final E entity)
    {
        final List<Direction> possibleDirections = new ArrayList<>();
        final List<Direction> dirList;
        final World world = game.getWorld();
        final Location loc = entity.getLocation();
        final Map<Direction, Location> map;
        dirList = getDirectionsToLookAt(game, entity);
        map = world.getTilesAround(loc, dirList);
        for(Direction d : dirList)
        {
            if(map.containsKey(d) && !possibleDirections.contains(d))
            {
                final Location toLocation = map.get(d);
                if(entity.canMoveTo(world.getTileAt(toLocation), d))
                {
                    possibleDirections.add(d);
                }
            }
        }
        return possibleDirections;
    }

    /**
     * Get the directions that should be considered when moving.
     *
     * @param game   - the game being played.
     * @param entity - the entity that is moving.
     *
     * @return the directions that the entity should consider moving in.
     */
    protected abstract List<Direction> getDirectionsToLookAt(T game,
                                                             E entity);

    /**
     * Pick the direction to move in.
     *
     * @param game               - the game being played.
     * @param entity             - the entity that is moving.
     * @param possibleDirections - the directions that are possible to move.
     *
     * @return the direction to move.
     */
    protected abstract Direction chooseDirection(T game,
                                                 E entity,
                                                 List<Direction> possibleDirections);

}
