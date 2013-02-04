package ca.bcit.cst.comp2526.assign6.solution.game.pacman;


import ca.bcit.cst.comp2526.assign6.solution.BaseEntityFactory;
import ca.bcit.cst.comp2526.assign6.solution.Entity;
import ca.bcit.cst.comp2526.assign6.solution.EntityData;
import ca.bcit.cst.comp2526.assign6.solution.Location;
import ca.bcit.cst.comp2526.assign6.solution.game.MovableEntityData;
import ca.bcit.cst.comp2526.assign6.solution.game.pacman.pathfinder.GhostRandomPathFinder;
import ca.bcit.cst.comp2526.assign6.solution.game.pacman.renderer.swing.SwingDoorRenderer;
import ca.bcit.cst.comp2526.assign6.solution.game.pacman.renderer.swing.SwingGhostRenderer;
import ca.bcit.cst.comp2526.assign6.solution.game.pacman.renderer.swing.SwingInvisibleWallRenderer;
import ca.bcit.cst.comp2526.assign6.solution.game.pacman.renderer.swing.SwingPacManRenderer;
import ca.bcit.cst.comp2526.assign6.solution.game.pacman.renderer.swing.SwingPelletRenderer;
import ca.bcit.cst.comp2526.assign6.solution.game.pacman.renderer.swing.SwingPowerPelletRenderer;
import ca.bcit.cst.comp2526.assign6.solution.game.pacman.renderer.swing.SwingTeleportRenderer;
import ca.bcit.cst.comp2526.assign6.solution.ui.console.ConsoleEntityRenderer;
import ca.bcit.cst.comp2526.assign6.solution.ui.swing.SwingEntityRenderer;
import ca.bcit.cst.comp2526.assign6.solution.worldreader.UnknownEntityTypeException;
import java.awt.Color;


/**
 * Create entities for a PacMan game based on the value in a data source.
 *
 * @author D'Arcy Smnith
 * @version 1.0
 */
