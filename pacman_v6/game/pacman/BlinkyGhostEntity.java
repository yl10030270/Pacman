package ca.bcit.cst.comp2526.assign6.solution.game.pacman;


import ca.bcit.cst.comp2526.assign6.solution.game.MovableEntityData;


/**
 * The ghost named Blinky.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public final class BlinkyGhostEntity
    extends GhostEntity
{
    /**
     * Construct a BlinkyGhostEntity.
     * 
     * @param data the values for the entity state.
     */
    public BlinkyGhostEntity(final MovableEntityData<PacManGame, GhostEntity> data)
    {
        super(data);
    }
}
