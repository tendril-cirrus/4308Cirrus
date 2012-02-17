package edu.colorado.cs.cirrus.domain.model;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class ExtendedProperty {

	public ExtendedProperty() {
	}

	public ExtendedProperty(String namespace, String name,
			List<String> valueList) {
		super();
		this.namespace = namespace;
		this.name = name;
		this.valueList = valueList;
	}

	@Element(required = false)
	String namespace;

	@Element
	String name;

	@ElementList(inline = true, entry = "value")
	List<String> valueList;

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
		return valueList;
	}

	public void setValue(List<String> valueList) {
		this.valueList = valueList;
	}

	@Override
	public String toString() {
		return "ExtendedProperty [namespace=" + namespace + ", name=" + name
				+ ", valueList=" + valueList + "]";
	}
}
