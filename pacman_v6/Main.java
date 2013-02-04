package ca.bcit.cst.comp2526.assign6.solution;


import ca.bcit.cst.comp2526.assign6.solution.entityfinder.FoundTooFewEntitiesException;
import ca.bcit.cst.comp2526.assign6.solution.entityfinder.FoundTooManyEntitiesException;
import ca.bcit.cst.comp2526.assign6.solution.game.CollisionException;
import ca.bcit.cst.comp2526.assign6.solution.game.Game;
import ca.bcit.cst.comp2526.assign6.solution.game.pacman.PacManEntityFactory;
import ca.bcit.cst.comp2526.assign6.solution.game.pacman.PacManGameImpl;
import ca.bcit.cst.comp2526.assign6.solution.ui.WorldDisplayer;
import ca.bcit.cst.comp2526.assign6.solution.ui.WorldDisplayerException;
import ca.bcit.cst.comp2526.assign6.solution.ui.swing.SwingWorldDisplayer;
import ca.bcit.cst.comp2526.assign6.solution.worldreader.ColumnsNotIntegerException;
import ca.bcit.cst.comp2526.assign6.solution.worldreader.DecompressionException;
import ca.bcit.cst.comp2526.assign6.solution.worldreader.EmptyDataException;
import ca.bcit.cst.comp2526.assign6.solution.worldreader.ExtraRowsException;
import ca.bcit.cst.comp2526.assign6.solution.worldreader.LongRowException;
import ca.bcit.cst.comp2526.assign6.solution.worldreader.MissingRowsException;
import ca.bcit.cst.comp2526.assign6.solution.worldreader.RowsNotIntegerException;
import ca.bcit.cst.comp2526.assign6.solution.worldreader.ShortRowException;
import ca.bcit.cst.comp2526.assign6.solution.worldreader.UnknownEntityTypeException;
import ca.bcit.cst.comp2526.assign6.solution.worldreader.WorldDataSourceException;
import ca.bcit.cst.comp2526.assign6.solution.worldreader.WorldReader;
import ca.bcit.cst.comp2526.assign6.solution.worldreader.file.FileWorldReader;
import java.io.File;


/**
 * A program that loads a world from the specified file and displays it on the console.
 *
 * @author D'Arcy Smith
 * @version 1.0
 */
public final class Main
{
    /**
     * Indicates that the program exited due to too few arguments being passed.
     */
    public static final int TOO_FEW_ARGUMENT_EXIT_CODE = 1;

    /**
     * Indicates that the program exited due to too many arguments being passed.
     */
    public static final int TOO_MANY_ARGUMENT_EXIT_CODE = 2;

    /**
     * Indicates that the program exited due to the file not existing.
     */
    public static final int BAD_FILE_NAME_EXIT_CODE = 3;

    /**
     * Indicates that the program exited due to the file actually being a directory.
     */
    public static final int NOT_A_FILE_EXIT_CODE = 4;

    /**
     * Indicates that the program exited due the world data source having too few rows.
     */
    public static final int TOO_FEW_ROWS_EXIT_CODE = 5;

    /**
     * Indicates that the program exited due the world data source having too many rows.
     */
    public static final int TOO_MANY_ROWS_EXIT_CODE = 6;

    /**
     * Indicates that the program exited due the world data source having too few columns.
     */
    public static final int TOO_FEW_COLUMNS_EXIT_CODE = 7;

    /**
     * Indicates that the program exited due the world data source having too many columns.
     */
    public static final int TOO_MANY_COLUMNS_EXIT_CODE = 8;

    /**
     * Indicates that the program exited due the world data source having too few entities on a row.
     */
    public static final int SHORT_ROW_EXIT_CODE = 9;

    /**
     * Indicates that the program exited due the world data source having too many entities on a row.
     */
    public static final int LONG_ROW_EXIT_CODE = 10;

    /**
     * Indicates that the program exited due the world data source rows not being an integer.
     */
    public static final int ROWS_NOT_AN_INTEGER_EXIT_CODE = 11;

