/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign6.solution.worldreader;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * The parent of all WorldReders that can read compressed map data.
 *
 * @author leon
 * @version 1.0
 */
public abstract class CompressedWorldReader
    extends AbstractWorldReader
{
    /**
     * escape char.
     */
    private final char escape;

    /**
     * constructor.
     *
     * @param c - escape char.
     */
    public CompressedWorldReader(final char c)
    {
        escape = c;
    }

    /**
     * Decompress each line.
     *
     * @param worldcontent - to store decompressed lines.
     * @param line         - the line need to decompress
     *
     * @throws DecompressionException - throw when have a decompression problem.
     */
    private void lineDecompress(final List<String> worldcontent,
                                final String line)
        throws DecompressionException
    {
        String tmp;
        final StringBuilder strbuffer = new StringBuilder();
        final Scanner scan = new Scanner(line);
        while(scan.hasNext())
        {
            tmp = scan.findWithinHorizon("\\S", 0);
            if(tmp.equals(Character.toString(escape)))
            {
                if(!scan.hasNextInt())
                {
                    throw new DecompressionException("Missing item count");
                }
                final int repeat = scan.nextInt();
                if(!scan.hasNext())
                {
                    throw new DecompressionException("Missing type");
                }
                scan.findWithinHorizon(".", 0);
                final String repeatchar = scan.findWithinHorizon("\\S", 0);
                for(int i = 1; i <= repeat; i++)
                {
                    strbuffer.append(repeatchar);
                }
            }
            else
            {
                strbuffer.append(tmp);
            }
        }
        worldcontent.add(strbuffer.toString());
    }

    @Override
    protected final List<String> getWorldContents(final String worldName)
        throws DecompressionException
    {
        final List<String> rawworldcontent;
        final List<String> worldcontent = new ArrayList<>();
        rawworldcontent = getRawWorldContents(worldName);

        for(String line : rawworldcontent)
        {
            lineDecompress(worldcontent, line);
        }

        return worldcontent;
    }

    /**
     * get original data from map.
     *
     * @param worldName - file path.
     *
     * @return - the contents of the world
     */
    protected abstract List<String> getRawWorldContents(final String worldName);

}
