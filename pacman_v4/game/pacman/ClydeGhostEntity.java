/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign4.solution.game.pacman;


import ca.bcit.cst.comp2526.assign4.solution.EntityData;
import ca.bcit.cst.comp2526.assign4.solution.game.pacman.pathfinder.GhostRandomPathFinder;


/**
 * The ghost named Clyde.
 *
 * @author Leon
 * @version 1.0
 */
public final class ClydeGhostEntity
    extends GhostEntity
{
    /**
     * Construct a ClydeGhostEntity.
     *
     * @param data - the values for the entity state.
     */
    public ClydeGhostEntity(final EntityData data)
    {
        super(data, new GhostRandomPathFinder());
    }

}
