/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.bcit.cst.comp2526.assign6.solution.worldreader;


/**
 * throw when decompression has error.
 *
 * @author leon
 * @version 1.0
 */
public class DecompressionException
    extends WorldDataException
{
    /**
     * construct a DecompressionException.
     *
     * @param msg - error message.
     */
    public DecompressionException(final String msg)
    {
        super(msg);
    }

}
