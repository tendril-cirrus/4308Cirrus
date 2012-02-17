package edu.colorado.cs.cirrus.domain.model;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;


public class Device {

	public Device() {
	}

	public Device(String deviceId, String networkId, String category,
			String name, String marketingName,
			List<ExtendedProperty> extendedPropertyList,
			List<String> supportedOperation) {
		super();
		this.deviceId = deviceId;
		this.networkId = networkId;
		this.category = category;
		this.name = name;
		this.marketingName = marketingName;
		this.extendedPropertyList = extendedPropertyList;
		this.supportedOperation = supportedOperation;
	}

	@Element
	String deviceId;

	@Element
	String networkId;

	@Element
	String category;

	@Element
	String name;

	@Element
	String marketingName;

	@ElementList(inline=true)
	List<ExtendedProperty> extendedPropertyList;

	@ElementList
	List<String> supportedOperation;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getNetworkId() {
		return networkId;
	}

	public void setNetworkId(String networkId) {
		this.networkId = networkId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMarketingName() {
		return marketingName;
	}

	public void setMarketingName(String marketingName) {
		this.marketingName = marketingName;
	}

	public List<ExtendedProperty> getExtendedPropertyList() {
		return extendedPropertyList;
	}

	public void setExtendedPropertyList(List<ExtendedProperty> extendedPropertyList) {
		this.extendedPropertyList = extendedPropertyList;
	}

	public List<String> getSupportedOperation() {
		return supportedOperation;
	}

	public void setSupportedOperation(List<String> supportedOperation) {
		this.supportedOperation = supportedOperation;
	}
	

}