    /**
     * Indicates that the program exited due the world data source columns not being an integer.
     */
    public static final int COLUMNS_NOT_AN_INTEGER_EXIT_CODE = 12;

    /**
     * Indicates that the program exited due the world data source having an unknown entity typer.
     */
    public static final int UNKNOWN_ENTITY_TYPE_EXIT_CODE = 13;

    /**
     * Indicates that the program exited due the world data source not having enough rows of entities.
     */
    public static final int MISSING_ROWS_EXIT_CODE = 14;

    /**
     * Indicates that the program exited due the world data source having too many rows of entities.
     */
    public static final int EXTRA_ROWS_EXIT_CODE = 15;

    /**
     * Indicates that the program exited due the world data source not having any data.
     */
    public static final int EMPTY_DATA_EXIT_CODE = 16;

    /**
     * Indicates that the program exited due un underlying issue reading the world data source.
     */
    public static final int WORLD_DATA_SOURCE_EXIT_CODE = 17;

    /**
     * Indicates that the program exited due un underlying issue reading the world data source.
     */
    public static final int TOO_MANY_ENTITIES_EXIT_CODE = 18;

    /**
     * Indicates that the program exited due un underlying issue reading the world data source.
     */
    public static final int TOO_FEW_ENTITIES_EXIT_CODE = 19;

    /**
     * Indicates that the program exited due un underlying issue reading the world data source.
     */
    public static final int BAD_COLLISION_EXIT_CODE = 20;

    /**
     * The smallest number of rows a world can have.
     */
    public static final int SMALLEST_ROWS = 3;

    /**
     * The smallest number of columns a world can have.
     */
    public static final int SMALLEST_COLUMNS = 3;

    /**
     * The largest number of rows a world can have.
     */
    public static final int LARGEST_ROWS = 100;

    /**
     * The largest number of columns a world can have.
     */
    public static final int LARGEST_COLUMNS = 100;

    /**
     * The target frames per second.
     */
    public static final int TARGET_FRAMES_PER_SECOND = 8;

    /**
     * Prevent accidental construction.
     */
    private Main()
    {
    }

