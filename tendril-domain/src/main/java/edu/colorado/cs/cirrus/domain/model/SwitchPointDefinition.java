package edu.colorado.cs.cirrus.domain.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class SwitchPointDefinition {

	public SwitchPointDefinition() {
	}

	public SwitchPointDefinition(String content) {
		super();
		this.content = content;
	}

	@Element
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "SwitchPointDefinition [content=" + content + "]";
	}

}