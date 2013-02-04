package ca.bcit.cst.comp2526.assign4.solution;


import ca.bcit.cst.comp2526.assign4.solution.worldreader.UnknownEntityTypeException;
import java.awt.Color;


/**
 * Create entities based on the value in a data source.
 *
 * @author Leon
 * @version 2.0
 */
public class BaseEntityFactory
    implements EntityFactory
{
    /**
     * Create an entity based on the character.
     *
     * @param type     the type of entity to create.
     * @param location the location that the entity is on.
     *
     * @return the entity created.
     *
     * @throws UnknownEntityTypeException if the type of entity is unrecognized.
     */
    @Override
    public final Entity createEntity(final char type,
                                     final Location location)
        throws UnknownEntityTypeException
    {
        final Entity entity;

        if(location == null)
        {
            throw new IllegalArgumentException("location cannot be null");
        }

        if(type == getKeyForNullEntity())
        {
            entity = null;
        }
        else
        {
            if(type == getKeyForWallEntity())
            {
                entity = new WallEntity(new EntityData(getKeyForWallEntity(), getLabelForWallEntity(),
                                                       getColourForWallEntity()));
            }
            else
            {
                entity = doCreateEntity(type,
                                        location);
            }
        }

        return (entity);
    }

    /**
     * Throws an UnknownEntityTypeException. It is intended that subclasses override this method.
     *
     * @param type     the type of entity to create.
     * @param location the location that the entity is on.
     *
     * @return the entity created.
     *
     * @throws UnknownEntityTypeException if the type of entity is unrecognized.
     */
    protected Entity doCreateEntity(final char type,
                                    final Location location)
        throws UnknownEntityTypeException
    {
        throw new UnknownEntityTypeException(type,
                                             location);
    }

    /**
     * Get the character for the null entity from a data source.
     *
     * @return '.'
     */
    @Override
    public char getKeyForNullEntity()
    {
        return ('.');
    }

    /**
     * Get the character for the wall entity from a data source.
     *
     * @return '*'
     */
    @Override
    public char getKeyForWallEntity()
    {
        return ('*');
    }

    /**
     * Get the character for the null entity for displaying.
     *
     * @return ' '.
     */
    @Override
    public char getLabelForNullEntity()
    {
        return (' ');
    }

    /**
     * Get the character for the wall entity for displaying.
     *
     * @return '*'.
     */
    @Override
    public char getLabelForWallEntity()
    {
        return ('*');
    }

    /**
     * Get the colour of the null entity..
     *
     * @return Color.BLACK.
     */
    @Override
    public Color getColourForNullEntity()
    {
        return Color.BLACK;
    }

    /**
     * Get the colour of the wall entity..
     *
     * @return Color.BLUE.
     */
    @Override
    public Color getColourForWallEntity()
    {
        return Color.BLUE;
    }

}