package edu.colorado.cs.cirrus.domain.model;

import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;

public class ProgramDays {
	@Attribute
	String dayOfWeek;
	
	@ElementList(inline=true)
	List<ProgramSegment> programSegment;

	public ProgramDays(String dayOfWeek, List<ProgramSegment> programSegment) {
		super();
		this.dayOfWeek = dayOfWeek;
		this.programSegment = programSegment;
	}

	public ProgramDays() {
		super();
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public List<ProgramSegment> getProgramSegment() {
		return programSegment;
	}

	public void setProgramSegment(List<ProgramSegment> programSegment) {
		this.programSegment = programSegment;
	}

	@Override
	public String toString() {
		return "ProgramDays [dayOfWeek=" + dayOfWeek + ", programSegment="
				+ programSegment + "]";
	}
	
	
}
