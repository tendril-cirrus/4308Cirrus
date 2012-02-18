package edu.colorado.cs.cirrus.domain.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class ProfileItem {

    /**
     * Constructs a new instance.
     *
     * @param name The name for this instance.
     * @param value The value for this instance.
     */
    public ProfileItem(String name, String value)
    {
        this.name = name;
        this.value = value;
    }

    /**
     * Constructs a new instance.
     */
    public ProfileItem()
    {
    }

    @Element
    private String name;

    @Element
    private String value;

    /**
     * Gets the name for this instance.
     *
     * @return The name.
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Sets the name for this instance.
     *
     * @param name The name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the value for this instance.
     *
     * @return The value.
     */
    public String getValue()
    {
        return this.value;
    }

    /**
     * Sets the value for this instance.
     *
     * @param value The value.
     */
    public void setValue(String value)
    {
        this.value = value;
    }

    @Override
    public String toString(){
        return "ProfileItem [name=" + name + ", value=" + value + "]";
    }

}
