package edu.colorado.cs.cirrus.domain.model;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class Devices {

    public Devices() {
    }

    public Devices(List<Device> deviceList) {
        super();
        this.deviceList = deviceList;
    }

    @ElementList(inline = true)
    List<Device> deviceList;

    public List<Device> getDevice() {
        return deviceList;
    }

    public void setDevice(List<Device> device) {
        this.deviceList = device;
    }

    @Override
    public String toString() {
        return "Devices [deviceList=" + deviceList + "]";
    }

}
