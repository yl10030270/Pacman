package ca.bcit.cst.comp2526.assign6.solution.game.pacman;


import ca.bcit.cst.comp2526.assign6.solution.game.MovableEntityData;


/**
 * A pac man on a world.
 *
 * @author D'Arcy Smith
 * @version 1.0
 */
public final class PacManEntity
    extends AbstractPacManGameMovableEntity<PacManEntity>
{
    /**
     * mouth position.
     */
    private int mouthPosition;

    /**
     * Construct a PacManEntity.
     *
     * @param data the values for the entity state.
     */
    public PacManEntity(final MovableEntityData<PacManGame, PacManEntity> data)
    {
        super(data);
    }

    /**
     * Get the mouth position that pac man is in.
     *
     * @return the mouth position that pac man is in.
     */
    public int getMouthPosition()
    {
        return (mouthPosition);
    }

    /**
     * Move the pac man mouth by cycling through the mouth positions. There are 6 positions total.
     */
    public void moveMouth()
    {
        mouthPosition++;

        if(mouthPosition > Integer.parseInt("5"))
        {
            mouthPosition = 0;
        }
    }

    /**
     * Close the pac man mouth by resetting the position to 0.
     */
    public void stopMoving()
    {
        mouthPosition = 0;
    }

}