public class PacManEntityFactory
    extends BaseEntityFactory
{
    /**
     * create ghost entity.
     *
     * @param type - key for entity
     *
     * @return - the created entity, null if no match.
     */
    private Entity createGhostAndPacman(final char type)
    {
        final Entity entity;
        if(type == getKeyForPacManEntity())
        {
            final MovableEntityData<PacManGame, PacManEntity> data;

            data = new MovableEntityData<PacManGame, PacManEntity>(getKeyForPacManEntity(),
                                                                   getLabelForPacManEntity(),
                                                                   getColourForPacManEntity(),
                                                                   getSwingEntityRendererForPacManEntity(),
                                                                   getConsoleEntityRendererForPacManEntity(),
                                                                   new PacManMoveChecker(),
                                                                   new RegularPacManCollisionHandler(),
                                                                   null);
            entity = new PacManEntity(data);
        }
        else if(type == getKeyForBlinkyGhostEntity())
        {
            final MovableEntityData<PacManGame, GhostEntity> data;

            data = new MovableEntityData<PacManGame, GhostEntity>(getKeyForBlinkyGhostEntity(),
                                                                  getLabelForBlinkyGhostEntity(),
                                                                  getColourForBlinkyGhostEntity(),
                                                                  getSwingEntityRendererForBlinkyGhostEntity(),
                                                                  getConsoleEntityRendererForBlinkyGhostEntity(),
                                                                  new AttackingGhostMoveChecker(),
                                                                  new AttackingGhostCollisionHandler(),
                                                                  new GhostRandomPathFinder());
            entity = new BlinkyGhostEntity(data);
        }
        else if(type == getKeyForPinkyGhostEntity())
        {
            final MovableEntityData<PacManGame, GhostEntity> data;

            data = new MovableEntityData<PacManGame, GhostEntity>(getKeyForPinkyGhostEntity(),
                                                                  getLabelForPinkyGhostEntity(),
                                                                  getColourForPinkyGhostEntity(),
                                                                  getSwingEntityRendererForPinkyGhostEntity(),
                                                                  getConsoleEntityRendererForPinkyGhostEntity(),
                                                                  new AttackingGhostMoveChecker(),
                                                                  new AttackingGhostCollisionHandler(),
                                                                  new GhostRandomPathFinder());
            entity = new PinkyGhostEntity(data);
        }
        else if(type == getKeyForInkyGhostEntity())
        {
            final MovableEntityData<PacManGame, GhostEntity> data;

            data = new MovableEntityData<PacManGame, GhostEntity>(getKeyForInkyGhostEntity(),
                                                                  getLabelForInkyGhostEntity(),
                                                                  getColourForInkyGhostEntity(),
                                                                  getSwingEntityRendererForInkyGhostEntity(),
                                                                  getConsoleEntityRendererForInkyGhostEntity(),
                                                                  new AttackingGhostMoveChecker(),
                                                                  new AttackingGhostCollisionHandler(),
                                                                  new GhostRandomPathFinder());
            entity = new InkyGhostEntity(data);
        }
        else if(type == getKeyForClydeGhostEntity())
        {
            final MovableEntityData<PacManGame, GhostEntity> data;

            data = new MovableEntityData<PacManGame, GhostEntity>(getKeyForClydeGhostEntity(),
                                                                  getLabelForClydeGhostEntity(),
                                                                  getColourForClydeGhostEntity(),
                                                                  getSwingEntityRendererForClydeGhostEntity(),
                                                                  getConsoleEntityRendererForClydeGhostEntity(),
                                                                  new AttackingGhostMoveChecker(),
                                                                  new AttackingGhostCollisionHandler(),
                                                                  new GhostRandomPathFinder());
            entity = new ClydeGhostEntity(data);
        }
        else
        {
            entity = null;
        }
        return entity;
    }

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
        final Entity entity;




        if(type == getKeyForPelletEntity())
        {
            final EntityData data;

            data = new EntityData(getKeyForPelletEntity(),
                                  getLabelForPelletEntity(),
                                  getColourForPelletEntity(),
                                  getSwingEntityRendererForPelletEntity(),
                                  getConsoleEntityRendererForPelletEntity());
            entity = new PelletEntity(data);
        }
        else if(type == getKeyForPowerPelletEntity())
        {
            final EntityData data;

            data = new EntityData(getKeyForPowerPelletEntity(),
                                  getLabelForPowerPelletEntity(),
                                  getColourForPowerPelletEntity(),
                                  getSwingEntityRendererForPowerPelletEntity(),
                                  getConsoleEntityRendererForPowerPelletEntity());
            entity = new PowerPelletEntity(data);
        }
        else if(type == getKeyForDoorEntity())
        {
            final EntityData data;

            data = new EntityData(getKeyForDoorEntity(),
                                  getLabelForDoorEntity(),
                                  getColourForDoorEntity(),
                                  getSwingEntityRendererForDoorEntity(),
                                  getConsoleEntityRendererForDoorEntity());
            entity = new DoorEntity(data);
        }
        else if(type == getKeyForInvisibleWallEntity())
        {
            final EntityData data;

            data = new EntityData(getKeyForInvisibleWallEntity(),
                                  getLabelForInvisibleWallEntity(),
                                  getColourForInvisibleWallEntity(),
                                  getSwingEntityRendererForInvisibleWallEntity(),
                                  getConsoleEntityRendererForInvisibleWallEntity());
            entity = new InvisibleWallEntity(data);
        }
        else if(type == getKeyForTeleportEntity())
        {
            final EntityData data;

            data = new EntityData(getKeyForTeleportEntity(),
                                  getLabelForTeleportEntity(),
                                  getColourForTeleportEntity(),
                                  getSwingEntityRendererForTeleportEntity(),
                                  getConsoleEntityRendererForTeleportEntity());
            entity = new TeleportEntity(data);
        }
        else
        {
            entity = createGhostAndPacman(type);
            if(entity == null)
            {
                throw new UnknownEntityTypeException(type,
                                                     location);
            }
        }

        return (entity);
    }

    /**
     * Get the character for the null entity from a data source.
     *
     * @return '-'
     */
    @Override
    public char getKeyForNullEntity()
    {
        return ('-');
    }

    /**
     * Get the character for the wall entity from a data source.
     *
     * @return '+'
     */
    @Override
    public char getKeyForWallEntity()
    {
        return ('+');
    }

    /**
     * Get the character for the pac man entity from a data source.
     *
     * @return 'P'
     */
    public char getKeyForPacManEntity()
    {
        return ('P');
    }

    /**
     * Get the character for the Blinky ghost entity from a data source.
     *
     * @return '1'
     */
    public char getKeyForBlinkyGhostEntity()
    {
        return ('1');
    }

    /**
     * Get the character for the Pinky ghost entity from a data source.
     *
     * @return '2'
     */
    public char getKeyForPinkyGhostEntity()
    {
        return ('2');
    }

    /**
     * Get the character for the Inky ghost entity from a data source.
     *
     * @return '3'
     */
    public char getKeyForInkyGhostEntity()
    {
        return ('3');
    }

    /**
     * Get the character for the Clyde ghost entity from a data source.
     *
     * @return '4'
     */
    public char getKeyForClydeGhostEntity()
    {
        return ('4');
    }

    /**
     * Get the character for the pellet entity from a data source.
     *
     * @return '.'
     */
    public char getKeyForPelletEntity()
    {
        return ('.');
    }

    /**
     * Get the character for the power pellet entity from a data source.
     *
     * @return '*'
     */
    public char getKeyForPowerPelletEntity()
    {
        return ('*');
    }

    /**
     * Get the character for the door entity from a data source.
     *
     * @return '^'
     */
    public char getKeyForDoorEntity()
    {
        return ('^');
    }

    /**
     * Get the character for the teleport entity from a data source.
     *
     * @return 'T'
     */
    public char getKeyForTeleportEntity()
    {
        return ('T');
    }

    /**
     * Get the character for the invisible wall entity from a data source.
     *
     * @return 'I'
     */
    public char getKeyForInvisibleWallEntity()
    {
        return ('I');
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
     * @return '+'.
     */
    @Override
    public char getLabelForWallEntity()
    {
        return ('+');
    }

    /**
     * Get the character for the pacman entity for displaying.
     *
     * @return 'P'.
     */
    public char getLabelForPacManEntity()
    {
        return ('P');
    }

    /**
     * Get the character for the Blinky Ghost entity for displaying.
     *
     * @return '1'.
     */
    public char getLabelForBlinkyGhostEntity()
    {
        return ('1');
    }

    /**
     * Get the character for the Pinky Ghost entity for displaying.
     *
     * @return '2'.
     */
    public char getLabelForPinkyGhostEntity()
    {
        return ('2');
    }

    /**
     * Get the character for the Inky Ghost entity for displaying.
     *
     * @return '3'.
     */
    public char getLabelForInkyGhostEntity()
    {
        return ('3');
    }

    /**
     * Get the character for the Clyde Ghost entity for displaying.
     *
     * @return '4'.
     */
    public char getLabelForClydeGhostEntity()
    {
        return ('4');
    }

    /**
     * Get the character for the pellet entity for displaying.
     *
     * @return '.'.
     */
    public char getLabelForPelletEntity()
    {
        return ('.');
    }

    /**
     * Get the character for the power pellet entity for displaying.
     *
     * @return '*'.
     */
    public char getLabelForPowerPelletEntity()
    {
        return ('*');
    }

    /**
     * Get the character for the door entity for displaying.
     *
     * @return getLabelForNullEntity().
     */
    public char getLabelForDoorEntity()
    {
        return (getLabelForNullEntity());
    }

    /**
     * Get the character for the invisible wall entity for displaying.
     *
     * @return getLabelForNullEntity().
     */
    public char getLabelForInvisibleWallEntity()
    {
        return (getLabelForNullEntity());
    }

    /**
     * Get the character for the teleport entity for displaying.
     *
     * @return getLabelForNullEntity().
     */
    public char getLabelForTeleportEntity()
    {
        return (getLabelForNullEntity());
    }

    /**
     * Get the colour of the Pac Man entity.
     *
     * @return Color.YELLOW.
     */
    public Color getColourForPacManEntity()
    {
        return (Color.YELLOW);
    }

    /**
     * Get the colour of the Blinky Ghost entity.
     *
     * @return Color.RED.
     */
    public Color getColourForBlinkyGhostEntity()
    {
        return (Color.RED);
    }

    /**
     * Get the colour of the Pinky Ghost entity.
     *
     * @return Color.PINK.
     */
    public Color getColourForPinkyGhostEntity()
    {
        return (Color.PINK);
    }

    /**
     * Get the colour of the Inky Ghost entity.
     *
     * @return Color.CYAN.
     */
    public Color getColourForInkyGhostEntity()
    {
        return (Color.CYAN);
    }

    /**
     * Get the colour of the Clyde Ghost entity.
     *
     * @return Color.ORANGE.
     */
    public Color getColourForClydeGhostEntity()
    {
        return (Color.ORANGE);
    }

    /**
     * Get the colour of the pellet entity.
     *
     * @return Color.MAGENTA.
     */
    public Color getColourForPelletEntity()
    {
        return (Color.MAGENTA);
    }

    /**
     * Get the colour of the powerpellet entity.
     *
     * @return Color.GREEN.
     */
    public Color getColourForPowerPelletEntity()
    {
        return (Color.GREEN);
    }

    /**
     * Get the colour of the door entity.
     *
     * @return getColourForNullEntity().
     */
    public Color getColourForDoorEntity()
    {
        return (getColourForNullEntity());
    }

    /**
     * Get the colour of the invisible wall entity.
     *
     * @return getColourForInvisibelWallEntity().
     */
    public Color getColourForInvisibleWallEntity()
    {
        return (getColourForNullEntity());
    }

    /**
     * Get the colour of the teleport entity.
     *
     * @return getColourForNullEntity().
     */
    public Color getColourForTeleportEntity()
    {
        return (getColourForNullEntity());
    }

    /**
     * Get the renderer used to display pac man via swing.
     *
     * @return the renderer used to display pac man via swing.
     */
    public SwingEntityRenderer<PacManGame, PacManEntity> getSwingEntityRendererForPacManEntity()
    {
        return (new SwingPacManRenderer());
    }

    /**
     * Get the renderer used to display blinky via swing.
     *
     * @return the renderer used to display blinky via swing.
     */
    public SwingEntityRenderer<PacManGame, GhostEntity> getSwingEntityRendererForBlinkyGhostEntity()
    {
        return (new SwingGhostRenderer());
    }

    /**
     * Get the renderer used to display pinky via swing.
     *
     * @return the renderer used to display pinky via swing.
     */
    public SwingEntityRenderer<PacManGame, GhostEntity> getSwingEntityRendererForPinkyGhostEntity()
    {
        return (new SwingGhostRenderer());
    }

    /**
     * Get the renderer used to display inky via swing.
     *
     * @return the renderer used to display inky via swing.
     */
    public SwingEntityRenderer<PacManGame, GhostEntity> getSwingEntityRendererForInkyGhostEntity()
    {
        return (new SwingGhostRenderer());
    }

    /**
     * Get the renderer used to display clyde via swing.
     *
     * @return the renderer used to display clyde via swing.
     */
    public SwingEntityRenderer<PacManGame, GhostEntity> getSwingEntityRendererForClydeGhostEntity()
    {
        return (new SwingGhostRenderer());
    }

    /**
     * Get the renderer used to display a pellet via swing.
     *
     * @return the renderer used to display a pellet via swing.
     */
    public SwingEntityRenderer<PacManGame, PelletEntity> getSwingEntityRendererForPelletEntity()
    {
        return (new SwingPelletRenderer());
    }

    /**
     * Get the renderer used to display a power pellet via swing.
     *
     * @return the renderer used to display a power pellet via swing.
     */
    public SwingEntityRenderer<PacManGame, PowerPelletEntity> getSwingEntityRendererForPowerPelletEntity()
    {
        return (new SwingPowerPelletRenderer());
    }

    /**
     * Get the renderer used to display a door via swing.
     *
     * @return the renderer used to display a door via swing.
     */
    public SwingEntityRenderer<PacManGame, DoorEntity> getSwingEntityRendererForDoorEntity()
    {
        return (new SwingDoorRenderer());
    }

    /**
     * Get the renderer used to display an invisible wall via swing.
     *
     * @return the renderer used to display a in invisible wall via swing.
     */
    public SwingEntityRenderer<PacManGame, InvisibleWallEntity> getSwingEntityRendererForInvisibleWallEntity()
    {
        return (new SwingInvisibleWallRenderer());
    }

    /**
     * Get the renderer used to display a teleporter via swing.
     *
     * @return the renderer used to display a teleporter via swing.
     */
    public SwingEntityRenderer<PacManGame, TeleportEntity> getSwingEntityRendererForTeleportEntity()
    {
        return (new SwingTeleportRenderer());
    }

    /**
     * Get the renderer used to display a pac man via the console.
     *
     * @return the renderer used to display a pac man via the console.
     */
    public ConsoleEntityRenderer<PacManGame, PacManEntity> getConsoleEntityRendererForPacManEntity()
    {
        return (new ConsoleEntityRenderer<PacManGame, PacManEntity>());
    }

    /**
     * Get the renderer used to display a blinky via the console.
     *
     * @return the renderer used to display a blinky via the console.
     */
    public ConsoleEntityRenderer<PacManGame, GhostEntity> getConsoleEntityRendererForBlinkyGhostEntity()
    {
        return (new ConsoleEntityRenderer<PacManGame, GhostEntity>());
    }

    /**
     * Get the renderer used to display a pinky via the console.
     *
     * @return the renderer used to display a pinky via the console.
     */
    public ConsoleEntityRenderer<PacManGame, GhostEntity> getConsoleEntityRendererForPinkyGhostEntity()
    {
        return (new ConsoleEntityRenderer<PacManGame, GhostEntity>());
    }

    /**
     * Get the renderer used to display an inky via the console.
     *
     * @return the renderer used to display an inky via the console.
     */
    public ConsoleEntityRenderer<PacManGame, GhostEntity> getConsoleEntityRendererForInkyGhostEntity()
    {
        return (new ConsoleEntityRenderer<PacManGame, GhostEntity>());
    }

    /**
     * Get the renderer used to display a clyde via the console.
     *
     * @return the renderer used to display a clyde via the console.
     */
    public ConsoleEntityRenderer<PacManGame, GhostEntity> getConsoleEntityRendererForClydeGhostEntity()
    {
        return (new ConsoleEntityRenderer<PacManGame, GhostEntity>());
    }

    /**
     * Get the renderer used to display a pellet via the console.
     *
     * @return the renderer used to display a pellet via the console.
     */
    public ConsoleEntityRenderer<PacManGame, PelletEntity> getConsoleEntityRendererForPelletEntity()
    {
        return (new ConsoleEntityRenderer<PacManGame, PelletEntity>());
    }

    /**
     * Get the renderer used to display a power pellet via the console.
     *
     * @return the renderer used to display a power pellet via the console.
     */
    public ConsoleEntityRenderer<PacManGame, PowerPelletEntity> getConsoleEntityRendererForPowerPelletEntity()
    {
        return (new ConsoleEntityRenderer<PacManGame, PowerPelletEntity>());
    }

    /**
     * Get the renderer used to display a door via the console.
     *
     * @return the renderer used to display a door via the console.
     */
    public ConsoleEntityRenderer<PacManGame, DoorEntity> getConsoleEntityRendererForDoorEntity()
    {
        return (new ConsoleEntityRenderer<PacManGame, DoorEntity>());
    }

    /**
     * Get the renderer used to display an invisible wall via the console.
     *
     * @return the renderer used to display ain invisible wall via the console.
     */
    public ConsoleEntityRenderer<PacManGame, InvisibleWallEntity> getConsoleEntityRendererForInvisibleWallEntity()
    {
        return (new ConsoleEntityRenderer<PacManGame, InvisibleWallEntity>());
    }

    /**
     * Get the renderer used to display a teleporter via the console.
     *
     * @return the renderer used to display a teleporter via the console.
     */
    public ConsoleEntityRenderer<PacManGame, TeleportEntity> getConsoleEntityRendererForTeleportEntity()
    {
        return (new ConsoleEntityRenderer<PacManGame, TeleportEntity>());
    }

}