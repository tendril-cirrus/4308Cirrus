package edu.colorado.cs.cirrus.domain.model;

import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;

public class ThermostatProgram {
	@Attribute(name="programId")
	int programID;
	
	@ElementList(inline=true)
	List<ProgramDays> programDays;

	public ThermostatProgram(int programID, List<ProgramDays> programDays) {
		super();
		this.programID = programID;
		this.programDays = programDays;
	}

	public ThermostatProgram() {
		super();
	}

	public int getProgramID() {
		return programID;
	}

	public void setProgramID(int programID) {
		this.programID = programID;
	}

	public List<ProgramDays> getProgramDays() {
		return programDays;
	}

	public void setProgramDays(List<ProgramDays> programDays) {
		this.programDays = programDays;
	}

	@Override
	public String toString() {
		return "ThermostatProgram [programID=" + programID + ", programDays="
				+ programDays + "]";
	}
	
	
}
