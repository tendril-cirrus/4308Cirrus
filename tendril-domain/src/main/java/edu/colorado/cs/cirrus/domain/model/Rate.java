package edu.colorado.cs.cirrus.domain.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Rate {
	public Rate() {
	}

	public Rate(String key, String label, PriceTier priceTier) {
		super();
		this.key = key;
		this.label = label;
		this.priceTier = priceTier;
	}

	@Attribute
	private String key;
	@Element
	private String label;

	@Element
	private PriceTier priceTier;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public PriceTier getPriceTier() {
		return priceTier;
	}

	public void setPriceTier(PriceTier priceTier) {
		this.priceTier = priceTier;
	}

	@Override
	public String toString() {
		return "Rate [key=" + key + ", label=" + label + ", priceTier="
				+ priceTier + "]";
	}
	

}