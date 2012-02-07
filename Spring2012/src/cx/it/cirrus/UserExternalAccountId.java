/*
 * Insert License Here
 */

package cx.it.cirrus;

import cx.it.cirrus.util.JSONUtils;

public class UserExternalAccountId{

    private String externalAccountId;
    private Integer id;

    /**
     * Constructs a new instance.
     */
    public UserExternalAccountId()
    {
    }

    /**
     * Nominal Constructor
     *
     * @param externalAccountId
     * @param id
     *
     */
    public UserExternalAccountId(String externalAccountId, Integer id){
        this.setExternalAccountId(externalAccountId);
        this.setId(id);
    }

    /**
     * Constructor for constructing a UserExternalAccoundId from
     * a JSON string
     * 
     * @param json
     */
    public UserExternalAccountId(String json){
        UserExternalAccountId myUEA = JSONUtils.getJsonAsObject(json,
                                            UserExternalAccountId.class);

        this.setExternalAccountId(myUEA.getExternalAccountId());
        this.setId(myUEA.getId());
    }

    /**
     * Gets the externalAccountId for this instance.
     *
     * @return The externalAccountId.
     */
    public String getExternalAccountId()
    {
        return this.externalAccountId;
    }

    /**
     * Sets the externalAccountId for this instance.
     *
     * @param externalAccountId The externalAccountId.
     */
    public void setExternalAccountId(String externalAccountId)
    {
        this.externalAccountId = externalAccountId;
    }

    /**
     * Gets the id for this instance.
     *
     * @return The id.
     */
    public Integer getId()
    {
        return this.id;
    }

    /**
     * Sets the id for this instance.
     *
     * @param id The id.
     */
    public void setId(Integer id)
    {
        this.id = id;
    }

    /**
     * Gets the object as a JSON string
     *
     * @return The json for this object
     */
    public String toJSON(){
        return JSONUtils.getObjectAsJson(this, UserExternalAccountId.class);
    }

}
