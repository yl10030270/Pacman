package ca.bcit.cst.comp2526.assign6.solution.game.pacman;


import ca.bcit.cst.comp2526.assign6.solution.game.MovableEntityData;


/**
 * The ghost named Pinky.
 *
 * @author D'Arcy Smith
 * @version 1.0
 */
public final class PinkyGhostEntity
    extends GhostEntity
{
    /**
     * Construct a PinkyGhostEntity.
     *
     * @param data the values for the entity state.
     */
    public PinkyGhostEntity(final MovableEntityData<PacManGame, GhostEntity> data)
    {
        super(data);
    }

}
