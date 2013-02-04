package ca.bcit.cst.comp2526.assign4.solution.ui.swing;


import ca.bcit.cst.comp2526.assign4.solution.Entity;
import ca.bcit.cst.comp2526.assign4.solution.EntityFactory;
import ca.bcit.cst.comp2526.assign4.solution.Tile;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


/**
 * Displays a tile of a world.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public class TilePanel
    extends JPanel
{
    /**
     * Constant serialized ID used for compatibility.
     */
    private static final long serialVersionUID = 0;
    
    /**
     * The tile to display.
     */
    private final transient Tile tile;
    
    /**
     * The entity factory.
     */
    private final transient EntityFactory factory;
    
    /**
     * Construct a TilePanel with the specified values.
     * 
     * @param t the tile to display.
     * @param f the entity factory.
     */
    public TilePanel(final Tile          t,
                     final EntityFactory f)
    {
        tile    = t;
        factory = f;
    }
    
    /**
     * Get the tile that is being displayed.
     * 
     * @return the tile being displayed.
     */
    public Tile getTile()
    {
        return (tile);
    }
    
    /**
     * Draw the top entity on the tile.
     * 
     * @param g the graphics context.
     */
    @Override
    public void paintComponent(final Graphics g)
    {
        final Entity entity;
        final Color  colour;
        
        entity = tile.getEntity();

        if(entity == null)
        {
            colour = factory.getColourForNullEntity();
        }
        else
        {
            colour = entity.getColour();
        }

        setBackground(colour);
        
        super.paintComponent(g);
    }
}
