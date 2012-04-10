package edu.colorado.cs.cirrus.android;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
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
import org.springframework.http.converter.HttpMessageNotReadableException;
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
                return new HttpHeaders();
            }

            public InputStream getBody() throws IOException {
                // TODO Auto-generated method stub
                return new FileInputStream(new File("src/test/resources/MeterReadings.xml"));
            }
        };
        for (HttpMessageConverter<?> hmc : restTemplate.getMessageConverters()) {
            System.out.println("hmc: " + hmc);
            if (hmc.canRead(MeterReadings.class, MediaType.APPLICATION_XML)) {
                HttpMessageConverter<MeterReadings> typedHmc = (HttpMessageConverter<MeterReadings>) hmc;
                System.out.println("Can Read: " + hmc);
                hmc.canRead(MeterReadings.class, MediaType.APPLICATION_XML);
                try {
                    MeterReadings mr = (MeterReadings) typedHmc.read(MeterReadings.class, him);
                    System.out.println(mr);
                }
                catch (HttpMessageNotReadableException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    fail();
                }
                catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    fail();
                }
               
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
