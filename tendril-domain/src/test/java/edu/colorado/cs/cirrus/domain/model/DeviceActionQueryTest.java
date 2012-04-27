package edu.colorado.cs.cirrus.domain.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class DeviceActionQueryTest {
    @Test
    public void canDeserializeDeviceActionQuery1() {
        Serializer serializer = new Persister();
        File source = new File("src/test/resources/QueryDeviceAction1.xml");
        try {
            DeviceActionQuery exampleUser = serializer.read(DeviceActionQuery.class, source);
            System.err.println(exampleUser);
        }
        catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void canDeserializeDeviceActionQuery2() {
        Serializer serializer = new Persister();
        File source = new File("src/test/resources/QueryDeviceAction2.xml");
        try {
            DeviceActionQuery exampleUser = serializer.read(DeviceActionQuery.class, source);
            System.err.println(exampleUser);
        }
        catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void canDeserializeDeviceActionQuery3() {
        Serializer serializer = new Persister();
        File source = new File("src/test/resources/QueryDeviceAction3.xml");
        try {
            DeviceActionQuery exampleUser = serializer.read(DeviceActionQuery.class, source);
            System.err.println(exampleUser);
        }
        catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void canDeserializeDeviceActionQuery4() {
        Serializer serializer = new Persister();
        File source = new File("src/test/resources/QueryDeviceAction4.xml");
        try {
            DeviceActionQuery exampleUser = serializer.read(DeviceActionQuery.class, source);
            System.err.println(exampleUser);
        }
        catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    // @Ignore("not ready yet")
    @Test
    public void canDeserializeDeviceActionQuery5() {
        Serializer serializer = new Persister();
        File source = new File("src/test/resources/QueryDeviceAction5.xml");
        try {
            DeviceActionQuery q = serializer.read(DeviceActionQuery.class, source);
            System.err.println(q);
            assertNotNull(q.getResult());
            assertNotNull(q.getResult().getType());
            assertNotNull(q.getResult().getTemperatureScale());
            assertNotNull(q.getResult().getSetpoint());
            assertNotNull(q.getResult().getMode());
            assertNotNull(q.getResult().getCurrentTemp());
        }
        catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    // @Ignore("not ready yet")
    @Test
    public void canDeserializeDeviceActionQuery6() {
        Serializer serializer = new Persister();
        File source = new File("src/test/resources/QueryDeviceAction6.xml");
        try {
            DeviceActionQuery q = serializer.read(DeviceActionQuery.class, source);
            System.err.println(q);
            assertNotNull(q.getResult());
            assertNotNull(q.getResult().getNetworkId());
            assertNotNull(q.getResult().getLoadControlEvent());
            assertNotNull(q.getResult().getLoadControlEvent().getLoadControlEventId());
            assertNotNull(q.getResult().getLoadControlEvent().getLoadControlEventReturnMode());
            assertNotNull(q.getResult().getLoadControlEvent().isLoadControlEventActive());
            assertNotNull(q.getResult().getLoadControlEvent().isLoadControlEventDutyCycling());
            assertNotNull(q.getResult().getLoadControlEvent().isLoadControlEventMandatory());
            assertNotNull(q.getResult().getLoadControlEvent().isLoadControlEventOptedOut());
        }
        catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    // @Ignore("waiting on Tendril for response about incorrect xml")
    @Test
    public void canDeserializeDeviceActionQuery7() {
        Serializer serializer = new Persister();
        File source = new File("src/test/resources/QueryDeviceAction7.xml");
        try {
            DeviceActionQuery q = serializer.read(DeviceActionQuery.class, source);
            System.err.println(q);
            assertNotNull(q.getResult().getThermostatProgram());
            assertNotNull(q.getResult().getThermostatProgram().getProgramID());
            List<ProgramDays> pd = q.getResult().getThermostatProgram().getProgramDays();
            for (ProgramDays d : pd) {
                assertNotNull(d);
                assertNotNull(d.getDayOfWeek());
                List<ProgramSegment> ps = d.getProgramSegment();
                assertNotNull(ps);
                for (ProgramSegment s : ps) {
                    assertNotNull(s);
                    assertNotNull(s.getCoolingSetPoint());
                    assertNotNull(s.getHeatingSetPoint());
                    assertNotNull(s.getName());
                    assertNotNull(s.getTimeOfDay());
                }
            }
            assertNotNull(pd);
        }
        catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    // @Ignore("waiting on Tendril for response about incorrect xml")
    @Test
    public void canDeserializeDeviceActionQuery8() {
        Serializer serializer = new Persister();
        File source = new File("src/test/resources/QueryDeviceAction8.xml");
        try {
            DeviceActionQuery q = serializer.read(DeviceActionQuery.class, source);
            System.err.println(q);
            assertNotNull(q.getResult());
            assertNotNull(q.getResult().getHoldStatus());
        }
        catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Ignore("Looks like tendril dropped this one")
    @Test
    public void canDeserializeDeviceActionQuery9() {
        Serializer serializer = new Persister();
        File source = new File("src/test/resources/QueryDeviceAction9.xml");
        try {
            DeviceActionQuery exampleUser = serializer.read(DeviceActionQuery.class, source);
            System.err.println(exampleUser);
        }
        catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
