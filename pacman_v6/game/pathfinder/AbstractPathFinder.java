package ca.bcit.cst.comp2526.assign6.solution.game.pathfinder;


import ca.bcit.cst.comp2526.assign6.solution.Direction;
import ca.bcit.cst.comp2526.assign6.solution.Location;
import ca.bcit.cst.comp2526.assign6.solution.Tile;
import ca.bcit.cst.comp2526.assign6.solution.World;
import ca.bcit.cst.comp2526.assign6.solution.game.Game;
import ca.bcit.cst.comp2526.assign6.solution.game.MovableEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Find the direction to move next.
 * 
 * @param <T> The type of game being played.
 * @param <E> The type of the moving entity.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public abstract class AbstractPathFinder<T extends Game,
                                         E extends MovableEntity<T, E>>
    implements PathFinder<T, E>
{
    /**
     * Get the direction to move next.
     * 
     * @param game         the game being played.
     * @param movingEntity the entity that is moving.
     * 
     * @return the direction to move next.
     */
    @Override
    public final Direction getDirectionToMove(final T game,
                                              final E movingEntity)
    {
        final Direction       newDirection;
        final List<Direction> possibleDirections;

        if(game == null)
        {
            throw new IllegalArgumentException("game cannot be null");
        }

        if(movingEntity == null)
        {
            throw new IllegalArgumentException("entity cannot be null");
        }
        
        possibleDirections = getPossibleDirections(game,
                                                   movingEntity);
        
        newDirection = chooseDirection(game,
                                       movingEntity,
                                       possibleDirections);
        
        return (newDirection);
    }
    
    /**
     * Get the directions that the entity can possible move to.
     * 
     * @param game   the game being played.
     * @param entity the entity that is moving.
     * 
     * @return the directions that the entity can possibly move to.
     */
    protected List<Direction> getPossibleDirections(final T game,
                                                    final E entity)
    {
        final Location                 currentLocation;
        final World                    world;
        final List<Direction>          directionsToLookAt;
        final Map<Direction, Location> locations;
        final List<Direction>          possibleDirections;

        currentLocation    = entity.getLocation();
        world              = game.getWorld();
        directionsToLookAt = getDirectionsToLookAt(game, 
                                                   entity);        
        locations = world.getTilesAround(currentLocation,
                                         directionsToLookAt);
        
        possibleDirections = new ArrayList<Direction>();
        
        for(final Map.Entry<Direction, Location> entry : locations.entrySet())
        {
            final Direction possibleDirection;
            final Location  location;
            final Tile      tile;

            possibleDirection = entry.getKey();
            location          = entry.getValue();
            tile              = world.getTileAt(location);
            
            if(entity.canMoveTo(tile,
                                possibleDirection))
            {
                possibleDirections.add(possibleDirection);
            }
        }
        
        return (possibleDirections);
    }
    
    /**
     * Get the directions that should be considered when moving.
     * 
     * @param game   the game being played.
     * @param entity the entity that is moving.
     * 
     * @return the directions that the entity should consider moving in.
     */
    protected abstract List<Direction> getDirectionsToLookAt(T game,
                                                             E entity);
    
    /**
     * Pick the direction to move in.
     * 
     * @param game               the game being played.
     * @param entity             the entity that is moving.
     * @param possibleDirections the directions that are possible to move.
     * 
     * @return the direction to move.
     */
    protected abstract Direction chooseDirection(T               game,
                                                 E               entity,
                                                 List<Direction> possibleDirections);
}
