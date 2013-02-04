package ca.bcit.cst.comp2526.assign6.solution.game.pacman;


import ca.bcit.cst.comp2526.assign6.solution.game.MovableEntityData;


/**
 * The ghost named Inky.
 *
 * @author D'Arcy Smith
 * @version 1.0
 */
public final class InkyGhostEntity
    extends GhostEntity
{
    /**
     * Construct a InkyGhostEntity.
     *
     * @param data the values for the entity state.
     */
    public InkyGhostEntity(final MovableEntityData<PacManGame, GhostEntity> data)
    {
        super(data);
    }

}
