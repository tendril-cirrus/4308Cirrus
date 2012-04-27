package edu.colorado.cs.cirrus.domain.model;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class ScheduleRates {
    public ScheduleRates() {
    }

    public ScheduleRates(int id, String scheduleName, String effectiveDate, int consumptionBaseline, List<Rate> rateList) {
        super();
        this.id = id;
        this.scheduleName = scheduleName;
        this.effectiveDate = effectiveDate;
        this.consumptionBaseline = consumptionBaseline;
        this.rateList = rateList;
    }

    @Element
    private int id;

    @Element
    private String scheduleName;

    @Element
    private String effectiveDate;

    @Element
    private int consumptionBaseline;

    @ElementList
    private List<Rate> rateList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public int getConsumptionBaseline() {
        return consumptionBaseline;
    }

    public void setConsumptionBaseline(int consumptionBaseline) {
        this.consumptionBaseline = consumptionBaseline;
    }

    public List<Rate> getRateList() {
        return rateList;
    }

    public void setRateList(List<Rate> rateList) {
        this.rateList = rateList;
    }

    @Override
    public String toString() {
        return "ScheduleRates [id=" + id + ", scheduleName=" + scheduleName + ", effectiveDate=" + effectiveDate
                + ", consumptionBaseline=" + consumptionBaseline + ", rateList=" + rateList + "]";
    }

}
