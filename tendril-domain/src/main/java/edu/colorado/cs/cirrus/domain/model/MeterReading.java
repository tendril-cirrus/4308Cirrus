package edu.colorado.cs.cirrus.domain.model;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;

//@Namespace(reference="http://iec.ch/TC57/2009/MeterReadings#",prefix="ns2")
public class MeterReading {
	@Element
	CustomerAgreement CustomerAgreement;
	
	@Element
	MeterAsset MeterAsset;
	
	@ElementList(inline=true,entry="Readings")
	List<Readings> readings;

	public MeterReading(CustomerAgreement customerAgreement,
			MeterAsset meterAsset, List<Readings> readings) {
		super();
		this.CustomerAgreement = customerAgreement;
		this.MeterAsset = meterAsset;
		this.readings = readings;
	}

	public MeterReading() {
		
	}

	public CustomerAgreement getCustomerAgreement() {
		return CustomerAgreement;
	}

	public void setCustomerAgreement(CustomerAgreement customerAgreement) {
		this.CustomerAgreement = customerAgreement;
	}

	public MeterAsset getMeterAsset() {
		return MeterAsset;
	}

	public void setMeterAsset(MeterAsset meterAsset) {
		this.MeterAsset = meterAsset;
	}

	public List<Readings> getReadings() {
		return readings;
	}

	public void setReadings(List<Readings> readings) {
		this.readings = readings;
	}

	@Override
	public String toString() {
		return "MeterReading [CustomerAgreement=" + CustomerAgreement
				+ ", MeterAsset=" + MeterAsset + ", readings=" + readings + "]";
	}
	
	
}