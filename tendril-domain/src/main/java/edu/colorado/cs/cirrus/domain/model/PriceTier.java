package edu.colorado.cs.cirrus.domain.model;

import org.simpleframework.xml.Element;

public class PriceTier {
	public PriceTier() {
	}

	public PriceTier(String energyPrice, String deliveryCharge) {
		super();
		this.energyPrice = energyPrice;
		this.deliveryCharge = deliveryCharge;
	}

	@Element
	private String energyPrice;
	@Element
	private String deliveryCharge;

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

	@Override
	public String toString() {
		return "PriceTier [energyPrice=" + energyPrice + ", deliveryCharge="
				+ deliveryCharge + "]";
	}

}