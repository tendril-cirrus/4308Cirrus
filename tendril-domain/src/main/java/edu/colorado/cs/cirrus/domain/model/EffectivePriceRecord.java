package edu.colorado.cs.cirrus.domain.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class EffectivePriceRecord {

	public EffectivePriceRecord(){}
	
	
	

	@Element
	private String effectiveDate;
	
	@Element
	private String programName;
	
	@Element
	private String programDescription;
	
	@Element
	private String scheduleName;
	
	@Element
	private String rateKey;
	
	@Element
	private String rateLabel;
	
	@Element
	private String energyPrice;
	
	@Element
	private String deliveryCharge;
	
	@Element
	private String accountId;
	
	@Element
	private int priceIndex;
	
	@Element
	private int registerIndex;
	
	@Element
	private int numberOfRates;
	
	@Element
	private boolean peak;
	
	@Element
	private String endDate;
	
	@Element
	private long id;

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getProgramDescription() {
		return programDescription;
	}

	public void setProgramDescription(String programDescription) {
		this.programDescription = programDescription;
	}

	public String getScheduleName() {
		return scheduleName;
	}

	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}

	public String getRateKey() {
		return rateKey;
	}

	public void setRateKey(String rateKey) {
		this.rateKey = rateKey;
	}

	public String getRateLabel() {
		return rateLabel;
	}

	public void setRateLabel(String rateLabel) {
		this.rateLabel = rateLabel;
	}

	public String getEnergyPrice() {
		return energyPrice;
	}

	public void setEnergyPrice(String energyPrice) {
		this.energyPrice = energyPrice;
	}

	public String getDeliveryCharge() {
		return deliveryCharge;
	}

	public void setDeliveryCharge(String deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public int getPriceIndex() {
		return priceIndex;
	}

	public void setPriceIndex(int priceIndex) {
		this.priceIndex = priceIndex;
	}

	public int getRegisterIndex() {
		return registerIndex;
	}

	public void setRegisterIndex(int registerIndex) {
		this.registerIndex = registerIndex;
	}

	public int getNumberOfRates() {
		return numberOfRates;
	}

	public void setNumberOfRates(int numberOfRates) {
		this.numberOfRates = numberOfRates;
	}

	public boolean isPeak() {
		return peak;
	}

	public void setPeak(boolean peak) {
		this.peak = peak;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "EffectivePriceRecord [effectiveDate=" + effectiveDate
				+ ", programName=" + programName + ", programDescription="
				+ programDescription + ", scheduleName=" + scheduleName
				+ ", rateKey=" + rateKey + ", rateLabel=" + rateLabel
				+ ", energyPrice=" + energyPrice + ", deliveryCharge="
				+ deliveryCharge + ", accountId=" + accountId + ", priceIndex="
				+ priceIndex + ", registerIndex=" + registerIndex
				+ ", numberOfRates=" + numberOfRates + ", peak=" + peak
				+ ", endDate=" + endDate + ", id=" + id + "]";
	}
	
	
}
