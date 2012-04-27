package edu.colorado.cs.cirrus.domain.model;

import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class PricingSchedule {
    public PricingSchedule() {
    }

    @Attribute
    private String accountId;

    @Attribute
    private String endDate;

    @Attribute
    private String startDate;

    @ElementList
    List<EffectivePriceRecord> effectivePriceRecords;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public List<EffectivePriceRecord> getEffectivePriceRecords() {
        return effectivePriceRecords;
    }

    public void setEffectivePriceRecords(List<EffectivePriceRecord> effectivePriceRecords) {
        this.effectivePriceRecords = effectivePriceRecords;
    }

    @Override
    public String toString() {
        return "PricingSchedule [accountId=" + accountId + ", endDate=" + endDate + ", startDate=" + startDate
                + ", effectivePriceRecords=" + effectivePriceRecords + "]";
    }

}
