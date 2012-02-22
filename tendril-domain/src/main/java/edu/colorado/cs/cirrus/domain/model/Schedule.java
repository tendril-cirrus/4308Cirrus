package edu.colorado.cs.cirrus.domain.model;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class Schedule {

	public Schedule() {
	}

	public Schedule(int id, String name, String effectiveDate,
			SwitchPointDefinition switchPointDefinition,
			List<ScheduleRates> scheduleRatesList) {
		super();
		this.id = id;
		this.name = name;
		this.effectiveDate = effectiveDate;
		this.switchPointDefinition = switchPointDefinition;
		this.scheduleRatesList = scheduleRatesList;
	}

	@Element
	private int id;

	@Element
	private String name;

	@Element
	private String effectiveDate;

	@Element
	private SwitchPointDefinition switchPointDefinition;

	@ElementList
	private List<ScheduleRates> scheduleRatesList;

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

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDateTime) {
		this.effectiveDate = effectiveDateTime;
	}

	public SwitchPointDefinition getSwitchPointDefinition() {
		return switchPointDefinition;
	}

	public void setSwitchPointDefinition(
			SwitchPointDefinition switchPointDefinition) {
		this.switchPointDefinition = switchPointDefinition;
	}

	public List<ScheduleRates> getScheduleRatesList() {
		return scheduleRatesList;
	}

	public void setScheduleRatesList(List<ScheduleRates> scheduleRatesList) {
		this.scheduleRatesList = scheduleRatesList;
	}

	@Override
	public String toString() {
		return "Schedule [id=" + id + ", name=" + name + ", effectiveDate="
				+ effectiveDate + ", switchPointDefinition="
				+ switchPointDefinition + ", scheduleRatesList="
				+ scheduleRatesList + "]";
	}
	

}