package ca.bcit.cst.comp2526.assign6.solution.worldreader.file;


import ca.bcit.cst.comp2526.assign6.solution.NumberUtils;
import ca.bcit.cst.comp2526.assign6.solution.worldreader.ColumnsNotIntegerException;
import ca.bcit.cst.comp2526.assign6.solution.worldreader.CompressedWorldReader;
import ca.bcit.cst.comp2526.assign6.solution.worldreader.EmptyDataException;
import ca.bcit.cst.comp2526.assign6.solution.worldreader.RowsNotIntegerException;
import ca.bcit.cst.comp2526.assign6.solution.worldreader.WorldDataSourceException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;


/**
 * Read a world from a local file.
 *
 * @author D'Arcy Smith
 * @version 1.0
 */
public class FileWorldReader
    extends CompressedWorldReader
{
    /**
     * The contents of the file.
     */
    private List<String> inputLines;

    
    {
        inputLines = null;
    }

    /**
     * construct a file world reader.
     *
     * @param c - the escape char.
     */
    public FileWorldReader(final char c)
    {
        super(c);
    }

    /**
     * Open the data source.
     *
     * @param filePath the path to the local file.
     *
     * @throws EmptyDataException       if there is no data in the file.
     * @throws WorldDataSourceException if there is an underlying problem reading the file.
     */
    @Override
    protected void openWorldData(final String filePath)
        throws EmptyDataException,
               WorldDataSourceException
    {
        final FileSystem fileSystem;
        final Path path;

        fileSystem = FileSystems.getDefault();
        path = fileSystem.getPath(filePath);

        try
        {
            final List<String> lines;

            lines = Files.readAllLines(path,
                                       StandardCharsets.UTF_8);
            inputLines = Collections.unmodifiableList(lines);

            if(inputLines.isEmpty())
            {
                throw new EmptyDataException();
            }
        }
        catch(final IOException ex)
        {
            throw new WorldDataSourceException(ex);
        }
    }

    /**
     * I cannot comment on this one without telling you about the private data members I used... sorry.
     *
     * @param worldName - file path.
     */
    @Override
    protected void closeWorldData(final String worldName)
    {
        inputLines = null;
    }

    /**
     * Get the number of rows on the world.
     *
     * @param worldName - file path.
     *
     * @return the number of rows on the word.
     *
     * @throws RowsNotIntegerException - row not integer.
     */
    @Override
    protected int getNumberOfRows(final String worldName)
        throws RowsNotIntegerException
    {
        final String valueAsString;
        final int value;

        valueAsString = inputLines.get(0);

        if(!(NumberUtils.isInt(valueAsString)))
        {
            throw new RowsNotIntegerException(valueAsString);
        }

        value = Integer.parseInt(valueAsString);

        return (value);
    }

    /**
     * Get the number of columns on the world.
     *
     * @param worldName - file path.
     *
     * @return the number of columns on the word.
     *
     * @throws ColumnsNotIntegerException - columns are not integer.
     */
    @Override
    protected int getNumberOfColumns(final String worldName)
        throws ColumnsNotIntegerException
    {
        final String valueAsString;
        final int value;

        valueAsString = inputLines.get(1);

        if(!(NumberUtils.isInt(valueAsString)))
        {
            throw new ColumnsNotIntegerException(valueAsString);
        }

        value = Integer.parseInt(valueAsString);

        return (value);
    }

    /**
     * Get the lines that represent the entities on the world.
     *
     * @param filePath - file path.
     *
     * @return the lines that represent the entities on the world.
     */
    @Override
    protected List<String> getRawWorldContents(final String filePath)
    {
        final List<String> contents;

        contents = inputLines.subList(2,
                                      inputLines.size());

        return (Collections.unmodifiableList(contents));
    }

}
