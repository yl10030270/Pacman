package ca.bcit.cst.comp2526.assign6.solution;


import ca.bcit.cst.comp2526.assign6.solution.renderers.SwingNullRenderer;
import ca.bcit.cst.comp2526.assign6.solution.renderers.SwingWallRenderer;
import ca.bcit.cst.comp2526.assign6.solution.ui.console.ConsoleEntityRenderer;
import ca.bcit.cst.comp2526.assign6.solution.ui.swing.SwingEntityRenderer;
import ca.bcit.cst.comp2526.assign6.solution.worldreader.UnknownEntityTypeException;
import java.awt.Color;


/**
 * Create entities based on the value in a data source.
 * 
 * @author D'Arcy Smnith
 * @version 1.1
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
    public final Entity createEntity(final char     type,
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
        else if(type == getKeyForWallEntity())
        {
            final EntityData data;
            
            data = new EntityData(getKeyForWallEntity(),
                                  getLabelForWallEntity(),
                                  getColourForWallEntity(),
                                  getSwingEntityRendererForWallEntity(),
                                  getConsoleEntityRendererForNullEntity());
            entity = new WallEntity(data);
        }
        else
        {
            entity = doCreateEntity(type,
                                    location);
        }
        
        return (entity);
    }
    
    /**
     * Throws an UnknownEntityTypeException.  It is intended that subclasses override this method.
     * 
     * @param type     the type of entity to create.
     * @param location the location that the entity is on. 
     * 
     * @return the entity created.
     * 
     * @throws UnknownEntityTypeException if the type of entity is unrecognized.
     */
    protected Entity doCreateEntity(final char     type,
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
     * Get the colour of the null entity.
     * 
     * @return Color.BLACK.
     */
    @Override
    public Color getColourForNullEntity()
    {
        return (Color.BLACK);
    }

    /**
     * Get the colour of the null entity.
     * 
     * @return Color.BLUE.
     */
    @Override
    public Color getColourForWallEntity()
    {
        return (Color.BLUE);
    }
    
    /**
     * Get the renderer used to draw the null entity via swing.
     * 
     * @return the renderer used to draw the null entity via swing.
     */
    @Override
    public SwingEntityRenderer getSwingEntityRendererForNullEntity()
    {
        return new SwingNullRenderer();
    }
    
    /**
     * Get the renderer used to draw the wall entity via swing.
     * 
     * @return the renderer used to draw the wall entity via swing.
     */
    @Override
    public SwingEntityRenderer getSwingEntityRendererForWallEntity()
    {
        return new SwingWallRenderer();
    }
    
    /**
     * Get the renderer used to draw the null entity via console.
     * 
     * @return the renderer used to draw the null entity via console.
     */
    @Override
    public ConsoleEntityRenderer getConsoleEntityRendererForNullEntity()
    {
        return (new ConsoleEntityRenderer());
    }
    
    /**
     * Get the renderer used to draw the wall entity via console.
     * 
     * @return the renderer used to draw the wall entity via console.
     */
    @Override
    public ConsoleEntityRenderer getConsoleEntityRendererForWallEntity()
    {
        return (new ConsoleEntityRenderer());
    }
}
