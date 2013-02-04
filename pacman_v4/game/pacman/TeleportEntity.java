/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign4.solution.game.pacman;


import ca.bcit.cst.comp2526.assign4.solution.AbstractEntity;
import ca.bcit.cst.comp2526.assign4.solution.EntityData;


/**
 * Allows entities to teleport from one part of a world to another.
 *
 * @author Leon
 * @version 1.0
 */
public final class TeleportEntity
    extends AbstractEntity
{
    /**
     * Construct a TeleportEntity.
     *
     * @param data - the values for the entity state.
     */
    public TeleportEntity(final EntityData data)
    {
        super(data);
    }

}
