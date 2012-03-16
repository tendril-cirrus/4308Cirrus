package edu.colorado.cs.cirrus.domain.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class TendrilErrorResponse {
	@Attribute
	private String reason;
	
	@Element
	private String details;

	public TendrilErrorResponse(String reason, String details) {
		this.reason = reason;
		this.details = details;
	}
	
	public TendrilErrorResponse() {}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "TendrilErrorResponse [reason=" + reason + ", details="
				+ details + "]";
	}
}
