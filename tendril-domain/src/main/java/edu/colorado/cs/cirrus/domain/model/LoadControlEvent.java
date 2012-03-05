package edu.colorado.cs.cirrus.domain.model;

import org.simpleframework.xml.Element;

public class LoadControlEvent {
	@Element
	boolean loadControlEventActive;
	
	@Element
	boolean loadControlEventMandatory;
	
	@Element
	boolean loadControlEventDutyCycling;
	
	@Element
	boolean loadControlEventOptedOut;
	
	@Element
	String loadControlEventReturnMode;
	
	@Element
	String loadControlEventId;
	
	public LoadControlEvent(){}

	public LoadControlEvent(boolean loadControlEventActive,
			boolean loadControlEventMandatory,
			boolean loadControlEventDutyCycling,
			boolean loadControlEventOptedOut,
			String loadControlEventReturnMode, String loadControlEventId) {
		super();
		this.loadControlEventActive = loadControlEventActive;
		this.loadControlEventMandatory = loadControlEventMandatory;
		this.loadControlEventDutyCycling = loadControlEventDutyCycling;
		this.loadControlEventOptedOut = loadControlEventOptedOut;
		this.loadControlEventReturnMode = loadControlEventReturnMode;
		this.loadControlEventId = loadControlEventId;
	}

	public boolean isLoadControlEventActive() {
		return loadControlEventActive;
	}

	public void setLoadControlEventActive(boolean loadControlEventActive) {
		this.loadControlEventActive = loadControlEventActive;
	}

	public boolean isLoadControlEventMandatory() {
		return loadControlEventMandatory;
	}

	public void setLoadControlEventMandatory(boolean loadControlEventMandatory) {
		this.loadControlEventMandatory = loadControlEventMandatory;
	}

	public boolean isLoadControlEventDutyCycling() {
		return loadControlEventDutyCycling;
	}

	public void setLoadControlEventDutyCycling(boolean loadControlEventDutyCycling) {
		this.loadControlEventDutyCycling = loadControlEventDutyCycling;
	}

	public boolean isLoadControlEventOptedOut() {
		return loadControlEventOptedOut;
	}

	public void setLoadControlEventOptedOut(boolean loadControlEventOptedOut) {
		this.loadControlEventOptedOut = loadControlEventOptedOut;
	}

	public String getLoadControlEventReturnMode() {
		return loadControlEventReturnMode;
	}

	public void setLoadControlEventReturnMode(String loadControlEventReturnMode) {
		this.loadControlEventReturnMode = loadControlEventReturnMode;
	}

	public String getLoadControlEventId() {
		return loadControlEventId;
	}

	public void setLoadControlEventId(String loadControlEventId) {
		this.loadControlEventId = loadControlEventId;
	}

	@Override
	public String toString() {
		return "LoadControlEvent [loadControlEventActive="
				+ loadControlEventActive + ", loadControlEventMandatory="
				+ loadControlEventMandatory + ", loadControlEventDutyCycling="
				+ loadControlEventDutyCycling + ", loadControlEventOptedOut="
				+ loadControlEventOptedOut + ", loadControlEventReturnMode="
				+ loadControlEventReturnMode + ", loadControlEventId="
				+ loadControlEventId + "]";
	}
}
