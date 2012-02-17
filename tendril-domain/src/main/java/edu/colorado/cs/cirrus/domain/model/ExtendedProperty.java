package edu.colorado.cs.cirrus.domain.model;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class ExtendedProperty {

	public ExtendedProperty() {
	}

	public ExtendedProperty(String namespace, String name, List<String> value) {
		super();
		this.namespace = namespace;
		this.name = name;
		this.value = value;
	}

	@Element(required=false)
	String namespace;

	@Element
	String name;

	@ElementList(inline=true, name="value")
	List<String> value;

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getValue() {
		return value;
	}

	public void setValue(List<String> value) {
		this.value = value;
	}
	

}
