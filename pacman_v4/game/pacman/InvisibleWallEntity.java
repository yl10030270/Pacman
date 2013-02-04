/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign4.solution.game.pacman;


import ca.bcit.cst.comp2526.assign4.solution.AbstractEntity;
import ca.bcit.cst.comp2526.assign4.solution.EntityData;


/**
 * An invisible wall on a world.
 *
 * @author Leon
 * @version 1.0
 */
public final class InvisibleWallEntity
    extends AbstractEntity
{
    /**
     * Construct a WallEntity.
     *
     * @param data - the values for the entity state.
     */
    public InvisibleWallEntity(final EntityData data)
    {
        super(data);
    }

}
