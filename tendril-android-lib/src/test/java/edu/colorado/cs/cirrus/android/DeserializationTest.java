package edu.colorado.cs.cirrus.android;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import edu.colorado.cs.cirrus.domain.model.MeterReadings;

public class DeserializationTest {

    @Test
    public void canDeserializeMeterReading() {
        RestTemplate restTemplate = new RestTemplate();//TendrilTemplate.get().getRestTemplate();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(HttpUtils.getNewHttpClient()));
        HttpInputMessage him = new HttpInputMessage() {

            public HttpHeaders getHeaders() {
                // TODO Auto-generated method stub
                return null;
            }

            public InputStream getBody() throws IOException {
                // TODO Auto-generated method stub
                return null;
            }
        };
        for (HttpMessageConverter<?> hmc : restTemplate.getMessageConverters()) {
            System.out.println("hmc: " + hmc);
            if (hmc.canRead(MeterReadings.class, MediaType.APPLICATION_XML)) {
               // hmc = (HttpMessageConverter<MeterReadings>) hmc.;
          //      MeterReadings mr = (MeterReadings) hmc.read(MeterReadings.class, null);
                System.out.println("Can Read: " + hmc);
            }
            //else
                //fail();

        }
        // Serializer serializer = new Persister();
        // File source = new File("src/test/resources/MeterReadings.xml");
        // try {
        // MeterReadings exampleReading = serializer.read(MeterReadings.class, source);
        // System.err.println(exampleReading);
        // }
        // catch (Exception e) {
        // e.printStackTrace();
        // fail();
        // }
        // }

    }
}
