package edu.colorado.cs.cirrus.domain.model;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class Users {
    
    /**
     * Constructs a new instance.
     */
    public Users() {
    }

    /**
     * Constructs a new instance.
     *
     * @param userList The userList for this instance.
     */
    public Users(List<User> userList)
    {
        this.users = userList;
    }

    @ElementList(inline=true)
    List<User> users;

    /**
     * Gets the userList for this instance.
     *
     * @return The userList.
     */
    public List<User> getUser()
    {
        return this.users;
    }

    /**
     * Sets the userList for this instance.
     *
     * @param userList The userList.
     */
    public void setUser(List<User> userList)
    {
        this.users = userList;
    }
    
    @Override
    public String toString(){
        return "Users [userList=" + users + "]";
    }
}
