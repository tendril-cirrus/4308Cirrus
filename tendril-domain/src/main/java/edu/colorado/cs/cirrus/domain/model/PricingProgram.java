/*
 * Insert License Here
 */

package edu.colorado.cs.cirrus.domain.model;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class PricingProgram {

	public PricingProgram() {
	}

	public PricingProgram(int id, String name, String description,
			boolean active, List<Schedule> schedules, List<Holiday> holidays) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.active = active;
		this.schedules = schedules;
		this.holidays = holidays;
	}

	@Element
	private int id;

	@Element
	private String name;

	@Element
	private String description;

	@Element
	private boolean active;

	@ElementList
	private List<Schedule> schedules;

	@ElementList
	private List<Holiday> holidays;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	public List<Holiday> getHolidays() {
		return holidays;
	}

	public void setHolidays(List<Holiday> holidays) {
		this.holidays = holidays;
	}

	@Override
	public String toString() {
		return "PricingProgram [id=" + id + ", name=" + name + ", description="
				+ description + ", active=" + active + ", schedules="
				+ schedules + ", holidays=" + holidays + "]";
	}
	

}
