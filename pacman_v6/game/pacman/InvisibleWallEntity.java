package ca.bcit.cst.comp2526.assign6.solution.game.pacman;


import ca.bcit.cst.comp2526.assign6.solution.AbstractEntity;
import ca.bcit.cst.comp2526.assign6.solution.EntityData;


/**
 * An invisible wall on a world.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public final class InvisibleWallEntity
    extends AbstractEntity
{
    /**
     * Construct a WallEntity.
     * 
     * @param data the values for the entity state.
     */
    public InvisibleWallEntity(final EntityData data)
    {
        super(data);
    }
}
