/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign4.solution.game;


import ca.bcit.cst.comp2526.assign4.solution.Dimension;
import ca.bcit.cst.comp2526.assign4.solution.Direction;
import ca.bcit.cst.comp2526.assign4.solution.Tile;


/**
 * Check to see if an entity can move to a particular tile.
 *
 * @param <T> The type of game being played.
 * @param <E> The type of the moving entity.
 *
 * @author leon
 * @version 1.0
 */
public interface MoveChecker<T extends Game, E extends MovableEntity<T, E>>
{
    /**
     * Check to see if the entity can move to the tile.
     *
     * @param movingEntity - the entity that is moving to the tile.
     * @param tile         - the tile being moved to.
     * @param dimension    - the distance and direction to the tile from where the entity is moving from.
     * @param direction    - the direction that the entity is currently traveling.
     *
     * @return true if the entity can move to the tile, false if it cannot.
     */
    boolean canMoveTo(E movingEntity,
                      Tile tile,
                      Dimension dimension,
                      Direction direction);

}
