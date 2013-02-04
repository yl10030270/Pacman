package ca.bcit.cst.comp2526.assign6.solution.game.pacman;


import ca.bcit.cst.comp2526.assign6.solution.game.MovableEntityData;


/**
 * The ghost named Clyde.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public final class ClydeGhostEntity
    extends GhostEntity
{
    /**
     * Construct a ClydeGhostEntity.
     * 
     * @param data the values for the entity state.
     */
    public ClydeGhostEntity(final MovableEntityData<PacManGame, GhostEntity> data)
    {
        super(data);
    }
}
