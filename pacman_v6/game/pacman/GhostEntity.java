package ca.bcit.cst.comp2526.assign6.solution.game.pacman;


import ca.bcit.cst.comp2526.assign6.solution.Direction;
import ca.bcit.cst.comp2526.assign6.solution.game.MovableEntityData;
import ca.bcit.cst.comp2526.assign6.solution.game.pathfinder.PathFinder;


/**
 * A ghost on a world.
 *
 * @author D'Arcy Smith
 * @version 1.0
 */
public abstract class GhostEntity
    extends AbstractPacManGameMovableEntity<GhostEntity>
{
    /**
     * path finder.
     */
    private PathFinder<PacManGame, GhostEntity> pathFinder;

    /**
     * Construct a GhostEntity.
     *
     * @param data the values for the entity state.
     */
    public GhostEntity(final MovableEntityData<PacManGame, GhostEntity> data)
    {
        super(data);

        pathFinder = data.getPathFinder();

        if(pathFinder == null)
        {
            throw new IllegalStateException("path finder cannot be null");
        }
    }

    /**
     * Get the desired direction to move. This uses the path finder.
     *
     * @param game the game being played in.
     *
     * @return the direction that the ghost should move next.
     */
    @Override
    public Direction getDesiredDirection(final PacManGame game)
    {
        final Direction direction;

        direction = pathFinder.getDirectionToMove(game,
                                                  this);

        if(direction == null)
        {
            throw new IllegalStateException();
        }

        setCurrentDirection(direction);

        return (direction);
    }

    /**
     * Set the path finder.
     *
     * @param finder the path finder.
     */
    public void setPathFinder(final PathFinder<PacManGame, GhostEntity> finder)
    {
        if(finder == null)
        {
            throw new IllegalArgumentException("finder cannot be null");
        }

        pathFinder = finder;
    }

    /**
     * Get the path finder.
     *
     * @return the path finder.
     */
    public PathFinder<PacManGame, GhostEntity> getPathFinder()
    {
        return (pathFinder);
    }

}
