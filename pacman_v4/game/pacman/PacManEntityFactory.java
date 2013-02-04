/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign4.solution.game.pacman;


import ca.bcit.cst.comp2526.assign4.solution.BaseEntityFactory;
import ca.bcit.cst.comp2526.assign4.solution.Entity;
import ca.bcit.cst.comp2526.assign4.solution.EntityData;
import ca.bcit.cst.comp2526.assign4.solution.Location;
import ca.bcit.cst.comp2526.assign4.solution.worldreader.UnknownEntityTypeException;
import java.awt.Color;


/**
 * Create entities for a PacMan game based on the value in a data source.
 *
 * @author Leon
 * @version 1.0
 */
public class PacManEntityFactory
    extends BaseEntityFactory
{
    /**
     * Create an entity for a PacMan game.
     *
     * @param type     the type of entity to create.
     * @param location the location that the entity is on.
     *
     * @return the entity created.
     *
     * @throws UnknownEntityTypeException if the type of entity is unrecognized.
     */
    @Override
    protected Entity doCreateEntity(final char type,
                                    final Location location)
        throws UnknownEntityTypeException
    {
        final Entity retval;
        if(type == getKeyForBlinkyGhostEntity())
        {
            retval = new BlinkyGhostEntity(new EntityData(getKeyForBlinkyGhostEntity(),
                                                          getLabelForBlinkyGhostEntity(),
                                                          getColourForBlinkyGhostEntity()));
        }
        else if(type == getKeyForClydeGhostEntity())
        {
            retval = new ClydeGhostEntity(new EntityData(getKeyForClydeGhostEntity(),
                                                         getLabelForClydeGhostEntity(),
                                                         getColourForClydeGhostEntity()));
        }
        else if(type == getKeyForDoorEntity())
        {
            retval = new DoorEntity(new EntityData(getKeyForDoorEntity(), getLabelForDoorEntity(),
                                                   getColourForDoorEntity()));
        }
        else if(type == getKeyForInkyGhostEntity())
        {
            retval = new InkyGhostEntity(new EntityData(getKeyForInkyGhostEntity(), getLabelForInkyGhostEntity(),
                                                        getColourForInkyGhostEntity()));
        }
        else if(type == getKeyForInvisibleWallEntity())
        {
            retval = new InvisibleWallEntity(new EntityData(getKeyForInvisibleWallEntity(),
                                                            getLabelForInvisibleWallEntity(),
                                                            getColourForInvisibleWallEntity()));
        }
        else if(type == getKeyForPacManEntity())
        {
            retval = new PacManEntity(new EntityData(getKeyForPacManEntity(), getLabelForPacManEntity(),
                                                     getColourForPacManEntity()));
        }
        else if(type == getKeyForPelletEntity())
        {
            retval = new PelletEntity(new EntityData(getKeyForPelletEntity(), getLabelForPelletEntity(),
                                                     getColourForPelletEntity()));
        }
        else if(type == getKeyForPinkyGhostEntity())
        {
            retval = new PinkyGhostEntity(new EntityData(getKeyForPinkyGhostEntity(),
                                                         getLabelForPinkyGhostEntity(),
                                                         getColourForPinkyGhostEntity()));
        }
        else if(type == getKeyForPowerPelletEntity())
        {
            retval = new PowerPelletEntity(new EntityData(getKeyForPowerPelletEntity(),
                                                          getLabelForPowerPelletEntity(),
                                                          getColourForPowerPelletEntity()));
        }
        else if(type == getKeyForTeleportEntity())
        {
            retval = new TeleportEntity(new EntityData(getKeyForTeleportEntity(), getLabelForTeleportEntity(),
                                                       getColourForTeleportEntity()));
        }
        else
        {
            throw new UnknownEntityTypeException(type, location);
        }

        return retval;
    }

    /**
     * Get the character for the null entity from a data source.
     *
     * @return '.'
     */
    @Override
    public char getKeyForNullEntity()
    {
        return '-';
    }

    /**
     * Get the character for the wall entity from a data source.
     *
     * @return '+'
     */
    @Override
    public char getKeyForWallEntity()
    {
        return '+';
    }

    /**
     * Get the character for the pac man entity from a data source.
     *
     * @return 'P'
     */
    public char getKeyForPacManEntity()
    {
        return 'P';
    }

    /**
     * Get the character for the Blinky ghost entity from a data source.
     *
     * @return '1'
     */
    public char getKeyForBlinkyGhostEntity()
    {
        return '1';
    }

    /**
     * Get the character for the Pinky ghost entity from a data source.
     *
     * @return '2'
     */
    public char getKeyForPinkyGhostEntity()
    {
        return '2';
    }

    /**
     * Get the character for the Inky ghost entity from a data source.
     *
     * @return '3'
     */
    public char getKeyForInkyGhostEntity()
    {
        return '3';
    }

    /**
     * Get the character for the Clyde ghost entity from a data source.
     *
     * @return '4'
     */
    public char getKeyForClydeGhostEntity()
    {
        return '4';
    }

    /**
     * Get the character for the pellet entity from a data source.
     *
     * @return '.'
     */
    public char getKeyForPelletEntity()
    {
        return '.';
    }

    /**
     * Get the character for the power pellet entity from a data source.
     *
     * @return '*'
     */
    public char getKeyForPowerPelletEntity()
    {
        return '*';
    }

    /**
     * Get the character for the door entity from a data source.
     *
     * @return '^'
     */
    public char getKeyForDoorEntity()
    {
        return '^';
    }

    /**
     * Get the character for the teleport entity from a data source.
     *
     * @return 'T'
     */
    public char getKeyForTeleportEntity()
    {
        return 'T';
    }

    /**
     * Get the character for the invisible wall entity from a data source.
     *
     * @return 'I'
     */
    public char getKeyForInvisibleWallEntity()
    {
        return 'I';
    }

    /**
     * Get the character for the null entity for displaying.
     *
     * @return ' '.
     */
    @Override
    public char getLabelForNullEntity()
    {
        return ' ';
    }

    /**
     * Get the character for the wall entity for displaying.
     *
     * @return '+'.
     */
    @Override
    public char getLabelForWallEntity()
    {
        return '+';
    }

    /**
     * Get the character for the pacman entity for displaying.
     *
     * @return 'P'.
     */
    public char getLabelForPacManEntity()
    {
        return 'P';
    }

    /**
     * Get the character for the Blinky Ghost entity for displaying.
     *
     * @return '1'.
     */
    public char getLabelForBlinkyGhostEntity()
    {
        return '1';
    }

    /**
     * Get the character for the Pinky Ghost entity for displaying.
     *
     * @return '2'.
     */
    public char getLabelForPinkyGhostEntity()
    {
        return '2';
    }

    /**
     * Get the character for the Inky Ghost entity for displaying.
     *
     * @return '3'.
     */
    public char getLabelForInkyGhostEntity()
    {
        return '3';
    }

    /**
     * Get the character for the Clyde Ghost entity for displaying.
     *
     * @return '4'.
     */
    public char getLabelForClydeGhostEntity()
    {
        return '4';
    }

    /**
     * Get the character for the pellet entity for displaying.
     *
     * @return '.'.
     */
    public char getLabelForPelletEntity()
    {
        return '.';
    }

    /**
     * Get the character for the power pellet entity for displaying.
     *
     * @return '*'.
     */
    public char getLabelForPowerPelletEntity()
    {
        return '*';
    }

    /**
     * Get the character for the door entity for displaying.
     *
     * @return getLabelForNullEntity().
     */
    public char getLabelForDoorEntity()
    {
        return getLabelForNullEntity();
    }

    /**
     * Get the character for the invisible wall entity for displaying.
     *
     * @return getLabelForNullEntity().
     */
    public char getLabelForInvisibleWallEntity()
    {
        return getLabelForNullEntity();
    }

    /**
     * Get the character for the teleport entity for displaying.
     *
     * @return getLabelForNullEntity().
     */
    public char getLabelForTeleportEntity()
    {
        return getLabelForNullEntity();
    }

    /**
     * Get the color of the Pac Man entity.
     *
     * @return Color.YELLOW.
     */
    public Color getColourForPacManEntity()
    {
        return Color.YELLOW;
    }

    /**
     * Get the color of the Blinky Ghost entity.
     *
     * @return Color.RED.
     */
    public Color getColourForBlinkyGhostEntity()
    {
        return Color.RED;
    }

    /**
     * Get the color of the Pinky Ghost entity.
     *
     * @return Color.PINK.
     */
    public Color getColourForPinkyGhostEntity()
    {
        return Color.PINK;
    }

    /**
     * Get the color of the Inky Ghost entity.
     *
     * @return Color.CYAN.
     */
    public Color getColourForInkyGhostEntity()
    {
        return Color.CYAN;
    }

    /**
     * Get the color of the Clyde Ghost entity.
     *
     * @return Color.ORANGE.
     */
    public Color getColourForClydeGhostEntity()
    {
        return Color.ORANGE;
    }

    /**
     * Get the colour of the pellet entity.
     *
     * @return Color.MAGENTA.
     */
    public Color getColourForPelletEntity()
    {
        return Color.MAGENTA;
    }

    /**
     *
     * Get the colour of the powerpellet entity.
     *
     * @return Color.GREEN.
     */
    public Color getColourForPowerPelletEntity()
    {
        return Color.GREEN;
    }

    /**
     * Get the colour of the door entity.
     *
     * @return getColourForNullEntity().
     */
    public Color getColourForDoorEntity()
    {
        return Color.BLACK;
    }

    /**
     * Get the colour of the invisible wall entity.
     *
     * @return getColourForInvisibelWallEntity().
     */
    public Color getColourForInvisibleWallEntity()
    {
        return Color.BLACK;
    }

    /**
     * Get the colour of the teleport entity.
     *
     * @return getColourForNullEntity().
     */
    public Color getColourForTeleportEntity()
    {
        return Color.BLACK;
    }

}
