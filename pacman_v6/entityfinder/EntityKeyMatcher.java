package ca.bcit.cst.comp2526.assign6.solution.entityfinder;


import ca.bcit.cst.comp2526.assign6.solution.Entity;


/**
 * A filter to match entities by the key.
 * 
 * @author D'Arcy Smith
 * @version 1.0
 */
public final class EntityKeyMatcher
    implements EntityMatcher
{
    /**
     * THe key that an entity must have to be accepted.
     */
    private final char key;
    
    /**
     * Construct an EntityKeyMatcher with the specified key.
     * 
     * @param k the key to match on.
     */
    public EntityKeyMatcher(final char k)
    {
        key = k;
    }
    
    /**
     * Tests whether or not the specified entity should be included in a entity list.
     * 
     * @param entity the entity to check.
     * @return true if the entity is getKey is the key being looked for, false if it is not.
     */
    @Override
    public boolean matches(final Entity entity)
    {
        final boolean retVal;

        if(entity == null)
        {
            retVal = false;
        }
        else
        {
            final char entityKey;
            
            entityKey = entity.getKey();
            retVal    = key == entityKey;
        }
        
        return (retVal);
    }
}