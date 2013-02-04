/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign4.solution.game.pacman;


import ca.bcit.cst.comp2526.assign4.solution.EntityData;


/**
 * A pac man on a world.
 *
 * @author Leon
 * @version 1.0
 */
public final class PacManEntity
    extends AbstractPacManGameMovableEntity<PacManEntity>
{
    /**
     * Construct a PacManEntity.
     *
     * @param data - the values for the entity state.
     */
    public PacManEntity(final EntityData data)
    {
        super(data, new PacManMoveChecker(), new RegularPacManCollisionHandler());
    }

}
