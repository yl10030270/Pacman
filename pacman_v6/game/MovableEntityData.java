package ca.bcit.cst.comp2526.assign6.solution.game;


import ca.bcit.cst.comp2526.assign6.solution.EntityData;
import ca.bcit.cst.comp2526.assign6.solution.game.pathfinder.PathFinder;
import ca.bcit.cst.comp2526.assign6.solution.ui.console.ConsoleEntityRenderer;
import ca.bcit.cst.comp2526.assign6.solution.ui.swing.SwingEntityRenderer;
import java.awt.Color;


/**
 * Movable Entity Date.
 *
 * @author darcy
 * @param <T>
 * @param <E>
 *
 * @version 1.0
 */
public class MovableEntityData<T extends Game, E extends MovableEntity<T, E>>
    extends EntityData<T, E>
{
    /**
     * Checks to see if a move is valid or not.
     */
    private final MoveChecker<T, E> moveChecker;

    /**
     * Handles collisions with other entities.
     */
    private final CollisionHandler<T, E> collisionHandler;

    /**
     * The path finder.
     */
    private final PathFinder<T, E> pathFinder;

    /**
     * constructor.
     *
     * @param k       - key.
     * @param lbl     - label
     * @param c       - color
     * @param sr      - render
     * @param cr      - console render
     * @param checker - move checker
     * @param handler - handler
     * @param finder  - finder
     */
    public MovableEntityData(final char k,
                             final char lbl,
                             final Color c,
                             final SwingEntityRenderer sr,
                             final ConsoleEntityRenderer cr,
                             final MoveChecker<T, E> checker,
                             final CollisionHandler<T, E> handler,
                             final PathFinder<T, E> finder)
    {
        super(k,
              lbl,
              c,
              sr,
              cr);

        if(checker == null)
        {
            throw new IllegalArgumentException("checker cannot be null");
        }

        if(handler == null)
        {
            throw new IllegalArgumentException("handler cannot be null");
        }

        moveChecker = checker;
        collisionHandler = handler;
        pathFinder = finder;
    }

    /**
     * Get the move checker.
     *
     * @return the move checker.
     */
    public MoveChecker<T, E> getMoveChecker()
    {
        return (moveChecker);
    }

    /**
     * Get the collision handler.
     *
     * @return the collision handler.
     */
    public CollisionHandler<T, E> getCollisionHandler()
    {
        return (collisionHandler);
    }

    /**
     * Get the path finder.
     *
     * @return the path finder.
     */
    public PathFinder<T, E> getPathFinder()
    {
        return (pathFinder);
    }

}