    /**
     * The main entry point for the program.
     *
     * @param argv the command line arguments, argv[0] contains the path to the map file.
     *
     * @throws DecompressionException - when compression world map has error.
     */
    public static void main(final String[] argv)
        throws DecompressionException
    {
        final File file;

        if(argv.length < 1)
        {
            usage("Missing world-name",
                  TOO_FEW_ARGUMENT_EXIT_CODE);
        }

        if(argv.length > 1)
        {
            usage("Too many arguments",
                  TOO_MANY_ARGUMENT_EXIT_CODE);
        }

        file = new File(argv[0]);

        if(!(file.exists()))
        {
            usage(argv[0] + " does not exist",
                  BAD_FILE_NAME_EXIT_CODE);
        }

        if(!(file.isFile()))
        {
            usage(argv[0] + " is not a file",
                  NOT_A_FILE_EXIT_CODE);
        }

        try
        {
            final WorldBounds bounds;
            final WorldReader worldReader;
            final PacManEntityFactory factory;
            final DefaultMutableWorld world;
            final WorldDisplayer worldDisplayer;
            final Game game;

            worldReader = new FileWorldReader('%');
            factory = new PacManEntityFactory();
            bounds = new WorldBounds(SMALLEST_ROWS,
                                     SMALLEST_COLUMNS,
                                     LARGEST_ROWS,
                                     LARGEST_COLUMNS);
            world = worldReader.readWorld(argv[0],
                                          factory,
                                          bounds);
            game = new PacManGameImpl(world,
                                      factory,
                                      TARGET_FRAMES_PER_SECOND);
            worldDisplayer = new SwingWorldDisplayer(world,
                                                     argv[0],
                                                     game,
                                                     factory);
            worldDisplayer.init(game);
            worldDisplayer.displayWorld();
            game.start();
        }
        catch(final TooFewRowsException ex)
        {
            usage(argv[0] + " the world must have at least 3 rows on it",
                  TOO_FEW_ROWS_EXIT_CODE);
        }
        catch(final TooManyRowsException ex)
        {
            usage(argv[0] + " the world must have at most 100 rows on it",
                  TOO_MANY_ROWS_EXIT_CODE);
        }
        catch(final TooFewColumnsException ex)
        {
            usage(argv[0] + " the world must have at least 3 columns on it",
                  TOO_FEW_COLUMNS_EXIT_CODE);
        }
        catch(final TooManyColumnsException ex)
        {
            usage(argv[0] + " the world must have at most 100 columns on it",
                  TOO_MANY_COLUMNS_EXIT_CODE);
        }
        catch(final ShortRowException ex)
        {
            usage(argv[0] + " row " + ex.getRow() + " has too few entities",
                  SHORT_ROW_EXIT_CODE);
        }
        catch(final LongRowException ex)
        {
            usage(argv[0] + " row " + ex.getRow() + " has too many entities",
                  LONG_ROW_EXIT_CODE);
        }
        catch(final RowsNotIntegerException ex)
        {
            usage(argv[0] + " the rows must be an integer",
                  ROWS_NOT_AN_INTEGER_EXIT_CODE);
        }
        catch(final ColumnsNotIntegerException ex)
        {
            usage(argv[0] + " the columns must be an integer",
                  COLUMNS_NOT_AN_INTEGER_EXIT_CODE);
        }
        catch(final UnknownEntityTypeException ex)
        {
            usage(argv[0] + " unknown entity type \"" + ex.getKey() + "\" on row: " + ex.getRow() + " at column: " +
                ex.getColumn(),
                  UNKNOWN_ENTITY_TYPE_EXIT_CODE);
        }
        catch(final MissingRowsException ex)
        {
            usage(argv[0] + " has too few rows of data",
                  MISSING_ROWS_EXIT_CODE);
        }
        catch(final ExtraRowsException ex)
        {
            usage(argv[0] + " has too many rows of data",
                  EXTRA_ROWS_EXIT_CODE);
        }
        catch(final EmptyDataException ex)
        {
            usage(argv[0] + " is empty",
                  EMPTY_DATA_EXIT_CODE);
        }
        catch(final WorldDataSourceException ex)
        {
            usage(argv[0] + " problem reading data: " + ex.getMessage(),
                  WORLD_DATA_SOURCE_EXIT_CODE);
        }
        catch(final WorldDisplayerException ex)
        {
            usage(argv[0] + " problem displaying the world: " + ex.getMessage(),
                  WORLD_DATA_SOURCE_EXIT_CODE);
        }
        catch(final FoundTooManyEntitiesException ex)
        {
            usage(argv[0] + " Too many entities of type: " + ex.getMessage() + " found",
                  TOO_MANY_ENTITIES_EXIT_CODE);
        }
        catch(final FoundTooFewEntitiesException ex)
        {
            usage(argv[0] + " Too few entities of type: " + ex.getMessage() + " found",
                  TOO_FEW_ENTITIES_EXIT_CODE);
        }
        catch(final CollisionException ex)
        {
            usage("Error when: " + ex.getAttacker() + " collided with: " + ex.getVictim(),
                  BAD_COLLISION_EXIT_CODE);
        }
    }

    /**
     * Display the usage message and exit with the specified exit code.
     *
     * @param message  the message to print out before the usage message. If null nothing is displayed.
     * @param exitCode the code to pass to System.exit.
     */
    private static void usage(final String message,
                              final int exitCode)
    {
        if(message != null)
        {
            System.err.println(message);
        }

        fatal(String.format("Usage: java ca.bcit.cst.comp2526.assign6.a00811101.Main <world-name>%n"),
              exitCode);
    }

    /**
     * Display the usage message and exit with the specified exit code.
     *
     * @param message  the message to display to System.err.
     * @param exitCode the code to pass to System.exit.
     */
    private static void fatal(final String message,
                              final int exitCode)
    {
        System.err.println(message);
        System.exit(exitCode);
    }

}
